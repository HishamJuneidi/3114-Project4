/**
 * represents box that holds air objects
 * 
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class LeafNode implements TreeInterface {

    private int xVal;
    private int yVal;
    private int zVal;
    private int xLen;
    private int yLen;
    private int zLen;
    private int level;
    private MyLinkedList[] nodes;
    private final int maxNodes = 4;

    /**
     * constructor for leaf node
     * 
     * @param newX    x value of bottom left corner
     * @param newY    y value of bottom left corner
     * @param newZ    z value of bottom left corner
     * @param xLength length in x direction
     * @param yLength length in y direction
     * @param zLength length in z direction
     * @param l       level in the tree
     */
    public LeafNode(int newX, int newY, int newZ, 
            int xLength, int yLength, int zLength, int l) {
        xVal = newX;
        yVal = newY;
        zVal = newZ;
        xLen = xLength;
        yLen = yLength;
        zLen = zLength;
        level = l;
        nodes = new MyLinkedList[maxNodes];
        for (int i = 0; i < maxNodes; i++) {
            nodes[i] = new MyLinkedList();
        }
    }
    
    /**
     * returns list of nodes
     * @return list of airobjects
     * in leaf
     */
    public MyLinkedList[] nodes() {
        return nodes;
    }

    /**
     * inserts airobject into node
     * @param ao object being inserted
     * @return interface with object
     */
    public TreeInterface insert(AirObject ao) {
        for (int i = 0; i < maxNodes; i++) {
            if (nodes[i].head() == null) {
                nodes[i].insert(new LinkedNode(ao));
                break;
            }
            if (nodes[i].collides(ao)) {
                nodes[i].insert(new LinkedNode(ao));
                break;
            }
        }
        int tempLen = 0;
        int numLocations = 0;
        for (int j = 0; j < maxNodes; j++) {
            tempLen += nodes[j].length();
            if (nodes[j].length() > 0) {
                numLocations++;
            }
        }
        if (tempLen > 3 && numLocations > 1) {
            return split();
        } 
        else {
            return this;
        }
    }

    /**
     * splits node when it reaches limit
     * 
     * @return inner node containing 2 new nodes
     */
    private TreeInterface split() {
        InnerNode output = new InnerNode(xVal, yVal, zVal, 
                xLen, yLen, zLen, level);
        for (MyLinkedList l : nodes) {
            if (l.head() != null) {
                LinkedNode curr = l.head();
                while (curr != null) {
                    output.insert(curr.value());
                    curr = curr.next();
                }
            }
        }
        return output;
    }

    /**
     * prints all objects in leaf node
     * @param count number of nodes printed
     * @return number of nodes printed
     */
    public int dump(int count) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i < level; i++) {
            buffer.append("  ");
        }
        int numObjects = 0;
        MyLinkedList objects = new MyLinkedList();
        for (MyLinkedList l : nodes) {
            LinkedNode curr = l.head();
            while (curr != null) {
                objects.insert(new LinkedNode(curr.value()));
                numObjects++;
                curr = curr.next();
            }
        }
        count++;
        System.out.print(buffer);
        System.out.println("Leaf with " + numObjects + " objects:");
        LinkedNode o = objects.tail();
        while (o != null) {
            System.out.print(buffer.toString());
            System.out.println(o.value().toString());
            o = o.previous();
        }

        return count;
    }
    
    /**
     * gets all pairs of colliding objects
     */
    public void collisions() {
        for (MyLinkedList l : nodes) {
            if (l.length() > 1) {
                l.collissions(xVal, yVal, zVal, xLen, yLen, zLen);
            }
        }
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
        MyLinkedList i = new MyLinkedList();
        for (MyLinkedList l : nodes) {
            LinkedNode tail = l.tail();
            while (tail != null) {
                i.insert(new LinkedNode(tail.value()));
                tail = tail.previous();
            }
            
        }
        LinkedNode tail = i.tail();
        while (tail != null) {
            if (tail.intersects(x, y, z, xWidth, yWidth, zWidth)) {
                int xCoordinate; // x coordinate of intersection
                int yCoordinate; // y coordinate of intersection
                int zCoordinate; // z coordinate of intersection
                if (x > tail.value().getXorig()) {
                    xCoordinate = x;
                } 
                else {
                    xCoordinate = tail.value().getXorig();
                }
                if (y > tail.value().getYorig()) {
                    yCoordinate = y;
                } 
                else {
                    yCoordinate = tail.value().getYorig();
                }
                if (z > tail.value().getZorig()) {
                    zCoordinate = z;
                } 
                else {
                    zCoordinate = tail.value().getZorig();
                }
                if ((this.xVal <= xCoordinate && 
                        xCoordinate <= (this.xVal + xLen))
                        && (this.yVal <= yCoordinate && 
                        yCoordinate <= (this.yVal + yLen))
                        && (this.zVal <= zCoordinate && 
                        zCoordinate <= (this.zVal + zLen))) {
                    StringBuilder output = new 
                            StringBuilder(tail.value().toString());
                    output.deleteCharAt(output.length() - 1);
                    output.deleteCharAt(0);
                    System.out.println(output.toString());
                }

            }
            tail = tail.previous();
        }
        return count;
    }
    
    /**
     * deletes object from interface
     * @param name name of object being deleted
     * @return interface with object
     * deleted
     */
    public TreeInterface delete(String name) {
        for (MyLinkedList l : nodes) {
            if (l.remove(name)) {
                break;
            }
        }
        int tempLen = 0;
        for (int j = 0; j < maxNodes; j++) {
            tempLen += nodes[j].length();
        }
        if (tempLen == 0) {
            return new Flyweight(xVal, yVal, zVal, xLen, yLen, zLen, level);
        }
        return this;
    }
    
    /**
     * if interface is inner node
     * @return true if inner node
     */
    public boolean isInner() {
        return false;
    }
    
    /**
     * if interface is leaf node
     * @return true if leaf
     */
    public boolean isLeaf() {
        return true;
    }
    
    /**
     * if interface is flyweight
     * @return true if flyweight
     */
    public boolean isFlyweight() {
        return false;
    }

}
