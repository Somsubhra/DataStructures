
/**
 *
 * @author Somsubhra(201101056)
 */
public class HeapTester {
    
    public static void main(String[] args){
    
        Heap h = new Heap(3,100);
        for(int i=1; i<17; i++ ){
            h.add(i);
        }
        System.out.println(h.getChild(2, 2));
        System.out.println(h.getChild(1, 3));
        System.out.println(h.getChild(3, 3));
        System.out.println(h.getParent(13));
    }
}
