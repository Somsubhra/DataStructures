
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class StackFromQueue {
    Queue q1,q2;
     
    /**
     * Creates an empty stack using queue.
     */
    public StackFromQueue(){
        q1 = new Queue();
        q2 = new Queue();
    }
    /**
     * Adds an element to the top of the stack.
     * @param element the element to be pushed 
     */
    public void push(int x){
        q1.enqueue(x);
        
    }
    /**
     * Removes the topmost element of the stack.
     * @return the element popped
     */
    public int pop(){
        int j = q1.getNumberOfElements()-1;
        for(int i=0; i<j; i++){
            q2.enqueue(q1.dequeue());
        }
        
        int x = q1.dequeue();
        int k = q2.getNumberOfElements();
        for(int i=0; i<k; i++){
            q1.enqueue(q2.dequeue());
        }
        
        return x;
    }
    
}
