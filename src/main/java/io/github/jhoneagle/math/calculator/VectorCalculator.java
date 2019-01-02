package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Vector;

public class VectorCalculator {
    private Double[] one;
    private Double[] two;
    private Vector<Double> uno;
    private Vector<Double> dos;

    public VectorCalculator(Vector<Double> uno) {
        init(uno);
    }

    public VectorCalculator(Vector<Double> uno, Vector<Double> dos) {
        init(uno, dos);
    }

    public VectorCalculator(Double[] one) {
        init(one);
    }

    public VectorCalculator(Double[] one, Double[] two) {
        init(one, two);
    }

    public VectorCalculator() {
    }

    public void init(Double[]... values) {
        if (values.length > 0) {
            one = values[0];

            if (values.length > 1) {
                two = values[1];
            }
        }
    }

    public void init(Vector<Double>... values) {
        if (values.length > 0) {
            uno = values[0];

            if (values.length > 1) {
                dos = values[1];
            }
        }
    }

    public Double[] additionArray(Double[] first, Double[] second) {
        init(first, second);
        return additionArray();
    }

    public Double[] additionArray() {
        if (one.length != two.length) {
            throw new RuntimeException("Unwanted vector!");
        }

        for (int i = 0; i < one.length; i++) {
            one[i] += two[i];
        }

        return one;
    }

    public Vector<Double> additionVector(Vector<Double> first, Vector<Double> second) {
        init(first, second);
        return additionVector();
    }

    public Vector<Double> additionVector() {
        if (uno.length() != dos.length()) {
            throw new RuntimeException("Unwanted vector!");
        }

        for (int i = 1; i <= uno.length(); i++) {
            uno.set(i, uno.get(i) + dos.get(i));
        }

        return uno;
    }

    public Double[] scalarMultiplyArray(double scalar, Double[] first) {
        init(first);
        return scalarMultiplyArray(scalar);
    }

    public Double[] scalarMultiplyArray(double scalar) {
        for (int i = 0; i < one.length; i++) {
            one[i] *= scalar;
        }

        return one;
    }

    public Vector<Double> scalarMultiplyVector(double scalar, Vector<Double> first) {
        init(first);
        return scalarMultiplyVector(scalar);
    }

    public Vector<Double> scalarMultiplyVector(double scalar) {
        for (int i = 1; i <= uno.length(); i++) {
            uno.set(i, uno.get(i) * scalar);
        }

        return uno;
    }

    public double lengthArray(Double[] first) {
        init(first);
        return lengthArray();
    }

    public double lengthArray() {
        double result = 0;

        for (int i = 0; i < one.length; i++) {
            result += Math.pow(one[i], 2);
        }

        return result;
    }

    public double lengthVector(Vector<Double> first) {
        init(first);
        return lengthVector();
    }

    public double lengthVector() {
        double result = 0;

        for (int i = 1; i <= uno.length(); i++) {
            result += Math.pow(uno.get(i), 2);
        }

        return result;
    }

    public double dotProductArray(Double[] first, Double[] second) {
        init(first, second);
        return dotProductArray();
    }

    public double dotProductVector(Vector<Double> first, Vector<Double> second) {
        init(first, second);
        return dotProductVector();
    }

    public double dotProductArray() {
        double result = 0;

        for (int i = 0; i < one.length; i++) {
            result += (one[i] * two[i]);
        }

        return result;
    }

    public double dotProductVector() {
        double result = 0;

        for (int i = 1; i <= uno.length(); i++) {
            result += (uno.get(i) * dos.get(i));
        }

        return result;
    }

    public Double[] crossProductArray(Double[] first, Double[] second) {
        init(first, second);
        return crossProductArray();
    }

    public Double[] crossProductArray() {
        Double[] newOne = new Double[3];

        if (one.length != two.length || one.length != 3) {
            throw new RuntimeException("Unwanted vector!");
        }

        newOne[0] = one[1] * two[2] - one[2] * two[1];
        newOne[1] = one[2] * two[0] - one[0] * two[2];
        newOne[2] = one[0] * two[1] - one[1] * two[0];

        return newOne;
    }

    public Vector<Double> crossProductVector(Vector<Double> first, Vector<Double> second) {
        init(first, second);
        return crossProductVector();
    }

    public Vector<Double> crossProductVector() {
        Vector<Double> newOne = new Vector<>(new Double[3]);

        if (uno.length() != dos.length() || uno.length() != 3) {
            throw new RuntimeException("Unwanted vector!");
        }

        newOne.set(1, uno.get(2) * dos.get(3) - uno.get(3) * dos.get(2));
        newOne.set(2, uno.get(3) * dos.get(1) - uno.get(1) * dos.get(3));
        newOne.set(3, uno.get(1) * dos.get(2) - uno.get(2) * dos.get(1));

        return newOne;
    }
}
