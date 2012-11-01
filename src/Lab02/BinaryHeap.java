package Lab02;

/**
 *
 * @author Somsubhra(201101056)
 */
public class BinaryHeap {
    
    private int[] array;
    private int i=0;
    public BinaryHeap(){
        array = new int[200];
    }
    
    public void add(int data){
        if(i==array.length){
            System.out.println("Error: Overflow.");
        }else{
            array[i] = data;
            i++;
        }
    }
    
    public int leftChildOf(int data){
        int j=0;
        while(data!=array[j]){
            j++;
        }
        return array[2*j+1];
    }
    
    public int rightChildOf(int data){
        int j=0;
        while(data!=array[j]){
            j++;
        }
        return array[2*j+2];
    }
    
    public int parentOf(int data){
        int j=0;
        while(data!=array[j]){
            j++;
        }
        return array[(j-1)/2];
    }
    
    public int numberOfNodes(){
        return i+1;
    }
}
