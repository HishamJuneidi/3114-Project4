
public class leafNode implements treeInterface {
	
	private int x, y, z, xLen, yLen, zLen, level;
	private linkedList[] nodes;
	private final int MAX_NODES = 3;
	
	public leafNode(int newX, int newY, int newZ, int xLength, int yLength, int zLength, int l) {
		x = newX;
		y = newY;
		z = newZ;
		xLen = xLength;
		yLen = yLength;
		zLen = zLength;
		level = l;
		nodes = new linkedList[MAX_NODES];
		for (int i = 0; i < MAX_NODES; i++) {
			nodes[i] = new linkedList();
		}
	}

	
    
	public treeInterface insert(AirObject ao) {
		/*if (numNodes == 3) {
			split();
		}*/
		for (int i = 0; i < MAX_NODES; i++) {
			if (nodes[i].head() == null) {
				nodes[i].insert(new linkedNode(ao));
				break;
			}
			if (nodes[i].head().collides(ao)) {
				nodes[i].insert(new linkedNode(ao));
				break;
			}
		}
		int tempLen = 0;
		int numLocations = 0;
		for (int j = 0; j < MAX_NODES; j++) {
			tempLen += nodes[j].length();
			if (nodes[j].length() > 0) {
				numLocations++;
			}
		}
		if (tempLen > 3 && numLocations > 1) {
			return split();
		}
		else {
			return this;
		}
	}
	
	
	private treeInterface split() {
		InnerNode output = new InnerNode(x, y, z, xLen, yLen, zLen, level);
		for (linkedList l: nodes) {
			if (l.head() != null) {
				linkedNode curr = l.head();
				while (curr != null) {
					output.insert(curr.value());
					curr = curr.next();
				}
			}
		}
		/*treeInterface left;
		treeInterface right;
		// split by x axis
		if (level % 3 == 1) {
			left = new emptyNode(x, y, z, xLen / 2, yLen, zLen, this.level + 1);
			right = new emptyNode(x + (xLen / 2), y, z, xLen / 2, yLen, zLen, this.level + 1);
			for (linkedList l: nodes) {
				if (l.head() != null) {
					if (l.head().value().getXorig() < x + (xLen / 2)) {
						linkedNode curr = l.head();
						while (curr != null) {
							left = left.insert(curr.value());
							curr = curr.next();
						}
					}
					else {
						linkedNode curr = l.head();
						while (curr != null) {
							right = right.insert(curr.value());
							curr = curr.next();
						}
					}
				}
			}
		}
		// split by y axis
		else if (level % 3 == 2) {
			left = new emptyNode(x, y, z, xLen, yLen / 2, zLen, this.level + 1);
			right = new emptyNode(x, y + (yLen / 2), z, xLen, yLen / 2, zLen, this.level + 1);
			for (linkedList l: nodes) {
				if (l.head() != null) {
					if (l.head().value().getYorig() < y + (yLen / 2)) {
						linkedNode curr = l.head();
						while (curr != null) {
							left = left.insert(curr.value());
							curr = curr.next();
						}
					}
					else {
						linkedNode curr = l.head();
						while (curr != null) {
							right = right.insert(curr.value());
							curr = curr.next();
						}
					}
				}
			}
		}
		// split by z axis
		else {
			left = new emptyNode(x, y, z, xLen, yLen, zLen / 2, this.level + 1);
			right = new emptyNode(x, y, z + (zLen / 2), xLen, yLen, zLen / 2, this.level + 1);
			for (linkedList l: nodes) {
				if (l.head() != null) {
					if (l.head().value().getZorig() < z + (zLen / 2)) {
						linkedNode curr = l.head();
						while (curr != null) {
							left = left.insert(curr.value());
							curr = curr.next();
						}
					}
					else {
						linkedNode curr = l.head();
						while (curr != null) {
							right = right.insert(curr.value());
							curr = curr.next();
						}
					}
				}
			}
		}
		output.setLeft(left);
		output.setRight(right);*/
		return output;
	}
	
	public void dump() {
		StringBuilder buffer = new StringBuilder();
		for (int i = 1; i < level; i++) {
			buffer.append("  ");
		}
		int numObjects = 0;
		linkedList objects = new linkedList();
		for (linkedList l: nodes) {
			linkedNode curr = l.head();
			while (curr != null) {
				objects.insert(curr);
				numObjects++;
				curr = curr.next();
			}
		}
		System.out.print(buffer);
		if (numObjects == 0) {
			System.out.println("E");
		}
		else {
			System.out.println("Leaf with " + numObjects + " objects:");
			linkedNode o = objects.head();
			while (o != null) {
				System.out.print(buffer.toString());
				System.out.println(o.value().toString());
				o = o.next();
			}
		}
	}

	

}
