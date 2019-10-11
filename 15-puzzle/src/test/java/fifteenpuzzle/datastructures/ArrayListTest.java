
package fifteenpuzzle.datastructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayListTest {
    
    ArrayList list;
    
    public ArrayListTest() {
    }
        
    @Before
    public void setUp() {
        list = new ArrayList();
    }
    
    @Test
    public void addWorks() {
        list.add(10);
        assertEquals(10, list.get(0));
    }   
    
    @Test
    public void sizeIncreaseWorks() {
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15, list.size());
    }


}
