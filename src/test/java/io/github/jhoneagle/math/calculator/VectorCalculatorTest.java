package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorCalculatorTest {
    @Test
    public void additionVector() {
        Vector one = createVector(1.0, 2.0, 6.0);
        Vector two = createVector(8.0, -3.0, 0.0);

        Vector result = AdvancedMathOperations.additionVector(one, two);

        assertEquals(9, result.get(1), 0.0);
        assertEquals(-1, result.get(2), 0.0);
        assertEquals(6, result.get(3), 0.0);
    }

    @Test
    public void crossProductVector() {
        Vector one = createVector(1.0, 2.0, 6.0);
        Vector two = createVector(8.0, -3.0, 0.0);

        Vector result = AdvancedMathOperations.crossProductVector(one, two);

        assertEquals(18, result.get(1), 0.0);
        assertEquals(48, result.get(2), 0.0);
        assertEquals(-19, result.get(3), 0.0);
    }

    @Test
    public void dotProductVector() {
        Vector one = createVector(1.0, 2.0, 6.0);
        Vector two = createVector(8.0, -3.0, 0.0);

        double result = AdvancedMathOperations.dotProductVector(one, two);

        assertEquals(2, result, 0.0);
    }

    @Test
    public void lengthVector() {
        Vector one = createVector(1.0, 2.0, 6.0);

        double result = AdvancedMathOperations.lengthVector(one);

        assertEquals(Math.sqrt(41), result, 0.01);
    }

    @Test
    public void scalarMultiplyVector() {
        Vector one = createVector(1.0, 2.0, 6.0);

        Vector result = AdvancedMathOperations.scalarMultiplyVector(5.0, one);

        assertEquals(5, result.get(1), 0.0);
        assertEquals(10, result.get(2), 0.0);
        assertEquals(30, result.get(3), 0.0);
    }

    @Test
    public void additionArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);
        Double[] two = createArray(7.0, 9.0, 0.0);

        Double[] result = AdvancedMathOperations.additionArray(one, two);

        assertEquals(-5, result[0], 0.0);
        assertEquals(8, result[1], 0.0);
        assertEquals(21, result[2], 0.0);
    }

    @Test
    public void crossProductArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);
        Double[] two = createArray(7.0, 9.0, 0.0);

        Double[] result = AdvancedMathOperations.crossProductArray(one, two);

        assertEquals(-189, result[0], 0.0);
        assertEquals(147, result[1], 0.0);
        assertEquals(-101, result[2], 0.0);
    }

    @Test
    public void dotProductArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);
        Double[] two = createArray(7.0, 9.0, 0.0);

        double result = AdvancedMathOperations.dotProductArray(one, two);

        assertEquals(-93, result, 0.0);
    }

    @Test
    public void lengthArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);

        double result = AdvancedMathOperations.lengthArray(one);

        assertEquals(586, result, 0.0);
    }

    @Test
    public void scalarMultiplyArray() {
        Double[] one = createArray(-12.0, -1.0, 21.0);

        Double[] result = AdvancedMathOperations.scalarMultiplyArray(3.14, one);

        assertEquals(-37.68, result[0], 0.0);
        assertEquals(-3.14, result[1], 0.0);
        assertEquals(65.94, result[2], 0.0);
    }

    private Vector createVector(Double... values) {
        return new Vector(values);
    }

    private Double[] createArray(Double... values) {
        return values;
    }
}