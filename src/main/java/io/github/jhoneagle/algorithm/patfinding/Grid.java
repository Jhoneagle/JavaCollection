package io.github.jhoneagle.algorithm.patfinding;

public interface Grid {
    int getHeight();
    int getWidth();
    void reset();
    void setVisited(int x, int y);
    boolean isVisited(int x, int y);
    boolean isInsideMap(int x, int y);
    boolean isWalkable(int x, int y);

    /**
     * Method returns cost of moving from one block to another next to it. Currently in straight this means one and in diagonally it means square two.
     * All other coordinate pairs result in returning zero.
     *
     * @param fromX     x-coordinate came
     * @param fromY     y-coordinate came
     * @param toX     x-coordinate go
     * @param toY     y-coordinate go
     *
     * @return Double
     */
    default double getValueForMovement(int fromX, int fromY, int toX, int toY) {
        int dx = Math.abs(fromX - toX);
        int dy = Math.abs(fromY - toY);

        if (dx != 0 && dy != 0) {
            return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        } else if (dx != 0 || dy != 0) {
            return (dx == 0) ? dy : dx;
        } else {
            return 0;
        }
    }

    /**
     * Returns octile distance between two coordinates in the ascii map.
     *
     * @see Math#max(int, int)
     * @see Math#min(int, int)
     * @see Math#abs(int)
     * @see Math#sqrt(double)
     *
     * @param fromX    Start points x-coordinate.
     * @param fromY   Start points y-coordinate.
     * @param toX    End points x-coordinate.
     * @param toY   End points y-coordinate.
     *
     * @return Double
     */
    default double getAproxDistance(int fromX, int fromY, int toX, int toY) {
        int diffirentX = Math.abs(fromX - toX);
        int diffirentY = Math.abs(fromY - toY);

        return (double) Math.max(diffirentX, diffirentY) + (Math.sqrt(2) - 1) * Math.min(diffirentX, diffirentY);
    }
}
