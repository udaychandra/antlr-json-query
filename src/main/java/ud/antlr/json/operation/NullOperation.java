package ud.antlr.json.operation;

import ud.antlr.json.operand.Operand;

public class NullOperation implements Operation {

    private NullOperation() {}

    public static final NullOperation SELF = new NullOperation();

    public Boolean eq(Operand leftOperand, Operand rightOperand) {
        return leftOperand.getValue() == null;
    }

    public Boolean ne(Operand leftOperand, Operand rightOperand) {
        return leftOperand.getValue() != null;
    }

    public Boolean gt(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("gt is not a supported operator on nulls.");
    }

    public Boolean lt(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("lt is not a supported operator on nulls.");
    }

    public Boolean ge(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("ge is not a supported operator on nulls.");
    }

    public Boolean le(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("le is not a supported operator on nulls.");
    }

    public Boolean co(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("co is not a supported operator on nulls.");
    }

    public Boolean sw(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("sw is not a supported operator on nulls.");
    }

    public Boolean ew(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("ew is not a supported operator on nulls.");
    }
}
