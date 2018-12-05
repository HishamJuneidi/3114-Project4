/**
 * bintree that stores aircrafts
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class BinTree {

    private TreeInterface empN;
    private int xVal;
    private int yVal;
    private int zVal;
    private int length;
    private int width;
    private int height;
    private int level;
    
    /**
     * constructor for bintree
     * @param newX x coordinate for bottom corner
     * @param newY y coordinate for bottom corner
     * @param newZ z coordinate for bottom corner
     * @param boxLength length in x direction
     * @param boxWidth length in y direction
     * @param boxHeight length in z direction
     * @param l starting level
     */
    public BinTree(int newX, int newY, int newZ, 
            int boxLength, int boxWidth, int boxHeight, int l) {
        length = boxLength;
        width = boxWidth;
        height = boxHeight;
        xVal = newX;
        yVal = newY;
        zVal = newZ;
        level = l;
        empN = new Flyweight(xVal, yVal, zVal, length, width, height, level);
    }
    
    /**
     * inserts airobject into bintree
     * @param v object being inserted
     */
    public void insert(AirObject v) {
        empN = empN.insert(v);
    }
    
    /**
     * print contents of bintree
     * @param count number of nodes printed so far
     * @return number of nodes printed
     */
    public int dump(int count) {
        System.out.println("Bintree dump:");
        count = empN.dump(count);
        return count;
    }
    
    /**
     * gets all collisions in bintree
     */
    public void collisions() {
        empN.collisions();
    }
    
    /**
     * finds all objects that intersect with
     * given box
     * @param x x value of box
     * @param y y value of box
     * @param z z value of box
     * @param xWidth length in x-direction of box
     * @param yWidth length in y-direction of box
     * @param zWidth length in z-direction of box
     * @return number of nodes visited
     */
    public int intersect(int x, int y, int z, 
            int xWidth, int yWidth, int zWidth) {
        return empN.intersect(x, y, z, xWidth, yWidth, zWidth, 0);
    }
    
    /**
     * deletes object from bintree
     * @param name name of object being deleted
     */
    public void delete(String name) {
        empN = empN.delete(name);
    }
    
    /**
     * gets x
     * @return x value
     */
    public int xVal() {
        return xVal;
    }
    
    /**
     * gets y
     * @return y value
     */
    public int yVal() {
        return yVal;
    }
    
    /**
     * gets z
     * @return z value
     */
    public int zVal() {
        return zVal;
    }
    
    /**
     * gets length
     * @return length
     */
    public int length() {
        return length;
    }
    
    /**
     * gets height
     * @return height
     */
    public int height() {
        return height;
    }
    
    /**
     * gets width
     * @return width
     */
    public int width() {
        return width;
    }
    
    /**
     * gets level
     * @return level
     */
    public int level() {
        return level;
    }
}
