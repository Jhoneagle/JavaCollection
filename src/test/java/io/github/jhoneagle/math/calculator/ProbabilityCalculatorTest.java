package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Kombination;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityCalculatorTest {
    private ProbabilityCalculator calc;

    @Before
    public void setUp() {
        calc = new ProbabilityCalculator();
    }

    @Test
    public void permutations() {
        Double permutation = calc.permutation(10);
        assertEquals(3628800, permutation, 0.0);
    }

    @Test
    public void permutations2() {
        Double permutation = calc.permutation("{6,1}");
        assertEquals(720, permutation, 0.0);
    }

    @Test
    public void permutations3() {
        calc.init(new Kombination(-14,2));
        Double permutation = calc.permutation();
        assertEquals(-14, permutation, 0.0);
    }

    @Test
    public void permutations4() {
        Double permutation = calc.permutation(new Kombination(8,3));
        assertEquals(40320.0, permutation, 0.0);
    }

    @Test
    public void variation() {
        Double permutation = calc.variation(10, 3);
        assertEquals(3628800, permutation, 0.0);
    }

    @Test
    public void variation2() {
        Double permutation = calc.variation("{6,1}");
        assertEquals(6, permutation, 0.0);
    }

    @Test
    public void variation3() {
        calc.init(new Kombination(-1,2));
        Double permutation = calc.variation();
        assertEquals(0, permutation, 0.0);
    }

    @Test
    public void variation4() {
        Double permutation = calc.variation(new Kombination(8,3));
        assertEquals(336, permutation, 0.0);
    }

    @Test
    public void combination() {
        Double permutation = calc.combination(10, 3);
        assertEquals(604800, permutation, 0.0);
    }

    @Test
    public void combination2() {
        Double permutation = calc.combination("{6,1}");
        assertEquals(6, permutation, 0.0);
    }

    @Test
    public void combination3() {
        calc.init(new Kombination(-1,2));
        Double permutation = calc.combination();
        assertEquals(0.166, permutation, 0.01);
    }

    @Test
    public void combination4() {
        Double permutation = calc.combination(new Kombination(8,3));
        assertEquals(56, permutation, 0.0);
    }
}