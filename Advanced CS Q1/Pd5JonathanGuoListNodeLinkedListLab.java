/*==============================================================================
Rubric: Program header (2 pts)
        Each functional method is worth 2 points. Total: 22 pts
        Correct pre- and post-conditions for all methods: 2 pts 
        --------------------------------------------------------
        Total: 26 pts
        --------------------------------------------------------
        Perfunctory "What I learned" OR "What I wonder" OR missing "credits" and
        "Students whom I helped" (-1 point)
        Missing one/incorrect desciptions: -1 pt
===============================================================================*/

/******************************************************************************
* Name:  Jonathan Guo
* Period:   5
* Date: 9/13/19
 
* What I learned: 
   - I learned how to work with listnode commands and how to make sure that it is never a null pointer exception
      - If head is null I created if statements so the program won't crash
   - I also learned how to use for and while loops with list nodes to keep track of which node I am pointing at (learned the new syntax)
   - I learned how to create a new listnode to modify the list such as ListNode temp
   - I learned how to "split" a list node into different halves by using different while loops and instance variables to keep track of where I am at
   
* How I feel about this lab: I feel that this lab helped me a lot with the syntax of using the listnode commands and learning the logic behind how to avoid exceptions
* What I wonder: 
   - Is using listnode is always worth it? For small data like these I think it is just easier to use an ArrayList since this is a lot more complicated and the memory difference is insignificant.
   - Is there a way for the user to be able to immediately access a piece of data that is not the head and is in the middle of the list
* Credits:  https://stackoverflow.com/questions/15792682/delete-last-node-of-a-linked-list.
   - I used this website to learn how not to get a null pointer exception for all the other methods and use temp.getNext() != null instead of temp != null
* Students whom I helped (to what extent): I did not help anyone
*********************************************************************************/
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Pd5JonathanGuoListNodeLinkedListLab
{

   private static class ListNode <E> 
   {    
      private E value;    
      private ListNode <E>  next; 
      public ListNode  (E  initValue, ListNode <E> initNext)    
      { 
         value = initValue; 
         next = initNext; 
      }  
      public E getValue()  
      { 
         return value; 
      }    
   
      public ListNode <E> getNext() 
      { 
         return next;  
      } 
   
      public void setValue(E theNewValue)
      { 
         value = theNewValue;
      }
   
      public void setNext(ListNode  <E> theNewNext)
      { 
         next = theNewNext; 
      }
   
   }  // end of ListNode



   
   public static void main(String[] args) 
   {
      Scanner input = new Scanner(System.in);
      ListNode<Integer> h = new ListNode <>(5, null);
      h = new ListNode(4, h);
      h = new ListNode(3, h);
      h = new ListNode(2, h);
      h = new ListNode(1, h);
      
      char option;
      do {
         option = menu();
         if (option == 'a') {
            System.out.println("list: ");
            printLinkedList(h);
         } else if (option == 'b') {
            System.out.println("The List has atleast two element?");
            System.out.println(hasTwo(h));
         } else if (option == 'c') {
            System.out.print("The size of the array is: ");
            System.out.println(size(h));
         } else if (option == 'd') {
            h = removeFirst(h);
            System.out.print("New list is: ");
            printLinkedList(h);
         } else if (option == 'e') {
            System.out.println("Enter the number to be inserted at the end: ");
            int num = input.nextInt();
            h = add(h, new Integer(num));
            System.out.print("New list is: ");
            printLinkedList(h);
         
         } else if (option == 'f') {
            h = reverseList(h);
            System.out.println("Reverse is: ");
            printLinkedList(h);
         } else if (option == 'g') {
            h = rotate(h);         // rotate the list clockwise
            System.out.println("rotated array is: ");
            printLinkedList(h);
         } else if (option == 'h') {
            printLinkedList(h);
            if (middleNode (h) == null)
            {
               System.out.print ("\nmiddle node is: There is no middle node");
            }
            else 
            {
               System.out.println("\nmiddle node is: " + middleNode(h).getValue());
            }
         }
            
         else if (option == 'i') {
            h = removeLast(h);
            System.out.println("New list is: ");
            printLinkedList(h);
         }
            
         else if (option == 'j') {
            System.out.println("Please enter the value you want to remove");
            int v = input.nextInt();
            h = remove(h, v);
            System.out.println("New list is: ");
            printLinkedList(h);
         }
            
         else if (option == 'k') {
            split(h);
         }
         
      } while (option != 'z');
   } // end of main
   
   public static char menu() {
      Scanner input = new Scanner(System.in);
      System.out.println("\n====> What would you like to do?");
      System.out.println("a) Print list");
      System.out.println("b) Check if list has at least two nodes");
      System.out.println("c) Get size of the list");
      System.out.println("d) Remove first node");
      System.out.println("e) Add a node");
      System.out.println("f) Reverse");
      System.out.println("g) Rotate");
      System.out.println("h) Get middle node");
      System.out.println("i) Remove last node");
      System.out.println("j) Remove node with value");
      System.out.println("k) Split List");
      System.out.println("z) Quit?");
      String choice = input.next();
      return choice.charAt(0);
   } // end of menu
   
   //pre: head is instantiated
   //post: prints string representing linked list 
   public static void printLinkedList(ListNode<Integer> head) 
   {
      ListNode <Integer> temp = head;
      for (temp = head; temp != null; temp = temp.getNext())
      {
         System.out.print (temp.getValue() + " ");
      }
   }

   //pre: head is instantiated
   //post: returns true if list has more than two values, false if less than two values
   public static boolean hasTwo(ListNode<Integer> head) 
   {
      int count = 0;
      for (head = head; head != null; head = head.getNext())
      {
         count++;
      }
      if (count >= 2)
      {
         return true;
      }
      return false;
   }

   //pre: head is instantiated
   //post:  returns size of the list
   public static int size(ListNode<Integer> head) 
   {
      int count = 0;
      for (head = head; head != null; head = head.getNext())
      {
         count++;
      }
      return count;
   }
   
   //pre:   head is instantiated
   //post:  returns new list with first value removed
   public static ListNode<Integer> removeFirst(ListNode<Integer> head) 
   {
      if (size (head) == 0)
      {
         return head;
      }
      head = head.getNext();
      return head;
   }
   
   //pre: head is instantiated
   //post: returns new list without last value
   public static ListNode<Integer> removeLast(ListNode<Integer> head) 
   {
      ListNode <Integer> prev = null;
      ListNode <Integer> curr = head;
      if (size (head) <= 1)
      {
         head = null;
         return head;
      }
      while (curr.getNext() != null) 
      {
         prev = curr; 
         curr = curr.getNext();
      }
      prev.setNext (curr.getNext());
      
      return head;
   }
   
   //pre: value is an Integer, head is instantiated
   //post: returns new list without the value that was removed
   public static ListNode<Integer> remove(ListNode<Integer> head, Integer value) 
   {
      if(head == null)
      {
         return null;
      }
      for(ListNode <Integer> temp = head; temp.getNext() != null; temp = temp.getNext())
      {
         if (temp.getNext().getValue().equals(value))
            temp.setNext(temp.getNext().getNext());
      }
   		  	  
      return head;
   }
   
   //pre: value is an Integer, head is instantiated
   //post: returns new list with added value at the end
   public static ListNode<Integer> add(ListNode<Integer> head, Integer value) 
   {
      ListNode <Integer> temp = head;
      ListNode <Integer> var = new ListNode <Integer> (value, null);
      if (head == null)    //if head is null sets heads value to value
      {  
         head = (new ListNode <Integer> (value, null));
         return head;
      }
      while (temp.getNext() != null)
      {
         temp = temp.getNext();
      }
      temp.setNext(var);   //adds value to end of head   
      return head;	        
   }
   
   //pre: head is instantiated
   //post: returns new list in reverse order of original
   public static ListNode<Integer> reverseList(ListNode<Integer> head) 
   {
      if (size (head) == 0)
      {
         return null;
      }
      if (size (head) == 1)
      {
         return head;
      }
      
      ListNode <Integer> curr = head;
      ListNode <Integer> next = null;
      ListNode <Integer> prev = null;
   	   
      while(curr != null)
      {
         next = curr.getNext();  
         curr.setNext(prev);     //points at previous value
         prev = curr;            //move prev up one
         curr = next;            //move curr up one
      }
      head = prev;
      return head;
   }
   
   //pre: head is instantiated
   //post: returns list that has been rotated to the left, first value is now at end of list
   public static ListNode<Integer> rotate(ListNode<Integer> head) 
   {
      if (head == null)
      {
         return null;
      }
      if (size(head) == 1)
      {
         return head;
      }
      int val = head.getValue();
      head = head.getNext();           //starts head at the second value instead of first
      ListNode <Integer> temp = head;
      
      while (temp.getNext() != null)
      {
         temp = temp.getNext();
      }
      
      
      temp.setNext(new ListNode <Integer> (val, null));  //sets last value to be first value of head
      return head;
   }
   
   //pre: head is instantiated
   //post: returns the middle node of the list
   public static ListNode<Integer> middleNode(ListNode<Integer> head) 
   {
      if (head == null)
      {
         return null;
      }
      
      int length = 0;
      ListNode <Integer> curr = head;
      ListNode <Integer> mid = head;
      
      while(curr.getNext() != null)
      {
         length++;
         if(length % 2 == 1)        //sets mids final value to be the middle value of the list by setting it to next once every two times current is set to next
         {
            mid = mid.getNext();
         }
         curr = curr.getNext();
      }
      return mid;
   }

   // pre: head is instantiated
   // post: returns the first half (or larger half of the list if the list has
   //       odd number of nodes) and prints onto the screen the second half of the 
   //       list onto the screen
   public static ListNode <Integer> split(ListNode<Integer> head) 
   {
      if (size (head) <= 1)
      {
         return head;
      }
      
      int length = 0;
      int count = 0;
      ListNode <Integer> index = head;
      ListNode <Integer> first = null;
      ListNode <Integer> second = null;
      while (index.getNext() != null)
      {
         length++;
         index = index.getNext();
      }
      
      ListNode <Integer> temp = head;
      while (count <= length/2)
      {
         first = new ListNode <Integer> (temp.getValue(), first); //adds values from head into first
         temp = temp.getNext();
         count++;
      }
      
      while (count < size (head))
      {
         second = new ListNode <Integer> (temp.getValue(), second);  //adds second half values of head into first
         temp = temp.getNext();
         count++;
      }
      
      first = reverseList (first);        //reverses lists since values were inputted backwards
      second = reverseList (second);
      printLinkedList (second);
      return first;
   }
}

