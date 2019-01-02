package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.operation.Action;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MathExecTest {
    private MathExec math;

    @Before
    public void setUp() {
        math = new MathExec();
    }

    @Test
    public void simpleTest() {
        Action result = math.parse("((4 - 2^3 + 1) * -sqrt(3*3+4*4)) / 2");
        assertEquals(7.5, (double) result.execute(), 0.01);
    }

    @Test
    public void simpleTest2() {
        Action result = math.parse("sin(12) + 18.13 - (abs(-4+2) * 3^2)");
        assertEquals(0.338, (double) result.execute(), 0.001);
    }

    @Test
    public void simpleTest3() {
        Action result = math.parse("((-4)^3 + 1) * (cos(0.15) + sqrt(9))");
        assertEquals(-252, (double) result.execute(), 0.001);
    }

    @Test
    public void simpleTest4() {
        Action result = math.parse("(1-8+tan(16/9)) + 12!");
        assertEquals(4.7900159303103805E8, (double) result.execute(), 0.001);
    }

    @Test
    public void longerTest() {
        double result = math.eval("sin(6! / 12^2) - sqrt(cos(90)^2 + 41)");
        assertEquals(-6.237, result, 0.001);
    }

    @Test
    public void longerTest2() {
        double result = math.eval("(3.14^3 + sin(7))! + sqrt(abs(-cos(24/3))) - 9*(cos(18))");
        assertEquals(4.9992130713784156E18, result, 1.0);
    }

    @Test
    public void longerTest3() {
        double result = math.eval("abs(24.123 * tan(78)) - (4! / 5!)^1.75");
        assertEquals(113.49, result, 0.001);
    }

    @Test
    public void longerTest4() {
        double result = math.eval("sqrt(abs(sin(16*3.14) - 12^0.14)) * 31.89");
        assertEquals(25.658, result, 0.001);
    }

    @Test
    public void testStringify() {
        String func = "((-4)^3 + 1) * (cos(0.15) + sqrt(9))";
        Action result = math.parse(func);

        func = "(-((4.0)))^(3.0)+(1.0)*cos((0.15))+sqrt((9.0))";
        String actual = result.stringify();

        assertTrue(actual.contains(func));
    }

    @Test
    public void testStringify2() {
        String func = "(3.14^3 + sin(7))! + sqrt(abs(-cos(24/3))) - 9*(cos(18))";
        Action result = math.parse(func);

        func = "((3.14)^(3.0)+sin((7.0)))!+sqrt(abs((-(cos((24.0)/(3.0))))))-(9.0)*cos((18.0))";
        String actual = result.stringify();

        assertTrue(actual.contains(func));
    }

    @Test
    public void testStringify3() {
        String func = "sin(12) + 18.13 - (abs(-4+2) * 3^2)";
        Action result = math.parse(func);

        func = "sin((12.0))+(18.13)-abs((-((4.0)))+(2.0))*(3.0)^(2.0)";
        String actual = result.stringify();

        assertTrue(actual.contains(func));
    }

    @Test
    public void testStringify4() {
        String func = "sqrt(abs(tan(16*3.14) - 12^0.14)) * 31.89";
        Action result = math.parse(func);

        func = "sqrt(abs(tan((16.0)*(3.14))-(12.0)^(0.14)))*(31.89)";
        String actual = result.stringify();

        assertTrue(actual.contains(func));
    }
}