package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Log extends Action<Double> {
    public Log(Action first) {
        init(first);
    }

    public Log(Double firstValue) {
        init(firstValue);
    }

    public Log() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return Math.log10(firstValue);
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.log10(one.doubleValue());
            } else {
                return Math.log10((Double) first.execute());
            }
        }
    }

    @Override
    public String toString() {
        if (first != null) {
            return "log(" + first.toString() + ")";
        } else {
            return "log(" + firstValue + ")";
        }
    }
}
