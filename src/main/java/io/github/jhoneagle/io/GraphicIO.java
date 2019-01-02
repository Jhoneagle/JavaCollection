package io.github.jhoneagle.io;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class GraphicIO<T> implements IO<String> {
    protected Deque<String> previous;
    protected T inputOutput;

    public GraphicIO(T inputOutput) {
        previous = new ArrayDeque<>();
        this.inputOutput = inputOutput;
    }

    public GraphicIO() {
        previous = new ArrayDeque<>();
    }

    public void setInputOutput(T inputOutput) {
        this.inputOutput = inputOutput;
    }

    @Override
    public String previous() {
        return previous.pollLast();
    }
}
