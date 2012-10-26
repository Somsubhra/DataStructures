
package Lab01;
import java.util.Scanner;
/**
 *
 * @author Somsubhra(201101056)
 */
public class QueueTester {
    /**
     * Runs the Queue Tester.
     */
    public void run(){
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("************************Queue Tester*************************");
        System.out.println("Enter the elements of the queue and press q+ENTER at the end.");
        while(true){
            input = sc.next();
            if(input.equals("q")){
                break;
            }
            q.enqueue(Integer.parseInt(input));
        }
        
        while(true){
            System.out.println("1.Press d+ENTER to dequeue the elements from queue.");
            System.out.println("2.Press e+ENTER to enqueue the elements in queue.");
            System.out.println("3.Press r+ENTER to reverse portion of queue");
            System.out.println("4.Press x+ENTER to exchange two elements of queue");
            System.out.println("5.Press q+ENTER to quit");
            
            input = sc.next();
            if(input.equals("d")){
                
                System.out.println("Element "+q.dequeue()+" dequeued");
            }
            else if(input.equals("e")){
                System.out.println("Enter the elements of the queue and press q+ENTER at the end.");
                while(true){
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    q.enqueue(Integer.parseInt(input));
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
                    
                    q.reverse(to,from);
                    System.out.println("Queue portion reversed.");
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
                    
                    q.exchange(to,from);
                    System.out.println("Elements exchanged.");
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
