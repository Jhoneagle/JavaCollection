package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Sqrt extends Action<Double> {
    public Sqrt(Action first) {
        init(first);
    }

    public Sqrt(Double firstValue) {
        init(firstValue);
    }

    public Sqrt() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return Math.sqrt(firstValue);
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.sqrt((one.doubleValue()));
            } else {
                return Math.sqrt(((Double) first.execute()));
            }
        }
    }

    @Override
    public String toString() {
        if (first != null) {
            return "sqrt(" + first.toString() + ")";
        } else {
            return "sqrt(" + firstValue + ")";
        }
    }
}
