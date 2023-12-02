package expressivo;

import java.util.Objects;

/**
 * A class representing an addition operation in an expression.
 */
public class Addition implements Expression {
    private final Expression left;
    private final Expression right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Addition addition = (Addition) obj;
        return left.equals(addition.left) && right.equals(addition.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
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
