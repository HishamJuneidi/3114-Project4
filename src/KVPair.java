
public class KVPair<K extends Comparable<AirObject>, E> {
	
	private K key;
	private E  value;
	
	public KVPair(K k, E v) {
		key = k;
		value = v;
	}
	
	public K key() {
		return key;
	}
	
	public E value() {
		return value;
	}

}
