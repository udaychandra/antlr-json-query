package ud.antlr.json.operation;

import ud.antlr.json.operand.Operand;

public class StringOperation implements Operation {

    private StringOperation() {}

    public static final StringOperation SELF = new StringOperation();

    public Boolean eq(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).equalsIgnoreCase(rightOperand.getStrValue());
    }

    public Boolean ne(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return !((String) leftOperand.getValue()).equalsIgnoreCase(rightOperand.getStrValue());
    }

    public Boolean gt(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).compareToIgnoreCase(rightOperand.getStrValue()) > 0;
    }

    public Boolean lt(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).compareToIgnoreCase(rightOperand.getStrValue()) < 0;
    }

    public Boolean ge(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).compareToIgnoreCase(rightOperand.getStrValue()) >= 0;
    }

    public Boolean le(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).compareToIgnoreCase(rightOperand.getStrValue()) <= 0;
    }

    public Boolean co(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).contains(rightOperand.getStrValue());
    }

    public Boolean sw(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).startsWith(rightOperand.getStrValue());
    }

    public Boolean ew(Operand leftOperand, Operand rightOperand) {
        if (leftOperand.getValue() == null) return false;

        return ((String) leftOperand.getValue()).endsWith(rightOperand.getStrValue());
    }
}
