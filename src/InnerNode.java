
public class InnerNode implements TreeInterface {

	private int x, y, z, xLen, yLen, zLen, level;
	private TreeInterface left, right;

	public InnerNode(int newX, int newY, int newZ, int xLength, int yLength, int zLength, int l) {
		x = newX;
		y = newY;
		z = newZ;
		xLen = xLength;
		yLen = yLength;
		zLen = zLength;
		level = l;
		if (level % 3 == 1) {
			left = new Flyweight(x, y, z, xLen / 2, yLen, zLen, this.level + 1);
			right = new Flyweight(x + (xLen / 2), y, z, xLen / 2, yLen, zLen, this.level + 1);
		} 
		else if (level % 3 == 2) {
			left = new Flyweight(x, y, z, xLen, yLen / 2, zLen, this.level + 1);
			right = new Flyweight(x, y + (yLen / 2), z, xLen, yLen / 2, zLen, this.level + 1);
		} 
		else {
			left = new Flyweight(x, y, z, xLen, yLen, zLen / 2, this.level + 1);
			right = new Flyweight(x, y, z + (zLen / 2), xLen, yLen, zLen / 2, this.level + 1);
		}
	}

	public TreeInterface insert(AirObject ao) {
		// split by x axis
		if (level % 3 == 1) {
			if (ao.getXorig() < x + (xLen / 2)) {
				left = left.insert(ao);
				if ((ao.getXorig() + ao.getXwidth()) >= (x + (xLen / 2))) {
					right = right.insert(ao);
				}
			} 
			else {
				right = right.insert(ao);
			}
		}
		// split by y axis
		else if (level % 3 == 2) {
			if (ao.getYorig() < y + (yLen / 2)) {
				left = left.insert(ao);
				if ((ao.getYorig() + ao.getYwidth()) >= (y + (yLen / 2))) {
					right = right.insert(ao);
				}
			} 
			else {
				right = right.insert(ao);
			}
		}
		// split by z axis
		else {
			if (ao.getZorig() < z + (zLen / 2)) {
				left = left.insert(ao);
				if ((ao.getZorig() + ao.getZwidth()) >= (z + (zLen / 2))) {
					right = right.insert(ao);
				}
			} 
			else {
				right = right.insert(ao);
			}
		}
		return this;
	}

	public void setLeft(TreeInterface l) {
		this.left = l;
	}

	public void setRight(TreeInterface r) {
		this.right = r;
	}

	public TreeInterface left() {
		return left;
	}

	public TreeInterface right() {
		return right;
	}

	public int dump(int count) {
		for (int i = 1; i < level; i++) {
			System.out.print("  ");
		}
		System.out.println("I");
		count++;
		count = left.dump(count);
		count = right.dump(count);
		return count;
	}

	public void collisions() {
		left.collisions();
		right.collisions();
	}

	public int intersect(int x, int y, int z, int xWidth, int yWidth, int zWidth, int count) {
		count++;
		if (level % 3 == 1) { // split by x
			if (x < this.x + (xLen / 2)) {
				count = left.intersect(x, y, z, xWidth, yWidth, zWidth, count);
				if ((x + xWidth) >= this.x + (xLen / 2)) {
					return right.intersect(x, y, z, xWidth, yWidth, zWidth, count);
				}
				return count;
			} 
			else {
				return right.intersect(x, y, z, xWidth, yWidth, zWidth, count);
			}
		} 
		else if (level % 3 == 2) { // split by y
			if (y < this.y + (yLen / 2)) {
				count = left.intersect(x, y, z, xWidth, yWidth, zWidth, count);
				if ((y + yWidth) >= this.y + (yLen / 2)) {
					return right.intersect(x, y, z, xWidth, yWidth, zWidth, count);
				}
				return count;
			} 
			else {
				return right.intersect(x, y, z, xWidth, yWidth, zWidth, count);
			}
		} 
		else { // split by z
			if (z < this.z + (zLen / 2)) {
				count = left.intersect(x, y, z, xWidth, yWidth, zWidth, count);
				if ((z + zWidth) >= this.z + (zLen / 2)) {
					return right.intersect(x, y, z, xWidth, yWidth, zWidth, count);
				}
				return count;
			} 
			else {
				return right.intersect(x, y, z, xWidth, yWidth, zWidth, count);
			}
		}
	}

	public TreeInterface delete(String name) {
		left = left.delete(name);
		right = right.delete(name);
		return this.merge();
	}
	
	private TreeInterface merge() {
		if (left.isFlyweight() && right.isFlyweight()) {
			//System.out.println(left.isEmpty() + " " + right.isEmpty());
			TreeInterface output = new Flyweight(x, y, z, xLen, yLen, zLen, level);
			return output;
		}
		TreeInterface output = new LeafNode(x, y, z, xLen, yLen, zLen, level);
		if (left.isFlyweight() && right.isLeaf()) {
			MyLinkedList[] nodes = right.nodes();
			for (MyLinkedList l: nodes) {
				LinkedNode head = l.head();
				while (head != null) {
					output = output.insert(head.value());
					head = head.next();
				}
			}
			return output;
		}
		if (left.isLeaf() && right.isFlyweight()) {
			MyLinkedList[] nodes = left.nodes();
			for (MyLinkedList l: nodes) {
				LinkedNode head = l.head();
				while (head != null) {
					output = output.insert(head.value());
					head = head.next();
				}
			}
			return output;
		}
		if (left.isLeaf() && right.isLeaf()) {
			MyLinkedList[] rightNodes = right.nodes();
			MyLinkedList[] leftNodes = left.nodes();
			for (MyLinkedList r: rightNodes) {
				LinkedNode head = r.head();
				while (head != null) {
					output = output.insert(head.value());
					head = head.next();
				}
			}
			for (MyLinkedList l: leftNodes) {
				LinkedNode head = l.head();
				while (head != null) {
					output = output.insert(head.value());
					head = head.next();
				}
			}
			if (output.isLeaf()) {
				return output;
			}
		}
		return this;
	}
	
	public boolean isInner() {
    	return true;
    }
    
    public boolean isLeaf() {
    	return false;
    }
    
    public boolean isFlyweight() {
    	return false;
    }
    
    public MyLinkedList[] nodes() {
    	return null;
    }
}
