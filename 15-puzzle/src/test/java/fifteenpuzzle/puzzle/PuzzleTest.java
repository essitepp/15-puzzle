
package fifteenpuzzle.puzzle;

import java.util.ArrayList;
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
}
