
package Lab01;

import java.util.Scanner;
/**
 *
 * @author Somsubhra(201101056)
 */
public class LinkedListTester  {
    /**
     * Runs the Linked List Tester.
     */
    public void run(){
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("***********************Linked List Tester**************************");
        System.out.println("Enter the elements of the Linked List and press q+ENTER at the end.");
        while(true){
            input = sc.next();
            if(input.equals("q")){
                break;
            }
            list.add(Integer.parseInt(input));
        }
        
        while(true){
            System.out.println("1.Press s+ENTER to search for an element from linked list.");
            System.out.println("2.Press x+ENTER to delete an element from linked list.");
            System.out.println("3.Press r+ENTER to reverse the linked list.");
            System.out.println("4.Press d+ENTER to display the linked list.");
            System.out.println("5.Press a+ENTER to add more elements to linked list.");
            System.out.println("6.Press q+ENTER to quit.");
            input = sc.next();
            if(input.equals("s")){
                while(true){
                    System.out.println("Enter the element to search and press ENTER or press q+ENTER to go back.");
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                            
                    System.out.println("Element found at "+list.search(Integer.parseInt(input)));
                    
                }
            }
            
            else if(input.equals("x")){
                while(true){
                    System.out.println("Enter the element to delete and press ENTER or press q+ENTER to go back");
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    System.out.println("Element "+list.delete(Integer.parseInt(input)).data +" deleted");
                }
            }
            
            else if(input.equals("r")){
                list.reverse();
                System.out.println("Linked list reversed.");
            }
            
            else if(input.equals("d")){
                list.display();
            }
            else if(input.equals("q")){
                break;
            }
            else if(input.equals("a")){
                System.out.println("Enter the elements of the linked list and press q+ENTER at the end.");
                while(true){
                    input = sc.next();
                    if(input.equals("q")){
                        break;
                    }
                    list.add(Integer.parseInt(input));
                }
            }
            else{
                System.out.println("Invalid key");
            }
        }
        
    }
}
