
package Lab01;

import java.util.Scanner;

/**
 *
 * @author Somsubhra(201101056)
 */
public class StackTester {
    /**
     * Runs the Stack Tester.
     */
    public void run(){
        Stack s = new Stack();
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("***********************Stack Tester**************************");
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
            System.out.println("3.Press r+ENTER to reverse portion of stack");
            System.out.println("4.Press x+ENTER to exchange two elements of stack");
            System.out.println("5.Press d+ENTER to display the stack");
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
            
            else if(input.equals("r")){
                while(true){
                    System.out.println("Enter the starting position or press q+ENTER to go back.");
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    int from = Integer.parseInt(input);
                    
                    System.out.println("Enter the ending position or press q+ENTER to go back.");
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    int to = Integer.parseInt(input);
                    
                    s.reverse(to,from);
                    System.out.println("Stack portion reversed.");
                }
            }
            
            else if(input.equals("x")){
                while(true){
                    System.out.println("Enter the position of first element or press q+ENTER to go back.");
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    int from = Integer.parseInt(input);
                    
                    System.out.println("Enter the position of second element or press q+ENTER to go back.");
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    int to = Integer.parseInt(input);
                    
                    s.exchange(to,from);
                    System.out.println("Elements exchanged.");
                }
            }
            else if(input.equals("d")){
                s.display();
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
