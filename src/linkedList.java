
public class linkedList {
	private linkedNode head, tail; 
	private int length;
	
	
	public linkedList(){
		length = 0;
	}
	
	public void insert(linkedNode l) {
		if (length == 0) {
			head.setValue(l.value());
			tail.setValue(l.value());
		}
		else {
			l.setPrevious(tail);
			tail.setNext(l);
			tail = l;
		}
		length++;
	}
	
	public void remove(AirObject ao) {
		linkedNode current = head;
		while (current != null && !current.value().equals(ao)) {
			current = current.next();
		}
		if (current != null) {
			if (current.previous() != null) {
				current.previous().setNext(current.next());
			}
			if (current.next() != null) {
				current.next().setPrevious(current.previous());
			}
			length--;
		}
	}
	
	public linkedNode head() {
		return head;
	}
	
	public int length() {
		return length;
	}
}
