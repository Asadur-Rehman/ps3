package expressivo;

import java.util.Objects;

//A class representing a variable in an exp.

public class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Variable variable = (Variable) obj;
        return Objects.equals(name, variable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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