package fifteenpuzzle.puzzle;

public class Grid {

    private int[][] tiles;
    private Position empty;

    public Grid() {
        this.tiles = new int[4][4];
        this.empty = new Position(3, 3);
        reset();
    }

    /**
     * Reset the grid
     */
    public void reset() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.tiles[i][j] = (i) * 4 + j + 1;
            }
        }
        this.tiles[3][3] = 0;
        this.empty.setX(3);
        this.empty.setY(3);
    }

    public int[][] getTiles() {
        return tiles;
    }

    public Position getEmpty() {
        return empty;
    }
    
    /**
     * Switches the empty space and the tile in the given position
     * @param y y-coordinate of the tile to be switched
     * @param x x-coordinate of the tile to be switched
     * @return value of the switched tile
     */
    public int move(int y, int x) {
        int tile = tiles[y][x];
        tiles[empty.getY()][empty.getX()] = tile;
        tiles[y][x] = 0;
        empty.setX(x);
        empty.setY(y);
        return tile;
    }
    
}