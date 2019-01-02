package io.github.jhoneagle.algorithm.patfinding;

public class AStar extends Dijkstra {
    public AStar(Grid map) {
        super(map);
    }

    @Override
    protected GridShell getNext(int x, int y) {
        GridShell next = nodes[y][x];

        if (next == null) {
            next = new GridShell(x, y);
            next.setDistanceToStart(Integer.MAX_VALUE);
            next.setDistanceToEnd(map.getAproxDistance(next.getX(), end.getX(), next.getY(), end.getY()));
        }

        return next;
    }
}
