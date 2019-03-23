package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Tan extends Action<Double> {
    public Tan(Action first) {
        init(first);
    }

    public Tan(Double firstValue) {
        init(firstValue);
    }

    public Tan() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return Math.tan(Math.toRadians((firstValue)));
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.tan(Math.toRadians((one.doubleValue())));
            } else {
                return Math.tan(Math.toRadians(((Double) first.execute())));
            }
        }
    }

    @Override
    public String toString() {
        if (first != null) {
            return "tan(" + first.toString() + ")";
        } else {
            return "tan(" + firstValue + ")";
        }
    }
}
