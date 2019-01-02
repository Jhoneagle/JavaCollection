package io.github.jhoneagle.algorithm.patfinding;

public class GridShell extends Node {
    private int x;
    private int y;

    public GridShell(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public GridShell(int x, int y, double distanceToStart, double distanceToEnd) {
        super(distanceToStart, distanceToEnd);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Checks if objects are representation of same cordinates in the grid.
     *
     * @param o     Another Chell object which is compared to this one
     * @return  {@code true} if Chell objects contain same coordinates
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GridShell chell = (GridShell) o;

        return getX() == chell.getX() && getY() == chell.getY();
    }
}
