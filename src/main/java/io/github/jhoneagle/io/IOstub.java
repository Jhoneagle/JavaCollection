package io.github.jhoneagle.io;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


public class IOstub implements IO<String> {
    private Deque<String> commands;
    private Deque<String> executed;

    public IOstub(Deque<String> commands) {
        this.commands = commands;
        this.executed = new ArrayDeque<>();
    }

    public IOstub(List<String> commands) {
        this.commands = new ArrayDeque<>();
        this.executed = new ArrayDeque<>();

        this.commands.addAll(commands);
    }

    public IOstub() {
        this.commands = new ArrayDeque<>();
        this.executed = new ArrayDeque<>();
    }

    @Override
    public void write(String text) {
        this.commands.add(text);
    }

    @Override
    public String read() {
        String s = this.commands.pollFirst();

        if (s != null) {
            this.executed.add(s);
        }

        return s;
    }

    @Override
    public String previous() {
        return this.executed.peekLast();
    }
}
