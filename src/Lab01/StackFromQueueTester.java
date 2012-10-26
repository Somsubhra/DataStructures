
package Lab01;

import java.util.Scanner;

/**
 *
 * @author Somsubhra(201101056)
 */
public class StackFromQueueTester {
    /**
     * Runs the Stack from Queue Tester.
     */
    public void run(){
        StackFromQueue s = new StackFromQueue();
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("******************Stack from Queue Tester********************");
        System.out.println("Enter the elements of the stack and press q+ENTER at the end.");
        while(true){
            input = sc.next();
            if(input.equals("q")){
                break;
            }
            s.push(Integer.parseInt(input));
        }
        
        while(true){
            System.out.println("1.Press o+ENTER to pop the elements from stack.");
            System.out.println("2.Press p+ENTER to push the elements in stack.");
            System.out.println("6.Press q+ENTER to quit");
            input = sc.next();
            if(input.equals("o")){
                
                System.out.println("Element "+s.pop()+" popped");
            }
            else if(input.equals("p")){
                System.out.println("Enter the elements of the stack and press q+ENTER at the end.");
                while(true){
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    s.push(Integer.parseInt(input));
                }
            }
            else if(input.equals("q")){
                break;
            }
            else{
                System.out.println("Invalid key");
            }
        }
    }
}
