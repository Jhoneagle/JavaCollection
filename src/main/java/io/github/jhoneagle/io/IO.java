package io.github.jhoneagle.io;

public interface IO<T> {
    void write(T text);
    T read();
    T previous();
}
