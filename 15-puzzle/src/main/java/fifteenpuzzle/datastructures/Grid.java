package fifteenpuzzle.datastructures;

public class Grid {

    private int[][] tiles;
    private Coordinates empty;

    /**
     * Constructs a new grid.
     */
    public Grid() {
        this.tiles = new int[4][4];
        this.empty = new Coordinates(3, 3);
        reset();
    }

    /**
     * Construct a new grid with the specified order of tiles.
     * @param tiles array containing order of tiles for the grid
     */
    public Grid(int[][] tiles) {
        this.tiles = new int[4][4];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                this.tiles[i][j] = tiles[i][j];
                if (tiles[i][j] == 0) {
                    this.empty = new Coordinates(i, j);
                }
            }
        }
    }

    /**
     * Resets the grid.
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

    /**
     * Returns the array containing the order of the grid's tiles.
     *
     * @return array containing the order of the grid's tiles
     */
    public int[][] getTiles() {
        return tiles;
    }

    /**
     * Returns the position of the empty tile.
     *
     * @return position of the empty tile
     */
    public Coordinates getEmpty() {
        return empty;
    }

    /**
     * Switches the empty space and the tile in the given position.
     *
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
