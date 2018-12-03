/**
 * represents box that holds air objects
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class leafNode implements treeInterface {
    
    private int x, y, z, xLen, yLen, zLen, level;
    private linkedList[] nodes;
    private final int MAX_NODES = 3;
    
    /**
     * constructor for leaf node
     * @param newX x value of bottom left corner
     * @param newY y value of bottom left corner
     * @param newZ z value of bottom left corner
     * @param xLength length in x direction
     * @param yLength length in y direction
     * @param zLength length in z direction
     * @param l level in the tree
     */
    public leafNode(int newX, int newY, int newZ, int xLength, int yLength, int zLength, int l) {
        x = newX;
        y = newY;
        z = newZ;
        xLen = xLength;
        yLen = yLength;
        zLen = zLength;
        level = l;
        nodes = new linkedList[MAX_NODES];
        for (int i = 0; i < MAX_NODES; i++) {
            nodes[i] = new linkedList();
        }
    }

    
    /**
     * inserts airobject into node
     */
    public treeInterface insert(AirObject ao) {
        /*if (numNodes == 3) {
            split();
        }*/
        for (int i = 0; i < MAX_NODES; i++) {
            if (nodes[i].head() == null) {
                nodes[i].insert(new linkedNode(ao));
                break;
            }
            if (nodes[i].head().collides(ao)) {
                nodes[i].insert(new linkedNode(ao));
                break;
            }
        }
        int tempLen = 0;
        int numLocations = 0;
        for (int j = 0; j < MAX_NODES; j++) {
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
     * @return inner node containing 2 new
     * nodes
     */
    private treeInterface split() {
        InnerNode output = new InnerNode(x, y, z, xLen, yLen, zLen, level);
        for (linkedList l: nodes) {
            if (l.head() != null) {
                linkedNode curr = l.head();
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
     */
    public int dump(int count) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i < level; i++) {
            buffer.append("  ");
        }
        int numObjects = 0;
        linkedList objects = new linkedList();
        for (linkedList l: nodes) {
            linkedNode curr = l.head();
            while (curr != null) {
                objects.insert(new linkedNode(curr.value()));
                numObjects++;
                curr = curr.next();
            }
        }
        count++;
        System.out.print(buffer);
        if (numObjects == 0) {
            System.out.println("E");
        }
        else {
            System.out.println("Leaf with " + numObjects + " objects:");
            linkedNode o = objects.tail();
            while (o != null) {
                System.out.print(buffer.toString());
                System.out.println(o.value().toString());
                o = o.previous();
            }
        }
        return count;
    }

}
