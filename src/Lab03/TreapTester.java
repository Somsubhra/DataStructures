package Lab03;

/**
 *
 * @author Somsubhra(201101056)
 */
public class TreapTester {
    
    public static void main(String[] args){
        Treap<Integer> t = new Treap<Integer>();
        t.add(12, 13);
        t.add(14, 11);
        t.add(9, 4);
        t.add(7, 6);
        t.add(8, 3);
        t.add(15, 7);
        t.display();
        
    }
    
}
