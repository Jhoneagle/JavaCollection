package io.github.jhoneagle.math.operation;

import io.github.jhoneagle.Operate;
import io.github.jhoneagle.math.Term;

public abstract class Action<T> implements Operate<T>, Term {
    protected Action first;
    protected Action second;
    protected T firstValue;
    protected T secondValue;

    public void init(Action<T>... actions) {
        if (actions.length > 0) {
            first = actions[0];

            if (actions.length > 1) {
                second = actions[1];
            }
        }
    }

    public void init(T... actions) {
        if (actions.length > 0) {
            firstValue = actions[0];

            if (actions.length > 1) {
                secondValue = actions[1];
            }
        }
    }

    public Action getFirst() {
        return first;
    }

    public Action getSecond() {
        return second;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public T getSecondValue() {
        return secondValue;
    }
}
