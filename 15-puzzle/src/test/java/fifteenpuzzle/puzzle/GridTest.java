package fifteenpuzzle.puzzle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridTest {

    Grid grid;

    public GridTest() {
    }

    @Before
    public void setUp() {
        grid = new Grid();
    }

    @Test
    public void moveWorks() {
        grid.move(0, 0);
        int[][] testArray = {{0, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 1}};
        Assert.assertArrayEquals(testArray, grid.getTiles());
    }

    @Test
    public void resetWorks() {
        int[][] testArray = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] tiles = {{5,9,1,13},{4,10,14,6},{11,0,2,8},{7,15,3,12}};
        grid = new Grid(tiles);
        grid.reset();
        Assert.assertArrayEquals(testArray, grid.getTiles());
    }
}
