package io.github.jhoneagle.algorithm.chess;

public interface Player {
    State makeAMove(State p);
    void setColor(int color);
}
