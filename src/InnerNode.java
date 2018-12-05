/**
 * internal node implementation
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class InnerNode implements TreeInterface {

    private int xVal;
    private int yVal;
    private int zVal;
    private int xLen;
    private int yLen;
    private int zLen;
    private int level;
    private TreeInterface left;
    private TreeInterface right;
    
    /**
     * constructor for innernode
     * @param newX x value of corner
     * @param newY y value of corner
     * @param newZ z value of corner
     * @param xLength length in x dir
     * @param yLength length in y dir
     * @param zLength length in z dir
     * @param l level
     */
    public InnerNode(int newX, int newY, int newZ, 
            int xLength, int yLength, int zLength, int l) {
        xVal = newX;
        yVal = newY;
        zVal = newZ;
        xLen = xLength;
        yLen = yLength;
        zLen = zLength;
        level = l;
        if (level % 3 == 1) {
            left = new Flyweight(xVal, yVal, zVal, xLen / 2, 
                    yLen, zLen, this.level + 1);
            right = new Flyweight(xVal + (xLen / 2), yVal, zVal, 
                    xLen / 2, yLen, zLen, this.level + 1);
        } 
        else if (level % 3 == 2) {
            left = new Flyweight(xVal, yVal, zVal, xLen, 
                    yLen / 2, zLen, this.level + 1);
            right = new Flyweight(xVal, yVal + (yLen / 2), zVal, 
                    xLen, yLen / 2, zLen, this.level + 1);
        } 
        else {
            left = new Flyweight(xVal, yVal, zVal, xLen, 
                    yLen, zLen / 2, this.level + 1);
            right = new Flyweight(xVal, yVal, zVal + (zLen / 2), 
                    xLen, yLen, zLen / 2, this.level + 1);
        }
    }
    
    /**
     * inserts object into interface
     * @param ao object inserted
     * @return interface with object
     */
    public TreeInterface insert(AirObject ao) {
        // split by x axis
        if (level % 3 == 1) {
            if (ao.getXorig() < xVal + (xLen / 2)) {
                left = left.insert(ao);
                if ((ao.getXorig() + ao.getXwidth()) >= (xVal + (xLen / 2))) {
                    right = right.insert(ao);
                }
            } 
            else {
                right = right.insert(ao);
            }
        }
        // split by y axis
        else if (level % 3 == 2) {
            if (ao.getYorig() < yVal + (yLen / 2)) {
                left = left.insert(ao);
                if ((ao.getYorig() + ao.getYwidth()) >= (yVal + (yLen / 2))) {
                    right = right.insert(ao);
                }
            } 
            else {
                right = right.insert(ao);
            }
        }
        // split by z axis
        else {
            if (ao.getZorig() < zVal + (zLen / 2)) {
                left = left.insert(ao);
                if ((ao.getZorig() + ao.getZwidth()) >= (zVal + (zLen / 2))) {
                    right = right.insert(ao);
                }
            } 
            else {
                right = right.insert(ao);
            }
        }
        return this;
    }
    
    /**
     * sets the left value
     * @param l new left interface
     */
    public void setLeft(TreeInterface l) {
        this.left = l;
    }
    
    /**
     * sets right vale
     * @param r new right interface
     */
    public void setRight(TreeInterface r) {
        this.right = r;
    }
    
    /**
     * returns left interface
     * @return left interface
     */
    public TreeInterface left() {
        return left;
    }
    
    /**
     * returns right value
     * @return right interface
     */
    public TreeInterface right() {
        return right;
    }
    
    /**
     * prints contents
     * @param count nodes printed so far
     * @return count nodes printed
     */
    public int dump(int count) {
        for (int i = 1; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("I");
        count++;
        count = left.dump(count);
        count = right.dump(count);
        return count;
    }
    
    /**
     * gets all pairs of objects that 
     * collide
     */
    public void collisions() {
        left.collisions();
        right.collisions();
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
        count++;
        if (level % 3 == 1) { // split by x
            if (x < this.xVal + (xLen / 2)) {
                count = left.intersect(x, y, z, 
                        xWidth, yWidth, zWidth, count);
                if ((x + xWidth) >= this.xVal + (xLen / 2)) {
                    return right.intersect(x, y, z, 
                            xWidth, yWidth, zWidth, count);
                }
                return count;
            } 
            else {
                return right.intersect(x, y, z, 
                        xWidth, yWidth, zWidth, count);
            }
        } 
        else if (level % 3 == 2) { // split by y
            if (y < this.yVal + (yLen / 2)) {
                count = left.intersect(x, y, z, 
                        xWidth, yWidth, zWidth, count);
                if ((y + yWidth) >= this.yVal + (yLen / 2)) {
                    return right.intersect(x, y, z, 
                            xWidth, yWidth, zWidth, count);
                }
                return count;
            } 
            else {
                return right.intersect(x, y, z, 
                        xWidth, yWidth, zWidth, count);
            }
        } 
        else { // split by z
            if (z < this.zVal + (zLen / 2)) {
                count = left.intersect(x, y, z, 
                        xWidth, yWidth, zWidth, count);
                if ((z + zWidth) >= this.zVal + (zLen / 2)) {
                    return right.intersect(x, y, z, 
                            xWidth, yWidth, zWidth, count);
                }
                return count;
            } 
            else {
                return right.intersect(x, y, z, 
                        xWidth, yWidth, zWidth, count);
            }
        }
    }
    
    /**
     * deletes object from interface
     * @param name object being deleted
     * @return interface without object
     */
    public TreeInterface delete(String name) {
        left = left.delete(name);
        right = right.delete(name);
        return this.merge();
    }
    
    /**
     * merges left and right
     * @return result of merging
     */
    private TreeInterface merge() {
        if (left.isFlyweight() && right.isFlyweight()) {
            TreeInterface output = new Flyweight(xVal, yVal, zVal, 
                    xLen, yLen, zLen, level);
            return output;
        }
        TreeInterface output = new LeafNode(xVal, yVal, zVal, 
                xLen, yLen, zLen, level);
        if (left.isFlyweight() && right.isLeaf()) {
            MyLinkedList[] nodes = right.nodes();
            for (MyLinkedList l: nodes) {
                LinkedNode head = l.head();
                while (head != null) {
                    output = output.insert(head.value());
                    head = head.next();
                }
            }
            return output;
        }
        if (left.isLeaf() && right.isFlyweight()) {
            MyLinkedList[] nodes = left.nodes();
            for (MyLinkedList l: nodes) {
                LinkedNode head = l.head();
                while (head != null) {
                    output = output.insert(head.value());
                    head = head.next();
                }
            }
            return output;
        }
        if (left.isLeaf() && right.isLeaf()) {
            MyLinkedList[] rightNodes = right.nodes();
            MyLinkedList[] leftNodes = left.nodes();
            for (MyLinkedList r: rightNodes) {
                LinkedNode head = r.head();
                while (head != null) {
                    output = output.insert(head.value());
                    head = head.next();
                }
            }
            for (MyLinkedList l: leftNodes) {
                LinkedNode head = l.head();
                while (head != null) {
                    output = output.insert(head.value());
                    head = head.next();
                }
            }
            if (output.isLeaf()) {
                return output;
            }
        }
        return this;
    }
    
    /**
     * returns if is inner node
     * @return true if inner
     */
    public boolean isInner() {
        return true;
    }
    
    /**
     * returns if is leaf node
     * @return true if leaf
     */
    public boolean isLeaf() {
        return false;
    }
    
    /**
     * returns if is Flyweight
     * @return true if flyweight
     */
    public boolean isFlyweight() {
        return false;
    }
    
    /**
     * returns list of nodes
     * @return list of airobjects
     */
    public MyLinkedList[] nodes() {
        return null;
    }
}
