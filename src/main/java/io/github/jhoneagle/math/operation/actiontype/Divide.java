package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Divide extends Action<Double> {
    public Divide(Action first, Action second) {
        init(first, second);
    }

    public Divide(Double firstValue, Double secondValue) {
        init(firstValue, secondValue);
    }

    public Divide() {
    }

    @Override
    public Double execute() {
        if (first == null || second == null) {
            return firstValue / secondValue;
        } else {
            if (first.getClass() == Factorial.class && second.getClass() == Factorial.class) {
                return (double) ((Long) first.execute() / (Long) second.execute());
            } else if (first.getClass() == Factorial.class) {
                Long one = (Long) first.execute();
                return one.doubleValue() / (Double) second.execute();
            } else if (second.getClass() == Factorial.class) {
                Long two = (Long) second.execute();
                return (Double) first.execute() / two.doubleValue();
            } else {
                return (Double) first.execute() / (Double) second.execute();
            }
        }
    }

    @Override
    public String toString() {
        if (first != null && second != null) {
            return first.toString() + "/" + second.toString();
        } else {
            return firstValue + "/" + secondValue;
        }
    }
}
