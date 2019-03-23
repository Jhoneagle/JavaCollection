package io.github.jhoneagle.math;

public class Variable implements Term {
    private String name;
    private int degree;

    public Variable(String name, int degree) {
        this.name = name;
        this.degree = degree;
    }

    public Variable(String name) {
        this.name = name;
        this.degree = 1;
    }

    public String getName() {
        return name;
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        if (degree != 1) {
            return name + "^" + degree;
        } else {
            return name;
        }
    }
}
