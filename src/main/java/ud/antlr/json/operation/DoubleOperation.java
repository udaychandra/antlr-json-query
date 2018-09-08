package ud.antlr.json.operation;

import ud.antlr.json.operand.Operand;

public class DoubleOperation implements Operation {

    private DoubleOperation() {}

    public static final DoubleOperation SELF = new DoubleOperation();

    public Boolean eq(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toDouble().equals(rightOperand.getDoubleValue());
    }

    public Boolean ne(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return !leftOperand.toDouble().equals(rightOperand.getDoubleValue());
    }

    public Boolean gt(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toDouble() > rightOperand.getDoubleValue();
    }

    public Boolean lt(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toDouble() < rightOperand.getDoubleValue();
    }

    public Boolean ge(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toDouble() >= rightOperand.getDoubleValue();
    }

    public Boolean le(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return leftOperand.toDouble() <= rightOperand.getDoubleValue();
    }

    public Boolean co(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("co is not a supported operator on double.");
    }

    public Boolean sw(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("sw is not a supported operator on double.");
    }

    public Boolean ew(Operand leftOperand, Operand rightOperand) {
        throw new UnsupportedOperationException("ew is not a supported operator on double.");
    }
}
