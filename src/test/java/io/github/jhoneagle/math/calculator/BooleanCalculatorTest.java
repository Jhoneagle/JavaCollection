package io.github.jhoneagle.math.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanCalculatorTest {
    private BooleanCalculator calc;

    @Before
    public void setUp() {
        calc = new BooleanCalculator();
    }

    @Test
    public void testAnd() {
        assertTrue(calc.and(true, true, true));
        assertFalse(calc.and(true, false, true, false, false));
        assertFalse(calc.and(false));
    }

    @Test
    public void testOr() {
        assertTrue(calc.or(true, true, true));
        assertTrue(calc.or(true, false, true, false, false, true));
        assertFalse(calc.or(false, false));
    }

    @Test
    public void testNegation() {
        assertTrue(calc.not(false));
        assertFalse(calc.not(true));
    }

    @Test
    public void testMaterialImplication() {
        assertFalse(calc.materialImplication(true, false));
        assertTrue(calc.materialImplication(true, true));
        assertTrue(calc.materialImplication(false, false));
        assertTrue(calc.materialImplication(false, true));
    }

    @Test
    public void testEquivalence() {
        assertTrue(calc.equivalence(false, false));
        assertTrue(calc.equivalence(true, true, true));
        assertFalse(calc.equivalence(true, false, false, true, true));
        assertFalse(calc.equivalence(false, true));
    }

    @Test
    public void testExclusiveOR() {
        assertTrue(calc.exclusiveOR(true, false));
        assertTrue(calc.exclusiveOR(false, true));
        assertFalse(calc.exclusiveOR(false, false));
        assertFalse(calc.exclusiveOR(true, true));
    }
}