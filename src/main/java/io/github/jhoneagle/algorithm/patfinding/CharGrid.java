package io.github.jhoneagle.algorithm.patfinding;

import java.util.HashSet;

public class CharGrid implements Grid {
    private char[][] map;
    private HashSet<Character> walkable;
    private boolean[][] visited;

    public CharGrid(char[][] map, HashSet<Character> walkable) {
        init(map, walkable);
    }

    public CharGrid(HashSet<Character> walkable) {
        init(null, walkable);
    }

    public CharGrid(char[][] map) {
        init(map, null);
    }

    public CharGrid() {
        init(null, null);
    }

    public void init(char[][] map, HashSet<Character> walkable) {
        this.map = map;
        this.walkable = walkable;

        if (map != null) {
            this.visited = new boolean[map.length][map[0].length];
        } else {
            this.visited = new boolean[1][1];
        }
    }

    @Override
    public int getHeight() {
        return map.length;
    }

    @Override
    public int getWidth() {
        return map[0].length;
    }

    @Override
    public void reset() {
        this.visited = new boolean[map.length][map[0].length];
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public void setWalkable(HashSet<Character> walkable) {
        this.walkable = walkable;
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
        return (y < map.length && x < map[0].length);
    }

    @Override
    public boolean isWalkable(int x, int y) {
        return walkable.contains(map[y][x]);
    }
}
