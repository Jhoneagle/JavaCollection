package io.github.jhoneagle.math.calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommonCalculatorTest {
    private CommonCalculator calc;

    @Before
    public void setUp() {
        calc = new CommonCalculator();
    }

    @Test
    public void testStaticFactoring() {
        List<Integer> factors = CommonCalculator.getFactors(1500);
        factors.sort(Integer::compareTo);
        assertEquals(6, factors.size());
        assertEquals(5, factors.get(factors.size() - 1).longValue());
    }

    @Test
    public void testStaticFactoring2() {
        List<Integer> factors = CommonCalculator.getFactors(16824);
        factors.sort(Integer::compareTo);
        assertEquals(5, factors.size());
        assertEquals(701, factors.get(factors.size() - 1).longValue());
    }

    @Test
    public void testStaticCommonDIvisor() {
        int i = CommonCalculator.greatestCommonDIvisor(234, 700);
        assertEquals(2, i);
    }

    @Test
    public void testStaticCommonDIvisor2() {
        int i = CommonCalculator.greatestCommonDIvisor(88998, 32274);
        assertEquals(978, i);
    }

    @Test
    public void testStaticCommonMultiple() {
        int i = CommonCalculator.smallestCommonMultiple(15, 71);
        assertEquals(1065, i);
    }

    @Test
    public void testStaticCommonMultiple2() {
        int i = CommonCalculator.smallestCommonMultiple(177, 299);
        assertEquals(52923, i);
    }

    @Test
    public void testRationalSum() {
        String s = calc.sumOfRationalNumbers("1/6", "1/5");
        assertTrue(s.contains("11/30"));
    }
    
    @Test
    public void testRationalMinus() {
        String s = calc.minusOfRationalNumbers("2/6", "1/5");
        assertTrue(s.contains("4/30"));
    }

    @Test
    public void testRationalMultiply() {
        String s = calc.multiplyOfRationalNumbers("1/6", "1/5");
        assertTrue(s.contains("1/30"));
    }

    @Test
    public void testRationalDivide() {
        String s = calc.divideOfRationalNumbers("2/6", "1/5");
        assertTrue(s.contains("10/6"));
    }
}