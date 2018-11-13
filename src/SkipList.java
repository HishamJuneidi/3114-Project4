import java.util.Random;

public class SkipList<K extends Comparable<AirObject>, E> {
	private SkipNode<K> head;
	private int level;
	private int size;
	static private Random ran = new Random(); // Hold the Random class object
	
	public SkipList() {
	    head = new SkipNode<K>(null, 0);
	    level = -1;
	    size = 0;
	}
	
	public K find(K key) {
	    SkipNode<K> x = head; // Dummy header node
	    AirObject k = (AirObject) key;
	    for (int i = level; i >= 0; i--) // For each level...
	    		while ((x.forward[i] != null) && (x.forward[i].key().compareTo(k) < 0)) // go forward
	    			x = x.forward[i]; // Go one last step
	    x = x.forward[0]; // Move to actual record, if it exists
	    if ((x != null) && (x.key().compareTo(k) == 0)) return x.key(); // Got it
	    else return null; // Its not there
	}
	
	int randomLevel() {
	    int lev;
	    for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) // ran is random generator
	      ; // Do nothing
	    return lev;
	}
	
	/** Insert a key, element pair into the skip list */
	  @SuppressWarnings("unchecked")
	public boolean insert(K key) {
		  if (this.find(key) != null)
			  return false;
		  int newLevel = randomLevel(); // New node's level
		  if (newLevel > level) // If new node is deeper
			  adjustHead(newLevel); // adjust the header
		  	  // Track end of level
		    	  SkipNode<K>[] update = new SkipNode[level + 1];
		      SkipNode<K> x = head; // Start at header node
		      for (int i = level; i >= 0; i--) { // Find insert position
		    	  	while ((x.forward[i] != null) && (x.forward[i].key().compareTo((AirObject) key) < 0))
			    	  	x = x.forward[i];
			    update[i] = x; // Track end at level i
		    }
		    x = new SkipNode<K>(key, newLevel);
		    for (int i = 0; i <= newLevel; i++) { // Splice into list
		    		x.forward[i] = update[i].forward[i]; // Who x points to
		    		update[i].forward[i] = x; // Who points to x
		    }
		    size++; // Increment dictionary size
		    return true;
	  }

	  private void adjustHead(int newLevel) {
		    SkipNode<K> temp = head;
		    head = new SkipNode<K>(null, newLevel);
		    for (int i = 0; i <= level; i++)
		    		head.forward[i] = temp.forward[i];
		    level = newLevel;
	  }
	  
	  public void dump() {
		  System.out.println("SkipList dump:");
		  SkipNode<K> x = head;
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

}
