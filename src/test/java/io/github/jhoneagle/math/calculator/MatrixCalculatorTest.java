package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Matrix;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixCalculatorTest {
    private MatrixCalculator calc;

    @Before
    public void setUp() {
        calc = new MatrixCalculator();
    }

    @Test
    public void additionMatrix() {
        Matrix<Double> one = createMatrix(1.0, 2.0, 6.0, 0.0, 2.2, -14.1, 1.56, 9.0, -5.2);
        Matrix<Double> two = createMatrix(8.0, -3.0, 0.0, -1.0, 7.32, 1.0, 4.31, 0.0, -2.13);

        Matrix<Double> result = calc.additionMatrix(one, two);

        assertEquals(9, result.get(1, 1), 0.01);
        assertEquals(-1, result.get(1, 2), 0.01);
        assertEquals(6, result.get(1, 3), 0.01);
        assertEquals(-1, result.get(2, 1), 0.01);
        assertEquals(9.52, result.get(2, 2), 0.01);
        assertEquals(-13.1, result.get(2, 3), 0.01);
        assertEquals(5.87, result.get(3, 1), 0.01);
        assertEquals(9, result.get(3, 2), 0.01);
        assertEquals(-7.33, result.get(3, 3), 0.01);
    }

    @Test
    public void additionArray() {
        Double[][] one = createArray(-8.1, 0.0, 2.32, 3.14, 7.0, 0.0, -3.1, -10.1, 12.0);
        Double[][] two = createArray(0.0, 11.0, -4.01, 5.3, 0.012, -2.0, 1.1, 7.0, -2.0);

        Double[][] result = calc.additionArray(one, two);

        assertEquals(-8.1, result[0][0], 0.01);
        assertEquals(11, result[0][1], 0.01);
        assertEquals(-1.69, result[0][2], 0.01);
        assertEquals(8.44, result[1][0], 0.01);
        assertEquals(7.012, result[1][1], 0.01);
        assertEquals(-2, result[1][2], 0.01);
        assertEquals(-2, result[2][0], 0.01);
        assertEquals(-3.1, result[2][1], 0.01);
        assertEquals(10, result[2][2], 0.01);
    }

    @Test
    public void multiplicationMatrix() {
        Matrix<Double> one = createMatrix(1.0, 2.0, 6.0, 0.0, 2.2, -14.1, 1.56, 9.0, -5.2);
        Matrix<Double> two = createMatrix(8.0, -3.0, 0.0, -1.0, 7.32, 1.0, 4.31, 0.0, -2.13);

        Matrix<Double> result = calc.multiplicationMatrix(one, two);

        assertEquals(31.86, result.get(1, 1), 0.01);
        assertEquals(11.64, result.get(1, 2), 0.01);
        assertEquals(-10.78, result.get(1, 3), 0.01);
        assertEquals(-62.97, result.get(2, 1), 0.01);
        assertEquals(16.1, result.get(2, 2), 0.01);
        assertEquals(32.23, result.get(2, 3), 0.01);
        assertEquals(-18.93, result.get(3, 1), 0.01);
        assertEquals(61.2, result.get(3, 2), 0.01);
        assertEquals(20.08, result.get(3, 3), 0.01);
    }

    @Test
    public void multiplicationArray() {
        Double[][] one = createArray(-8.1, 0.0, 2.32, 3.14, 7.0, 0.0, -3.1, -10.1, 12.0);
        Double[][] two = createArray(0.0, 11.0, -4.01, 5.3, 0.012, -2.0, 1.1, 7.0, -2.0);

        Double[][] result = calc.multiplicationArray(one, two);

        assertEquals(2.55, result[0][0], 0.01);
        assertEquals(-72.86, result[0][1], 0.01);
        assertEquals(27.84, result[0][2], 0.01);
        assertEquals(37.1, result[1][0], 0.01);
        assertEquals(34.62, result[1][1], 0.01);
        assertEquals(-26.59, result[1][2], 0.01);
        assertEquals(-40.33, result[2][0], 0.01);
        assertEquals(49.78, result[2][1], 0.01);
        assertEquals(8.63, result[2][2], 0.01);
    }

    @Test
    public void transpositionMatrix() {
        Matrix<Double> one = createMatrix(1.0, 2.0, 6.0, 0.0, 2.2, -14.1, 1.56, 9.0, -5.2);

        Matrix<Double> result = calc.transpositionMatrix(one);

        assertEquals(1, result.get(1, 1), 0.01);
        assertEquals(0, result.get(1, 2), 0.01);
        assertEquals(1.56, result.get(1, 3), 0.01);
        assertEquals(2, result.get(2, 1), 0.01);
        assertEquals(2.2, result.get(2, 2), 0.01);
        assertEquals(9, result.get(2, 3), 0.01);
        assertEquals(6, result.get(3, 1), 0.01);
        assertEquals(-14.1, result.get(3, 2), 0.01);
        assertEquals(-5.2, result.get(3, 3), 0.01);
    }

    @Test
    public void transpositionArray() {
        Double[][] one = createArray(-8.1, 0.0, 2.32, 3.14, 7.0, 0.0, -3.1, -10.1, 12.0);

        Double[][] result = calc.transpositionArray(one);

        assertEquals(-8.1, result[0][0], 0.01);
        assertEquals(3.14, result[0][1], 0.01);
        assertEquals(-3.1, result[0][2], 0.01);
        assertEquals(0, result[1][0], 0.01);
        assertEquals(7, result[1][1], 0.01);
        assertEquals(-10.1, result[1][2], 0.01);
        assertEquals(2.32, result[2][0], 0.01);
        assertEquals(0, result[2][1], 0.01);
        assertEquals(12, result[2][2], 0.01);
    }

    @Test
    public void determinantMatrix() {
        Matrix<Double> one = createMatrix(1.0, 2.0, 6.0, 0.0, 2.2, -14.1, 1.56, 9.0, -5.2);

        double result = calc.determinantMatrix(one);

        assertEquals(50.87, result, 0.01);
    }

    @Test
    public void determinantArray() {
        Double[][] one = createArray(-8.1, 0.0, 2.32, 3.14, 7.0, 0.0, -3.1, -10.1, 12.0);

        double result = calc.determinantArray(one);

        assertEquals(-703.63, result, 0.01);
    }

    @Test
    public void scalarMultiplyMatrix() {
        Matrix<Double> one = createMatrix(1.0, 2.0, 6.0, 0.0, 2.2, -14.1, 1.56, 9.0, -5.2);

        Matrix<Double> result = calc.scalarMultiplyMatrix(-1.5, one);

        assertEquals(-1.5, result.get(1, 1), 0.01);
        assertEquals(-3, result.get(1, 2), 0.01);
        assertEquals(-9, result.get(1, 3), 0.01);
        assertEquals(0, result.get(2, 1), 0.01);
        assertEquals(-3.3, result.get(2, 2), 0.01);
        assertEquals(21.15, result.get(2, 3), 0.01);
        assertEquals(-2.34, result.get(3, 1), 0.01);
        assertEquals(-13.5, result.get(3, 2), 0.01);
        assertEquals(7.8, result.get(3, 3), 0.01);
    }

    @Test
    public void scalarMultiplyArray() {
        Double[][] one = createArray(-8.1, 0.0, 2.32, 3.14, 7.0, 0.0, -3.1, -10.1, 12.0);

        Double[][] result = calc.scalarMultiplyArray(4.12, one);

        assertEquals(-33.37, result[0][0], 0.01);
        assertEquals(0, result[0][1], 0.01);
        assertEquals(9.56, result[0][2], 0.01);
        assertEquals(12.937, result[1][0], 0.001);
        assertEquals(28.84, result[1][1], 0.01);
        assertEquals(0, result[1][2], 0.01);
        assertEquals(-12.77, result[2][0], 0.01);
        assertEquals(-41.61, result[2][1], 0.01);
        assertEquals(49.44, result[2][2], 0.01);
    }

    private Matrix<Double> createMatrix(Double... values) {
        return new Matrix<>(createArray(values));
    }

    private Double[][] createArray(Double... values) {
        int round = Math.toIntExact(Math.round(Math.sqrt(values.length)));
        Double[][] c = new Double[round][round];

        for (int i = 0; i < round; i++) {
            for (int j = 0; j < round; j++) {
                c[i][j] = values[i * round + j];
            }
        }

        return c;
    }
}