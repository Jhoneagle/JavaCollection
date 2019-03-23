package io.github.jhoneagle.math;

public class Kombination implements Term {
    private long n;
    private long k;

    public Kombination(long n, long k) {
        init(n, k);
    }

    public Kombination() {
    }

    public void init(long n, long k) {
        this.n = n;
        this.k = k;
    }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public long getK() {
        return k;
    }

    public void setK(long k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "{" + n + "," + k + "}";
    }
}
