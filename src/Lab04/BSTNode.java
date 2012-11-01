package Lab04;
/**
 * Implementation of a Binary Search Tree Node.
 * 
 * @author Somsubhra
 * 
 */
public class BSTNode {

	public BSTNode leftChild, rightChild, parent;

	public int data;

	/**
	 * Displays the BST Node.
	 */
	public void display() {

		System.out.println(this.data);
	}

}
