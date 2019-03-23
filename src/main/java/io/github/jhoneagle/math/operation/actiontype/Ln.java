package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Ln extends Action<Double> {
    public Ln(Action first) {
        init(first);
    }

    public Ln(Double firstValue) {
        init(firstValue);
    }

    public Ln() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return Math.log(firstValue);
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.log(one.doubleValue());
            } else {
                return Math.log((Double) first.execute());
            }
        }
    }

    @Override
    public String toString() {
        if (first != null) {
            return "ln(" + first.toString() + ")";
        } else {
            return "ln(" + firstValue + ")";
        }
    }
}
