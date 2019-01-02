package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Vector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorCalculatorTest {
    private VectorCalculator calc;

    @Before
    public void setUp() {
        calc = new VectorCalculator();
    }

    @Test
    public void additionVector() {
        Vector<Double> one = createVector(1.0, 2.0, 6.0);
        Vector<Double> two = createVector(8.0, -3.0, 0.0);

        Vector<Double> result = calc.additionVector(one, two);

        assertEquals(9, (double) result.get(1), 0.0);
        assertEquals(-1, (double) result.get(2), 0.0);
        assertEquals(6, (double) result.get(3), 0.0);
    }

    @Test
    public void crossProductVector() {
        Vector<Double> one = createVector(1.0, 2.0, 6.0);
        Vector<Double> two = createVector(8.0, -3.0, 0.0);

        Vector<Double> result = calc.crossProductVector(one, two);

        assertEquals(18, (double) result.get(1), 0.0);
        assertEquals(48, (double) result.get(2), 0.0);
        assertEquals(-19, (double) result.get(3), 0.0);
    }

    @Test
    public void dotProductVector() {
        Vector<Double> one = createVector(1.0, 2.0, 6.0);
        Vector<Double> two = createVector(8.0, -3.0, 0.0);

        double result = calc.dotProductVector(one, two);

        assertEquals(2, (double) result, 0.0);
    }

    @Test
    public void lengthVector() {
        Vector<Double> one = createVector(1.0, 2.0, 6.0);

        double result = calc.lengthVector(one);

        assertEquals(41, (double) result, 0.01);
    }

    @Test
    public void scalarMultiplyVector() {
        Vector<Double> one = createVector(1.0, 2.0, 6.0);

        Vector<Double> result = calc.scalarMultiplyVector(5.0, one);

        assertEquals(5, (double) result.get(1), 0.0);
        assertEquals(10, (double) result.get(2), 0.0);
        assertEquals(30, (double) result.get(3), 0.0);
    }

    @Test
    public void additionArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);
        Double[] two = createArray(7.0, 9.0, 0.0);

        Double[] result = calc.additionArray(one, two);

        assertEquals(-5, (double) result[0], 0.0);
        assertEquals(8, (double) result[1], 0.0);
        assertEquals(21, (double) result[2], 0.0);
    }

    @Test
    public void crossProductArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);
        Double[] two = createArray(7.0, 9.0, 0.0);

        Double[] result = calc.crossProductArray(one, two);

        assertEquals(-189, (double) result[0], 0.0);
        assertEquals(147, (double) result[1], 0.0);
        assertEquals(-101, (double) result[2], 0.0);
    }

    @Test
    public void dotProductArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);
        Double[] two = createArray(7.0, 9.0, 0.0);

        double result = calc.dotProductArray(one, two);

        assertEquals(-93, (double) result, 0.0);
    }

    @Test
    public void lengthArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);

        double result = calc.lengthArray(one);

        assertEquals(586, (double) result, 0.0);
    }

    @Test
    public void scalarMultiplyArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);

        Double[] result = calc.scalarMultiplyArray(3.14, one);

        assertEquals(-37.68, (double) result[0], 0.0);
        assertEquals(-3.14, (double) result[1], 0.0);
        assertEquals(65.94, (double) result[2], 0.0);
    }

    private Vector<Double> createVector(Double... values) {
        return new Vector<>(values);
    }

    private Double[] createArray(Double... values) {
        return values;
    }
}