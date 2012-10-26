
package Lab01;

/**
 *
 * @author Somsubhra(201101056)
 */
public class Stack {
    int[] arr;
    int top;
    
    /**
     * Creates an empty Stack.
     */
    public Stack(){
        arr = new int[100];
        top = -1;
    }
    /**
     * Checks whether a Stack is empty or not.
     * @return true or false
     */
    public boolean isEmpty(){
        if(this.top==-1){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Adds an element to the top of the stack.
     * @param element the element to be pushed 
     */
    public void push(int element){
        if(this.top<arr.length-1){
        this.top++;
        arr[this.top]=element;
        }else{
            System.out.println("Error: Overflow");
        }
    }
    /**
     * Removes the topmost element of the stack.
     * @return the element popped
     */
    public int pop(){
        if(this.isEmpty()){
            System.out.println("Error: Underflow");
            return 0;
        }
        else{
            this.top--;
            return arr[this.top+1];
        }
    }
    /**
     * Counts number of elements in the stack.
     * @return number of elements in stack.
     */
    public int getNumberOfElements(){
        return this.top+1;
    }
    /**
     * Displays the stack in the top to bottom order.
     */
    public void display(){
        for(int i=this.getNumberOfElements()-1; i>=0;i--){
            System.out.println(arr[i]);
        }
    }
    /**
     * Exchanges two elements of a stack
     * @param a the first element
     * @param b the second element
     */
    public void exchange(int a, int b){
        if(a>b){
            int tmp=a;
            a = b;
            b = tmp;
        }
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        for(int i=0; i<a; i++){
            s1.push(this.pop());
        }
 
        for(int i=0; i<b-a; i++){
            s2.push(this.pop());
        }
        this.push(s1.pop());
        int temp = s2.pop();
        this.push(s2.pop());
        this.push(temp);
        this.push(s1.pop());
    }
    /**
     * Reverses a portion of the stack.
     * @param a The starting element
     * @param b The ending element.
     */
    public void reverse(int a, int b){
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        if(a>b){
            int temp = a;
            a=b;
            b=temp;
        }

        for(int i=0; i<a-1; i++){
            s1.push(this.pop());
        }

        for(int i=0; i<b-a+1; i++){
            s2.push(this.pop());
        }

        for(int i=0; i<b-a+1; i++){
            s1.push(s2.pop());
        }
        for(int i=0; i<b-a+1;i++){
            this.push(s1.pop());
        }
        for(int i=0; i<a-1; i++){
            this.push(s1.pop());
        }

    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
