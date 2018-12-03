/**
 * linked list class, meant for holding 
 * intersecting aircrafts
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class linkedList {
    private linkedNode head, tail; 
    private int length;
    
    /**
     * constructor for linked list
     */
    public linkedList(){
        length = 0;
    }
    
    /**
     * inserts object into linked list
     * @param l node being inserted
     */
    public void insert(linkedNode l) {
        if (length == 0) {
            head = l;
            tail = l;
        }
        else {
            linkedNode current = head;
            while (current != null && 
                    current.value().getName().compareToIgnoreCase(l.value().getName()) > 0) {
                current = current.next();
            }
            if (current != null) {
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
            /*l.setPrevious(tail);
            tail.setNext(l);
            tail = l;*/
        }
        length++;
    }
    
    /**
     * removes object from linked list
     * @param ao airobject being removed
     */
    public void remove(AirObject ao) {
        linkedNode current = head;
        while (current != null && !current.value().equals(ao)) {
            current = current.next();
        }
        if (current != null) {
            if (current.previous() != null) {
                current.previous().setNext(current.next());
            }
            if (current.next() != null) {
                current.next().setPrevious(current.previous());
            }
            length--;
        }
    }
    
    /**
     * gets head of linked list
     * @return head of linked list
     */
    public linkedNode head() {
        return head;
    }
    
    /**
     * returns tail of linked list
     * @return tail
     */
    public linkedNode tail() {
        return tail;
    }
    
    /**
     * returns number of nodes in linked list
     * @return length
     */
    public int length() {
        return length;
    }
}
