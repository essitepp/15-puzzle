package fifteenpuzzle.puzzle;

public class Tile {

    private int y;
    private int x;

    public Tile(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
