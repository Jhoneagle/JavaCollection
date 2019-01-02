package io.github.jhoneagle.math;

public class Matrix<T> implements Term {
    private T[][] values;

    public Matrix(T[][] values) {
        this.values = values;
    }

    public T get(int y, int x) {
        return values[y - 1][x - 1];
    }

    public void set(int y, int x, T value) {
        values[y - 1][x - 1] = value;
    }

    public int height() {
        return values.length;
    }

    public int width() {
        return values[0].length;
    }

    @Override
    public String stringify() {
        if (values.length == 0 || values[0].length == 0) {
            return "[]";
        }

        String result = "[" + values[0];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                result += " " + values[j].toString();
            }
            
            if (i < values.length - 1) {
                result += ",";
            }
        }

        return result + "]";
    }
}
