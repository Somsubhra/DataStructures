/**
 * Implementation of 2-3-4 Tree.
 * 
 * @author Somsubhra
 * 
 */
public class TwoThreeFourTree {

	private TwoThreeFourNode root = new TwoThreeFourNode();

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

}
