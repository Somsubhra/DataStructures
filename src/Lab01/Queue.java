
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class Queue {
    int[] arr;
    int tail;
    int head;
    int n;
    /**
     * Creates an empty queue.
     */
    public Queue(){
         arr = new int[100];
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
    public void enqueue(int x){
        if(this.isFull()){
            System.out.println("Error: Overflow");
            
        }
        else{
            arr[this.tail]=x;
            n++;
            if(this.tail==arr.length-1){
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
    public int dequeue(){
        if(!this.isEmpty()){
            int x=arr[this.head];
            n--;
            if(this.head==arr.length-1){
                this.head=0;
            }else{
                this.head++;
            }
            return x;
        }else{
            System.out.println("Error: Underflow");
            return 0;
        }
    }
    /**
     * Find the number of elements in the queue.
     * @return number of elements in the queue.
     */
    public int getNumberOfElements(){
        return this.n;
    }
    /**
     * Exchange two element of a queue.
     * @param a The first element
     * @param b The second element
     */
    public void exchange(int a, int b){
        int n = this.getNumberOfElements();
        Queue q1 = new Queue();
        Queue q2 = new Queue();
        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int i=0; i<b-1; i++){
            q2.enqueue(this.dequeue());
        }
        for(int i=0; i<a-1; i++){
            q1.enqueue(q2.dequeue());
        }
        q1.enqueue(this.dequeue());
        for(int i=0; i<a; i++){
            this.enqueue(q1.dequeue());
        }
        q1.enqueue(q2.dequeue());
        
        for(int i=0; i<n-b;i++){
            q1.enqueue(this.dequeue());
        }
        for(int i=0; i<b-a-1;i++){
            this.enqueue(q2.dequeue());
        }
        this.enqueue(q1.dequeue());
        
        for(int i=0; i<n-b; i++){
            this.enqueue(q1.dequeue());
        }
    }
    /**
     * Reverses a certain portion of the queue.
     * @param a The starting element 
     * @param b The ending element
     */
    public void reverse(int a, int b){
        int n = this.getNumberOfElements();
        Queue q1 = new Queue();
        Queue q2 = new Queue();
        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        for(int i=0; i<b; i++){
            q2.enqueue(this.dequeue());
        }
        for(int i=0; i<a-1; i++){
            this.enqueue(q2.dequeue());
        }
        for(int i=0; i<b-a;i++){
            q1.enqueue(q2.dequeue());
        }
        this.enqueue(q2.dequeue());
        int k = b-a-1;
        for(int i = 0; i<((b-a-1)/2); i++){
            for(int j=0; j<k; j++){
                q2.enqueue(q1.dequeue());
            }
            k--;
            this.enqueue(q1.dequeue());
            
            for(int j=0; j<k; j++){
                q1.enqueue(q2.dequeue());
            }
            k--;
            this.enqueue(q2.dequeue());
        }
        if(k!=0){
            q2.enqueue(q1.dequeue());
            this.enqueue(q1.dequeue());
            this.enqueue(q2.dequeue());
            
        }else{
        this.enqueue(q1.dequeue());}
        for(int i=0; i<n-b; i++){
            q1.enqueue(this.dequeue());
        }
        for(int i=0; i<n-b; i++){
            this.enqueue(q1.dequeue());
        }
    }
    
    
}
