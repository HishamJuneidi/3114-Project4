/**
 * key and value pair stored in skipnode
 * @author risha97, hishamj6
 * @version 12/04/2018
 * @param <K> key
 * @param <E> value
 */
public class KVPair<K extends Comparable<AirObject>, E> {
    
    private K key;
    private E  value;
    
    /**
     * constructor for kvpair
     * @param k key
     * @param v value
     */
    public KVPair(K k, E v) {
        key = k;
        value = v;
    }
    
    /**
     * returns key
     * @return key
     */
    public K key() {
        return key;
    }
    
    /**
     * returns value
     * @return value
     */
    public E value() {
        return value;
    }

}
