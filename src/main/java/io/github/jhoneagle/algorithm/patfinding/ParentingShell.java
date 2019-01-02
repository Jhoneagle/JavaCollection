package io.github.jhoneagle.algorithm.patfinding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ParentingShell extends Node {
    private Deque<Node> connections;

    public ParentingShell(double distanceToStart, double distanceToEnd) {
        super(distanceToStart, distanceToEnd);
        connections = new ArrayDeque<>();
    }

    public ParentingShell() {
        this(0,0);
    }

    public ParentingShell(double distanceToStart, double distanceToEnd, Deque<Node> connections) {
        super(distanceToStart, distanceToEnd);
        this.connections = connections;
    }

    public ParentingShell(Deque<Node> connections) {
        this(0,0, connections);
    }

    public ParentingShell(double distanceToStart, double distanceToEnd, List<Node> connections) {
        super(distanceToStart, distanceToEnd);
        this.connections.addAll(connections);
    }

    public ParentingShell(List<Node> connections) {
        this(0,0, connections);
    }

    public Deque<Node> getConnections() {
        return connections;
    }

    public void setConnections(Deque<Node> connections) {
        this.connections = connections;
    }

    public void setConnections(List<Node> connections) {
        this.connections.addAll(connections);
    }

    public Node getNeighbour() {
        return this.connections.pollFirst();
    }

    public void AddNeighbour(Node o) {
        this.connections.addLast(o);
    }
}
