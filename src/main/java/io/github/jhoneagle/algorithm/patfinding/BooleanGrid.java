package io.github.jhoneagle.algorithm.patfinding;

public class BooleanGrid implements Grid {
    private boolean[][] visited;
    private boolean[][] walkable;

    public BooleanGrid(boolean[][] walkable) {
        init(walkable);
    }

    public BooleanGrid(int height, int width) {
        init(height, width);
    }

    public BooleanGrid() {
        init(1,1);
    }

    public void init(int height, int width) {
        visited = new boolean[height][width];
        walkable = new boolean[height][width];
    }

    public void init(boolean[][] walkable) {
        this.walkable = walkable;
        this.visited = new boolean[walkable.length][walkable[0].length];
    }

    @Override
    public int getHeight() {
        return walkable.length;
    }

    @Override
    public int getWidth() {
        return walkable[0].length;
    }

    @Override
    public void reset() {
        this.visited = new boolean[walkable.length][walkable[0].length];
    }

    @Override
    public boolean isVisited(int x, int y) {
        return visited[y][x];
    }

    @Override
    public void setVisited(int x, int y) {
        visited[y][x] = true;
    }

    @Override
    public boolean isInsideMap(int x, int y) {
        return (x < visited[0].length) && (y < visited.length);
    }

    @Override
    public boolean isWalkable(int x, int y) {
        return walkable[y][x];
    }
}
