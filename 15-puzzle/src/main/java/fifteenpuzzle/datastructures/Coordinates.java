package fifteenpuzzle.datastructures;

public class Coordinates {

    private int y;
    private int x;

    /**
     * Constructs a new coordinate pair.
     * @param y value to set as y-coordinate
     * @param x value to set as x-coordinate
     */
    public Coordinates(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    /**
     * Sets the value of y.
     * @param y value to set to y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the value of x.
     * @param x value to set to x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the value of y.
     * @return value of y
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the value of x.
     * @return value of x
     */
    public int getX() {
        return x;
    }

}
