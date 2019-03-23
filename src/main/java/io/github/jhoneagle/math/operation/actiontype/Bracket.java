package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Bracket extends Action<Double> {
    public Bracket(Action first) {
        init(first);
    }

    public Bracket(Double firstValue) {
        init(firstValue);
    }

    public Bracket() {
    }

    @Override
    public Double execute() {
        if (first == null) {
            return firstValue;
        } else {
            if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return one.doubleValue();
            }else {
                return (Double) first.execute();
            }
        }
    }

    @Override
    public String toString() {
        if (first != null) {
            return "(" + first.toString() + ")";
        } else {
            return "(" + firstValue + ")";
        }
    }
}
