//Name: Jonathan Guo
//Date: 2/18/20
// What I learned: 
//- I learned how to write the sort method by swapping and then reheaping down
//- I learned how to write makeHeap by starting at the middle of the heap and then reheapingdown
//- I learned how to write the heapDown method for all values except for the first one 
//       (I couldnt figure out what was wrong with my code that the first and second values were sometimes out of order)
//- I learned how to use decimal format

// How I feel about this lab: I feel pretty confident about this lab and it taught me more about exactly how the Heapsort works

// I am wondering: I am wondering why my heapSort helper method did not fully work and also in what scenarios we would use other searches since this is generally the most efficient.

import java.text.*;
import java.io.*;
public class Pd5GuoJonathanHeapSort_shell
{
   public static final int SIZE = 10;
	
   public static void main(String[] args)
   {
   //Part 1: Given a heap, sort it. Do this part first.   
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};
      display(heap);
      sort(heap);
      display(heap);
      
   //Part 2:  Generate 10 random numbers, make a heap, sort it.
      double[] heap2 = new double[SIZE];
      
      createRandom(heap2);
      display(heap2);
      makeHeap(heap2);
      display(heap2); 
      sort(heap2);
      display(heap2);
   }
   
	//******* Part 1 ******************************************
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(new DecimalFormat("0.00").format(array[k]) + "    ");
      System.out.println("\n");	
   }
   public static void sort(double[] array)
   {
      for (int i = SIZE - 1; i >= 1; i--) 
      {
         swap(array, 1, i);
         heapDown(array, i - 1); 
      }  
   }
   public static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;   
   }
   public static void heapDown(double[] array, int size)
   {
      heapDownHelper(array, 1, size);   
   }
   public static void heapDownHelper(double[] array, int k, int size)
   {
      int left = k * 2;
      int right = k * 2 + 1;
      int maxChild = 0;
      if (k > size || left > size || right > size)
      {
         return;
      }
      else
      {
         if (array[left] >= array[right] && array[left] > array[k])
         {
            //maxChild = left;
            swap(array, k, left);
            heapDownHelper(array, left, size);
         }
         else if (array[right] > array[left] && array[right] > array[k])
         {
            //maxChild = right;
            swap(array, k, right);
            heapDownHelper(array, right, size);
         }
         /*if (array[k] < array[maxChild])
         {
            swap(array, k, maxChild);
            heapDownHelper(array, maxChild, size);
         }*/   
      }
   }
   
   
   // ****** Part 2 *******************************************
   public static void makeHeap(double[] array)
   {
      for (int i = SIZE / 2; i > 1; i--)
      {
         heapDownHelper(array, i - 1, SIZE);  
      } 
   }
   //Generate 100 random numbers (between 1 and 100, formatted to 2 decimal places) 
   public static void createRandom(double[] array)
   {  
      for (int i = 1; i < array.length; i++)
      {
         array[i] = (double)(Math.random() * 100) + 1;   
      }
   }
}

/*
Output:
 
 
  ----jGRASP exec: java Pd5GuoJonathanHeapSort_shell
 99.00    80.00    85.00    17.00    30.00    84.00    2.00    16.00    1.00    
 
 2.00    1.00    16.00    17.00    30.00    80.00    84.00    85.00    99.00    
 
 58.53    16.53    4.30    20.41    57.88    84.03    75.43    3.71    25.11    
 
 84.03    57.88    75.43    25.11    16.53    4.30    58.53    3.71    20.41    
 
 3.71    4.30    16.53    20.41    25.11    57.88    58.53    75.43    84.03    
 
 
  ----jGRASP: operation complete.
 
*/
