/**
 * Implementation of the Binary Search Tree.
 * 
 * @author Somsubhra
 * 
 */

public class BSTree {

	protected BSTNode root;

	/**
	 * Inserts a new item into the BST.
	 * 
	 * @param item
	 *            The new data to be inserted into the BST
	 * 
	 */
	public void insert(int item) {

		BSTNode newNode = new BSTNode();
		newNode.data = item;

		if (this.getRoot() == null) {

			this.root = newNode;

		} else {
			BSTNode current = root;
			BSTNode parent = null;

			while (true) {

				parent = current;

				if (newNode.data < current.data) {

					current = current.leftChild;

					if (current == null) {

						parent.leftChild = newNode;
						newNode.parent = parent;
						return;
					}
				} else {

					current = current.rightChild;

					if (current == null) {

						parent.rightChild = newNode;
						newNode.parent = parent;
						return;
					}
				}
			}
		}
	}

	/**
	 * Finds a particular item in the BST.
	 * 
	 * @param item
	 *            The item to be found in the BST
	 * @return The node containing the data to be found in the BST
	 */
	public BSTNode find(int item) {

		BSTNode current = this.getRoot();

		while (current != null && current.data != item) {

			if (item < current.data) {

				current = current.leftChild;
			} else {

				current = current.rightChild;
			}
		}

		return current;
	}

	/**
	 * Prints the item found along with its address.
	 * 
	 * @param item
	 *            The item to be found in the BST
	 */
	public void search(int item) {

		BSTNode nodeFound = find(item);

		if (nodeFound == null) {

			System.out.println(item + " not found");
		}

		else {

			System.out.println(item + " found at " + nodeFound);
		}

	}

	/**
	 * Finds the node containing the maximum element in the BST.
	 * 
	 * @return The node containing the maximum element in the BST
	 */

	public BSTNode getMaximum() {

		return getLocalMaximum(this.getRoot());

	}

	/**
	 * Finds the node containing the maximum element in the subtree rooted at
	 * the given node.
	 * 
	 * @param localRoot
	 *            The root of the subtree in which the maximum node has to be
	 *            found
	 * @return The node containing the maximum element in the subtree rooted at
	 *         the given node
	 */
	public BSTNode getLocalMaximum(BSTNode localRoot) {

		BSTNode maximum = localRoot;

		while (maximum.rightChild != null) {

			maximum = maximum.rightChild;
		}

		return maximum;
	}

	/**
	 * Finds the node containing the minimum element in the BST.
	 * 
	 * @return The node containing the minimum element in the BST
	 */
	public BSTNode getMinimum() {

		return getLocalMinimum(this.getRoot());
	}

	/**
	 * Finds the node containing the minimum element in the subtree rooted at
	 * the given node.
	 * 
	 * @param localRoot
	 *            The root of the subtree in which the minimum node has to be
	 *            found
	 * @return The node containing the minimum element in the subtree rooted at
	 *         the given node
	 */
	public BSTNode getLocalMinimum(BSTNode localRoot) {

		BSTNode minimum = localRoot;

		while (minimum.leftChild != null) {

			minimum = minimum.leftChild;
		}

		return minimum;
	}

	/**
	 * Finds the root of the BST.
	 * 
	 * @return The root of the BST
	 */

	public BSTNode getRoot() {
		return this.root;
	}

	/**
	 * Traverses and prints the nodes of the subtree rooted at a particular node
	 * in-order fashion.
	 * 
	 * @param localRoot
	 *            The root of the subtree which has to be traversed in-order
	 */
	public void inOrder(BSTNode localRoot) {

		if (localRoot != null) {

			inOrder(localRoot.leftChild);
			localRoot.display();
			inOrder(localRoot.rightChild);
		}
	}

	/**
	 * Traverses and prints the nodes of the BST in in-order fashion.
	 */
	public void inOrder() {

		inOrder(this.getRoot());
	}

