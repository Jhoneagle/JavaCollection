package io.github.jhoneagle.algorithm.patfinding;

import java.util.Properties;

public class Node implements Comparable<Node> {
    protected boolean visited;
    protected double distanceToStart;
    protected double distanceToEnd;

    public Node(double distanceToStart, double distanceToEnd) {
        this.distanceToStart = distanceToStart;
        this.distanceToEnd = distanceToEnd;
        visited = false;
    }

    public Node() {
        this(0,0);
    }

    public boolean isVisited() {
        return visited;
    }

    public void chanceVisited() {
        this.visited = !visited;
    }

    public void setDistanceToStart(double distanceToStart) {
        this.distanceToStart = distanceToStart;
    }

    public void setDistanceToEnd(double distanceToEnd) {
        this.distanceToEnd = distanceToEnd;
    }

    public double getDistanceToStart() {
        return distanceToStart;
    }

    public double getDistanceToEnd() {
        return distanceToEnd;
    }

    public double getPriority() {
        return distanceToStart + distanceToEnd;
    }

    @Override
    public int compareTo(Node o) {
        double original = getPriority();
        double compare = o.getPriority();

        if (original < compare) {
            return -1;
        } else if (original == compare) {
            return 0;
        } else {
            return 1;
        }
    }
}
