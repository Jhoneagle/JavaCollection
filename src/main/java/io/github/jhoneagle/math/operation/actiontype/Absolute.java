package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Absolute extends Action<Double> {
    public Absolute(Action first) {
        init(first);
    }

    public Absolute(Double firstValue) {
        init(firstValue);
    }

    public Absolute() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return Math.abs(firstValue);
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.abs(one.doubleValue());
            }else {
                return Math.abs((Double) first.execute());
            }
        }
    }

    @Override
    public String stringify() {
        if (first != null) {
            return "abs(" + first.stringify() + ")";
        } else {
            return "abs(" + firstValue + ")";
        }
    }
}
