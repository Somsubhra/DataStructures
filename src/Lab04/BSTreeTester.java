package Lab04;
/**
 * The tester for BSTree.
 * 
 * @author Somsubhra
 * 
 */
public class BSTreeTester {

	public static void main(String[] args) {

		BSTree t = new BSTree();
		t.insert(12);
		t.insert(13);
		t.insert(7);
		t.insert(17);
		t.insert(11);
		t.insert(16);
		t.insert(18);
		t.preOrder();
		System.out.println("\n");
		t.rotateLeft(t.find(12));
		t.preOrder();
		// t.search(12);
		// t.getMinimum().display();
	}
}
