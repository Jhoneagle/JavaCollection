package io.github.jhoneagle.math.operation;

import io.github.jhoneagle.math.operation.actiontype.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ActionFactoryTest {
    private ActionFactory factory;

    @Before
    public void setUp() {
        factory = new ActionFactory();
    }

    @Test
    public void testSum() {
        Action sum = factory.getSum(1.0, 2.0);

        assertSame(sum.getClass(), Sum.class);
        assertEquals(3, (double) sum.execute(), 0.0);
    }

    @Test
    public void testMinus() {
        Action minus = factory.getMinus(2.0, 1.0);

        assertSame(minus.getClass(), Minus.class);
        assertEquals(1, (double) minus.execute(), 0.0);
    }

    @Test
    public void testMultiply() {
        Action multiply = factory.getMultiply(3.0, 2.0);

        assertSame(multiply.getClass(), Multiply.class);
        assertEquals(6, (double) multiply.execute(), 0.0);
    }

    @Test
    public void testDivide() {
        Action divide = factory.getDivide(8.0, 2.0);

        assertSame(divide.getClass(), Divide.class);
        assertEquals(4, (double) divide.execute(), 0.0);
    }

    @Test
    public void testPower() {
        Action power = factory.getPower(3.0, 2.0);

        assertSame(power.getClass(), Power.class);
        assertEquals(9, (double) power.execute(), 0.0);
    }

    @Test
    public void testSqrt() {
        Action sqrt = factory.getSqrt(25.0);

        assertSame(sqrt.getClass(), Sqrt.class);
        assertEquals(5, (double) sqrt.execute(), 0.0);
    }

    @Test
    public void testSin() {
        Action sin = factory.getSin(16.0);

        assertSame(sin.getClass(), Sin.class);
        assertEquals(0.27, (double) sin.execute(), 0.01);
    }

    @Test
    public void testCos() {
        Action cos = factory.getCos(25.0);

        assertSame(cos.getClass(), Cos.class);
        assertEquals(0.9, (double) cos.execute(), 0.01);
    }

    @Test
    public void testTan() {
        Action tan = factory.getTan(78.0);

        assertSame(tan.getClass(), Tan.class);
        assertEquals(4.7, (double) tan.execute(), 0.01);
    }

    @Test
    public void testFactorial() {
        Action factorial = factory.getFactorial(5L);

        assertSame(factorial.getClass(), Factorial.class);
        assertEquals(120L, factorial.execute());
    }

    @Test
    public void testBracket() {
        Action number = factory.getBracket(6.0);

        assertSame(number.getClass(), Bracket.class);
        assertEquals(6, (double) number.execute(), 0.0);
    }

    @Test
    public void testNegation() {
        Action negation = factory.getNegation(18.0);

        assertSame(negation.getClass(), Negation.class);
        assertEquals(-18, (double) negation.execute(), 0.0);
    }

    @Test
    public void testAbsolute() {
        Action abs = factory.getAbsolute(-100.0);

        assertSame(abs.getClass(), Absolute.class);
        assertEquals(100, (double) abs.execute(), 0.0);
    }

    @Test
    public void testSum2() {
        Action prepare1 = factory.getSum(7.0, 2.0);
        Action prepare2 = factory.getSum(1.0, 2.0);
        Action sum = factory.getSum(prepare1, prepare2);

        assertSame(sum.getClass(), Sum.class);
        assertEquals(12, (double) sum.execute(), 0.0);
    }

    @Test
    public void testMinus2() {
        Action prepare1 = factory.getSum(7.0, 8.0);
        Action prepare2 = factory.getSum(10.0, 1.0);
        Action minus = factory.getMinus(prepare1, prepare2);

        assertSame(minus.getClass(), Minus.class);
        assertEquals(4, (double) minus.execute(), 0.0);
    }

    @Test
    public void testMultiply2() {
        Action prepare1 = factory.getSum(7.0, 8.0);
        Action prepare2 = factory.getSum(3.0, 1.0);
        Action multiply = factory.getMultiply(prepare1, prepare2);

        assertSame(multiply.getClass(), Multiply.class);
        assertEquals(60, (double) multiply.execute(), 0.0);
    }

    @Test
    public void testDivide2() {
        Action prepare1 = factory.getSum(-4.0, 8.0);
        Action prepare2 = factory.getSum(1.0, 1.0);
        Action divide = factory.getDivide(prepare1, prepare2);

        assertSame(divide.getClass(), Divide.class);
        assertEquals(2, (double) divide.execute(), 0.0);
    }

    @Test
    public void testPower2() {
        Action prepare1 = factory.getSum(1.0, 9.0);
        Action prepare2 = factory.getSum(1.0, 2.0);
        Action power = factory.getPower(prepare1, prepare2);

        assertSame(power.getClass(), Power.class);
        assertEquals(1000, (double) power.execute(), 0.0);
    }

    @Test
    public void testSqrt2() {
        Action prepare = factory.getSum(12.0, 52.0);
        Action sqrt = factory.getSqrt(prepare);

        assertSame(sqrt.getClass(), Sqrt.class);
        assertEquals(8, (double) sqrt.execute(), 0.0);
    }

    @Test
    public void testSin2() {
        Action prepare = factory.getSum(0.12, 8.46);
        Action sin = factory.getSin(prepare);

        assertSame(sin.getClass(), Sin.class);
        assertEquals(0.15, (double) sin.execute(), 0.001);
    }

    @Test
    public void testCos2() {
        Action prepare = factory.getSum(3.145, 0.1);
        Action cos = factory.getCos(prepare);

        assertSame(cos.getClass(), Cos.class);
        assertEquals(1, (double) cos.execute(), 0.01);
    }

    @Test
    public void testTan2() {
        Action prepare = factory.getSum(10.0, 10.0);
        Action tan = factory.getTan(prepare);

        assertSame(tan.getClass(), Tan.class);
        assertEquals(0.36, (double) tan.execute(), 0.01);
    }

    @Test
    public void testFactorial2() {
        Action prepare = factory.getSum(-12.0, 18.0);
        Action factorial = factory.getFactorial(prepare);

        assertSame(factorial.getClass(), Factorial.class);
        assertEquals(720L, factorial.execute());
    }

    @Test
    public void testBracket2() {
        Action prepare = factory.getSum(0.1, 0.1);
        Action number = factory.getBracket(prepare);

        assertSame(number.getClass(), Bracket.class);
        assertEquals(0.2, (double) number.execute(), 0.0);
    }

    @Test
    public void testNegation2() {
        Action prepare = factory.getSum(7.0, 8.0);
        Action negation = factory.getNegation(prepare);

        assertSame(negation.getClass(), Negation.class);
        assertEquals(-15, (double) negation.execute(), 0.0);
    }

    @Test
    public void testAbsolute2() {
        Action prepare = factory.getSum(-7.0, 1.0);
        Action abs = factory.getAbsolute(prepare);

        assertSame(abs.getClass(), Absolute.class);
        assertEquals(6, (double) abs.execute(), 0.0);
    }
}