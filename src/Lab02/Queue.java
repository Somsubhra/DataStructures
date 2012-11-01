package Lab02;
import java.util.ArrayList;




/**
 *
 * @author Somsubhra(201101056)
 */
public class Queue<E>{
    ArrayList<E> arr;
    int tail;
    int head;
    int n;
    /**
     * Creates an empty queue.
     */
    public Queue(){
        arr = new ArrayList<>(100);
        this.tail = 0;
        this.head = 0;
        n=0;
    }
    /**
     * Checks whether queue is empty or not.
     * @return true or false 
     */
    public boolean isEmpty(){
        if(n>0){
            return false;
        }
        else{
            return true;
        }
    }
                                                              
    /**
     * Checks whether a Queue is full or not.
     * @return true or false 
     */
    public boolean isFull(){
        return this.tail==this.head-1;
    }
    /**
     * Adds an element to the last of the Queue.
     * @param x The new element to be enqueued
     */
    public void enqueue(E x){
        if(this.isFull()){
            System.out.println("Error: Overflow");
            
        }
        else{
            arr.add(this.tail,x);
            n++;
            if(this.tail==arr.size()-1){
                this.tail=0;
            }else{
                this.tail++;
            }
        }
    }
    /**
     * Removes the first element of the queue.
     * @return the first element removed 
     */
    public E dequeue(){
        if(!this.isEmpty()){
            E x=arr.get(this.head);
            n--;
            if(this.head==arr.size()-1){
                this.head=0;
            }else{
                this.head++;
            }
            return x;
        }else{
            System.out.println("Error: Underflow");
            return null;
        }
    }
    /**
     * Find the number of elements in the queue.
     * @return number of elements in the queue.
     */
    public int getNumberOfElements(){
        return this.n;
    }
   
    
    
}
