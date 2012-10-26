
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class Link {
    
    int data; //The data field of the link
    Link next; //The field pointing to the next Link in linked list
    
    /**
     * Creates a new Link object which is the basic 
     * element of a Linked List.
     * @param data The data contained in the link 
     */
    public Link(int data){
        this.data = data;
    }
}
