//Name: Jonathan Guo  
//Date: 2/16/20
// What I learned:
//- I learned how to write the reheap up and reheap down methods, making comparisons with the children and with the parents to decide what values to swap and if they needed swapping
//- I learned how to write the add and remove methods by calling reheapUp() and reheapDown() in them
//- I learned how to write the remove method following the steps of swapping the last and first value, removing the last value, then reheapingdown
//- I learned how to create my own method, print, to showcase the heap in a tree format and see visually how the values are getting added and removed

// How I feel about this lab:
// I feel pretty good about this lab because I learned how to write the reheap up and down methods, making comparisons to check what the heap should be. 
// I also feel good because I got good practice implementing it with an array and solidifying the knowledge through writing simple methods

// I am wondering (the what-if moment): I am wondering why we would ever use an array to implement this when we could just use an arraylist and not have to worry about resizing the array

// Credits: https://people.cs.umass.edu/~liberato/courses/2015-spring-cmpsci187/lecture-notes-john/lecture19.pdf
// This website helped me better understand the logic for reheaping up and down and how it would look in pseudocode

import java.util.*;
public class Pd5GuoJonathanHeapPriorityQueue_shell <E extends Comparable>
{
   private static final int DEFAULT_CAPACITY = 1024;
   private Comparable items[];  // use a 1-D array instead of ArrayList
   private int numItems;  // number of elements in items

  
   public Pd5GuoJonathanHeapPriorityQueue_shell()
   {
      items = new Comparable [DEFAULT_CAPACITY];
      numItems = 0;
   }
   
   
   public Pd5GuoJonathanHeapPriorityQueue_shell (int initialCapacity)
   {
      items = new Comparable[initialCapacity];
      numItems = 0;
   }
   
   public boolean isEmpty()
   {    
      return numItems == 0;  
   }
   
   public E peek()
   { 
      return (E)(items [1]);  
   }
   
   public E remove()
   {
      if(isEmpty())
      {
         System.out.println("Empty already");
         return null;
      }
	   E temp = peek();  //swap last and first to remove
	   items[1] = items[numItems];
	   items[numItems] = null;
      numItems--;
	   reheapDown();     //keep in order
      return temp;  
   }
   
   public boolean add(E obj)
   {
      numItems++;
      if (numItems == items.length)
         doubleCapacity();
      items[numItems] = obj;
      reheapUp();
      return true;
   }
   
      
   private void reheapDown()
   {
      int index = 1;
      while(items[index] != null && items[index * 2] != null && items[index * 2 + 1] != null)
      {   
         if(items [index * 2].compareTo (items [index * 2 + 1]) > 0) //checks which child is greater
         {
            if(items[index].compareTo (items [index * 2]) < 0) //if child is greater then parent then swap values
            {
               E temp = (E)items[index];
               items[index] = items[index * 2];
               items[index * 2] = temp;
               index *= 2;
            }
            else
            {
               break;
            }
         }
         else
         {
            if(items[index].compareTo(items[index * 2 + 1]) < 0)
            {
               E temp = (E)items[index];
               items[index] = items[index * 2 + 1];
               items[index * 2 + 1] = temp;
               index *= 2; 
            }
            else
            {
               break;
            }
         }
      }
   }
   
   private void reheapUp()
   {
      int index = numItems;
      while (items[index / 2] != null && index > 0 && items[index].compareTo(items[index / 2]) > 0)  //checks if the node is greater than parent
      {
      
         E temp = (E) items[index]; //swaps parent and child
         items[index] =  items[index/2];
         items[index/2] = temp;
         index /= 2;
      }          
   }
   
   
   private void doubleCapacity()
   {
      Comparable [] temp = new Comparable[items.length * 2];
      for (int i = 0; i < items.length; i++)
         temp[i] = items[i];
      items = temp;               
   }
   
   private void print() 
   {
      for (int i = 1; i < numItems + 1; i++)
      {
         for (int j = 0; j < Math.pow(2, i-1) && j + Math.pow(2, i-1) < numItems + 1; j++)
         {
            System.out.print(items[j + (int)(Math.pow(2, i-1))] + " ");
         }
         System.out.println();   //tree format
      }
   }

   public static void main(String[] args) 
   {
      Pd5GuoJonathanHeapPriorityQueue_shell heap = new Pd5GuoJonathanHeapPriorityQueue_shell(5);
      heap.add(5);
      heap.add(10);
      heap.add(1);
      heap.add(20);
      System.out.println ("Is heap empty: " + heap.isEmpty());
      
      heap.print();
      heap.remove();
      heap.print();

      System.out.println(heap.peek()+ "\n");
           
   }
     
}  //HeapPriorityQueue_shell

/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanHeapPriorityQueue_shell
 Is heap empty: false
 20 
 10 1 
 5 
 
 10 
 5 1 
 
 10
 
 
  ----jGRASP: operation complete.
 
*/