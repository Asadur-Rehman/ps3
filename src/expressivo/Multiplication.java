package expressivo;

import java.util.Objects;

/**
 * A class representing a multiplication operation in an expression.
 */
public class Multiplication implements Expression {
    private final Expression left;
    private final Expression right;

    public Multiplication(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Multiplication multiplication = (Multiplication) obj;
        return left.equals(multiplication.left) && right.equals(multiplication.right);
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
