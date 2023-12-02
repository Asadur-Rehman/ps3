package expressivo;

// A class representing a number in exp.

public class Number implements Expression {
    private final double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Number number = (Number) obj;
        return Double.compare(number.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
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