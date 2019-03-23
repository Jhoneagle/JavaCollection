package io.github.jhoneagle.math;

public class Vector implements Term {
    private Double[] values;

    public Vector(Double[] values) {
        this.values = values;
    }

    public Vector(int dimension) {
        values = new Double[dimension];
    }

    public Double[] getVectorsValues() {
        return values;
    }

    public long getAsLong(int x) {
        return Double.doubleToLongBits(values[x - 1]);
    }

    public int getAsInteger(int x) {
        return Math.toIntExact(getAsLong(x));
    }

    public void set(int x, double value) {
        values[x - 1] = value;
    }

    public double get(int x) {
        return values[x - 1];
    }

    public void set(int x, long value) {
        values[x - 1] = Double.longBitsToDouble(value);
    }

    public void set(int x, int value) {
        values[x - 1] = (double) value;
    }

    /**
     * Length of the vector. Example vectors  [x,y,z] length is 3 as it's mathematical dimension is 3.
     *
     * @return the dimension of the vector
     */
    public int dimension() {
        return values.length;
    }

    /**
     * Formulates the vector into String.
     *
     * @return Vectors String representation.
     */
    @Override
    public String toString() {
        if (values.length == 0) {
            return "[]";
        }

        String result = "[" + values[0];

        for (int i = 1; i < values.length; i++) {
            result += "," + values[i];
        }

        return result + "]";
    }
}
