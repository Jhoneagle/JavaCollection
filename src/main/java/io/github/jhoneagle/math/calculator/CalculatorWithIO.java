package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.io.IO;

public class CalculatorWithIO {
    private double result;
    private IO<String> io;

    public CalculatorWithIO() {
        result = 0;
    }

    public CalculatorWithIO(IO<String> io) {
        this();
        this.io = io;
    }

    public void setIo(IO<String> io) {
        this.io = io;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setResult() {
        this.result = Double.parseDouble(io.read());
    }

    public double getResult() {
        if (io != null) {
            io.write("" + result);
            return 0;
        } else {
            return result;
        }
    }

    public void sum(double value) {
        result += value;
    }

    public void sum() {
        double n = Double.parseDouble(io.read());
        sum(n);
    }

    public void minus(double value) {
        result -= value;
    }

    public void minus() {
        double n = Double.parseDouble(io.read());
        minus(n);
    }

    public void multiply(double value) {
        result *= value;
    }

    public void multiply() {
        double n = Double.parseDouble(io.read());
        multiply(n);
    }

    public void divide(double value) {
        result /= value;
    }

    public void divide() {
        double n = Double.parseDouble(io.read());
        divide(n);
    }

    public void pow(double value) {
        result = Math.pow(result, value);
    }

    public void pow() {
        double n = Double.parseDouble(io.read());
        pow(n);
    }

    public void sin() {
        result = Math.sin(result);
    }

    public void previous() {
        result = Double.parseDouble(io.previous());
    }

    public void previous(double value) {
        result = value;
    }

    public void cos() {
        result = Math.cos(result);
    }

    public void tan() {
        result = Math.tan(result);
    }

    public void abs() {
        result = Math.abs(result);
    }

    public void round() {
        result = Math.round(result);
    }

    public void negate() {
        result *= -1;
    }

    public void factorial() {
        long round = Math.round(result);
        long value = round;

        while(round > 1) {
            round--;
            value *= round;
        }

        result = value;
    }

    public void sqrt() {
        result = Math.sqrt(result);
    }

    public void zero() {
        result = 0;
    }
}
