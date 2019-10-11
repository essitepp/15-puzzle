package fifteenpuzzle.puzzle;

import fifteenpuzzle.datastructures.ArrayList;

public class State implements Comparable<State> {

    private int steps;
    private Grid grid;
    private Grid previous;
    private int distance;
    private boolean solved;

    /**
     * Construct a new State.
     * @param steps number of steps taken to reach this state
     * @param grid grid containing the order of tiles for this state
     * @param previous the state this state was reached from
     */
    public State(int steps, Grid grid, Grid previous) {
        this(steps, grid);
        this.previous = previous;
    }
    
    /**
     * Construct a new State.
     * @param steps number of steps taken to reach this state
     * @param grid grid containing the order of tiles for this state
     */
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

    /**
     * Returns a list containing States that can be reached from current state by making one move.
     * @return a list containing neighboring States
     */
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

    /**
     * Returns true if the puzzle is solved in this State, otherwise returns false.
     * @return true if puzzle is solved, otherwise false
     */
    public boolean isSolved() {
        return solved;
    }

    /**
     * Returns the numbers of steps taken to reach this State.
     * @return number of steps to reach this State
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Returns the State's grid.
     * @return the State's grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Returns the State's distance from the puzzle's solution. The distance is calculated as sum of all tiles' Manhattan distances from the solution.
     * @return State's distance from solution
     */
    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(State t) {
        return (this.distance + this.steps) - (t.distance + t.steps);
    }
}
