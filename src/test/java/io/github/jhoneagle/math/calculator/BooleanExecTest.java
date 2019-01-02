package io.github.jhoneagle.math.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExecTest {
    private BooleanExec truth;

    @Before
    public void setUp() {
        truth = new BooleanExec();
    }

    @Test
    public void truthOrFalseSimpleOnNumber() {
        assertTrue(truth.eval("1"));
        assertFalse(truth.eval("0"));
    }

    @Test
    public void simpleEquationForOrOnNumber() {
        assertTrue(truth.eval("1v0"));
        assertTrue(truth.eval("1v1"));
        assertTrue(truth.eval("0v1"));
        assertFalse(truth.eval("0v0"));
    }

    @Test
    public void simpleEquationForAndOnNumber() {
        assertTrue(truth.eval("1^1"));
        assertFalse(truth.eval("1^0"));
        assertFalse(truth.eval("0^1"));
        assertFalse(truth.eval("0^0"));
    }

    @Test
    public void truthOrFalseSimpleOnCondition() {
        assertTrue(truth.eval("true"));
        assertFalse(truth.eval("false"));
    }

    @Test
    public void simpleEquationForOrOnCondition() {
        assertTrue(truth.eval("truevfalse"));
        assertTrue(truth.eval("truevtrue"));
        assertTrue(truth.eval("falsevtrue"));
        assertFalse(truth.eval("falsevfalse"));
    }

    @Test
    public void simpleEquationForAndOnCondition() {
        assertTrue(truth.eval("true^true"));
        assertFalse(truth.eval("true^false"));
        assertFalse(truth.eval("false^true"));
        assertFalse(truth.eval("false^false"));
    }

    @Test
    public void spacesInTheEquations() {
        assertTrue(truth.eval("1 v 1"));
        assertFalse(truth.eval("0 ^1"));
        assertTrue(truth.eval("truev false"));
        assertFalse(truth.eval("false ^ false"));
    }

    @Test
    public void simpleEquationOnNumberTrue() {
        assertTrue(truth.eval("(1 v 0) ^ (0 v 1)"));
        assertTrue(truth.eval("1 v 1 ^ 1"));
        assertTrue(truth.eval("1 ^ (1 ^ 1)"));
        assertTrue(truth.eval("1 v 1 ^ 1 v 0"));
        assertTrue(truth.eval("((1 v 0) ^ (0 v 1)) v 1"));
        assertTrue(truth.eval("1 v 0 v (1 ^ 1 v 0)"));
    }

    @Test
    public void simpleEquationOnNumberFalse() {
        assertFalse(truth.eval("0 v 1 ^ 0"));
        assertFalse(truth.eval("0 v 0 v (1 ^ 0)"));
        assertFalse(truth.eval("(0 v 0) ^ 0"));
        assertFalse(truth.eval("0 v ((1 v 0) ^ (1 ^ 0))"));
        assertFalse(truth.eval("((0 v 0) ^ 1) v (0 ^ 1)"));
        assertFalse(truth.eval("0 v ((0 v 1) ^ 0)"));
    }

    @Test
    public void advanceEquationsOnNumber() {
        assertTrue(truth.eval("((1 v 0) ^ (0 v 1)) v ((1 v 1) ^ (1 v 0))"));
        assertTrue(truth.eval("(1 v 0) ^ (1 v (1 v 0))"));
        assertFalse(truth.eval("((0 v 0) ^ 1) v (0 ^ 1)"));
        assertFalse(truth.eval("((0 v 0) ^ (1 v 0)) v ((0 ^ 1) v (0 ^ 0))"));
    }

    @Test
    public void simpleNotEquation() {
        assertTrue(truth.eval("!(1)v(1v0)"));
        assertTrue(truth.eval("!(0v1)v1"));
        assertTrue(truth.eval("!(0)"));
        assertFalse(truth.eval("0^!(0^1)"));
        assertFalse(truth.eval("!(0v1)"));
        assertFalse(truth.eval("!(0v1)v!(1^1)"));
    }
}