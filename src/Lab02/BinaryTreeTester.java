package Lab02;
/**
 * 
 * @author Somsubhra(201101056)
 */

public class BinaryTreeTester{
	public static void main(String[] args){
		BinaryTree t = new BinaryTree();
		t.insert(10);
		t.insert(16);
		t.insert(12);
		t.insert(17);
		t.insert(1);
		t.insert(15);
		t.inOrder(t.root);

		System.out.println("\n");
		t.preOrder(t.root);

		System.out.println("\n");
		t.postOrder(t.root);
                
                System.out.println("\n");
                t.levelOrder(t.root);
                
                System.out.println("\n");
                t.zigzagOrder(t.root);

	}
}