	/**
	 * Traverses and prints the nodes of the subtree rooted at a particular node
	 * pre-order fashion.
	 * 
	 * @param localRoot
	 *            The root of the subtree which has to be traversed pre-order
	 */
	public void preOrder(BSTNode localRoot) {

		if (localRoot != null) {

			localRoot.display();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	/**
	 * Traverses and prints the nodes of the BST in pre-order fashion.
	 */

	public void preOrder() {

		preOrder(this.getRoot());
	}

	/**
	 * Traverses and prints the nodes of the subtree rooted at a particular node
	 * post-order fashion.
	 * 
	 * @param localRoot
	 *            The root of the subtree which has to be traversed post-order
	 */
	public void postOrder(BSTNode localRoot) {

		if (localRoot != null) {

			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.display();
		}
	}

	/**
	 * Traverses and prints the nodes of the BST in post-order fashion.
	 */
	public void postOrder() {

		postOrder(this.getRoot());
	}

	/**
	 * Finds the successor of a given node in the BST.
	 * 
	 * @param node
	 *            The node whose successor has to be found
	 * @return The successor of the given node
	 */

	public BSTNode getSuccessor(BSTNode node) {

		if (node.rightChild != null) {

			return getLocalMinimum(node.rightChild);

		} else {

			if (node.parent.leftChild == node) {

				return node.parent;
			}

			else {
				BSTNode current = node;

				while (current == current.parent.rightChild) {

					current = current.parent;
				}

				return current.parent;
			}
		}

	}

	/**
	 * Finds the predecessor of a given node in the BST.
	 * 
	 * @param node
	 *            The node whose predecessor has to be found
	 * @return The predecessor of the given node
	 */
	public BSTNode getPredecessor(BSTNode node) {

		if (node.leftChild != null) {

			return getLocalMaximum(node.leftChild);
		} else {

			if (node.parent.rightChild == node) {

				return node.parent;
			}

			else {

				BSTNode current = node;

				while (current == current.parent.leftChild) {

					current = current.parent;
				}

				return current.parent;
			}
		}
	}

	/**
	 * Deletes a node with a given value from the BST.
	 * 
	 * @param item
	 *            The item to be deleted from the BST
	 * @return The node containing the item which is deleted from the BST
	 */
	public BSTNode delete(int item) {
		BSTNode current = root;

		boolean isLeftChild = true;

		while (current.data != item) {

			if (item < current.data) {

				isLeftChild = true;

				current = current.leftChild;
			} else {

				isLeftChild = false;

				current = current.rightChild;
			}
		}

		if (current.leftChild == null && current.rightChild == null) {

			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				current.parent.leftChild = null;
			} else {
				current.parent.rightChild = null;
			}
		}

		else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				current.parent.leftChild = current.leftChild;
			} else {
				current.parent.rightChild = current.leftChild;
			}
		}

