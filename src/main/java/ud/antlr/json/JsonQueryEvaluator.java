package ud.antlr.json;

import ud.antlr.json.operand.Operand;
import ud.antlr.json.operation.BooleanOperation;
import ud.antlr.json.operation.DoubleOperation;
import ud.antlr.json.operation.LongOperation;
import ud.antlr.json.operation.NullOperation;
import ud.antlr.json.operation.Operation;
import ud.antlr.json.operation.StringOperation;

import javax.json.JsonObject;
import java.util.Stack;

/**
 * Uses Antlr's visitor mechanism to walk over the parse tree and evaluate a JSON query expression against the
 * given JSON object.
 */
public class JsonQueryEvaluator extends JsonQueryBaseVisitor<Boolean> {

    private static final String AND = "and";
    private static final String OR = "or";

    private JsonObject givenItem;

    private Stack<JsonObject> objectStack;

    private Operation currentOperation;
    private Operand leftOperand = new Operand();
    private Operand rightOperand = new Operand();

    public JsonQueryEvaluator(JsonObject item) {
        this.givenItem = item;
        this.objectStack = new Stack<>();
    }

    @Override
    public Boolean visitParenExp(JsonQueryParser.ParenExpContext ctx) {
        Boolean result = visit(ctx.query());
        return ctx.NOT() != null ? !result : result;
    }

    @Override
    public Boolean visitLogicalExp(JsonQueryParser.LogicalExpContext ctx) {
        Boolean leftExp = visit(ctx.query(0));

        if (leftExp) {
            if (OR.equals(ctx.LOGICAL_OPERATOR().getText())) {
                // Short circuit "or"
                return leftExp;

            } else {
                return visit(ctx.query(1));
            }

        } else {
            if (AND.equals(ctx.LOGICAL_OPERATOR().getText())) {
                // Short circuit "and"
                return leftExp;

            } else {
                return visit(ctx.query(1));
            }
        }
    }

    @Override
    public Boolean visitPresentExp(JsonQueryParser.PresentExpContext ctx) {
        visit(ctx.attrPath());
        return leftOperand.getValue() != null;
    }

    @Override
    public Boolean visitCompareExp(JsonQueryParser.CompareExpContext ctx) {
        // Get the left operand.
        visit(ctx.attrPath());

        // Get the right operand.
        visit(ctx.value());

        try {
            switch (ctx.op.getType()) {
                case JsonQueryParser.EQ:
                    return currentOperation.eq(leftOperand, rightOperand);

                case JsonQueryParser.NE:
                    return currentOperation.ne(leftOperand, rightOperand);

                case JsonQueryParser.GT:
                    return currentOperation.gt(leftOperand, rightOperand);

                case JsonQueryParser.LT:
                    return currentOperation.lt(leftOperand, rightOperand);

                case JsonQueryParser.GE:
                    return currentOperation.ge(leftOperand, rightOperand);

                case JsonQueryParser.LE:
                    return currentOperation.le(leftOperand, rightOperand);

                case JsonQueryParser.CO:
                    return currentOperation.co(leftOperand, rightOperand);

                case JsonQueryParser.SW:
                    return currentOperation.sw(leftOperand, rightOperand);

                case JsonQueryParser.EW:
                    return currentOperation.ew(leftOperand, rightOperand);

                default:
                    throw new IllegalStateException("Unsupported operator detected.");
            }


        } catch (Exception ex) {
            throw new RuntimeException("Unable to execute the query.", ex);
        }
    }

    @Override
    public Boolean visitAttrPath(JsonQueryParser.AttrPathContext ctx) {
        if (ctx.subAttr() == null || ctx.subAttr().isEmpty()) {
            JsonObject item = !objectStack.empty() ? objectStack.pop() : givenItem;
            leftOperand.setValue(item, ctx.ATTRNAME().getText());
            objectStack.clear();
            return true;

        } else {
            // TODO: Handle JSON arrays.
            // Push to the stack.
            JsonObject item = !objectStack.empty() ? objectStack.peek() : givenItem;
            objectStack.push(item.getJsonObject(ctx.ATTRNAME().getText()));
            return visitChildren(ctx);
        }
    }

    @Override
    public Boolean visitBoolean(JsonQueryParser.BooleanContext ctx) {
        currentOperation = BooleanOperation.SELF;
        rightOperand.setBoolValue(Boolean.parseBoolean(ctx.getText()));

        return true;
    }

    @Override
    public Boolean visitNull(JsonQueryParser.NullContext ctx) {
        currentOperation = NullOperation.SELF;
        rightOperand.setValue(null);
        return true;
    }

    @Override
    public Boolean visitString(JsonQueryParser.StringContext ctx) {
        currentOperation = StringOperation.SELF;

        String text = ctx.getText();

        // Remove quotes. At a minimum the string length will be 2 (two quotes).
        if (text.length() > 2) {
            rightOperand.setStrValue(text.substring(1, text.length() - 1));

        } else {
            rightOperand.setStrValue("");
        }

        return true;
    }

    @Override
    public Boolean visitDouble(JsonQueryParser.DoubleContext ctx) {
        currentOperation = DoubleOperation.SELF;
        rightOperand.setDoubleValue(Double.parseDouble(ctx.getText()));
        return true;
    }

    @Override
    public Boolean visitLong(JsonQueryParser.LongContext ctx) {
        currentOperation = LongOperation.SELF;
        rightOperand.setLongValue(Long.parseLong(ctx.getText()));
        return true;
    }
}
