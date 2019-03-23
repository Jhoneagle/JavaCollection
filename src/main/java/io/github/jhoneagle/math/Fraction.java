package io.github.jhoneagle.math;

public class Fraction {
    private double ratios;
    private double division;

    public Fraction(double ratios, double division) {
        this.ratios = ratios;
        this.division = division;
    }

    public double getRatios() {
        return ratios;
    }

    public double getDivision() {
        return division;
    }
}
