

/**
 *
 * @author Somsubhra(201101056)
 */
public class Array {
    private int[] arr;
    private int size;
    
    public Array(int maxSize){
        arr = new int[maxSize];
    }
    
    public void insert(int data){
        arr[size] = data;
        size++;
    }
    
    public int getSize(){
        return size;
    }
    
    public void heapSort(){
        BinaryHeap h = new BinaryHeap(getSize()+1);
        
        for(int i=0; i<getSize(); i++){
            h.insert(arr[i]);
        }
        
        for(int i=0; i<getSize(); i++){
            arr[i] = h.deleteRoot();
        }
        
    }
    
    public void display(){
        for(int i=0; i<getSize(); i++){
            System.out.println(arr[i]);
        }
        System.out.println("\n");
    }
    
}
