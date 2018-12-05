/**
 * node being stored in skiplist
 * 
 * @author risha97, hishamj6
 * @version 12/04/2018
 * @param <K> key
 * @param <E> value
 */
public class SkipNode<K extends Comparable<AirObject>, E> {

    private KVPair<K, E> rec;
    private SkipNode<K, E>[] forward;
    private SkipNode<K, E> next;

    /**
     * returns value of node
     * 
     * @return value of node
     */
    public Object element() {
        return rec.value();
    }

    /**
     * returns key of nodes
     * 
     * @return key of node
     */
    public K key() {
        return rec.key();
    }

    /**
     * constructor of skipnode
     * 
     * @param key   key of skipnode
     * @param elem  value of skipnode
     * @param level level in skiplist
     */
    @SuppressWarnings("unchecked")
    public SkipNode(K key, E elem, int level) {
        rec = new KVPair<K, E>(key, elem);
        forward = new SkipNode[level + 1];
        for (int i = 0; i < level; i++) {
            forward[i] = null;
        }
    }

    /**
     * gets next skipnode in list
     * 
     * @return next node in list
     */
    public SkipNode<K, E> next() {
        return next;
    }

    /**
     * sets next skipnode
     * 
     * @param newNext new next node
     */
    public void setNext(SkipNode<K, E> newNext) {
        newNext.setNext(next);
        next = newNext;
    }
    
    /**
     * gets forward nodes
     * @return forward nodes
     */
    public SkipNode<K, E>[] forward() {
        return this.forward;
    }

}
