/**
 * flyweight class, serves as placeholder
 * for area with no objects
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class Flyweight implements TreeInterface {
    
    private int x;
    private int y;
    private int z;
    private int xLen;
    private int yLen;
    private int zLen;
    private int level;
    
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
    
    /**
     * gets all objects that intersect
     * with given box
     * @param x value of given box
     * @param y value of given box
     * @param z coordinate of given box
     * @param xwidth of given box
     * @param yWidth of given box
     * @param zWidth of given box
     * @param count nodes searched
     * @param number of nodes searched
     */
    public int intersect(int x, int y, int z, 
            int xWidth, int yWidth, int zWidth, int count) {
        return count + 1;
    }
    
    /**
     * deletes object form interface
     * @param object being deleted
     * @return interface with object
     * deleted
     */
    public TreeInterface delete(String name) {
        return this;
    }
    
    /**
     * if is inner node
     * @return true if inner
     */
    public boolean isInner() {
        return false;
    }
    
    /**
     * returns if is leaf
     * @return true if leaf
     */
    public boolean isLeaf() {
        return false;
    }
    
    /**
     * returns if is flyweight
     * @return true if flyweight
     */
    public boolean isFlyweight() {
        return true;
    }
    
    /**
     * returns nodes
     * @param list of objects in leaf
     */
    public MyLinkedList[] nodes() {
        return null;
    }
}
