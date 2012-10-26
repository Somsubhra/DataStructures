
/**
 *
 * @author Somsubhra(201101056)
 */
public class BinaryHeapTester {
    
    public static void main(String[] args){
        BinaryHeap h = new BinaryHeap(100);
        /*h.insert(12);
        h.insert(15);
        h.insert(2);
        h.insert(3);
        h.insert(55);
        h.insert(48);
        h.insert(10);
        h.insert(11);
        h.insert(87);
        h.display();
        h.alter(1, 3);
        h.display();*/
        int[] a = {12,15,2,3,55,48,10,11,87};
        h.buildDownward(a);
        //System.out.println(h.getSize());
        h.display();
        //System.out.println(h.hasLeftChild(2));
        //System.out.println(h.hasRightChild(2));
        //System.out.println(h.hasRightChild(10));
        //System.out.println(h.hasLeftChild(15));
        
        //System.out.println(h.deleteRoot());
        //System.out.println(h.hasLeftChild(10));
        //h.display();
        //System.out.println(h.size);
        /*System.out.println(h.deleteRoot());
        //h.display();
        System.out.println(h.deleteRoot());
        System.out.println(h.deleteRoot());
        System.out.println(h.deleteRoot());
        System.out.println(h.deleteRoot());
        System.out.println(h.deleteRoot());
        System.out.println(h.deleteRoot());
        System.out.println(h.deleteRoot());
        System.out.println(h.deleteRoot());*/
        //h.insert(7);
        //System.out.println(h.size);
        //h.getRoot();
        //h.display();
    }
    
}
