
public class SkipNode<K extends Comparable<AirObject>> {
	
	private KVPair<K> rec;
	public SkipNode<K>[] forward;
	

	
	public K key() {
	    return rec.key();
	}

	@SuppressWarnings("unchecked")
	public SkipNode(K key, int level) {
	    rec = new KVPair<K>(key);
	    forward = new SkipNode[level + 1];
	    for (int i = 0; i < level; i++)
	    		forward[i] = null;
	}


}
