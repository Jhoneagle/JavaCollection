package io.github.jhoneagle.math;

public class Constant extends Element {
    public static final int id = 302;
    private Variable var;
    private double value;

    public Constant(String name, double value) {
        this(name, 1, value);
    }

    public Constant(String name, int degree, double value) {
        super(id);
        this.var = new Variable(name, degree);
        this.value = value;
    }

    /**
     * Returns the variable object it has initialized inside it's constructor.
     *
     * @return Variable object
     */
    public Variable getVariable() {
        return var;
    }

    /**
     * The variables name it's assigned to as constant value.
     *
     * @return Name of the variable as String
     */
    public String getName() {
        return var.getName();
    }

    public double getValue() {
        return value;
    }
}
