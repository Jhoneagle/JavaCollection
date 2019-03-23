package io.github.jhoneagle.math.operation.actiontype;

import io.github.jhoneagle.math.operation.Action;

public class Factorial extends Action<Long> {
    public Factorial(Action first) {
        init(first);
    }

    public Factorial(Long firstValue) {
        init(firstValue);
    }

    public Factorial() {
    }

    @Override
    public Long execute() {
        if (first == null) {
            return count(firstValue);
        } else {
            return count(Math.round((Double) first.execute()));
        }
    }

    private Long count(long value) {
        long result = 1;

        if (value == 0) {
            return result;
        } else {
            result = value;
            value--;
        }

        while (value > 0) {
            result *= value;
            value--;
        }

        return result;
    }

    @Override
    public String toString() {
        if (first != null) {
            return "(" + first.toString() + ")!";
        } else {
            return "(" + firstValue + ")!";
        }
    }
}
