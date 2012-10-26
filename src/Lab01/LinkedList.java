
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class LinkedList {
    
    Link head;
    Link tail;
    int size;
    /**
     * Creates an empty Linked List.
     */
    public LinkedList(){
        head = null;
        tail = null;
                    
    }
    /**
     * Adds new data to the linked list at the tail. 
     * @param data The new data to be entered in the linked list. 
     */
    public void add(int data){
        Link newData = new Link(data);
        if(head==null){
            head = newData;
            tail = head;
            tail.next = null;
        }
        
        else{
            tail.next = newData;
            tail = newData;
            tail.next = null;
        }
        this.size++;
    }
    
    /**
     * Searches for a certain key value in the Linked list.
     * @param searchKey The key to be searched
     * @return The address of the key searched.
     */
    public Link search(int searchKey){
        Link current=head;
        
        while(current!=null){
            if(current.data==searchKey){
                
                break;
                
            }
            current = current.next;    
        }
        return current;
      
    }
    /**
     * Displays the Linked List along with next pointer.
     */
    public void display(){
        Link current = head;
        while(current!=null){
            System.out.println(current.data+"  "+current.next);
            current = current.next;
        }
    }
    /**
     * Deletes a certain key from the Linked list.
     * @param deleteKey the key to be deleted
     * @return The key deleted 
     */
    public Link delete(int deleteKey){
       
           Link current=head;
           Link previous = head;
           
           while(current.data!=deleteKey){
               if(current.next==null){
                   return null;
               }else{
                   previous = current;
                   current = current.next;
               }
           }
           
           if(current==head){
               head = head.next;
           }
           else{
               previous.next = current.next;
           }
           this.size--;
           return current;
           
    }
    /**
     * Check whether the Linked List is empty or not.
     * @return true or false
     */
    public boolean isEmpty(){
        return this.head==null;
    }
    /**
     * Removes the first element of the linked list.
     * @return the first element removed.
     */
    public Link removeFirst(){
        Link first = head;
        head = head.next;
        size--;
        return first;
    }
    /**
     * Removes the last element from the Linked list.
     * @return the last element removed 
     */
    public Link removeLast(){
        Link last = this.tail;
        if(head==tail){
            Link tmp = head;
            head=null;
            tail=null;
            return tmp;
        }
        else{
        Link current=head;
        
        while(current.next.next!=null){
            current = current.next;
        }
        tail=current;
        current.next=null;
        size--;
        return last;}
    }
    /**
     * Reverses the Linked List
     */
    public void reverse(){
        Link temp1 = this.head;
        Link temp2 = null;
        Link temp3 = null;
        
        while(temp1!=null){
            this.head = temp1;
            temp2 = temp1.next;
            temp1.next = temp3;
            temp3 = temp1;
            temp1 = temp2;
        }
        
    }
}
