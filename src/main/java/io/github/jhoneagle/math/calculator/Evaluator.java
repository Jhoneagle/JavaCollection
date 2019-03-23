package io.github.jhoneagle.math.calculator;

public class Evaluator {
    private static String str;
    private static int pos = -1;
    private static int ch;

    /**
     * Evaluates mathematical expression which can contain various basic operations. Also support parentheses.
     *
     * @param param math expression with all brackets and operations and numbers.
     *
     * @return result of the calculation.
     */
    public static double eval(String param) {
        str = param;
        nextChar();
        double x = parseExpression();

        if (pos < str.length()) {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }

        return x;
    }

    private static void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    private static boolean eat(int charToEat) {
        while (ch == ' ') nextChar();

        if (ch == charToEat) {
            nextChar();
            return true;
        }

        return false;
    }

    private static double parseExpression() {
        double x = parseTerm();

        for (;;) {
            if (eat('+')) {
                double a = x;
                double b = parseTerm();
                x = a + b; // addition
            } else if (eat('-')) {
                double a = x;
                double b = parseTerm();
                x = a - b; // subtraction
            } else {
                return x;
            }
        }
    }

    private static double parseTerm() {
        double x = parseFactor();

        for (;;) {
            if (eat('*')) {
                double a = x;
                double b = parseTerm();
                x = a * b; // multiplication
            } else if (eat('/')) {
                double a = x;
                double b = parseTerm();
                x = a / b; // division
            } else {
                return x;
            }
        }
    }

    private static double parseFactor() {
        if (eat('+')) {
            return parseFactor(); // unary plus
        }
        if (eat('-')) {
            return -parseFactor(); // unary minus
        }

        double x;
        int startPos = pos;

        if (eat('(')) { // parentheses
            x = parseExpression();
            eat(')');
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') {
                nextChar();
            }

            x = Double.parseDouble(str.substring(startPos, pos));
        } else if (ch >= 'a' && ch <= 'z') { // functions
            while (ch >= 'a' && ch <= 'z') {
                nextChar();
            }

            String func = str.substring(startPos, pos);
            x = parseFactor();

            if (func.equals("sqrt")) {
                x = Math.sqrt(x);
            } else if (func.equals("sin")) {
                x = Math.sin(x);
            } else if (func.equals("cos")) {
                x = Math.cos(x);
            } else if (func.equals("tan")) {
                x = Math.tan(x);
            } else if (func.equals("abs")) {
                x = Math.abs(x);
            } else if (func.equals("log")) {
                x = Math.log10(x);
            } else if (func.equals("ln")) {
                x = Math.log(x);
            } else {
                throw new RuntimeException("Unknown function: " + func);
            }
        } else {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }

        if (eat('^')) {
            x = Math.pow(x, parseFactor()); // exponentiation
        } else if (eat('!')) {
            x = count(Double.doubleToLongBits(x)).doubleValue(); // factorial
        }

        return x;
    }

    private static Long count(long value) {
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
}
