package Lab04;
/**
 * Implementation of Red-Black Tree Node
 * 
 * @author Somsubhra
 * 
 */
public class RedBlackNode {

	public RedBlackNode parent, leftChild, rightChild;
	public int data;

	public int color;

	/**
	 * Displays the Red Black Node.
	 */
	public void display() {

		System.out.println(this.data + "(" + color + ")");
	}

}
