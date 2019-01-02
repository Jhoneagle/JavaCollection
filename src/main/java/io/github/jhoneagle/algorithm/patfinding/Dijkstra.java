package io.github.jhoneagle.algorithm.patfinding;

public class Dijkstra extends HeuristicFinder {
    public Dijkstra(Grid map) {
        super(map);
    }

    protected GridShell getNext(int x, int y) {
        GridShell next = nodes[y][x];

        if (next == null) {
            next = new GridShell(x, y);
            next.setDistanceToStart(Integer.MAX_VALUE);
        }

        return next;
    }

    @Override
    protected void checkNeighbour(GridShell current, int x, int y, int dx, int dy) {
        GridShell next = getNext(x + dx, y + dy);

        if (map.isVisited(next.getX(), next.getY())) {
            double sum = current.getDistanceToStart() + map.getValueForMovement(current.getX(), current.getY(), next.getX(), next.getY());
            map.setVisited(next.getX(), next.getY());

            if (next.getDistanceToStart() > sum) {
                next.setDistanceToStart(sum);
                path[next.getY()][next.getX()] = current;
            }

            nodes[next.getY()][next.getX()] = next;
            queue.add(next);
        }
    }
}
