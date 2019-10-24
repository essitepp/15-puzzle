package fifteenpuzzle.puzzle;

import java.util.Random;
import fifteenpuzzle.datastructures.Heap;
import fifteenpuzzle.datastructures.ArrayList;

public class Puzzle {

    private Grid grid;

    /**
     * Constructs a new puzzle.
     */
    public Puzzle() {
        this.grid = new Grid();
    }

    /**
     * Resets the puzzle.
     */
    public void reset() {
        this.grid.reset();
    }

    /**
     * Shuffles the puzzle by making random moves.
     *
     * @param n Number of random moves to make
     */
    public void shuffle(int n) {
        int previous = 0;
        for (int i = 0; i < n; i++) {
            previous = moveRandom(previous);
        }
    }

    /**
     * Solves the puzzle.
     */
    public void solve() {
        long startTime = System.currentTimeMillis();
        Heap states = new Heap();
        states.add(new State(0, new Grid(this.grid.getTiles())));

        while (true) {
            State currentState = states.poll();

            if (currentState.isSolved()) {
                long endTime = System.currentTimeMillis();
                System.out.println("Solved in " + currentState.getSteps() + " steps\n"
                        + "Time: " + (endTime - startTime) + " ms");
                break;
            }

            ArrayList<State> neighbors = currentState.getNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                states.add(neighbors.get(i));
            }

        }
    }

    /**
     * Makes a random move.
     *
     * @param forbidden value of a tile that must not be moved
     * @return the value of the moved tile
     */
    private int moveRandom(int forbidden) {
        Random random = new Random();
        ArrayList<Coordinates> moves = possibleMoves();
        Coordinates tile = moves.get(random.nextInt(moves.size()));
        while (this.grid.getTiles()[tile.getY()][tile.getX()] == forbidden) {
            tile = moves.get(random.nextInt(moves.size()));
        }
        int moved = this.grid.move(tile.getY(), tile.getX());
        return moved;
    }

    /**
     * Returns a string representing the puzzle grid.
     *
     * @return a string representing the puzzle
     */
    @Override
    public String toString() {
        String s = "";
        int[][] tiles = this.grid.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                s += tiles[i][j];
                s += "\t";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Returns a list containing positions of tiles that can be moved.
     *
     * @return list containing positions of tiles that can be moved
     */
    private ArrayList<Coordinates> possibleMoves() {
        ArrayList<Coordinates> list = new ArrayList<>();
        int size = grid.getTiles().length;
        int xEmpty = grid.getEmpty().getX();
        int yEmpty = grid.getEmpty().getY();
        for (int i = yEmpty - 1; i <= yEmpty + 1; i++) {
            if (i >= 0 && i < size) {
                for (int j = xEmpty - 1; j <= xEmpty + 1; j++) {
                    if (j >= 0 && j < size) {
                        if ((i != yEmpty || j != xEmpty) && (i == yEmpty || j == xEmpty)) {
                            list.add(new Coordinates(i, j));
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     * Returns the puzzle's grid.
     *
     * @return the puzzle's grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Sets the puzzle's grid.
     *
     * @param grid grid to set to puzzle
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}
