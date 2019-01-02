package io.github.jhoneagle.algorithm.patfinding;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class HeuristicFinder implements Finder {
    protected Grid map;
    protected GridShell[][] nodes;
    protected GridShell end;
    protected GridShell[][] path;
    protected PriorityQueue<GridShell> queue;

    protected HeuristicFinder(Grid map) {
        this.map = map;
    }

    public void setMap(Grid map) {
        this.map = map;
    }

    @Override
    public List<Node> getPath(Node start, Node finnish) {
        GridShell begin = (GridShell) start;
        end = (GridShell) finnish;
        path = new GridShell[map.getHeight()][map.getWidth()];
        nodes = new GridShell[map.getHeight()][map.getWidth()];
        queue = new PriorityQueue<>();

        begin.setDistanceToStart(0);
        queue.add(begin);

        while (!queue.isEmpty()) {
            GridShell current = queue.poll();

            if (end.equals(current)) {
                end = current;
                break;
            }

            int x = current.getX();
            int y = current.getY();

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) {
                        continue;   // We don't want to look again the place we are already.
                    }

                    // Diagonal or vertical/horizontal.

                    if (dx != 0 && dy != 0) {
                        if (map.isInsideMap(x + dx, y + dy) && map.isWalkable(x + dx, y + dy)) {
                            if (map.isWalkable(x + dx, y) || map.isWalkable(x, y + dy)) {
                                checkNeighbour(current, x, y, dx, dy);
                            }
                        }
                    } else {
                        if (map.isInsideMap(x + dx, y + dy) && map.isWalkable(x + dx, y + dy)) {
                            checkNeighbour(current, x, y, dx, dy);
                        }
                    }
                }
            }
        }

        List<Node> result = new ArrayList<>();
        result.add(finnish);
        GridShell last = path[end.getY()][end.getX()];

        while (last != null) {
            result.add(last);
            last = path[last.getY()][last.getX()];
        }

        map.reset();
        return result;
    }

    protected abstract void checkNeighbour(GridShell current, int x, int y, int dx, int dy);
}
