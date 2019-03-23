package io.github.jhoneagle.math.calculator;

public class MathOperations {
    /**
     * Generalized logarithm of number.
     *
     * @param a value taken logarithm from
     * @param b base of the logarithm
     *
     * @return base b logarithm of value a.
     */
    public static double log(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            return Double.NaN;
        }

        double result = Double.NaN;
        double logb = Math.log(b);

        if (logb != 0) {
            result = Math.log(a) / logb;
        }

        return result;
    }

    /**
     * Extracts decimal numbers natural number part by removing decimal part.
     *
     * @param x decimal value
     *
     * @return numbers non decimal part.
     */
    public static double integerPart(double x) {
        if (x > 0) {
            return Math.floor(x);
        } else if (x < 0) {
            return -Math.floor(-x);
        } else {
            return 0;
        }
    }

    /**
     * Calculates bells number in partition of size n.
     *
     * @param n size of the partition
     *
     * @return bells number on value if n > 0 and 1 if n is 0 and otherwise NaN.
     */
    public static double bellNumber(int n) {
        double result = Double.NaN;

        if (n > 1) {
            n -= 1;
            long[][] bellTriangle = new long[n+1][n+1];
            bellTriangle[0][0] = 1;
            bellTriangle[1][0] = 1;

            for (int r = 1; r <= n; r++) {
                for (int k = 0; k < r; k++) {
                    bellTriangle[r][k + 1] = bellTriangle[r - 1][k] + bellTriangle[r][k];
                }

                if (r < n) {
                    bellTriangle[r+1][0] = bellTriangle[r][r];
                }
            }

            result = bellTriangle[n][n];
        } else if (n >= 0) {
            result = 1;
        }

        return result;
    }

    /**
     * Calculates bells number in partition of size n.
     *      *
     *      * @param n size of the partition
     *      *
     *      * @return bells number on value if n > 0 and 1 if n is 0 and otherwise NaN.
     */
    public static  double bellNumber(double n) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        } else {
            return bellNumber((int) Math.round(n) );
        }
    }

    /**
     * Calculates Euler number.
     *
     * @param n the n function param
     * @param k the k function param
     *
     * @return return Euler number if n and k are higher than 1. otherwise 0, 1, or NaN.
     */
    public static double eulerNumber(int n, int k) {
        if (n < 0) {
            return Double.NaN;
        }

        if (k < 0) {
            return 0;
        }

        if (n == 0) {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        return (k+1) * eulerNumber(n-1, k) + (n-k) * eulerNumber(n-1, k-1);
    }

    /**
     * Calculates Euler number.
     *
     * @param n the n function param
     * @param k the k function param
     *
     * @return return Euler number if n and k are higher than 1. otherwise 0, 1, or NaN.
     */
    public static double eulerNumber(double n, double k) {
        if (Double.isNaN(n) || Double.isNaN(k)) {
            return Double.NaN;
        } else {
            return eulerNumber((int) Math.round(n), (int) Math.round(k));
        }
    }

    /**
     * Calculates factorial of natural number.
     *
     * @param n natural number
     *
     * @return returns numbers factorial if atleast 0 otherwise NaN.
     */
    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return Double.NaN;
        } else {
            double result = 1;

            while (n > 0) {
                result *= n;
                n--;
            }

            return result;
        }
    }

    /**
     * Calculates factorial of natural number.
     *
     * @param n natural number
     *
     * @return returns numbers factorial if atleast 0 otherwise NaN.
     */
    public static double factorial(double n) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        } else {
            return factorial((int) Math.round(n));
        }
    }

    /**
     * Generalized binomial coefficient
     *
     * @param n the n function param
     * @param k the k function param
     *
     * @return NaN or binomial coefficient
     */
    public static double binomCoeff(double n, long k) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        }

        double result = Double.NaN;

        if (k >= 0) {
            double numerator = countNumerator(n, k);

            double denominator = 1;

            if (k > 1) {
                for (long i = 1; i <= k; i++) {
                    denominator *= i;
                }
            }

            result = numerator / denominator;
        }

        return result;
    }


    private static double countNumerator(double n, long k) {
        double numerator = 1;

        if (k > 0) {
            for (long i = 0; i <= k-1; i++) {
                numerator *= (n-i);
            }
        }
        return numerator;
    }

    /**
     * Generalized binomial coefficient
     *
     * @param n the n function param
     * @param k the k function param
     *
     * @return NaN or binomial coefficient
     */
    public static double binomCoeff(double n, double k) {
        if (Double.isNaN(n) || Double.isNaN(k)) {
            return Double.NaN;
        } else {
            return binomCoeff(n, Math.round(k));
        }
    }

    /**
     * Counts the amount of k permutations that can be drawn for n elements set.
     *
     * @param n size of the set
     * @param k amount of drawn
     *
     * @return amount of waves that k draw can be done to n set
     */
    public static double permutations(double n, long k) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        }

        double result = Double.NaN;

        if (k >= 0) {
            result = countNumerator(n, k);
        }

        return result;
    }

    /**
     * Counts the amount of k permutations that can be drawn for n elements set.
     *
     * @param n size of the set
     * @param k amount of drawn
     *
     * @return amount of waves that k draw can be done to n set
     */
    public static double permutations(double n, double k) {
        if (Double.isNaN(n) || Double.isNaN(k)) {
            return Double.NaN;
        } else {
            return permutations(n, Math.round(k));
        }
    }

    /**
     * Calculates Bernoulli number.
     *
     * @param m the m function parameter
     * @param n the n function parameter
     *
     * @return Bernoulli number or NaN if n or m is less then 0
     */
    public static double bernoulliNumber(int m, int n) {
        double result = Double.NaN;

        if ((m >= 0) && (n >= 0)) {
            result = 0;

            for (int k = 0; k <= m; k++) {
                for (int v = 0; v <= k; v++) {
                    result += Math.pow(-1, v) * binomCoeff(k, v) * (Math.pow(n + v, m) / (k + 1));
                }
            }
        }

        return result;
    }

    /**
     * Calculates Bernoulli number.
     *
     * @param m the m function parameter
     * @param n the n function parameter
     *
     * @return Bernoulli number or NaN if n or m is less then 0
     */
    public static double bernoulliNumber(double m, double n) {
        if (Double.isNaN(m) || Double.isNaN(n)) {
            return Double.NaN;
        } else {
            return bernoulliNumber((int) Math.round(m),(int) Math.round(n));
        }
    }

    /**
     * Stirling numbers of the first kind.
     *
     * @param n the n function parameter
     * @param k the k function parameter
     *
     * @return Stirling numbers of the first kind
     */
    public static double Stirling1Number(int n, int k) {
        double notZero = StirlingNotZero(n, k);

        if (notZero != 2) {
            return notZero;
        } else {
            return (n-1) * Stirling1Number(n-1, k) + Stirling1Number(n-1, k-1);
        }
    }

    /**
     * Stirling numbers of the first kind.
     *
     * @param n the n function parameter
     * @param k the k function parameter
     *
     * @return Stirling numbers of the first kind
     */
    public static double Stirling1Number(double n, double k) {
        if (Double.isNaN(n) || Double.isNaN(k)) {
            return Double.NaN;
        } else {
            return Stirling1Number((int) Math.round(n), (int) Math.round(k));
        }
    }

    private static double StirlingNotZero(int n, int k) {
        if (k > n) {
            return 0;
        }

        if (n == 0 || k == 0) {
            if (n == 0 && k == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        return 2;
    }

    /**
     * Stirling numbers of the second kind.
     *
     * @param n the n function parameter
     * @param k the k function parameter
     *
     * @return Stirling numbers of the second kind
     */
    public static double Stirling2Number(int n, int k) {
        double notZero = StirlingNotZero(n, k);

        if (notZero != 2) {
            return notZero;
        } else {
            return k * Stirling2Number(n-1, k) + Stirling2Number(n-1, k-1);
        }
    }

    /**
     * Stirling numbers of the second kind.
     *
     * @param n the n function parameter
     * @param k the k function parameter
     *
     * @return Stirling numbers of the second kind
     */
    public static double Stirling2Number(double n, double k) {
        if (Double.isNaN(n) || Double.isNaN(k)) {
            return Double.NaN;
        } else {
            return Stirling2Number((int) Math.round(n), (int) Math.round(k));
        }
    }

    /**
     * Calculates Worpitzky number.
     *
     * @param n the n function parameter
     * @param k the k function parameter
     *
     * @return Worpitzky number or NaN
     */
    public static double worpitzkyNumber(int n, int k) {
        double result = Double.NaN;

        if ((k >= 0) && (k <= n)) {
            result = 0;

            for (int v = 0; v <= k; v++) {
                result += Math.pow(-1, v+k) * Math.pow(v+1, n) * binomCoeff(k, v);
            }
        }

        return result;
    }

    /**
     * Calculates Worpitzky number.
     *
     * @param n the n function parameter
     * @param k the k function parameter
     *
     * @return Worpitzky number or NaN
     */
    public static double worpitzkyNumber(double n, double k) {
        if (Double.isNaN(n) || Double.isNaN(k)) {
            return Double.NaN;
        } else {
            return worpitzkyNumber((int) Math.round(n), (int) Math.round(k));
        }
    }

    /**
     * Calculates Harmonic number.
     *
     * @param n harmonic numbers n value
     *
     * @return harmonic number of n.
     */
    public static double harmonicNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        double h = 1;

        for (double k = 2.0; k <= n; k++) {
            h += 1.0 / k;
        }

        return h;
    }

    /**
     * Calculates Harmonic number.
     *
     * @param n harmonic numbers n value
     *
     * @return harmonic number of n.
     */
    public static double harmonicNumber(double n) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        } else {
            return harmonicNumber((int) Math.round(n) );
        }
    }

    /**
     * Harmonic number 1/1 + 1/2^x + ... + 1/n^x.
     *
     * @param x the x function parameter
     * @param n the n function parameter
     *
     * @return Harmonic number or NaN if x less then 0.
     */
    public static double harmonicNumber(double x, int n) {
        if ((Double.isNaN(x)) || (x < 0)) {
            return Double.NaN;
        }

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return x;
        }

        double h = 1;

        for (double k = 2.0; k <= n; k++) {
            h += 1 / power(k, x);
        }

        return h;
    }

    /**
     * Harmonic number 1/1 + 1/2^x + ... + 1/n^x.
     *
     * @param x the x function parameter
     * @param n the n function parameter
     *
     * @return Harmonic number or NaN if x less then 0.
     */
    public static double harmonicNumber(double x, double n) {
        if ((Double.isNaN(x)) || (Double.isNaN(n))) {
            return Double.NaN;
        } else {
            return harmonicNumber(x, (int) Math.round(n));
        }
    }

    /**
     * Calculates Catalan number.
     *
     * @param n the n function parameter
     *
     * @return Catalan numbers on position n.
     */
    public static double catalanNumber(int n) {
        return binomCoeff(2*n, n) * div(1, n+1);
    }

    /**
     * Calculates Catalan number.
     *
     * @param n the n function parameter
     *
     * @return Catalan numbers on position n.
     */
    public static double catalanNumber(double n) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        } else {
            return catalanNumber((int) Math.round(n));
        }
    }

    /**
     * Calculates Fibonacci number.
     *
     * @param n the n function parameter
     *
     * @return Fibonacci number on position n.
     */
    public static double fibonacciNumber(int n) {
        if (n < 0 ) {
            return Double.NaN;
        } if (n == 0) {
            return 0;
        } if (n == 1) {
            return 1;
        }

        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }

    /**
     * Calculates Fibonacci number.
     *
     * @param n the n function parameter
     *
     * @return Fibonacci number on position n.
     */
    public static double fibonacciNumber(double n) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        } else {
            return fibonacciNumber((int) Math.round(n));
        }
    }

    /**
     * Calculates Lucas number.
     *
     * @param n the n function parameter
     *
     * @return Lucas number on position n.
     */
    public static double lucasNumber(int n) {
        if (n < 0 ) {
            return Double.NaN;
        } if (n == 0) {
            return 2;
        } if (n == 1) {
            return 1;
        }

        return lucasNumber(n-1) + lucasNumber(n-2);
    }

    /**
     * Calculates Lucas number.
     *
     * @param n the n function parameter
     *
     * @return Lucas number on position n.
     */
    public static double lucasNumber(double n) {
        if (Double.isNaN(n)) {
            return Double.NaN;
        } else {
            return lucasNumber((int) Math.round(n));
        }
    }

    /**
     * Calculates Euler polynomial.
     *
     * @param m the m parameter
     * @param x the x parameter
     *
     * @return Euler polynomial or NaN.
     */
    public static double eulerPolynomial(int m, double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        double result = Double.NaN;

        if (m >= 0) {
            result = 0;

            for (int n = 0; n <= m; n++) {
                for (int k = 0; k <= n; k++) {
                    result += Math.pow(-1, k) * binomCoeff(n, k) * Math.pow(x+k, m);
                }

                result /= Math.pow(2, n);
            }
        }

        return result;
    }

    /**
     * Calculates Euler polynomial.
     *
     * @param m the m parameter
     * @param x the x parameter
     *
     * @return Euler polynomial or NaN.
     */
    public static double eulerPolynomial(double m, double x) {
        if (Double.isNaN(m) || Double.isNaN(x)) {
            return Double.NaN;
        } else {
            return eulerPolynomial((int) Math.round(m), (int) Math.round(x));
        }
    }

    /**
     * Generalized power of value to another.
     *
     * @param a value to be raised
     * @param b value to raised
     *
     * @return returns a raised to b or NaN
     */
    public static double power(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            return Double.NaN;
        }

        if (a >= 0 && abs(b) >= 1 && b == 0) {
            return Math.pow(a, b);
        } else {
            double ndob = 1.0 / abs(b);
            double nint = Math.round(ndob);

            if (abs(ndob - nint) < 0.000001) {
                long n = (long)nint;

                if (n % 2 == 1) {
                    if (b > 0) {
                        return -Math.pow(abs(a), 1.0 / ndob);
                    } else {
                        return -Math.pow(abs(a), -1.0 / ndob);
                    }
                } else {
                    return Double.NaN;
                }
            } else {
                return Double.NaN;
            }
        }
    }

    /**
     * Generalized root of value.
     *
     * @param n value to be taken root of
     * @param x root
     *
     * @return NaN or result of root
     */
    public static double root(double n, double x) {
        if (Double.isNaN(n) || Double.isNaN(x) || Double.isInfinite(n) || Double.isInfinite(x)) {
            return Double.NaN;
        }

        if (n < -0.000001) {
            return Double.NaN;
        }

        if (abs(n) <= 0.000001) {
            if (abs(x) <= 0.000001) {
                return 0;
            } else if (abs(x-1) <= 0.000001) {
                return 1;
            }
            else {
                return Double.NaN;
            }
        }

        long nint = (long)floor(n);

        if (nint == 1) {
            return x;
        }
        if (nint == 2) {
            return sqrt(x);
        }

        if (nint % 2 == 1) {
            if ( x >= 0) {
                return Math.pow(x, 1.0 / nint);
            }
            else {
                return -Math.pow( abs(x), 1.0 / nint);
            }
        } else {
            if ( x >= 0) {
                return Math.pow(x, 1.0 / nint);
            }
            else {
                return Double.NaN;
            }
        }
    }

    /**
     * Modulo operator a % b.
     *
     * @param a the a function parameter
     * @param b the b function parameter
     *
     * @return a % b or NaN if neither one is NaN
     */
    public static double mod(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            return Double.NaN;
        } else {
            return a % b;
        }
    }

    /**
     * Normal division of numbers.
     *
     * @param a ration
     * @param b divider
     *
     * @return divison of numbers or NaN
     */
    public static double div(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            return Double.NaN;
        }

        double result = Double.NaN;

        if (b != 0) {
            result = a / b;
        }

        return result;
    }

    /**
     * Sine trigonometric function.
     *
     * @param a the a function parameter
     *
     * @return result of Sin function
     */
    public static double sin(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.sin(a);
        }
    }

    /**
     * Cosine trigonometric function.
     *
     * @param a the a function parameter
     *
     * @return result of Cos function
     */
    public static double cos(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.cos(a);
        }
    }

    /**
     * Tangent trigonometric function.
     *
     * @param a the a function parameter
     *
     * @return result of Tan function
     */
    public static double tan(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.tan(a);
        }
    }

    /**
     * Cotangent trigonometric function.
     *
     * @param a the a function parameter
     *
     * @return NaN or reciprocal of Tan function
     */
    public static double ctan(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        }

        double result = Double.NaN;
        double tg = Math.tan(a);

        if (tg != 0) {
            result = 1.0 / tg;
        }

        return result;
    }

    /**
     * Secant trigonometric function.
     *
     * @param a the a function parameter
     *
     * @return NaN or reciprocal of Cos function
     */
    public static double sec(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        }

        double result = Double.NaN;
        double cos = Math.cos(a);

        if (cos != 0) {
            result = 1.0 / cos;
        }

        return result;
    }

    /**
     * Cosecant trigonometric function.
     *
     * @param a the a function parameter
     *
     * @return NaN or reciprocal of Sin function
     */
    public static double cosec(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        }

        double result = Double.NaN;
        double sin = Math.sin(a);

        if (sin != 0) {
            result = 1.0 / sin;
        }

        return result;
    }

    /**
     * Arcus sine - inverse trigonometric sine function.
     *
     * @param a the a function parameter
     *
     * @return result of Arcus Sin function
     */
    public static double asin(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.asin(a);
        }
    }

    /**
     * Arcus cosine - inverse trigonometric sine function.
     *
     * @param a the a function parameter
     *
     * @return result of Arcus Cos function
     */
    public static double acos(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.acos(a);
        }
    }

    /**
     * Arcus tangent - inverse trigonometric sine function.
     *
     * @param a the a function parameter
     *
     * @return result of Arcus Tan function
     */
    public static double atan(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.atan(a);
        }
    }

    /**
     * Arcus cotangent - inverse trigonometric cotangent function.
     *
     * @param a the a function parameter
     *
     * @return result of Arcus Tan function with reciprocal of a
     */
    public static double actan(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.atan(1 / a);
        }
    }

    /**
     * Arcus secant - inverse trigonometric cotangent function.
     *
     * @param a the a function parameter
     *
     * @return result of Arcus Cos function with reciprocal of a
     */
    public static double asec(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.acos(1 / a);
        }
    }

    /**
     * Arcus cosecant - inverse trigonometric cotangent function.
     *
     * @param a the a function parameter
     *
     * @return result of Arcus Sin function with reciprocal of a
     */
    public static double acosec(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.asin(1 / a);
        }
    }

    /**
     * Natural logarithm.
     *
     * @param a natural logarithm from
     *
     * @return a in natural logarithm
     */
    public static double ln(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.log(a);
        }
    }

    /**
     * Binary logarithm.
     *
     * @param a binary logarithm from
     *
     * @return a in binary logarithm
     */
    public static double log2(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.log(a) / Math.log(2.0);
        }
    }

    /**
     * Common logarithm.
     *
     * @param a common logarithm from
     *
     * @return a in common logarithm
     */
    public static double log10(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.log10(a);
        }
    }

    /**
     * Degrees to radius translation.
     *
     * @param a degrees
     *
     * @return radian equivalence to degree given
     */
    public static double rad(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.toRadians(a);
        }
    }

    /**
     * Calculates Exponential function.
     *
     * @param a the a function parameter
     *
     * @return NaN or Euler number raised to a
     */
    public static double exp(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.exp(a);
        }
    }

    /**
     * Square root.
     *
     * @param a value
     *
     * @return root of a
     */
    public static double sqrt(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.sqrt(a);
        }
    }

    /**
     * Hyperbolic sine function.
     *
     * @param a the a function parameter
     *
     * @return result of Hyperbolic Sin function
     */
    public static double sinh(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.sinh(a);
        }
    }

    /**
     * Hyperbolic cosine function.
     *
     * @param a the a function parameter
     *
     * @return result of Hyperbolic Cos function
     */
    public static double cosh(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.cosh(a);
        }
    }

    /**
     * Hyperbolic tangent function.
     *
     * @param a the a function parameter
     *
     * @return result of Hyperbolic Tan function
     */
    public static double tanh(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.tanh(a);
        }
    }

    /**
     * Radius to degrees translation.
     *
     * @param a radians
     *
     * @return degree equivalence to radian a
     */
    public static double deg(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.toDegrees(a);
        }
    }

    /**
     * Calculates Absolute value.
     *
     * @param a any realistic number
     *
     * @return values absolute distance from 0
     */
    public static double abs(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.abs(a);
        }
    }

    /**
     * Signum function.
     *
     * @param a the a function parameter
     *
     * @return result of signum function
     */
    public static double sgn(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.signum(a);
        }
    }

    /**
     * First natural number less then a.
     *
     * @param a decimal number
     *
     * @return first natural number less then a
     */
    public static double floor(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.floor(a);
        }
    }

    /**
     * Ceiling function.
     *
     * @param a the a function parameter
     *
     * @return result of Ceiling function
     */
    public static double ceil(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return Math.ceil(a);
        }
    }

    /**
     * Reciprocal of value a.
     *
     * @param a any realistic number
     *
     * @return result of 1/a
     */
    public static double reciprocal(double a) {
        if (Double.isNaN(a)) {
            return Double.NaN;
        } else {
            return 1 / a;
        }
    }
}
