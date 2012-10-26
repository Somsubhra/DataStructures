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

}
