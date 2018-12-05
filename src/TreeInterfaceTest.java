import junit.framework.TestCase;

/**
 * tests tree interface methods
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class TreeInterfaceTest extends TestCase {
	
	private TreeInterface ln;
	private TreeInterface fw;
	private TreeInterface in;
	
	/**
	 * sets up interfaces for testing
	 */
	public void setUp() {
		ln = new LeafNode(0, 0, 0, 1024, 1024, 1024, 1);
		fw = new Flyweight(0, 0, 0, 1024, 1024, 1024, 1);
		in = new InnerNode(0, 0, 0, 1024, 1024, 1024, 1);
	}
	
	/**
	 * tests dump() method
	 */
	public void testDump() {
		ln.dump(0);
		fw.dump(0);
		in.dump(0);
		assertNotNull(ln);
	}
	
	/**
	 * tests collisions() method
	 */
	public void testCollisions() {
		Drone ao1 = new Drone("MVPwatch");
		ao1.setX(50);
		ao1.setY(50);
		ao1.setZ(50);
		ao1.setXWidth(50);
		ao1.setYWidth(50);
		ao1.setZWidth(50);
		ao1.setBrand("Droners");
		ao1.setEngines(3);
		ln = ln.insert(ao1);
		Drone ao2 = new Drone("MVPwatch2"); // 2nd insert
		ao2.setX(91);
		ao2.setY(50);
		ao2.setZ(50);
		ao2.setXWidth(50);
		ao2.setYWidth(50);
		ao2.setZWidth(50);
		ao2.setBrand("Droners");
		ao2.setEngines(3);
		ln = ln.insert(ao2);
		Drone ao3 = new Drone("MVPwatch3"); // 3rd insert
		ao3.setX(132);
		ao3.setY(50);
		ao3.setZ(50);
		ao3.setXWidth(50);
		ao3.setYWidth(50);
		ao3.setZWidth(50);
		ao3.setBrand("Droners");
		ao3.setEngines(3);
		ln = ln.insert(ao3);
		Drone ao4 = new Drone("MVPwatch4"); // 4th insert
		ao4.setX(203);
		ao4.setY(50);
		ao4.setZ(50);
		ao4.setXWidth(50);
		ao4.setYWidth(50);
		ao4.setZWidth(50);
		ao4.setBrand("Droners");
		ao4.setEngines(3);
		ln = ln.insert(ao4);
		ln.collisions();
		fw.collisions();
		in.collisions();
	}
	
	/**
	 * tests insert() method
	 */
	public void testInsert() {
		Drone ao1 = new Drone("MVPwatch");
		ao1.setX(50);
		ao1.setY(50);
		ao1.setZ(50);
		ao1.setXWidth(50);
		ao1.setYWidth(50);
		ao1.setZWidth(50);
		ao1.setBrand("Droners");
		ao1.setEngines(3);
		ln = ln.insert(ao1);
		Drone ao2 = new Drone("MVPwatch2"); // 2nd insert
		ao2.setX(101);
		ao2.setY(50);
		ao2.setZ(50);
		ao2.setXWidth(50);
		ao2.setYWidth(50);
		ao2.setZWidth(50);
		ao2.setBrand("Droners");
		ao2.setEngines(3);
		ln = ln.insert(ao2);
		Drone ao3 = new Drone("MVPwatch3"); // 3rd insert
		ao3.setX(152);
		ao3.setY(50);
		ao3.setZ(50);
		ao3.setXWidth(50);
		ao3.setYWidth(50);
		ao3.setZWidth(50);
		ao3.setBrand("Droners");
		ao3.setEngines(3);
		ln = ln.insert(ao3);
		Drone ao4 = new Drone("MVPwatch4"); // 4th insert
		ao4.setX(203);
		ao4.setY(50);
		ao4.setZ(50);
		ao4.setXWidth(50);
		ao4.setYWidth(50);
		ao4.setZWidth(50);
		ao4.setBrand("Droners");
		ao4.setEngines(3);
		ln = ln.insert(ao4);
		ln.dump(0);
	}
	
	/**
	 * tests intersect method
	 */
	public void testIntersect() {
		Drone ao1 = new Drone("MVPwatch");
		ao1.setX(50);
		ao1.setY(50);
		ao1.setZ(50);
		ao1.setXWidth(50);
		ao1.setYWidth(50);
		ao1.setZWidth(50);
		ao1.setBrand("Droners");
		ao1.setEngines(3);
		ln = ln.insert(ao1);
		Drone ao2 = new Drone("MVPwatch2"); // 2nd insert
		ao2.setX(101);
		ao2.setY(50);
		ao2.setZ(50);
		ao2.setXWidth(50);
		ao2.setYWidth(50);
		ao2.setZWidth(50);
		ao2.setBrand("Droners");
		ao2.setEngines(3);
		ln = ln.insert(ao2);
		Drone ao3 = new Drone("MVPwatch3"); // 3rd insert
		ao3.setX(152);
		ao3.setY(50);
		ao3.setZ(50);
		ao3.setXWidth(50);
		ao3.setYWidth(50);
		ao3.setZWidth(50);
		ao3.setBrand("Droners");
		ao3.setEngines(3);
		ln = ln.insert(ao3);
		Drone ao4 = new Drone("MVPwatch4"); // 4th insert
		ao4.setX(203);
		ao4.setY(50);
		ao4.setZ(50);
		ao4.setXWidth(50);
		ao4.setYWidth(50);
		ao4.setZWidth(50);
		ao4.setBrand("Droners");
		ao4.setEngines(3);
		ln = ln.insert(ao4);
		ln.intersect(0, 0, 0, 1024, 1024, 1024, 1);
	}
	
	/**
	 * tests delete() method
	 */
	public void testDelete() {
		Drone ao1 = new Drone("MVPwatch");
		ao1.setX(50);
		ao1.setY(50);
		ao1.setZ(50);
		ao1.setXWidth(50);
		ao1.setYWidth(50);
		ao1.setZWidth(50);
		ao1.setBrand("Droners");
		ao1.setEngines(3);
		ln = ln.insert(ao1);
		Drone ao2 = new Drone("MVPwatch2"); // 2nd insert
		ao2.setX(101);
		ao2.setY(50);
		ao2.setZ(50);
		ao2.setXWidth(50);
		ao2.setYWidth(50);
		ao2.setZWidth(50);
		ao2.setBrand("Droners");
		ao2.setEngines(3);
		ln = ln.insert(ao2);
		Drone ao3 = new Drone("MVPwatch3"); // 3rd insert
		ao3.setX(152);
		ao3.setY(50);
		ao3.setZ(50);
		ao3.setXWidth(50);
		ao3.setYWidth(50);
		ao3.setZWidth(50);
		ao3.setBrand("Droners");
		ao3.setEngines(3);
		ln = ln.insert(ao3);
		Drone ao4 = new Drone("MVPwatch4"); // 4th insert
		ao4.setX(203);
		ao4.setY(50);
		ao4.setZ(50);
		ao4.setXWidth(50);
		ao4.setYWidth(50);
		ao4.setZWidth(50);
		ao4.setBrand("Droners");
		ao4.setEngines(3);
		ln = ln.insert(ao4);
		ln.dump(0);
		ln = ln.delete("MVPwatch");
		ln = ln.delete("MVPwatch4");
		ln.dump(0);
		ln = ln.delete("MVPwatch2");
		ln = ln.delete("MVPwatch3");
		ln.dump(0);
	}
	
	/**
	 * tests isInner() method
	 */
	public void testIsInner() {
		assertTrue(in.isInner());
		assertFalse(ln.isInner());
		assertFalse(fw.isInner());
    }
    
	/**
	 * tests isLeaf method
	 */
    public void testIsLeaf() {
    	assertTrue(ln.isLeaf());
    	assertFalse(in.isLeaf());
    	assertFalse(fw.isLeaf());
    }
    
    /**
     * tests isFlyweight method
     */
    public void testIsFlyweight() {
    	assertTrue(fw.isFlyweight());
    	assertFalse(ln.isFlyweight());
    	assertFalse(in.isFlyweight());
    }
    
    /**
     * tests nodes() method
     */
    public void testNodes() {
    	assertNotNull(ln.nodes());
    	assertNull(fw.nodes());
    	assertNull(in.nodes());
    }
}
