
public class linkedNode {
	private AirObject value;
	private linkedNode next, previous;
	
	public linkedNode(AirObject v) {
		this.value = v;
	}
	
	public AirObject value() {
		return value;
	}
	
	public linkedNode next() {
		return next;
	}
	
	public linkedNode previous() {
		return previous;
	}
	
	public void setPrevious(linkedNode p) {
		previous = p;
	}
	
	public void setNext(linkedNode n) {
		next = n;
	}
	
	public void setValue(AirObject v) {
		value = v;
	}
	
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
}
