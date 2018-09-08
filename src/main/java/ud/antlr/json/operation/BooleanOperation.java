package ud.antlr.json.operation;

import ud.antlr.json.operand.Operand;

public class BooleanOperation implements Operation {

    private BooleanOperation() {}

    public static final BooleanOperation SELF = new BooleanOperation();

    public Boolean eq(Operand leftOperand, Operand rightOperand) {
        return leftOperand.getValue() == rightOperand.getBoolValue();
    }

    public Boolean ne(Operand leftOperand, Operand rightOperand) {
        return leftOperand.getValue() != rightOperand.getBoolValue();
    }

    public Boolean gt(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("gt is not a supported operator on booleans.");
    }

    public Boolean lt(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("lt is not a supported operator on booleans.");
    }

    public Boolean ge(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("ge is not a supported operator on booleans.");
    }

    public Boolean le(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("le is not a supported operator on booleans.");
    }

    public Boolean co(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("co is not a supported operator on booleans.");
    }

    public Boolean sw(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("sw is not a supported operator on booleans.");
    }

    public Boolean ew(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("ew is not a supported operator on booleans.");
    }
}
