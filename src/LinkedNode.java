/**
 * node that is inserted into linked list
 * 
 * @author hishamj6, risha97
 * @version 12/02/2018
 */
public class LinkedNode {
	private AirObject value;
	private LinkedNode next;
	private LinkedNode previous;

	/**
	 * constructor for linked node
	 * 
	 * @param v airobject that node holds
	 */
	public LinkedNode(AirObject v) {
		this.value = v;
	}

	/**
	 * returns value of node
	 * 
	 * @return air object being held
	 */
	public AirObject value() {
		return value;
	}

	/**
	 * returns the next node
	 * 
	 * @return next node
	 */
	public LinkedNode next() {
		return next;
	}

	/**
	 * returns previous node
	 * 
	 * @return previous
	 */
	public LinkedNode previous() {
		return previous;
	}

	/**
	 * sets previous node
	 * 
	 * @param p new value of previous
	 */
	public void setPrevious(LinkedNode p) {
		previous = p;
	}

	/**
	 * sets next node
	 * 
	 * @param n new value of next
	 */
	public void setNext(LinkedNode n) {
		next = n;
	}

	/**
	 * sets value of current node
	 * 
	 * @param v new value of current
	 */
	public void setValue(AirObject v) {
		value = v;
	}

	/**
	 * checks if current node collides with another node
	 * 
	 * @param ao object being checked
	 * @return whether they collide
	 */
	public boolean collides(AirObject ao) {

		int x = value.getXorig();
		int y = value.getYorig();
		int z = value.getZorig();
		int xWidth = x + value.getXwidth();
		int yWidth = y + value.getYwidth();
		int zWidth = z + value.getZwidth();
		if (x > (ao.getXorig() + ao.getXwidth())) {
			return false;
		}
		if (y > (ao.getYorig() + ao.getYwidth())) {
			return false;
		}
		if (z > (ao.getZorig() + ao.getZwidth())) {
			return false;
		}
		if (xWidth < ao.getXorig()) {
			return false;
		}
		if (yWidth < ao.getYorig()) {
			return false;
		}
		if (zWidth < ao.getZorig()) {
			return false;
		}
		return true;
	}

	public boolean intersects(int x, int y, int z, 
			int xWidth, int yWidth, int zWidth) {
		int xVal = value.getXorig();
		int yVal = value.getYorig();
		int zVal = value.getZorig();
		int xLen = xVal + value.getXwidth();
		int yLen = yVal + value.getYwidth();
		int zLen = zVal + value.getZwidth();
		if (x >= xLen) {
			return false;
		}
		if (y >= yLen) {
			return false;
		}
		if (z >= zLen) {
			return false;
		}
		if (xVal >= (x + xWidth)) {
			return false;
		}
		if (yVal >= (y + yWidth)) {
			return false;
		}
		if (zVal >= (z + zWidth)) {
			return false;
		}
		return true;
	}
}
