
package fifteenpuzzle.datastructures;

import fifteenpuzzle.puzzle.Grid;
import fifteenpuzzle.puzzle.State;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HeapTest {
    
    Heap heap;
    
    public HeapTest() {
    }
        
    @Before
    public void setUp() {
        heap = new Heap();
    }
    
    @Test
    public void sizeIncreaseWorks() {
        for (int i = 0; i < 15; i++) {
            heap.add(new State(0, new Grid()));
        }
        assertEquals(15, heap.size());
    }
    
    @Test
    public void heapCOrderCorrect() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.add(new State(random.nextInt(20), new Grid()));
        }
        State previous = heap.poll();
        for (int i = 0; i < heap.size(); i++) {
            State next = heap.poll();
            assertTrue(previous.getDistance() + previous.getSteps() 
                    <= next.getDistance() + next.getSteps());
            previous = next;
        }
    }

}
