/**
 * Tester for array.
 * @author Somsubhra
 *
 */
public class ArrayTester {

	public static void main(String[] args){
		
		Array a = new Array(20);
		a.insert(15);
		a.insert(17);
		a.insert(11);
		a.insert(5);
		a.insert(27);
		a.insert(89);
		a.quickSort();
		a.display();
	}
}
