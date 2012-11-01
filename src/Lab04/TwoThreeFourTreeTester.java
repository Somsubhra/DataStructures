package Lab04;
/**
 * Tester for Two Three Four Tree.
 * 
 * @author Somsubhra
 * 
 */
public class TwoThreeFourTreeTester {

	public static void main(String[] args) {
		TwoThreeFourTree t = new TwoThreeFourTree();
		t.insert(12);
		t.insert(13);
		t.insert(78);
		t.insert(98);
		t.insert(7);
		t.insert(37);
		t.insert(45);
		t.insert(57);
		// System.out.println(t.root);
		// t.root.displayNode();

		t.display();
	}
}
