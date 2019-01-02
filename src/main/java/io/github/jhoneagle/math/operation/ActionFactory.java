package io.github.jhoneagle.math.operation;

import io.github.jhoneagle.math.operation.actiontype.*;

public class ActionFactory {
    public Action getSum(Action first, Action second) {
        return new Sum(first, second);
    }

    public Action getSum(Double first, Double second) {
        return new Sum(first, second);
    }

    public Action getMinus(Action first, Action second) {
        return new Minus(first, second);
    }

    public Action getMinus(Double first, Double second) {
        return new Minus(first, second);
    }

    public Action getMultiply(Action first, Action second) {
        return new Multiply(first, second);
    }

    public Action getMultiply(Double first, Double second) {
        return new Multiply(first, second);
    }

    public Action getDivide(Action first, Action second) {
        return new Divide(first, second);
    }

    public Action getDivide(Double first, Double second) {
        return new Divide(first, second);
    }

    public Action getPower(Action first, Action second) {
        return new Power(first, second);
    }

    public Action getPower(Double first, Double second) {
        return new Power(first, second);
    }

    public Action getTan(Action first) {
        return new Tan(first);
    }

    public Action getTan(Double first) {
        return new Tan(first);
    }

    public Action getSin(Action first) {
        return new Sin(first);
    }

    public Action getSin(Double first) {
        return new Sin(first);
    }

    public Action getCos(Action first) {
        return new Cos(first);
    }

    public Action getCos(Double first) {
        return new Cos(first);
    }

    public Action getFactorial(Action first) {
        return new Factorial(first);
    }

    public Action getFactorial(Long first) {
        return new Factorial(first);
    }

    public Action getBracket(Action first) {
        return new Bracket(first);
    }

    public Action getBracket(Double first) {
        return new Bracket(first);
    }

    public Action getSqrt(Action first) {
        return new Sqrt(first);
    }

    public Action getSqrt(Double first) {
        return new Sqrt(first);
    }

    public Action getAbsolute(Action first) {
        return new Absolute(first);
    }

    public Action getAbsolute(Double first) {
        return new Absolute(first);
    }

    public Action getNegation(Action first) {
        return new Negation(first);
    }

    public Action getNegation(Double first) {
        return new Negation(first);
    }
}
