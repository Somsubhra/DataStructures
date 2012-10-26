/**
 * Tester for AVL Tree.
 * 
 * @author Somsubhra
 * 
 */
public class AVLTreeTester {

	public static void main(String[] args) {

		AVLTree t = new AVLTree();

		t.insert(10);
		t.insert(9);
		// t.insert(11);
		t.insert(8);
		t.insert(7);
		t.insert(6);
		t.insert(5);
		t.insert(4);
		// t.rotateRight(t.find(10));
		// t.getRoot().display();
		// t.getRoot().rightChild.display();
		// System.out.println(t.balanceFactor(t.getRoot().leftChild));
		// System.out.println(t.getHeight(t.getRoot().leftChild));
		// t.rotateRight(t.find(10));
		t.delete(9);
		t.levelOrder();
	}

}
