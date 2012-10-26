
package Lab01;

import java.util.Scanner;
/**
 *
 * @author Somsubhra(201101056)
 */
public class DataStructureTester {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input;
        while(true){
            System.out.println("***********************Data Structure Tester Menu***********************");
            System.out.println("1.Press 1 for Linked List Tester.");
            System.out.println("2.Press 2 for Stack Tester.");
            System.out.println("3.Press 3 for Queue Tester.");
            System.out.println("4.Press 4 for Stack from Queue Tester.");
            System.out.println("5.Press 5 for Queue from Stack Tester");
            System.out.println("6.Press 6 from Stack from Linked List Tester");
            System.out.println("7.Press 7 from Queue form Linked List Tester");
            System.out.println("8.Press 8 for exit");
            input = sc.nextInt();
            
            if(input==1){
                (new LinkedListTester()).run();
            }
            else if(input==2){
                (new StackTester()).run();
            }
            else if(input==3){
                (new QueueTester()).run();
            }
            else if(input==4){
                (new StackFromQueueTester()).run();
            }
            else if(input==5){
                (new QueueFromStackTester()).run();
            }
            else if(input==6){
                (new StackFromLinkedListTester()).run();
            }
            else if(input==7){
                (new QueueFromLinkedListTester()).run();
            }
            else if(input==8){
                break;
            }
            else{
                System.out.println("Invalid key");
            }
        
        }
    }
}
