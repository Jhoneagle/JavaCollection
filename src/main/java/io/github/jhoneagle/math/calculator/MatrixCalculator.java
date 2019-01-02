package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Matrix;

public class MatrixCalculator {
    private Double[][] first;
    private Double[][] second;
    private Matrix<Double> one;
    private Matrix<Double> two;

    public MatrixCalculator() {
    }

    public MatrixCalculator(Matrix<Double> uno) {
        init(uno);
    }

    public MatrixCalculator(Double[][] uno) {
        init(uno);
    }

    public MatrixCalculator(Matrix<Double> uno, Matrix<Double> dos) {
        init(uno, dos);
    }

    public MatrixCalculator(Double[][] uno, Double[][] dos) {
        init(uno, dos);
    }

    public void init(Double[][]... values) {
        if (values.length > 0) {
            first = values[0];

            if (values.length > 1) {
                second = values[1];
            }
        }
    }

    public void init(Matrix<Double>... values) {
        if (values.length > 0) {
            one = values[0];

            if (values.length > 1) {
                two = values[1];
            }
        }
    }

    public Double[][] additionArray(Double[][] uno, Double[][] dos) {
        init(uno, dos);
        return additionArray();
    }

    public Double[][] additionArray() {
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

    public Double[][] scalarMultiplyArray(double scalar) {
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[0].length; j++) {
                first[i][j] *= scalar;
            }
        }

        return first;
    }

    public Double[][] scalarMultiplyArray(double scalar, Double[][] uno) {
        init(uno);
        return scalarMultiplyArray(scalar);
    }

    public Double[][] transpositionArray(Double[][] uno) {
        init(uno);
        return transpositionArray();
    }

    public Double[][] transpositionArray() {
        Double[][] newOne = new Double[first[0].length][first.length];

        for (int i = 0; i < first[0].length; i++) {
            for (int j = 0; j < first.length; j++) {
                newOne[i][j] = first[j][i];
            }
        }

        return newOne;
    }

    public Double[][] multiplicationArray() {
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

    public Double[][] multiplicationArray(Double[][] uno, Double[][] dos) {
        init(uno, dos);
        return multiplicationArray();
    }

    public double determinantArray() {
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

    public double determinantArray(Double[][] uno) {
        init(uno);
        return determinantArray();
    }

    public Matrix<Double> additionMatrix(Matrix<Double> uno, Matrix<Double> dos) {
        init(uno, dos);
        return additionMatrix();
    }

    public Matrix<Double> additionMatrix() {
        if (one.height() != two.height() || one.width() != two.width()) {
            throw new RuntimeException("Unwanted matrix!");
        }

        for (int i = 1; i <= one.height(); i++) {
            for (int j = 1; j <= one.width(); j++) {
                one.set(i, j, one.get(i, j) + two.get(i, j));
            }
        }

        return one;
    }

    public Matrix<Double> scalarMultiplyMatrix(double scalar) {
        for (int i = 1; i <= one.height(); i++) {
            for (int j = 1; j <= one.width(); j++) {
                one.set(i, j, one.get(i, j) * scalar);
            }
        }

        return one;
    }

    public Matrix<Double> scalarMultiplyMatrix(double scalar, Matrix<Double> uno) {
        init(uno);
        return scalarMultiplyMatrix(scalar);
    }

    public Matrix<Double> transpositionMatrix(Matrix<Double> uno) {
        init(uno);
        return transpositionMatrix();
    }

    public Matrix<Double> transpositionMatrix() {
        Matrix<Double> newOne = new Matrix<>(new Double[one.width()][one.height()]);

        for (int i = 1; i <= one.width(); i++) {
            for (int j = 1; j <= one.height(); j++) {
                newOne.set(i, j, one.get(j, i));
            }
        }

        return newOne;
    }

    public Matrix<Double> multiplicationMatrix() {
        Matrix<Double> newOne = new Matrix<>(new Double[one.height()][two.width()]);

        if (one.width() != two.height()) {
            throw new RuntimeException("Unwanted matrix!");
        }

        for (int i = 1; i <= newOne.height(); i++) {
            for (int j = 1; j <= newOne.width(); j++) {
                double value = 0;

                for (int k = 1; k <= one.width(); k++) {
                    value += one.get(i, k) * two.get(k, j);
                }

                newOne.set(i, j, value);
            }
        }

        return newOne;
    }

    public Matrix<Double> multiplicationMatrix(Matrix<Double> uno, Matrix<Double> dos) {
        init(uno, dos);
        return multiplicationMatrix();
    }

    public double determinantMatrix() {
        double result = 0;

        if (one.height() == 1 || one.width() == 1) {
            result = one.get(1, 1);
        } else if (one.height() == 2 || one.width() == 2) {
            result = one.get(1, 1) * one.get(2, 2) - one.get(1, 2) * one.get(2,1);
        } else if (one.height() == 3 || one.width() == 3) {
            result = one.get(1, 1) * one.get(2, 2) * one.get(3,3);
            result -= one.get(1, 1) * one.get(2, 3) * one.get(3, 2);
            result -= one.get(1, 2) * one.get(2,1) * one.get(3,3);
            result += one.get(1, 2) * one.get(2, 3) * one.get(3,1);
            result += one.get(1,3) * one.get(2,1) * one.get(3, 2);
            result -= one.get(1,3) * one.get(2, 2) * one.get(3,1);
        }

        return result;
    }

    public double determinantMatrix(Matrix<Double> uno) {
        init(uno);
        return determinantMatrix();
    }
}
