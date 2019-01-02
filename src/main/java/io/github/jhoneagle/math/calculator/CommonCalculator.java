package io.github.jhoneagle.math.calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CommonCalculator {
    private String one;
    private String two;

    public CommonCalculator(String one, String two) {
        init(one, two);
    }

    public CommonCalculator() {
    }

    public void init(String one, String two) {
        this.one = one;
        this.two = two;
    }

    public String sumOfRationalNumbers() {
        return operateRationalNumbers(one, two, '+');
    }

    public String sumOfRationalNumbers(String firstRational, String secondRational) {
        return operateRationalNumbers(firstRational, secondRational, '+');
    }

    public String minusOfRationalNumbers() {
        return minusOfRationalNumbers(one, two);
    }

    public String minusOfRationalNumbers(String firstRational, String secondRational) {
        String newSecond = "-" + secondRational;
        return sumOfRationalNumbers(firstRational, newSecond);
    }

    public String multiplyOfRationalNumbers() {
        return operateRationalNumbers(one, two, '*');
    }

    public String multiplyOfRationalNumbers(String firstRational, String secondRational) {
        return operateRationalNumbers(firstRational, secondRational, '*');
    }

    public String divideOfRationalNumbers() {
        return divideOfRationalNumbers(one, two);
    }

    public String divideOfRationalNumbers(String firstRational, String secondRational) {
        String[] second = secondRational.split("/");
        String newSecond = second[1] + "/" + second[0];
        return multiplyOfRationalNumbers(firstRational, newSecond);
    }

    private String operateRationalNumbers(String firstRational, String secondRational, char type) {
        String[] first = firstRational.split("/");
        String[] second = secondRational.split("/");

        int firstDivider = Integer.parseInt(first[1]);
        int secondDivider = Integer.parseInt(second[1]);
        int firstDivided = Integer.parseInt(first[0]);
        int secondDivided = Integer.parseInt(second[0]);

        if (type == '+') {
            int commonDivider = firstDivider * secondDivider;
            int commonDivided = firstDivided * secondDivider + secondDivided * firstDivider;

            return commonDivided + "/" + commonDivider;
        } else if (type == '*') {
            int commonDivider = firstDivider * secondDivider;
            int commonDivided = firstDivided * secondDivided;

            return commonDivided + "/" + commonDivider;
        } else {
            throw new RuntimeException("undefined type!");
        }
    }



    static public int greatestCommonDIvisor (int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0){
            if (a > b){
                a -= b;
            } else {
                b -= a;
            }
        }

        return a;
    }

    static public int smallestCommonMultiple(int a, int b) {
        int ab = Math.abs(a) * Math.abs(b);
        int sytAB = greatestCommonDIvisor(a, b);

        return ab / sytAB;
    }

    static public List<Integer> getFactors(int n) {
        Deque<Integer> f = new ArrayDeque<>();

        for (int x = 2; x * x <= n; x++) {
            while (n % x == 0) {
                f.addLast(x);

                n /= x;
            }
        }

        if (n > 1) {
            f.addLast(n);
        }

        return new ArrayList<>(f);
    }
}
