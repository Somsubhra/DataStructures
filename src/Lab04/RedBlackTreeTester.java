/**
 * The tester for Red Black Tree.
 * 
 * @author Somsubhra
 * 
 */
public class RedBlackTreeTester {

	public static void main(String[] args) {

		RedBlackTree t = new RedBlackTree();

		t.insert(5);
		t.insert(8);
		t.insert(14);
		t.insert(19);
		t.insert(97);
		t.insert(27);
		t.levelOrder();
		System.out.println();
		t.delete(14);

		t.levelOrder();
		// t.getRoot().display();
		// t.find(15).display();
	}
}
