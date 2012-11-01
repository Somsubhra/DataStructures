package Lab03;

/**
 *
 * @author Somsubhra(201101056)
 */
public class TreapNode<T extends Comparable>{
    
    TreapNode left;
    TreapNode right;
    TreapNode parent;
    T value;
    int priority;
    
    public TreapNode(T value, int priority){
        this.value = value;
        this.priority = priority;
        
    }
    
    public void displayNode(){
        System.out.println(this.value+","+this.priority);
    }
    
    
}
