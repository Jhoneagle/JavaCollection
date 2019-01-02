package io.github.jhoneagle.algorithm.patfinding;

import java.util.Arrays;

public class NodeGrid implements Grid {
    private Node[][] map;

    public NodeGrid(Node[][] map) {
        this.map = map;
    }

    public NodeGrid(int x, int y) {
        this.map = new Node[y][x];
    }

    public NodeGrid() {
        this(1, 1);
    }

    @Override
    public int getHeight() {
        return map.length;
    }

    @Override
    public int getWidth() {
        return map[0].length;
    }

    public void setMap(Node[][] map) {
        this.map = map;
    }

    @Override
    public void reset() {
        Arrays.fill(map, null);
    }

    public void setNode(int x, int y, Node value) {
        this.map[y][x] = value;
    }

    @Override
    public boolean isVisited(int x, int y) {
        return map[y][x].isVisited();
    }

    @Override
    public void setVisited(int x, int y) {
        map[y][x].chanceVisited();
    }

    @Override
    public boolean isInsideMap(int x, int y) {
        return (y < map.length && x < map[0].length);
    }

    @Override
    public boolean isWalkable(int x, int y) {
        return (map[y][x] != null);
    }
}
