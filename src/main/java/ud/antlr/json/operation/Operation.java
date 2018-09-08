package ud.antlr.json.operation;

import ud.antlr.json.operand.Operand;

/**
 * Defines the supported operations by the JSON query grammar.
 */
public interface Operation {

    Boolean eq(Operand leftOperand, Operand rightOperand);

    Boolean ne(Operand leftOperand, Operand rightOperand);

    Boolean gt(Operand leftOperand, Operand rightOperand);

    Boolean lt(Operand leftOperand, Operand rightOperand);

    Boolean ge(Operand leftOperand, Operand rightOperand);

    Boolean le(Operand leftOperand, Operand rightOperand);

    Boolean co(Operand leftOperand, Operand rightOperand);

    Boolean sw(Operand leftOperand, Operand rightOperand);

    Boolean ew(Operand leftOperand, Operand rightOperand);
}
