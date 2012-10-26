
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class QueueFromStack {
    Stack s1,s2;
    
    /**
     * Creates an empty Queue using Stack.
     */
    public QueueFromStack(){
        s1 = new Stack();
        s2 = new Stack();
        
    }
    /**
     * Adds an element to the last of the Queue.
     * @param x The new element to be enqueued
     */
    public void enqueue(int x){
        s1.push(x);
        
    }
    /**
     * Removes the first element of the queue.
     * @return the first element removed 
     */
    public int dequeue(){
        int j=s1.getNumberOfElements();
        for(int i=0;i<j; i++){
            s2.push(s1.pop());
           
            
        }
        int x = s2.pop();
        int k =s2.getNumberOfElements();
        for(int i=0; i<k; i++){
        s1.push(s2.pop());
        }
        return x;
    }
}
