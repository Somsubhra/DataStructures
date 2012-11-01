package Lab04;
/**
 * Implementation of Red-Black Tree
 * 
 * @author Somsubhra
 * 
 */
public class RedBlackTree {

	private final int BLACK = 0;
	private final int RED = 1;
	private RedBlackNode root;
	private RedBlackNode nil;

	/**
	 * Constructor of the Red-Black Tree.
	 */
	public RedBlackTree() {
		nil = new RedBlackNode();
		nil.color = BLACK;
		this.root = this.nil;
	}

	/**
	 * Inserts a new item into the Red Black Tree.
	 * 
	 * @param item
	 *            The item to be inserted in the Red Black Tree
	 */
	public void insert(int item) {
		RedBlackNode z = new RedBlackNode();
		z.data = item;

		RedBlackNode y, x;
		y = this.nil;
		x = this.root;

		while (x != this.nil) {
			y = x;
			if (z.data < x.data) {
				x = x.leftChild;
			} else {
				x = x.rightChild;
			}
		}

		z.parent = y;

		if (y == this.nil) {
			this.root = z;
		} else if (z.data < y.data) {
			y.leftChild = z;
		} else {
			y.rightChild = z;
		}

		z.leftChild = this.nil;
		z.rightChild = this.nil;
		z.color = RED;

		insertFixup(z);

	}

	/**
	 * Fixes up the Red Black Tree after insertion of an item.
	 * 
	 * @param node
	 *            The node where the fixup is to be made
	 */

	private void insertFixup(RedBlackNode node) {
		RedBlackNode y;
		while (node.parent.color == RED) {

			if (node.parent == node.parent.parent.leftChild) {
				y = node.parent.parent.rightChild;

				if (y.color == RED) {
					node.parent.color = BLACK;
					y.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				}

				else {
					if (node == node.parent.rightChild) {
						node = node.parent;
						leftRotate(node);
					}

					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					rightRotate(node.parent.parent);
				}
			}

			else {
				y = node.parent.parent.leftChild;

				if (y.color == RED) {
					node.parent.color = BLACK;
					y.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				}

				else {
					if (node == node.parent.leftChild) {
						node = node.parent;
						rightRotate(node);
					}

					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					leftRotate(node.parent.parent);
				}

			}
		}

		this.root.color = BLACK;
	}

	/**
	 * Deletes the given item from the Red Black Tree.
	 * 
	 * @param item
	 *            The item to be deleted from the Red Blck Tree
	 * @return The item that is deleted from the Red Black Tree
	 */
	public int delete(int item) {

		RedBlackNode z = find(item);
		RedBlackNode y, x;
		y = z;
		int yOriginalColor = y.color;

		if (z.leftChild == this.nil) {
			x = z.rightChild;
			transplant(z, z.rightChild);
		}

		else if (z.rightChild == this.nil) {

			x = z.leftChild;
			transplant(z, z.leftChild);
		}

		else {

			y = getMinimum(z.rightChild);
			yOriginalColor = y.color;
			x = y.rightChild;

			if (y.parent == z) {
				x.parent = y;
			} else {
				transplant(y, y.rightChild);
				y.rightChild = z.rightChild;
				y.rightChild.parent = y;
			}

			transplant(z, y);
			y.leftChild = z.leftChild;
			y.leftChild.parent = y;
			y.color = z.color;
		}
		if (yOriginalColor == BLACK) {
			deleteFixup(x);
		}

		return z.data;
	}

	/**
	 * Left Rotates the tree along a given node.
	 * 
	 * @param node
	 *            The node along which the left-rotation is to be done
	 */
	private void leftRotate(RedBlackNode node) {

		RedBlackNode y = node.rightChild;
		node.rightChild = y.leftChild;

		if (y.leftChild != this.nil) {
			y.leftChild.parent = node.parent;
		}

		y.parent = node.parent;

		if (node.parent == this.nil) {
			this.root = y;
		}

		else if (node == node.parent.leftChild) {
			node.parent.leftChild = y;
		}

		else {
			node.parent.rightChild = y;
		}

		y.leftChild = node;
		node.parent = y;
	}

	/**
	 * Right rotates the tree along the given node.
	 * 
	 * @param node
	 *            The node along which the right-rotation is to be done
	 */
	private void rightRotate(RedBlackNode node) {
		RedBlackNode y = node.leftChild;
		node.leftChild = y.rightChild;

		if (y.rightChild != this.nil) {
			y.rightChild.parent = node.parent;
		}

		y.parent = node.parent;

		if (node.parent == this.nil) {
			this.root = y;
		}

		else if (node == node.parent.rightChild) {
			node.parent.rightChild = y;
		}

		else {
			node.parent.leftChild = y;
		}

		y.rightChild = node;
		node.parent = y;

	}

