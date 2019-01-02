package io.github.jhoneagle.math;

public class Vector<T> implements Term {
    private T[] values;

    public Vector(T[] values) {
        this.values = values;
    }

    public T get(int x) {
        return values[x - 1];
    }

    public void set(int x, T value) {
        values[x - 1] = value;
    }

    public int length() {
        return values.length;
    }

    @Override
    public String stringify() {
        if (values.length == 0) {
            return "[]";
        }

        String result = "[" + values[0];

        for (int i = 1; i < values.length; i++) {
            result += "," + values[i].toString();
        }

        return result + "]";
    }
}
