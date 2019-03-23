package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Cos extends Action<Double> {
    public Cos(Action first) {
        init(first);
    }

    public Cos(Double firstValue) {
        init(firstValue);
    }

    public Cos() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return Math.cos(Math.toRadians((firstValue)));
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.cos(Math.toRadians((one.doubleValue())));
            } else {
                return Math.cos(Math.toRadians(((Double) first.execute())));
            }
        }
    }

    @Override
    public String toString() {
        if (first != null) {
            return "cos(" + first.toString() + ")";
        } else {
            return "cos(" + firstValue + ")";
        }
    }
}
