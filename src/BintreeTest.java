import student.TestCase;

/**
 * tests bintree methods
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class BintreeTest extends TestCase {
    
    private BinTree bn;
    
    /**
     * sets up bintree for testing
     */
    public void setUp() {
        bn = new BinTree(5, 5, 5, 5, 5, 5, 1);
    }
    
    /**
     * tests xVal()
     */
    public void testXVal() {
        assertEquals(5, bn.xVal());
    }
    
    /**
     * tests yVal
     */
    public void testYVal() {
        assertEquals(5, bn.yVal());
    }
    
    /**
     * tests zVal
     */
    public void testZVal() {
        assertEquals(5, bn.zVal());
    }
    
    /**
     * tests length()
     */
    public void testLength() {
        assertEquals(5, bn.length());
    }
    
    /**
     * tests width()
     */
    public void testWidth() {
        assertEquals(5, bn.width());
    }
    
    /**
     * tests height()
     */
    public void testHeight() {
        assertEquals(5, bn.height());
    }
    
    /**
     * tests level()
     */
    public void testLevel() {
        assertEquals(1, bn.level());
    }

}
