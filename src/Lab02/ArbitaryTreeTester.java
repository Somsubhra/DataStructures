package Lab02;
/**
 * 
 * @author Somsubhra(201101056)
 */

public class ArbitaryTreeTester{
	public static void main(String[] args){
		ArbitaryTree t = new ArbitaryTree();
		t.root.displayNode();
		t.root.c1.displayNode();
		t.root.c2.displayNode();
		t.root.c3.displayNode();
		t.root.c1.c1.displayNode();	
		t.root.c1.c2.displayNode();
		t.root.c2.c1.displayNode();
		t.root.c2.c2.displayNode();
		t.root.c2.c3.displayNode();
	}
}
