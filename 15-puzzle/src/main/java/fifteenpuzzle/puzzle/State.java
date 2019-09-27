package fifteenpuzzle.puzzle;

import java.util.ArrayList;

public class State implements Comparable<State> {

    private int steps;
    private Grid grid;
    private Grid previous;
    private int distance;
    private boolean solved;

    public State(int steps, Grid grid, Grid previous) {
        this(steps, grid);
        this.previous = previous;
    }

    public State(int steps, Grid grid) {
        this.steps = steps;
        this.grid = grid;
        this.distance = 0;
        for (int i = 0; i < grid.getTiles().length; i++) {
            for (int j = 0; j < grid.getTiles()[0].length; j++) {
                if (grid.getTiles()[i][j] != 0) {
                    //rows
                    this.distance += Math.abs((grid.getTiles()[i][j] - 1) / 4 - i);
                    //columns
                    this.distance += Math.abs((grid.getTiles()[i][j] - 1) % 4 - j);
                }
            }
        }
        if (this.distance == 0) {
            solved = true;
        }
    }

    public ArrayList<State> getNeighbors() {
        ArrayList<State> neighbors = new ArrayList<>();

        int size = grid.getTiles().length;
        int xEmpty = grid.getEmpty().getX();
        int yEmpty = grid.getEmpty().getY();
        
        for (int i = yEmpty - 1; i <= yEmpty + 1; i++) {
            if (i >= 0 && i < size) {
                for (int j = xEmpty - 1; j <= xEmpty + 1; j++) {
                    if (j >= 0 && j < size) {
                        if ((i != yEmpty || j != xEmpty) && (i == yEmpty || j == xEmpty)) {
                            Grid newGrid = new Grid(grid.getTiles());
                            newGrid.move(i, j);
                            if (this.previous == null || !newGrid.equals(this.previous)) {
                                neighbors.add(new State(this.steps + 1, newGrid, this.grid));
                            }
                        }
                    }
                }
            }
        }
        return neighbors;
    }

    public boolean isSolved() {
        return solved;
    }

    public int getSteps() {
        return steps;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(State t) {
        return (this.distance + this.steps) - (t.distance + t.steps);
    }

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
        return s + "steps: " + this.steps + "\ndistance: " + this.distance
                + "\ntotal: " + (this.steps + this.distance) + "\n";
    }

}
