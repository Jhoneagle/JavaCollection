package io.github.jhoneagle.math.calculator;

public class BooleanCalculator {
    private Boolean[] values;

    public BooleanCalculator(Boolean... values) {
        this.values = values;
    }

    public BooleanCalculator() {
    }

    public void init(Boolean... values) {
        this.values = values;
    }

    public boolean and() {
        for (boolean value : values) {
            if (not(value)) {
                return false;
            }
        }

        return true;
    }

    public boolean and(Boolean... values) {
        init(values);
        return and();
    }

    public boolean or(Boolean... values) {
        init(values);
        return or();
    }

    public boolean or() {
        for (boolean value : values) {
            if (value) {
                return true;
            }
        }

        return false;
    }

    public boolean not(Boolean first) {
        return !first;
    }

    public boolean materialImplication(Boolean first, Boolean second) {
        if (first && not(second)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean exclusiveOR(Boolean first, Boolean second) {
        return not(equivalence(first, second));
    }

    public boolean equivalence(Boolean... values) {
        init(values);
        return equivalence();
    }

    public boolean equivalence() {
        if (values.length == 0) {
            return true;
        }

        Boolean value = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] != value) {
                return false;
            }
        }

        return true;
    }
}
