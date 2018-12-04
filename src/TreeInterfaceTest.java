import junit.framework.TestCase;

public class TreeInterfaceTest extends TestCase {
	
	private TreeInterface ln;
	
	public void setUp() {
		ln = new LeafNode(0, 0, 0, 1024, 1024, 1024, 1);
	}
	
	public void testDump() {
		
	}
	
	public void testCollisions() {
		
	}
	
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

}
