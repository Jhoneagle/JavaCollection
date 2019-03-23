package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Sin extends Action<Double> {
    public Sin(Action first) {
        init(first);
    }

    public Sin(Double firstValue) {
        init(firstValue);
    }

    public Sin() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return Math.sin(Math.toRadians((firstValue)));
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.sin(Math.toRadians((one.doubleValue())));
            } else {
                return Math.sin(Math.toRadians(((Double) first.execute())));
            }
        }
    }

    @Override
    public String toString() {
        if (first != null) {
            return "sin(" + first.toString() + ")";
        } else {
            return "sin(" + firstValue + ")";
        }
    }
}
