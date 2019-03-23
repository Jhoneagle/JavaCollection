package io.github.jhoneagle.math;

public class Matrix implements Term {
    private Double[][] values;

    public Matrix(Double[][] values) {
        this.values = values;
    }

    public Matrix(int height, int width) {
        values = new Double[height][width];
    }

    public Double[][] getMatrixValues() {
        return values;
    }

    public long getAsLong(int y, int x) {
        return Double.doubleToLongBits(values[y - 1][x - 1]);
    }

    public int getAsInteger(int y, int x) {
        return Math.toIntExact(getAsLong(y, x));
    }

    public void set(int y, int x, double value) {
        values[y - 1][x - 1] = value;
    }

    public double get(int y, int x) {
        return values[y - 1][x - 1];
    }

    public void set(int y, int x, long value) {
        values[y - 1][x - 1] = Double.longBitsToDouble(value);
    }

    public void set(int y, int x, int value) {
        values[y - 1][x - 1] = (double) value;
    }

    public int height() {
        return values.length;
    }

    public int width() {
        return values[0].length;
    }

    /**
     * Formulates the matrix into String.
     *
     * @return Matrix String representation.
     */
    @Override
    public String toString() {
        if (values.length == 0 || values[0].length == 0) {
            return "[]";
        }

        String result = "[" + values[0];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                result += " " + values[j];
            }

            if (i < values.length - 1) {
                result += ",";
            }
        }

        return result + "]";
    }
}
