
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class StackFromLinkedList {
    LinkedList list;
    int n;
    /**
     * Creates a Stack using Linked list.
     */
    public StackFromLinkedList(){
        list = new LinkedList();
    }
    /**
     * Adds an element to the top of the stack.
     * @param element the element to be pushed 
     */
    public void push(int x){
        list.add(x);
        n++;
    }
    /**
     * Removes the topmost element of the stack.
     * @return the element popped
     */
    public int pop(){
        if(this.isEmpty()){
            System.out.println("Error: Underflow");
            return 0;
        }else{
            n--;
            return list.removeLast().data;
        }  
        
    }
    /**
     * Checks whether a Stack is empty or not.
     * @return true or false
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
     * Counts the number of elements in stack.
     * @return number of elements in stack. 
     */
    public int getNumberOfElements(){
        return n;
    }
}
