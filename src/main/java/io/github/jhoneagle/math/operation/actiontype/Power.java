package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Power extends Action<Double> {
    public Power(Action first, Action second) {
        init(first, second);
    }

    public Power(Double firstValue, Double secondValue) {
        init(firstValue, secondValue);
    }

    public Power() {
    }

    @Override
    public Double execute() {
        if (first == null || second == null) {
            return Math.pow(firstValue, secondValue);
        } else {
            if (first.getClass() == Factorial.class && second.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                Long two = (Long) second.execute();
                return Math.pow(one.doubleValue(), two.doubleValue());
            } else if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return Math.pow(one.doubleValue(), (Double) second.execute());
            } else if (second.getClass() == Factorial.class) {
                Long two = (Long) second.execute();
                return Math.pow((Double) first.execute(), two.doubleValue());
            } else {
                return Math.pow((Double) first.execute(), (Double) second.execute());
            }
        }
    }

    @Override
    public String stringify() {
        if (first != null && second != null) {
            return first.stringify() + "^" + second.stringify();
        } else {
            return firstValue + "^" + secondValue;
        }
    }
}
