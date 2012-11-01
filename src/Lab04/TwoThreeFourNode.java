package Lab04;
/**
 * Implementation of a 2-3-4 Tree Node.
 * 
 * @author Somsubhra
 * 
 */
public class TwoThreeFourNode {

	private int numItems;
	private TwoThreeFourNode parent;
	private TwoThreeFourNode[] childArray = new TwoThreeFourNode[4];
	private int[] itemArray = new int[3];

	/**
	 * Connects a child to the 2-3-4 Node at the position specified.
	 * 
	 * @param childNum
	 *            The position number of the child to be connected
	 * @param child
	 *            The child to be connected
	 */
	public void connectChild(int childNum, TwoThreeFourNode child) {

		childArray[childNum] = child;

		if (child != null) {

			child.parent = this;
		}
	}

	/**
	 * Deletes the child at the position specified the 2-3-4 Node.
	 * 
	 * @param childNum
	 *            The position number of the child to be deleted
	 * @return The child node which is deleted
	 */
	public TwoThreeFourNode disconnectChild(int childNum) {

		TwoThreeFourNode tempNode = childArray[childNum];

		childArray[childNum] = null;

		return tempNode;

	}

	/**
	 * Finds the child of the 2-3-4 Node at the position specified.
	 * 
	 * @param childNum
	 *            The position number of the child to be found
	 * @return The child node at the specified position
	 */
	public TwoThreeFourNode getChild(int childNum) {

		return childArray[childNum];
	}

	/**
	 * Finds the parent of the 2-3-4 Node.
	 * 
	 * @return The parent of the 2-3-4 Node
	 */
	public TwoThreeFourNode getParent() {

		return this.parent;
	}

	/**
	 * Finds whether the 2-3-4 Node is a leaf or not.
	 * 
	 * @return Whether the 2-3-4 Node is a leaf or not
	 */
	public boolean isLeaf() {

		return childArray[0] == null;
	}

	/**
	 * Finds the number of items in the 2-3-4 Node.
	 * 
	 * @return The number of items in the 2-3-4 Node
	 */
	public int getNumItems() {

		return this.numItems;
	}

	/**
	 * Finds the item in the 2-3-4 Node.
	 * 
	 * @param index
	 *            The position of the item in the Node
	 * @return The item at the given position
	 */
	public int getItem(int index) {

		return itemArray[index];
	}

	/**
	 * Finds whether the Node is full or not.
	 * 
	 * @return Whether the Node is full or not
	 */
	public boolean isFull() {

		return numItems == 3;
	}

	/**
	 * Finds the index of a given item in the 2-3-4 node.
	 * 
	 * @param item
	 *            The item to be found in the Node
	 * @return The index of the item found in the Node
	 */
	public int findItem(int item) {

		for (int j = 0; j < 3; j++) {

			if (itemArray[j] == 0) {

				break;
			}

			else if (itemArray[j] == item) {

				return j;
			}
		}
		return -1;
	}

	/**
	 * Inserts a new item in the 2-3-4 node.
	 * 
	 * @param item
	 *            The item to be inserted in the Node
	 * @return The index where the item is inserted in the Node
	 */
	public int insertItem(int item) {

		numItems++;

		for (int j = 2; j >= 0; j--) {

			if (itemArray[j] == 0) {

				continue;
			}

			else {

				if (item < itemArray[j]) {

					itemArray[j + 1] = itemArray[j];
				}

				else {

					itemArray[j + 1] = item;
					return j + 1;
				}
			}
		}

		itemArray[0] = item;
		return 0;
	}

	/**
	 * Removes the last item from the 2-3-4 node.
	 * 
	 * @return The last item removed from the Node
	 */
	public int removeItem() {

		int temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = 0;
		numItems--;
		return temp;
	}

	/**
	 * Displays the contents of a 2-3-4 node.
	 */
	public void displayNode() {

		for (int j = 0; j < numItems; j++) {

			System.out.print(itemArray[j] + "  ");
		}

		System.out.print("\n");
	}

}
