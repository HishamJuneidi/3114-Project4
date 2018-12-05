/**
 * flyweight class, serves as placeholder
 * for area with no objects
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class Flyweight implements TreeInterface {
    
    private int xVal;
    private int yVal;
    private int zVal;
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
    public Flyweight(int newX, int newY, int newZ, 
            int xLength, int yLength, int zLength, int l) {
        xVal = newX;
        yVal = newY;
        zVal = newZ;
        xLen = xLength;
        yLen = yLength;
        zLen = zLength;
        level = l;
    }
    
    /**
     * inserts into emptynode
     * @param ao object inserted
     * @return interface with ao inserted
     */
    public TreeInterface insert(AirObject ao) {
        LeafNode output = new LeafNode(xVal, yVal, zVal, 
                xLen, yLen, zLen, level);
        
        return output.insert(ao);
    }
    
    /**
     * prints the Empty node
     * @param count number of nodes visited
     * @return nodes visited
     */
    public int dump(int count) {
        for (int i = 1; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("E");
        return count + 1;
    }
    
    /**
     * prints objects that collide
     */
    public void collisions() {
        return;
    }
    
    /**
     * gets all objects that intersect
     * with given box
     * @param x value of given box
     * @param y value of given box
     * @param z coordinate of given box
     * @param xWidth of given box
     * @param yWidth of given box
     * @param zWidth of given box
     * @param count nodes searched
     * @return number of nodes searched
     */
    public int intersect(int x, int y, int z, 
            int xWidth, int yWidth, int zWidth, int count) {
        return count + 1;
    }
    
    /**
     * deletes object form interface
     * @param name object being deleted
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
     * @return list of objects in leaf
     */
    public MyLinkedList[] nodes() {
        return null;
    }
}
