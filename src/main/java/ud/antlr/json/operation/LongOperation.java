package ud.antlr.json.operation;

import ud.antlr.json.operand.Operand;

public class LongOperation implements Operation {

    private LongOperation() {}

    public static final LongOperation SELF = new LongOperation();

    public Boolean eq(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toLong().equals(rightOperand.getLongValue());
    }

    public Boolean ne(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return !leftOperand.toLong().equals(rightOperand.getLongValue());
    }

    public Boolean gt(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toLong() > rightOperand.getLongValue();
    }

    public Boolean lt(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toLong() < rightOperand.getLongValue();
    }

    public Boolean ge(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toLong() >= rightOperand.getLongValue();
    }

    public Boolean le(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toLong() <= rightOperand.getLongValue();
    }

    public Boolean co(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("co is not a supported operator on long.");
    }

    public Boolean sw(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("sw is not a supported operator on long.");
    }

    public Boolean ew(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("ew is not a supported operator on long.");
    }
}
