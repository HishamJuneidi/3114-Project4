/**
 * interface that connects inner nodes, empty nodes,
 * and leaf nodes
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public interface TreeInterface {
    /*public void innerNode();
    public void leafNode();
    public void emptyNode();*/
    
    /**
     * insert method for each node
     * @param ao object being inserted
     * @return object that as was inserted into
     */
    public TreeInterface insert(AirObject ao);
    
    /**
     * prints the contents of a given interface
     * @param count keeps count of number of branches
     * @return value of count
     */
    public int dump(int count);
    
    /**
     * gets all collisions in tree interface
     */
    public void collisions();
    
    /**
     * gets all objects that intersect with given box
     * @param x x coordinate of box
     * @param y y coordinate of box
     * @param z z coordinate of box
     * @param xWidth of box
     * @param yWidth of box
     * @param zWidth of box
     * @param count number of nodes searched
     * @return number of nodes searched
     */
    public int intersect(int x, int y, int z, 
            int xWidth, int yWidth, int zWidth, int count);
    
    /**
     * deletes airobject from bintree
     * @param name name of object being deleted
     * @return treeinterface with object deleted
     */
    public TreeInterface delete(String name);
    
    /**
     * if interface is internal node
     * @return true if internal node
     */
    public boolean isInner();
    
    /**
     * if interface is leaf
     * @return true if leaf node
     */
    public boolean isLeaf();
    
    /**
     * if interface is a flyweight
     * @return true if flyweight
     */
    public boolean isFlyweight();
    
    /**
     * list of objects being stored
     * @return list of objects
     */
    public MyLinkedList[] nodes();

}
