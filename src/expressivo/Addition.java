
package expressivo;

import java.util.Objects;

/**
 * A class representing an addition operation in an expression.
 */
public class Addition implements Expression {
    private final Expression leftOperand;
    private final Expression rightOperand;

    public Addition(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    @Override
    public String toString() {
        return "(" + leftOperand.toString() + " + " + rightOperand.toString() + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Addition addition = (Addition) obj;

        return leftOperand.equals(addition.leftOperand) && rightOperand.equals(addition.rightOperand);
    }

    @Override
    public int hashCode() {
        int result = leftOperand.hashCode();
        result = 31 * result + rightOperand.hashCode();
        return result;
    }

    @Override
    public Expression add(Expression other) {
        return new Addition(this, other);
    }

    @Override
    public Expression multiply(Expression other) {
        return new Multiplication(this, other);
    }
}
