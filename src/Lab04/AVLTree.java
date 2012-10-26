/**
 * Implementation of AVL Tree.
 * 
 * @author Somsubhra
 * 
 */
public class AVLTree extends BSTree {

	/**
	 * Inserts a new item into the AVL Tree.
	 * 
	 * @param item
	 *            The new data to be inserted into the AVL Tree
	 * 
	 */
	public void insert(int item) {

		BSTNode newNode = new BSTNode();
		newNode.data = item;

		if (this.getRoot() == null) {

			this.root = newNode;

		}

		else {
			BSTNode current = root;
			BSTNode parent = null;

			while (true) {

				parent = current;

				if (newNode.data < current.data) {

					current = current.leftChild;

					if (current == null) {

						parent.leftChild = newNode;
						newNode.parent = parent;
						break;
					}
				}

				else {

					current = current.rightChild;

					if (current == null) {

						parent.rightChild = newNode;
						newNode.parent = parent;
						break;
					}
				}
			}
		}

		balance(newNode);
	}

	/**
	 * Balances the AVL Tree along a given node.
	 * 
	 * @param node
	 *            The node along which balancing is to be done
	 */
	private void balance(BSTNode node) {

		node = node.parent;

		while (node != null) {
			if (this.balanceFactor(node) == -2) {

				if (this.balanceFactor(node.rightChild) == -1) {

					rotateLeft(node);
					break;
				}

				if (this.balanceFactor(node.rightChild) == 1) {

					rotateRight(node.rightChild);
					rotateLeft(node);
					break;
				}
			}

			if (this.balanceFactor(node) == 2) {

				if (this.balanceFactor(node.leftChild) == 1) {

					rotateRight(node);
					break;
				}

				if (this.balanceFactor(node.leftChild) == -1) {
					rotateLeft(node.leftChild);
					rotateRight(node);
					break;
				}
			}

			node = node.parent;
		}
	}

	/**
	 * Deletes a node with a given value from the AVL Tree.
	 * 
	 * @param item
	 *            The item to be deleted from the AVL Tree
	 * @return The node containing the item which is deleted from the AVL Tree
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

		BSTNode parent = current.parent;

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

		while (parent != null) {

			balance(parent);
			parent = parent.parent;
		}

		return current;

	}

}
