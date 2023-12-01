package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    // Testing strategy for toString()
    // - Test toString() on a Variable
    // - Test toString() on a Number
    // - Test toString() on an Addition expression
    // - Test toString() on a Multiplication expression
    @Test
    public void testToString() {
        Expression varX = new Variable("x");
        Expression varY = new Variable("y");
        Expression num3 = new Number(3.0);
        Expression num5 = new Number(5.0);
        Expression sum = varX.add(varY);
        Expression product = sum.multiply(num3);

        assertEquals("x", varX.toString());
        assertEquals("y", varY.toString());
        assertEquals("3.0", num3.toString());
        assertEquals("5.0", num5.toString());
        assertEquals("(x + y)", sum.toString());
        assertEquals("((x + y) * 3.0)", product.toString());
    }
    
    // Testing strategy for equals()
    // - Test equals() on equal Variables
    // - Test equals() on different Variables
    // - Test equals() on equal Numbers
    // - Test equals() on different Numbers
    // - Test equals() on equal Addition expressions
    // - Test equals() on different Addition expressions
    // - Test equals() on equal Multiplication expressions
    // - Test equals() on different Multiplication expressions
    @Test
    public void testEquals() {
        Expression varX1 = new Variable("x");
        Expression varX2 = new Variable("x");
        Expression varY = new Variable("y");
        Expression num3 = new Number(3.0);
        Expression num5 = new Number(5.0);
        Expression sum1 = varX1.add(varY);
        Expression sum2 = varX2.add(varY);
        Expression product1 = sum1.multiply(num3);
        Expression product2 = sum2.multiply(num3);

        assertEquals(varX1, varX2);
        assertNotEquals(varX1, varY);

        assertEquals(sum1, sum2);
        assertNotEquals(sum1, varX1);

        assertEquals(product1, product2);
        assertNotEquals(product1, sum1);
    }

    // Testing strategy for hashCode()
    // - Test hashCode() on equal Variables
    // - Test hashCode() on different Variables
    // - Test hashCode() on equal Numbers
    // - Test hashCode() on different Numbers
    // - Test hashCode() on equal Addition expressions
    // - Test hashCode() on different Addition expressions
    // - Test hashCode() on equal Multiplication expressions
    // - Test hashCode() on different Multiplication expressions
    @Test
    public void testHashCode() {
        Expression varX1 = new Variable("x");
        Expression varX2 = new Variable("x");
        Expression varY = new Variable("y");
        Expression num3 = new Number(3.0);
        Expression num5 = new Number(5.0);
        Expression sum1 = varX1.add(varY);
        Expression sum2 = varX2.add(varY);
        Expression product1 = sum1.multiply(num3);
        Expression product2 = sum2.multiply(num3);

        assertEquals(varX1.hashCode(), varX2.hashCode());
        assertNotEquals(varX1.hashCode(), varY.hashCode());

        assertEquals(sum1.hashCode(), sum2.hashCode());
        assertNotEquals(sum1.hashCode(), varX1.hashCode());

        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), sum1.hashCode());
    }

}
