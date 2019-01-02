package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.Term;
import io.github.jhoneagle.math.operation.Action;
import io.github.jhoneagle.math.operation.ActionFactory;

public class ProbabilityCalculator {
    private String[] func;
    private ActionFactory factory;

    public ProbabilityCalculator() {
        factory = new ActionFactory();
    }

    public ProbabilityCalculator(String nk) {
        init(nk);
        factory = new ActionFactory();
    }

    public ProbabilityCalculator(Term nk) {
        init(nk);
        factory = new ActionFactory();
    }

    public ProbabilityCalculator(long n, long k) {
        init(n, k);
        factory = new ActionFactory();
    }

    public void init(String nk) {
        String clean = nk.substring(1, nk.length() - 1);
        this.func = clean.split(",");
    }

    public void init(Term nk) {
        init(nk.stringify());
    }

    public void init(long n, long k) {
        this.func = new String[2];
        this.func[0] = Long.toString(n);
        this.func[1] = Long.toString(k);
    }

    public Double permutation() {
        Action result = factory.getFactorial(Long.parseLong(func[0]));
        Long execute = (Long) result.execute();
        return execute.doubleValue();
    }

    public Double permutation(String nk) {
        init(nk);
        return permutation();
    }

    public Double permutation(Term nk) {
        return permutation(nk.stringify());
    }

    public Double permutation(long n) {
        Action result = factory.getFactorial(n);
        Long execute = (Long) result.execute();
        return execute.doubleValue();
    }

    public Double variation() {
        Action minus = factory.getMinus(Double.parseDouble(func[0]), Double.parseDouble(func[1]));
        Action factorialOfMinus = factory.getFactorial(minus);

        Action factorial = factory.getFactorial(Long.parseLong(func[0]));
        Action result = factory.getDivide(factorial, factorialOfMinus);

        return (double) result.execute();
    }

    public Double variation(String nk) {
        init(nk);
        return variation();
    }

    public Double variation(Term nk) {
        return variation(nk.stringify());
    }

    public Double variation(long n, long k) {
        Action minus = factory.getMinus(Double.longBitsToDouble(n), Double.longBitsToDouble(k));
        Action factorialOfMinus = factory.getFactorial(minus);

        Action factorial = factory.getFactorial(n);
        Action result = factory.getDivide(factorial, factorialOfMinus);

        return (double) result.execute();
    }

    public Double combination() {
        Action minus = factory.getMinus(Double.parseDouble(func[0]), Double.parseDouble(func[1]));
        Action factorialOfMinus = factory.getFactorial(minus);
        Action factorialForMultiply = factory.getFactorial(Long.parseLong(func[1]));
        Action multiply = factory.getMultiply(factorialOfMinus, factorialForMultiply);

        Action factorial = factory.getFactorial(Long.parseLong(func[0]));
        Action result = factory.getDivide(factorial, multiply);

        return (double) result.execute();
    }

    public Double combination(String nk) {
        init(nk);
        return combination();
    }

    public Double combination(Term nk) {
        return combination(nk.stringify());
    }

    public Double combination(long n, long k) {
        Action minus = factory.getMinus(Double.longBitsToDouble(n), Double.longBitsToDouble(k));
        Action factorialOfMinus = factory.getFactorial(minus);
        Action factorialForMultiply = factory.getFactorial(k);
        Action multiply = factory.getMultiply(factorialOfMinus, factorialForMultiply);

        Action factorial = factory.getFactorial(n);
        Action result = factory.getDivide(factorial, multiply);

        return (double) result.execute();
    }
}
