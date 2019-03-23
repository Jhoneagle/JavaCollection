package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Fraction;
import io.github.jhoneagle.math.Matrix;
import io.github.jhoneagle.math.Vector;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AdvancedMathOperations {
    /**
     * Fractions sum.
     *
     * @param a first fraction
     * @param b second fraction
     *
     * @return new fraction that equals sum of two fractions
     */
    public static Fraction sumOfFraction(Fraction a, Fraction b) {
        double ratios = b.getDivision() * a.getRatios() + a.getDivision() * b.getRatios();
        double division = a.getDivision() * b.getDivision();
        return new Fraction(ratios, division);
    }

    /**
     * Fractions reduce.
     *
     * @param a first fraction
     * @param b second fraction
     *
     * @return new fraction that equals reduce of two fractions
     */
    public static Fraction reduceOfFraction(Fraction a, Fraction b) {
        double ratios = b.getDivision() * a.getRatios() - a.getDivision() * b.getRatios();
        double division = a.getDivision() * b.getDivision();
        return new Fraction(ratios, division);
    }

    /**
     * Fractions multiply.
     *
     * @param a first fraction
     * @param b second fraction
     *
     * @return new fraction that equals multiply of two fractions
     */
    public static Fraction multiplyOfFraction(Fraction a, Fraction b) {
        double ratios = a.getRatios() * b.getRatios();
        double division = a.getDivision() * b.getDivision();
        return new Fraction(ratios, division);
    }

    /**
     * Fractions division.
     *
     * @param a first fraction
     * @param b second fraction
     *
     * @return new fraction that equals division of two fractions
     */
    public static Fraction divisionOfFraction(Fraction a, Fraction b) {
        double ratios = b.getDivision() * a.getRatios();
        double division = a.getDivision() * b.getRatios();
        return new Fraction(ratios, division);
    }

    /**
     * reciprocal of fraction.
     *
     * @param a fraction
     *
     * @return fraction which multiplied by old one gives result of 1
     */
    public static Fraction reciprocalOfFraction(Fraction a) {
        return new Fraction(a.getDivision(), a.getRatios());
    }

    /**
     * Greatest common divisor.
     *
     * @param a first number
     * @param b second number
     *
     * @return greatest common divisor
     */
    public static double gcd(double a, double b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0){
            if (a > b){
                a -= b;
            } else {
                b -= a;
            }
        }

        return a;
    }

    /**
     * Least common multiple.
     *
     * @param a first number
     * @param b second number
     *
     * @return values least common multiple
     */
    public static double lcm(double a, double b) {
        double ab = Math.abs(a) * Math.abs(b);
        double sytAB = gcd(a, b);

        return ab / sytAB;
    }

    /**
     * Prime numbers.
     *
     * @param n value which prime numbers wanted
     *
     * @return list of smallest prime numbers n can be divided
     */
    public static List<Integer> getFactors(int n) {
        Deque<Integer> f = new ArrayDeque<>();

        for (int x = 2; x * x <= n; x++) {
            while (n % x == 0) {
                f.addLast(x);

                n /= x;
            }
        }

        if (n > 1) {
            f.addLast(n);
        }

        return new ArrayList<>(f);
    }

    /**
     * Sum of matrix.
     *
     * @param a first matrix
     * @param b second matrix
     *
     * @return new matrix which values are old ones together.
     */
    public static Matrix additionMatrix(Matrix a, Matrix b) {
        if (a.height() != b.height() || a.width() != b.width()) {
            return null;
        }

        for (int i = 1; i <= a.height(); i++) {
            for (int j = 1; j <= a.width(); j++) {
                a.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }

        return a;
    }

    /**
     * Matrix scalar multiply.
     *
     * @param scalar number which matrix values are multiplied
     * @param a matrix
     *
     * @return new matrix which values are old ones multiplied by number.
     */
    public static Matrix scalarMultiplyMatrix(double scalar, Matrix a) {
        for (int i = 1; i <= a.height(); i++) {
            for (int j = 1; j <= a.width(); j++) {
                a.set(i, j, a.get(i, j) * scalar);
            }
        }

        return a;
    }

    /**
     * Transposition of matrix.
     *
     * @param a matrix
     *
     * @return new matrix which rows are old ones columns and vice versa.
     */
    public static Matrix transpositionMatrix(Matrix a) {
        Matrix newOne = new Matrix(a.height(), a.width());

        for (int i = 1; i <= a.width(); i++) {
            for (int j = 1; j <= a.height(); j++) {
                newOne.set(i, j, a.get(j, i));
            }
        }

        return newOne;
    }

    /**
     * Multiplication of matrix.
     *
     * @param a first matrix
     * @param b second matrix
     *
     * @return new matrix which is both matrix together
     */
    public static Matrix multiplicationMatrix(Matrix a, Matrix b) {
        Matrix newOne = new Matrix(a.height(), b.width());

        if (a.width() != b.height()) {
            return null;
        }

        for (int i = 1; i <= newOne.height(); i++) {
            for (int j = 1; j <= newOne.width(); j++) {
                double value = 0;

                for (int k = 1; k <= a.width(); k++) {
                    value += a.get(i, k) * b.get(k, j);
                }

                newOne.set(i, j, value);
            }
        }

        return newOne;
    }

    /**
     * Determinant of matrix.
     *
     * @param a matrix of size 1x1, 2x2 or 3x3
     *
     * @return determinant of the matrix or zero
     */
    public static double determinantMatrix(Matrix a) {
        double result = 0;

        if (a.height() == 1 || a.width() == 1) {
            result = a.get(1, 1);
        } else if (a.height() == 2 || a.width() == 2) {
            result = a.get(1, 1) * a.get(2, 2) - a.get(1, 2) * a.get(2,1);
        } else if (a.height() == 3 || a.width() == 3) {
            result = a.get(1, 1) * a.get(2, 2) * a.get(3,3);
            result -= a.get(1, 1) * a.get(2, 3) * a.get(3, 2);
            result -= a.get(1, 2) * a.get(2,1) * a.get(3,3);
            result += a.get(1, 2) * a.get(2, 3) * a.get(3,1);
            result += a.get(1,3) * a.get(2,1) * a.get(3, 2);
            result -= a.get(1,3) * a.get(2, 2) * a.get(3,1);
        }

        return result;
    }

    /**
     * Sum of two vectors.
     *
     * @param a first vector
     * @param b second vector
     *
     * @return new vector that values are sum of old ones
     */
    public static Vector additionVector(Vector a, Vector b) {
        if (a.dimension() != b.dimension()) {
            return null;
        }

        for (int i = 1; i <= a.dimension(); i++) {
            a.set(i, a.get(i) + b.get(i));
        }

        return a;
    }

    /**
     * Vectors scalar multiply.
     *
     * @param scalar number which vectors values are multiplied
     * @param a vector
     *
     * @return new vector which values are old ones multiplied by a number
     */
    public static Vector scalarMultiplyVector(double scalar, Vector a) {
        for (int i = 1; i <= a.dimension(); i++) {
            a.set(i, a.get(i) * scalar);
        }

        return a;
    }

    /**
     * Vectors length.
     *
     * @param a vector
     *
     * @return square root of the vectors values squares sum
     */
    public static double lengthVector(Vector a) {
        double result = 0;

        for (int i = 1; i <= a.dimension(); i++) {
            result += Math.pow(a.get(i), 2);
        }

        return Math.sqrt(result);
    }

    /**
     * Dot product of two vectors.
     *
     * @param a first vector
     * @param b second vector
     *
     * @return sum of vectors values multiplications
     */
    public static double dotProductVector(Vector a, Vector b) {
        double result = 0;

        for (int i = 1; i <= a.dimension(); i++) {
            result += (a.get(i) * b.get(i));
        }

        return result;
    }

    /**
     * Cross product of two vectors.
     *
     * @param a first vector
     * @param b second vector
     *
     * @return new vector
     */
    public static Vector crossProductVector(Vector a, Vector b) {
        Vector newOne = new Vector(3);

        if (a.dimension() != b.dimension() || a.dimension() != 3) {
            return null;
        }

        newOne.set(1, a.get(2) * b.get(3) - a.get(3) * b.get(2));
        newOne.set(2, a.get(3) * b.get(1) - a.get(1) * b.get(3));
        newOne.set(3, a.get(1) * b.get(2) - a.get(2) * b.get(1));

        return newOne;
    }

    public static Double[][] additionArray(Double[][] first, Double[][] second) {
        if (first.length != second.length || first[0].length != second[0].length) {
            throw new RuntimeException("Unwanted matrix!");
        }

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[0].length; j++) {
                first[i][j] += second[i][j];
            }
        }

        return first;
    }

    public static Double[][] scalarMultiplyArray(double scalar, Double[][] first) {
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[0].length; j++) {
                first[i][j] *= scalar;
            }
        }

        return first;
    }

    public static Double[][] transpositionArray(Double[][] first) {
        Double[][] newOne = new Double[first[0].length][first.length];

        for (int i = 0; i < first[0].length; i++) {
            for (int j = 0; j < first.length; j++) {
                newOne[i][j] = first[j][i];
            }
        }

        return newOne;
    }

    public static Double[][] multiplicationArray(Double[][] first, Double[][] second) {
        Double[][] newOne = new Double[first.length][second[0].length];

        if (first[0].length != second.length) {
            throw new RuntimeException("Unwanted matrix!");
        }

        for (int i = 0; i < newOne.length; i++) {
            for (int j = 0; j < newOne[0].length; j++) {
                double value = 0;

                for (int k = 0; k < first[0].length; k++) {
                    value += first[i][k] * second[k][j];
                }

                newOne[i][j] = value;
            }
        }

        return newOne;
    }

    public static double determinantArray(Double[][] first) {
        double result = 0;

        if (first.length == 1 || first[0].length == 1) {
            result = first[0][0];
        } else if (first.length == 2 || first[0].length == 2) {
            result = first[0][0] * first[1][1] - first[0][1] * first[1][0];
        } else if (first.length == 3 || first[0].length == 3) {
            result = first[0][0] * first[1][1] * first[2][2];
            result -= first[0][0] * first[1][2] * first[2][1];
            result -= first[0][1] * first[1][0] * first[2][2];
            result += first[0][1] * first[1][2] * first[2][0];
            result += first[0][2] * first[1][0] * first[2][1];
            result -= first[0][2] * first[1][1] * first[2][0];
        }

        return result;
    }

    public static Double[] additionArray(Double[] first, Double[] second) {
        if (first.length != second.length) {
            throw new RuntimeException("Unwanted vector!");
        }

        for (int i = 0; i < first.length; i++) {
            first[i] += second[i];
        }

        return first;
    }

    public static Double[] scalarMultiplyArray(double scalar, Double[] first) {
        for (int i = 0; i < first.length; i++) {
            first[i] *= scalar;
        }

        return first;
    }


    public static double lengthArray(Double[] first) {
        double result = 0;

        for (int i = 0; i < first.length; i++) {
            result += Math.pow(first[i], 2);
        }

        return result;
    }

    public static double dotProductArray(Double[] first, Double[] second) {
        double result = 0;

        for (int i = 0; i < first.length; i++) {
            result += (first[i] * second[i]);
        }

        return result;
    }



    public static Double[] crossProductArray(Double[] first, Double[] second) {
        Double[] newfirst = new Double[3];

        if (first.length != second.length || first.length != 3) {
            throw new RuntimeException("Unwanted vector!");
        }

        newfirst[0] = first[1] * second[2] - first[2] * second[1];
        newfirst[1] = first[2] * second[0] - first[0] * second[2];
        newfirst[2] = first[0] * second[1] - first[1] * second[0];

        return newfirst;
    }
}
