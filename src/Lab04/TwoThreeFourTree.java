/**
 * Implementation of 2-3-4 Tree.
 * 
 * @author Somsubhra
 * 
 */
public class TwoThreeFourTree {

	public TwoThreeFourNode root = new TwoThreeFourNode();

	/**
	 * Finds the position of a given item in the 2-3-4 Tree.
	 * 
	 * @param item
	 *            The item to be found in the 2-3-4 tree
	 * @return The index of the item in the Node found
	 */
	public int find(int item) {

		TwoThreeFourNode current = root;
		int childNumber;

		while (true) {

			if ((childNumber = current.findItem(item)) != -1) {

				return childNumber;
			}

			else if (current.isLeaf()) {

				return -1;
			}

			else {

				current = getNextChild(current, item);
			}
		}
	}

	/**
	 * Finds the next child of a 2-3-4 node according to a given value.
	 * 
	 * @param node
	 *            The node whose next child is to be found
	 * @param value
	 *            The value according to which the next child of the node is to
	 *            be found
	 * @return The next child of the node according to the given value
	 */
	public TwoThreeFourNode getNextChild(TwoThreeFourNode node, int value) {

		int j;
		int numItems = node.getNumItems();

		for (j = 0; j < numItems; j++) {

			if (value < node.getItem(j)) {

				return node.getChild(j);
			}
		}

		return node.getChild(j);
	}

	/**
	 * Inserts a new item in the 2-3-4 Tree.
	 * 
	 * @param item
	 *            The item to be inserted in the 2-3-4 Tree
	 */
	public void insert(int item) {

		TwoThreeFourNode current = this.root;

		while (true) {

			if (current.isFull()) {

				split(current);
				current = current.getParent();
				current = getNextChild(current, item);
			}

			else if (current.isLeaf()) {
				break;
			}

			else {
				current = getNextChild(current, item);
			}

		}

		current.insertItem(item);
	}

	/**
	 * Splits a given 2-3-4 node.
	 * 
	 * @param node
	 *            The node to be split
	 */
	public void split(TwoThreeFourNode node) {
		int itemB, itemC;
		TwoThreeFourNode parent, child2, child3;
		int itemIndex;

		itemC = node.removeItem();
		itemB = node.removeItem();

		child2 = node.disconnectChild(2);
		child3 = node.disconnectChild(3);

		TwoThreeFourNode newRight = new TwoThreeFourNode();

		if (node == root) {
			root = new TwoThreeFourNode();

			parent = root;

			root.connectChild(0, node);
		}

		else {

			parent = node.getParent();
		}

		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();

		for (int j = n - 1; j > itemIndex; j--) {

			TwoThreeFourNode temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}

		parent.connectChild(itemIndex + 1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);

	}

	public void display() {
		recDisplayTree(root, 0, 0);
	}

	private void recDisplayTree(TwoThreeFourNode node, int level,
			int childNumber) {

		System.out.print("level=" + level + "child=" + childNumber + " ");
		node.displayNode();
		int numItems = node.getNumItems();
		for (int j = 0; j < numItems + 1; j++) {

			TwoThreeFourNode nextNode = node.getChild(j);

			if (nextNode != null) {
				recDisplayTree(nextNode, level + 1, j);
			} else {
				return;
			}
		}
	}

}
