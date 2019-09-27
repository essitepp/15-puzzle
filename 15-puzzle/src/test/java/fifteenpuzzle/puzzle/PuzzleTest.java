package fifteenpuzzle.puzzle;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PuzzleTest {

    Puzzle puzzle;

    public PuzzleTest() {
    }

    @Before
    public void setUp() {
        puzzle = new Puzzle();
    }

    @Test
    public void movingRandom() {
        for (int i = 0; i < 10; i++) {
            int[][] tiles = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 6}};
            puzzle.setGrid(new Grid(tiles));
            puzzle.shuffle(1);
            assertThat(puzzle.getGrid().getTiles()[1][1], anyOf(is(2), is(5), is(7), is(10)));
        }
    }
}
