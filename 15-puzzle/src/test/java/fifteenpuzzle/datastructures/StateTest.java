package fifteenpuzzle.datastructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StateTest {

    public StateTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void distanceCalculation() {
        int[][] testGrid = {
            {1, 4, 12, 7},
            {10, 9, 14, 5},
            {6, 13, 2, 15},
            {3, 0, 11, 8}
        };

        State state = new State(0, new Grid(testGrid));
        assertEquals(34, state.getDistance());

    }

    @Test
    public void neighborArraysCorner() {

        int[][] testGrid = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };

        int[][] neighbor1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 0},
            {13, 14, 15, 12}
        };
        int[][] neighbor2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 0, 15}
        };

        State state = new State(0, new Grid(testGrid));
        ArrayList<State> neighbors = state.getNeighbors();

        assertArrayEquals(neighbor1, neighbors.get(0).getGrid().getTiles());
        assertArrayEquals(neighbor2, neighbors.get(1).getGrid().getTiles());
    }

    @Test
    public void neighborArraysEdge() {

        int[][] testGrid = {
            {1, 4, 12, 7},
            {10, 9, 14, 5},
            {6, 13, 2, 15},
            {3, 0, 11, 8}
        };

        int[][] neighbor1 = {
            {1, 4, 12, 7},
            {10, 9, 14, 5},
            {6, 0, 2, 15},
            {3, 13, 11, 8}
        };
        int[][] neighbor2 = {
            {1, 4, 12, 7},
            {10, 9, 14, 5},
            {6, 13, 2, 15},
            {0, 3, 11, 8}
        };
        int[][] neighbor3 = {
            {1, 4, 12, 7},
            {10, 9, 14, 5},
            {6, 13, 2, 15},
            {3, 11, 0, 8}
        };

        State state = new State(0, new Grid(testGrid));
        ArrayList<State> neighbors = state.getNeighbors();

        assertArrayEquals(neighbor1, neighbors.get(0).getGrid().getTiles());
        assertArrayEquals(neighbor2, neighbors.get(1).getGrid().getTiles());
        assertArrayEquals(neighbor3, neighbors.get(2).getGrid().getTiles());
    }

    @Test
    public void neighborArraysMiddle() {

        int[][] testGrid = {
            {7, 1, 9, 4},
            {3, 10, 0, 14},
            {5, 13, 2, 8},
            {11, 15, 6, 12}
        };

        int[][] neighbor1 = {
            {7, 1, 0, 4},
            {3, 10, 9, 14},
            {5, 13, 2, 8},
            {11, 15, 6, 12}
        };
        int[][] neighbor2 = {
            {7, 1, 9, 4},
            {3, 0, 10, 14},
            {5, 13, 2, 8},
            {11, 15, 6, 12}
        };
        int[][] neighbor3 = {
            {7, 1, 9, 4},
            {3, 10, 14, 0},
            {5, 13, 2, 8},
            {11, 15, 6, 12}
        };
        int[][] neighbor4 = {
            {7, 1, 9, 4},
            {3, 10, 2, 14},
            {5, 13, 0, 8},
            {11, 15, 6, 12}
        };

        State state = new State(0, new Grid(testGrid));
        ArrayList<State> neighbors = state.getNeighbors();

        assertArrayEquals(neighbor1, neighbors.get(0).getGrid().getTiles());
        assertArrayEquals(neighbor2, neighbors.get(1).getGrid().getTiles());
        assertArrayEquals(neighbor3, neighbors.get(2).getGrid().getTiles());
        assertArrayEquals(neighbor4, neighbors.get(3).getGrid().getTiles());
    }

    @Test
    public void neighborStepsCorrect() {
        State state = new State(9, new Grid());
        assertEquals(10, state.getNeighbors().get(0).getSteps());
    }

}