	/**
	 * Traverses and prints the nodes of the subtree rooted at a particular node
	 * in-order fashion.
	 * 
	 * @param localRoot
	 *            The root of the subtree which has to be traversed in-order
	 */
	public void inOrder(RedBlackNode localRoot) {

		if (localRoot != null) {

			inOrder(localRoot.leftChild);

			if (localRoot != this.nil)
				localRoot.display();
			inOrder(localRoot.rightChild);
		}

	}

	/**
	 * Traverses and prints the nodes of the BST in in-order fashion.
	 */
	public void inOrder() {

		inOrder(this.root);
	}

	/**
	 * Finds the root of the Red Black Tree.
	 * 
	 * @return The root of the Red Black Tree
	 */
	public RedBlackNode getRoot() {
		return this.root;
	}

	/**
	 * Transplant two nodes of Red Black Tree.
	 * 
	 * @param u
	 *            The first node to transplant
	 * @param v
	 *            The second node to transplant
	 */
	private void transplant(RedBlackNode u, RedBlackNode v) {

		if (u.parent == this.nil) {
			this.root = v;
		}

		else if (u == u.parent.leftChild) {
			u.parent.leftChild = v;
		}

		else {
			u.parent.rightChild = v;
		}

		v.parent = u.parent;
	}

	/**
	 * Fixes up the Red Black Tree after deletion of a node.
	 * 
	 * @param node
	 *            The node on which fixup is to be done
	 */
	private void deleteFixup(RedBlackNode node) {

		RedBlackNode w;
		while (node != this.root && node.color == BLACK) {

			if (node == node.parent.leftChild) {
				w = node.parent.rightChild;

				if (w.color == RED) {

					w.color = BLACK;
					node.parent.color = RED;

					leftRotate(node.parent);
					w = node.parent.rightChild;
				}

				if (w.leftChild.color == BLACK && w.rightChild.color == BLACK) {
					w.color = RED;
					node = node.parent;
				}

				else {

					if (w.rightChild.color == BLACK) {
						w.leftChild.color = BLACK;
						w.color = RED;
						rightRotate(w);
						w = node.parent.rightChild;

					}

					w.color = node.parent.color;
					node.parent.color = BLACK;
					w.rightChild.color = BLACK;
					leftRotate(node.parent);
					node = this.root;
				}
			}

			else {
				w = node.parent.leftChild;

				if (w.color == RED) {

					w.color = BLACK;
					node.parent.color = RED;

					rightRotate(node.parent);
					w = node.parent.leftChild;
				}

				if (w.rightChild.color == BLACK && w.leftChild.color == BLACK) {
					w.color = RED;
					node = node.parent;
				}

				else {

					if (w.leftChild.color == BLACK) {
						w.rightChild.color = BLACK;
						w.color = RED;
						leftRotate(w);
						w = node.parent.leftChild;

					}

					w.color = node.parent.color;
					node.parent.color = BLACK;
					w.leftChild.color = BLACK;
					rightRotate(node.parent);
					node = this.root;
				}

			}
		}

		node.color = BLACK;
	}

	/**
	 * Finds the minimum element in the subtree rooted at the given root.
	 * 
	 * @param localRoot
	 *            The root of the subtree in which the minimum element is to be
	 *            found
	 * @return The minimum element in the subtree rooted at the given root
	 */
	private RedBlackNode getMinimum(RedBlackNode localRoot) {

		while (localRoot.leftChild != this.nil) {
			localRoot = localRoot.leftChild;
		}

		return localRoot;
	}

	/**
	 * Finds the item in the Red Black Tree.
	 * 
	 * @param item
	 *            The item which is to be found in the Red Black Tree
	 * @return The node containing the item in the Red Black Tree
	 */
	private RedBlackNode find(int item) {

		RedBlackNode current = this.getRoot();

		while (current != this.nil && current.data != item) {

			if (item < current.data) {

				current = current.leftChild;
			} else {

				current = current.rightChild;
			}
		}

		return current;
	}

	/**
	 * Traverses and prints the nodes of the subtree rooted at a particular node
	 * level-order fashion.
	 * 
	 * @param localRoot
	 *            The root of the subtree which has to be traversed level-order
	 */
	public void levelOrder(RedBlackNode localRoot) {
		Queue<RedBlackNode> q = new Queue<RedBlackNode>();
		RedBlackNode x = localRoot;
		RedBlackNode y = null;

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

			if (y != this.nil)
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
