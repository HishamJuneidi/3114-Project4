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
    
    public void collisions();
    
    public int intersect(int x, int y, int z, int xWidth, int yWidth, int zWidth, int count);
    
    public TreeInterface delete(String name);
    
    public boolean isInner();
    
    public boolean isLeaf();
    
    public boolean isFlyweight();
    
    public MyLinkedList[] nodes();

}
