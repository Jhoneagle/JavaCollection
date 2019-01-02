package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Negation extends Action<Double> {
    public Negation(Action first) {
        init(first);
    }

    public Negation(Double firstValue) {
        init(firstValue);
    }

    public Negation() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return -firstValue;
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return -one.doubleValue();
            } else {
                return -((Double) first.execute());
            }
        }
    }

    @Override
    public String stringify() {
        if (first != null) {
            return "(-(" + first.stringify() + "))";
        } else {
            return "(-(" + firstValue + "))";
        }
    }
}
