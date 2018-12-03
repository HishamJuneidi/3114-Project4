/**
 * node that is inserted into linked list
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class linkedNode {
    private AirObject value;
    private linkedNode next, previous;
    
    /**
     * constructor for linked node
     * @param v airobject that node holds
     */
    public linkedNode(AirObject v) {
        this.value = v;
    }
    
    /**
     * returns value of node
     * @return air object being held
     */
    public AirObject value() {
        return value;
    }
    
    /**
     * returns the next node
     * @return next node
     */
    public linkedNode next() {
        return next;
    }
    
    /**
     * returns previous node
     * @return previous
     */
    public linkedNode previous() {
        return previous;
    }
    
    /**
     * sets previous node
     * @param p new value of previous
     */
    public void setPrevious(linkedNode p) {
        previous = p;
    }
    
    /**
     * sets next node
     * @param n new value of next
     */
    public void setNext(linkedNode n) {
        next = n;
    }
    
    /**
     * sets value of current node
     * @param v new value of current
     */
    public void setValue(AirObject v) {
        value = v;
    }
    
    /**
     * checks if current node collides with
     * another node
     * @param ao object being checked
     * @return whether they collide
     */
    public boolean collides(AirObject ao) {
        int x = value.getXorig();
        int y = value.getYorig();
        int z = value.getZorig();
        int xWidth = x + value.getXwidth();
        int yWidth = y + value.getYwidth();
        int zWidth = z + value.getZwidth();
        if (x > (ao.getXorig() + ao.getXwidth())) {
            return false;
        }
        if (y > (ao.getYorig() + ao.getYwidth())) {
            return false;
        }
        if (z > (ao.getZorig() + ao.getZwidth())) {
            return false;
        }
        if (xWidth < ao.getXorig()) {
            return false;
        }
        if (yWidth < ao.getYorig()) {
            return false;
        }
        if (zWidth < ao.getZorig()) {
            return false;
        }
        return true;
    }
}
