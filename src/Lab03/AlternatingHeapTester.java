
/**
 *
 * @author Somsubhra(201101056)
 */
public class AlternatingHeapTester {
    
    public static void main(String[] args){
        AlternatingHeap h = new AlternatingHeap(100);
        h.insert(45);
        h.insert(12);
        h.insert(23);
        h.insert(87);
        h.insert(43);
        h.insert(22);
        h.insert(97);
        h.insert(13);
        h.insert(78);
        h.insert(66);
        h.display();
        //AlternatingHeap h1 = new AlternatingHeap(100);
        //int[] a = {45,12,23,87,43,22,77,66,54};
        //h1.build(a);
        //h1.display();
    }
}
