package io.github.jhoneagle.math.calculator;

import io.github.jhoneagle.math.operation.Action;
import io.github.jhoneagle.math.operation.ActionFactory;

/**
 *
 *
 * credits for the base of this parsing logic goes to https://stackoverflow.com/a/26227947.
 * There is some significant changes but it's origins are from that answer.
 */
public class MathExec {
    private String str;
    private int pos = -1;
    private int ch;
    private ActionFactory factory;

    public MathExec() {
        this.factory = new ActionFactory();
    }

    public MathExec(String str) {
        this.str = replace(str);;
        this.factory = new ActionFactory();
    }

    public Action parse(String param) {
        str = replace(param);
        return parse();
    }

    public Action parse() {
        nextChar();
        Action x = parseExpression();
        if (pos < str.length()) {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }

        return x;
    }

    public Double eval(String param) {
        return (double) parse(param).execute();
    }

    public Double eval() {
        return (double) parse().execute();
    }

    private String replace(String old) {
        return old.replace(" ", "");
    }

    private void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    private boolean eat(int charToEat) {
        while (ch == ' ') nextChar();

        if (ch == charToEat) {
            nextChar();
            return true;
        }

        return false;
    }

    private Action parseExpression() {
        Action x = parseTerm();

        for (;;) {
            if (eat('+')) {
                Action a = x;
                Action b = parseTerm();
                x = factory.getSum(a, b); // addition
            } else if (eat('-')) {
                Action a = x;
                Action b = parseTerm();
                x = factory.getMinus(a, b); // subtraction
            } else {
                return x;
            }
        }
    }

    private Action parseTerm() {
        Action x = parseFactor();

        for (;;) {
            if (eat('*')) {
                Action a = x;
                Action b = parseTerm();
                x = factory.getMultiply(a, b); // multiplication
            } else if (eat('/')) {
                Action a = x;
                Action b = parseTerm();
                x = factory.getDivide(a, b); // division
            } else {
                return x;
            }
        }
    }

    private Action parseFactor() {
        if (eat('+')) {
            return parseFactor(); // unary plus
        }
        if (eat('-')) {
            return factory.getNegation(parseFactor()); // unary minus
        }

        Action x;
        int startPos = this.pos;

        if (eat('(')) { // parentheses
            x = parseExpression();
            eat(')');
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') {
                nextChar();
            }

            x = factory.getBracket(Double.parseDouble(str.substring(startPos, this.pos)));
        } else if (ch >= 'a' && ch <= 'z') { // functions
            while (ch >= 'a' && ch <= 'z') {
                nextChar();
            }

            String func = str.substring(startPos, this.pos);
            x = parseFactor();

            if (func.equals("sqrt")) {
                x = factory.getSqrt(x);
            } else if (func.equals("sin")) {
                x = factory.getSin(x);
            } else if (func.equals("cos")) {
                x = factory.getCos(x);
            } else if (func.equals("tan")) {
                x = factory.getTan(x);
            } else if (func.equals("abs")) {
                x = factory.getAbsolute(x);
            } else {
                throw new RuntimeException("Unknown function: " + func);
            }
        } else {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }

        if (eat('^')) {
            x = factory.getPower(x, parseFactor()); // exponentiation
        } else if (eat('!')) {
            x = factory.getFactorial(x); // factorial
        }

        return x;
    }
}
