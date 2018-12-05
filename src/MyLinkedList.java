/**
 * linked list class, meant for holding intersecting aircrafts
 * 
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class MyLinkedList {
    private LinkedNode head;
    private LinkedNode tail;
    private int length;

    /**
     * constructor for linked list
     */
    public MyLinkedList() {
        length = 0;
    }

    /**
     * inserts object into linked list
     * 
     * @param l node being inserted
     */
    public void insert(LinkedNode l) {
        if (length == 0) {
            head = l;
            tail = l;
        } 
        else {
            LinkedNode current = head;
            while (current != null && current.value().getName().compareTo(l.value().getName()) > 0) {
                current = current.next();
            }
            if (current != null) {
                if (current.value().getName().equals(l.value().getName())) {
                    return;
                }
                l.setPrevious(current.previous());
                current.setPrevious(l);
                l.setNext(current);
                if (l.previous() != null) {
                    l.previous().setNext(l);
                } 
                else {
                    head = l;
                }
            } 
            else {
                l.setPrevious(tail);
                tail.setNext(l);
                tail = l;
            }
        }
        length++;
    }

    /**
     * removes object from linked list
     * 
     * @param name airobject being removed
     * @return if removal was successful
     */
    public boolean remove(String name) {
        LinkedNode current = head;
        while (current != null && !current.value().getName().equals(name)) {
            current = current.next();
        }
        if (current != null) {
            if (current.previous() != null) {
                current.previous().setNext(current.next());
            } 
            else {
                head = current.next();
            }
            if (current.next() != null) {
                current.next().setPrevious(current.previous());
            } 
            else {
                tail = current.previous();
            }
            length--;
            return true;
        }
        return false;
    }

    /**
     * gets head of linked list
     * 
     * @return head of linked list
     */
    public LinkedNode head() {
        return head;
    }

    /**
     * returns tail of linked list
     * 
     * @return tail
     */
    public LinkedNode tail() {
        return tail;
    }

    /**
     * returns number of nodes in linked list
     * 
     * @return length
     */
    public int length() {
        return length;
    }

    /**
     * checks if a given air object collides with all objects in linked list
     * 
     * @param ao
     * @return whether or not all objects collide
     */
    public boolean collides(AirObject ao) {
        LinkedNode curr = head;
        while (curr != null) {
            if (!curr.collides(ao)) {
                return false;
            }
            curr = curr.next();
        }
        return true;
    }

    /**
     * gets every object that collides with box
     * 
     * @param x      x coordinate of box
     * @param y      y coordinate of box
     * @param z      z coordinate of box
     * @param xWidth length of box in x direction
     * @param yWidth length of box in y direction
     * @param zWidth length of box in z direction
     */
    public void collissions(int x, int y, int z, int xWidth, int yWidth, int zWidth) {
        LinkedNode first = tail;
        LinkedNode second = first.previous();
        while (first.previous() != null) {
            while (second != null) {
                int xCoordinate;
                int yCoordinate;
                int zCoordinate;
                if (first.value().getXorig() > second.value().getXorig()) {
                    xCoordinate = first.value().getXorig();
                } 
                else {
                    xCoordinate = second.value().getXorig();
                }
                if (first.value().getYorig() > second.value().getYorig()) {
                    yCoordinate = first.value().getYorig();
                } 
                else {
                    yCoordinate = second.value().getYorig();
                }
                if (first.value().getZorig() > second.value().getZorig()) {
                    zCoordinate = first.value().getZorig();
                } 
                else {
                    zCoordinate = second.value().getZorig();
                }
                if ((x <= xCoordinate && xCoordinate <= (x + xWidth))
                        && (y <= yCoordinate && yCoordinate <= (y + yWidth))
                        && (z <= zCoordinate && zCoordinate <= (z + zWidth))) {
                    System.out.print(first.value().toString() + " and ");
                    System.out.println(second.value().toString());
                }
                second = second.previous();
            }
            first = first.previous();
            second = first.previous();
        }
    }
}
