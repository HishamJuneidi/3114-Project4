/**
 * flyweight class, serves as placeholder
 * for area with no objects
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class Flyweight implements TreeInterface {
    
    private int x, y, z, xLen, yLen, zLen, level;
    
    /**
     * constructor
     * @param newX x value of bottom left corner
     * @param newY y value of bottom left corner
     * @param newZ z value of bottom left corner
     * @param xLength length in x direction
     * @param yLength length in y direction
     * @param zLength length in z direction
     * @param l level in the tree
     */
    public Flyweight(int newX, int newY, int newZ, int xLength, int yLength, int zLength, int l) {
        x = newX;
        y = newY;
        z = newZ;
        xLen = xLength;
        yLen = yLength;
        zLen = zLength;
        level = l;
    }
    
    /**
     * inserts into emptynode
     */
    public TreeInterface insert(AirObject ao) {
        // TODO Auto-generated method stub
        LeafNode output = new LeafNode(x, y, z, xLen, yLen, zLen, level);
        
        return output.insert(ao);
    }
    
    /**
     * prints the Empty node
     */
    public int dump(int count) {
        for (int i = 1; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("E");
        return count + 1;
    }
    
    public void collisions() {
    	return;
    }
    
    public int intersect(int x, int y, int z, int xWidth, int yWidth, int zWidth, int count) {
    	return count + 1;
    }
    
    public TreeInterface delete(String name) {
    	return this;
    }
    
    public boolean isInner() {
    	return false;
    }
    
    public boolean isLeaf() {
    	return false;
    }
    
    public boolean isFlyweight() {
    	return true;
    }
    
    public MyLinkedList[] nodes() {
    	return null;
    }
}
