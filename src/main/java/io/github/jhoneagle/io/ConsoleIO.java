package io.github.jhoneagle.io;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ConsoleIO implements IO<String> {
    private Scanner reader;
    private Deque<String> previous;

    public ConsoleIO() {
        reader = new Scanner(System.in);
        previous = new ArrayDeque<>();
    }

    public ConsoleIO(Scanner reader) {
        this.reader = reader;
        previous = new ArrayDeque<>();
    }

    @Override
    public void write(String text) {
        this.previous.add(text);
        System.out.println(text);
    }

    @Override
    public String read() {
        String s = reader.nextLine();

        if (s != null) {
            this.previous.add(s);
        }

        return s;
    }

    @Override
    public String previous() {
        return this.previous.pollLast();
    }
}