		else if (current.leftChild == null) {
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				current.parent.leftChild = current.rightChild;
			} else {
				current.parent.rightChild = current.rightChild;
			}
		}

		else {
			BSTNode successor = delete(this.getSuccessor(current).data);

			if (current == root) {
				root = successor;
			}

			else if (isLeftChild) {
				current.parent.leftChild = successor;
				successor.leftChild = current.leftChild;
				successor.rightChild = current.rightChild;
			}

			else {
				current.parent.rightChild = successor;
				successor.leftChild = current.leftChild;
				successor.rightChild = current.rightChild;
			}
		}

		return current;

	}

	/**
	 * Left Rotates the BST along a given node.
	 * 
	 * @param node
	 *            The node along which the left-rotation is to be done
	 */
	public void rotateLeft(BSTNode node) {

		if (node.rightChild != null) {
			node = node.rightChild;
			BSTNode tmpLc = node.leftChild;
			BSTNode tmpParent = node.parent.parent;

			node.leftChild = node.parent;
			node.parent.parent = node;

			if (tmpLc != null) {

				node.parent.rightChild = tmpLc;
				tmpLc.parent = node.parent;
			}

			else {
				node.parent.rightChild = null;

			}

			if (tmpParent != null) {

				node.parent = tmpParent;
				tmpParent.rightChild = node;
			}

			else {

				node.parent = null;
				root = node;
			}

		}
	}

	/**
	 * Right rotates the BST along a given node.
	 * 
	 * @param node
	 *            The node along which the right-rotation is to be done
	 */
	public void rotateRight(BSTNode node) {

		if (node.leftChild != null) {

			node = node.leftChild;
			BSTNode tmpRc = node.rightChild;
			BSTNode tmpParent = node.parent.parent;

			node.rightChild = node.parent;
			node.parent.parent = node;

			if (tmpRc != null) {

				node.parent.leftChild = tmpRc;
				tmpRc.parent = node.parent;
			}

			else {

				node.parent.leftChild = null;
			}

			if (tmpParent != null) {

				node.parent = tmpParent;
				tmpParent.leftChild = node;
			}

			else {

				node.parent = null;
				root = node;
			}
		}
	}

	/**
	 * Finds the depth of a given node in a BST.
	 * 
	 * @param node
	 *            The node whose depth is to be found
	 * @return The depth of the given node in the BST
	 */
	public int getDepth(BSTNode node) {

		int d = 0;
		BSTNode current = node;

		while (current != root) {

			current = current.parent;
			d++;
		}
		return d;
	}

	/**
	 * Finds the number of nodes in the subtree rooted at a given node.
	 * 
	 * @param node
	 *            The node whose subtree's size is to be found
	 * @return The size of the subtree rooted at a given node
	 */
	public int getSizeOfSubtree(BSTNode node) {

		size = 0;
		traverse(node);
		return size;
	}

	private int size;

	/**
	 * Traverses the subtree rooted at the given node recursively.
	 * 
	 * @param localRoot
	 *            The node whose subtree is to be traversed
	 */
	private void traverse(BSTNode localRoot) {

		if (localRoot != null) {
			traverse(localRoot.leftChild);
			size++;
			traverse(localRoot.rightChild);
		}
	}

	/**
	 * Finds the height of the subtree rooted at the given node.
	 * 
	 * @param localRoot
	 *            The node whose height is to be found
	 * @return The height of the subtree rooted at the given node
	 */
	public int getHeight(BSTNode localRoot) {
		BSTNode x = localRoot;
		int height;

		if (x == null) {

			return -1;
		}

		if (x.leftChild == null && x.rightChild == null) {

			height = 0;
		}

		else {
			height = 1 + Math.max(setHeight(x.leftChild),
					setHeight(x.rightChild));
		}

		return height;
	}

	/**
	 * Finds height of subtree rooted at a given node recursively.
	 * 
	 * @param x
	 *            The node whose height is to be found
	 * @return The height of subtree rooted at given node
	 */
	private int setHeight(BSTNode x) {
		int height;

		if (x == null) {
			return -1;
		}

		if (x.leftChild == null && x.rightChild == null) {
			height = 0;
		}

		else {
			height = 1 + Math.max(setHeight(x.leftChild),
					setHeight(x.rightChild));
		}
		return height;
	}

	/**
	 * Finds the balance factor of a given node.
	 * 
	 * @param node
	 *            The node whose balance factor is to be found
	 * @return The balance factor of the given node
	 */
	public int balanceFactor(BSTNode node) {

		return getHeight(node.leftChild) - getHeight(node.rightChild);
	}

	/**
	 * Traverses and prints the nodes of the subtree rooted at a particular node
	 * level-order fashion.
	 * 
	 * @param localRoot
	 *            The root of the subtree which has to be traversed level-order
	 */
	public void levelOrder(BSTNode localRoot) {
		Queue<BSTNode> q = new Queue<BSTNode>();
		BSTNode x = localRoot;
		BSTNode y = null;

		if (x == null) {
			return;
		}

		q.enqueue(x);

		while (!(q.isEmpty())) {

			y = q.dequeue();
			if (y.leftChild != null) {
				q.enqueue(y.leftChild);
			}

			if (y.rightChild != null) {
				q.enqueue(y.rightChild);
			}
			y.display();
		}
	}

	/**
	 * Traverses and prints the nodes of BST in Level order fashion.
	 */
	public void levelOrder() {
		levelOrder(this.getRoot());
	}

}
