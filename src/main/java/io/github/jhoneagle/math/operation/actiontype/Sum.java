package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Sum extends Action<Double> {
    public Sum(Action first, Action second) {
        init(first, second);
    }

    public Sum(Double firstValue, Double secondValue) {
        init(firstValue, secondValue);
    }

    public Sum() {
    }

    @Override
    public Double execute() {
        if (first == null || second == null) {
            return firstValue + secondValue;
        } else {
            if (first.getClass() == Factorial.class && second.getClass() == Factorial.class) {
                Long result = (Long) first.execute() + (Long) second.execute();
                return result.doubleValue();
            } else if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return one.doubleValue() + (Double) second.execute();
            } else if (second.getClass() == Factorial.class) {
                Long two = (Long) second.execute();
                return (Double) first.execute() + two.doubleValue();
            } else {
                return (Double) first.execute() + (Double) second.execute();
            }
        }
    }

    @Override
    public String toString() {
        if (first != null && second != null) {
            return first.toString() + "+" + second.toString();
        } else {
            return firstValue + "+" + secondValue;
        }
    }
}
