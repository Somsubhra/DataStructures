
package Lab01;

import java.util.Scanner;

/**
 *
 * @author Somsubhra(201101056)
 */
public class QueueFromLinkedListTester {
    /**
     * Run the Queue from Linked list tester
     */
    public void run(){
        QueueFromLinkedList q = new QueueFromLinkedList();
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("****************Queue from Linked list Tester****************");
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
            else if(input.equals("q")){
                break;
            }
            else{
                System.out.println("Invalid key");
            }
        }
    }
}
