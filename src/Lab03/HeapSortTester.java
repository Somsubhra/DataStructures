
/**
 *
 * @author Somsubhra(201101056)
 */
public class HeapSortTester {
    
    public static void main(String[] args){
    
        Array a = new Array(100);
        a.insert(15);
        a.insert(17);
        a.insert(12);
        a.insert(55);
        a.insert(2);
        a.insert(87);
        a.insert(13);
        a.insert(23);
        a.insert(7);
        a.display();
        a.heapSort();
        a.display();
        
    }
    
}
