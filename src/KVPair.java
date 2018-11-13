
public class KVPair<K extends Comparable<AirObject>> {
	
	private K key;
	
	public KVPair(K k) {
		key = k;
	}
	
	public K key() {
		return key;
	}
	

}
