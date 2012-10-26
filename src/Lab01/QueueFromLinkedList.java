
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class QueueFromLinkedList {
    LinkedList list;
    int n;
    /**
     * Creates an empty Queue using Linked List.
     */
    public QueueFromLinkedList(){
        list = new LinkedList();
    }
    /**
     * Adds an element to the last of the Queue.
     * @param x The new element to be enqueued
     */
    public void enqueue(int x){
        list.add(x);
        n++;
    }
    /**
     * Removes the first element of the queue.
     * @return the first element removed 
     */
    public int dequeue(){
        if(this.isEmpty()){
            System.out.println("Error: Underflow");
            return 0;
        }
        else{
            n--;
            return list.removeFirst().data;
        }
    }
    /**
     * Checks whether a Queue is full or not.
     * @return true or false 
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
     * Gives number of elements in the queue.
     * @return number of elements in queue
     */
    public int getNumberOfElements(){
        return this.n;
    }
}
