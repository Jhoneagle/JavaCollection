package io.github.jhoneagle.math.equation;

import io.github.jhoneagle.math.Term;

import java.util.List;

public interface Equation {
    List<Term> getTerms();
    String stringify();
}
