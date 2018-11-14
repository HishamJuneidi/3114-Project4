
public class SkipNode<K extends Comparable<AirObject>, E> {
	
	private KVPair<K, E> rec;
	public SkipNode<K, E>[] forward;
	private SkipNode<K, E> next;
	
	public Object element() {
		return rec.value();
	}

	
	public K key() {
	    return rec.key();
	}

	@SuppressWarnings("unchecked")
	public SkipNode(K key, E elem, int level) {
	    rec = new KVPair<K, E>(key, elem);
	    forward = new SkipNode[level + 1];
	    for (int i = 0; i < level; i++)
	    		forward[i] = null;
	}
	
	public SkipNode<K, E> next() {
		return next;
	}
	
	public void setNext(SkipNode<K, E> newNext) {
		newNext.setNext(next);
		next = newNext;
	}


}
