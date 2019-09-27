package fifteenpuzzle.puzzle;

import java.util.Arrays;

public class Grid {

    private int[][] tiles;
    private Position empty;

    public Grid() {
        this.tiles = new int[4][4];
        this.empty = new Position(3, 3);
        reset();
    }

    public Grid(int[][] tiles) {
        this.tiles = new int[4][4];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                this.tiles[i][j] = tiles[i][j];
                if (tiles[i][j] == 0) {
                    this.empty = new Position(i, j);
                }
            }
        }
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grid other = (Grid) obj;
        if (!Arrays.deepEquals(this.tiles, other.tiles)) {
            return false;
        }
        if (!this.empty.equals(other.empty)) {
            return false;
        }
        return true;
    }

}
