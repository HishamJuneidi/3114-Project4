import java.util.Random;

/**
 * skip list implementation
 * @author hishamj6, risha97
 * @version 12/02/2018
 * @param <K> key of item being stored
 * @param <E> value of item being stored
 */
public class SkipList<K extends Comparable<AirObject>, E> {
    private SkipNode<K, E> head;
    private int level;
    private int size;
    static private Random ran = new Random(); // Hold the Random class object
    
    /**
     * constructor for skip list
     */
    public SkipList() {
        head = new SkipNode<K, E>(null, null, 0);
        level = -1;
        size = 0;
    }
    
    /**
     * searches for an item in skiplist
     * @param key item being searched for
     * @return key of item being searched,
     * or null if not there
     */
    public K find(E key) {
        SkipNode<K, E> x = head; // Dummy header node
        String k = (String) key;
        String elem;
        for (int i = level; i >= 0; i--) { // For each level...
                if (x.forward[i] != null) {
                    elem = (String) x.forward[i].element();
                    while ((x.forward[i] != null) && (elem.compareTo(k) < 0)) {// go forward
                        x = x.forward[i]; // Go one last step
                        if (x.forward[i] != null) {
                            elem = (String) x.forward[i].element();
                        }
                    }
                }
        }
        x = x.forward[0]; // Move to actual record, if it exists
        if (x != null) {
                elem = (String) x.element();
        }
        else {
                return null; // Its not there
        }
        if (elem.equals(k)) return x.key(); // Got it
        else return null; 
    }
    
    /**
     * generated a random level for
     * an object being inserted
     * @return level of object
     */
    int randomLevel() {
        int lev;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) // ran is random generator
          ; // Do nothing
        return lev;
    }
    
    /** Insert a key, element pair into the skip list */
    @SuppressWarnings("unchecked")
    public boolean insert(K key, E name) {
        if (this.find(name) != null) {
            return false;
        }
        int newLevel = randomLevel(); // New node's level
        if (newLevel > level) // If new node is deeper
            adjustHead(newLevel); // adjust the header
              // Track end of level
        SkipNode<K, E>[] update = new SkipNode[level + 1];
        SkipNode<K, E> x = head; // Start at header node
        for (int i = level; i >= 0; i--) { // Find insert position
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo((AirObject) key) < 0))
                x = x.forward[i];
            update[i] = x; // Track end at level i
        }
        x = new SkipNode<K, E>(key, name, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
            x.forward[i] = update[i].forward[i]; // Who x points to
            update[i].forward[i] = x; // Who points to x
        }
        size++; // Increment dictionary size
        return true;
    }
    
    /**
     * deletes an item from skip list
     * @param key item being deleted
     * @return true if deletion was successful,
     * false if item was never there
     */
    @SuppressWarnings("unchecked")
    public boolean delete(E key) {
        if (this.find(key) == null) {
            
            return false;
        }
        SkipNode<K, E>[] update = new SkipNode[level + 1];
        SkipNode<K, E> x = head;
        String elem = null;
          
        for (int i = level; i >= 0; i--) {
             
            SkipNode<K, E> temp = x.forward[i];
             
              
            if ( temp != null && temp.forward[i] != null) {
                elem = (String) temp.forward[i].element();
            }
            while ((temp.forward[i] != null) && 
                    (!elem.equals((String) key))) {
                temp = temp.forward[i];
                if (temp.forward[i] != null) {
                    elem = (String) temp.forward[i].element();
                }
            }
             
            update[i] = temp;
        }
        if (head.forward[0].element().equals((String) key)) {
            head.forward[0] = head.forward[0].forward[0];
        }
        for (int j = 0; j <= level; j++) {
              
            if (update[j] != null) {
                if (update[j].element().equals((String) key)) {
                    update[j] = update[j].forward[0];
                }
                else if (update[j].forward[0] != null) {
                    if (update[j].forward[0].element().equals((String) key))
                        update[j].forward[0] = update[j].forward[0].forward[0];
                }
                  
            }
            if (j == level && update[j] != null) {
                if ( update[j].forward[0] == null) {
                    level--;
                }
            }
        }
        size--;
        return true;
    }
    
    /**
     * adds level to skiplist
     * @param newLevel level number being added
     */
    private void adjustHead(int newLevel) {
        SkipNode<K, E> temp = head;
        head = new SkipNode<K, E>(null, null, newLevel);
        for (int i = 0; i <= level; i++)
            head.forward[i] = temp.forward[i];
        level = newLevel;
    }
    
    /**
     * prints items in skip list
     */
    public void dump() {
        System.out.println("SkipList dump:");
        SkipNode<K, E> x = head;
        int i = 0;
          
        while (x != null) {
            System.out.print("Node has depth " + x.forward.length + ", ");
            if (x.key() != null) {
                System.out.println("Value " + x.key().toString());
            }
            else {
                System.out.println("Value (null)");
            }
            x = x.forward[i];
        }
          
        System.out.println(size + " skiplist nodes printed");
    }
    
    /**
     * prints a particular item in skip list
     * @param key item being printed
     */
    public void printObject(E key) {
        K nodeToPrint = this.find(key);
        if (nodeToPrint != null) {
            StringBuilder output = new StringBuilder(nodeToPrint.toString());
            output.deleteCharAt(0);
            output.deleteCharAt(output.length() - 1);
            System.out.println("Found: " + output.toString());
        }
        else {
            System.out.print("|" + ((String) key) + "| ");
            System.out.println("does not exist in the database");
        }
    }
    
    /**
     * prints items in given alphabetical range
     * @param start first alphabet in range
     * @param end last alphabet in range
     */
    public void rangePrint(String start, String end) {
        if (end.compareTo(start) > 0) {
            System.out.print("Found these records in the range |" + start + "| ");
            System.out.println("to |" + end + "|");
            SkipNode<K, E> x = head.forward[0];
            int i = 0;
            String elem = null;
            if (x != null)
                elem = (String) x.element();
            while (elem != null && elem.compareTo(end) <= 0) {
                if (elem.compareTo(start) >= 0) {
                    StringBuilder output = new StringBuilder(x.key().toString());
                    output.deleteCharAt(0);
                    output.deleteCharAt(output.length() - 1);
                    System.out.println(output.toString());
                }
                x = x.forward[i];
                if (x != null)
                    elem = (String) x.element();
                else
                    elem = null;
            }
        }
        else {
            System.out.print("Error in rangeprint parameters: |" + start);
            System.out.println("| is not less than |" + end + "|");
        }
    }

}
