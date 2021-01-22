/*****************************************************************************************************************
NAME: Jonathan Guo     
PERIOD: 5
DUE DATE: 11/26/19 
ASSIGNMENT: Iterator Lab

PURPOSE: Practice using the iterator and ListIterator interface as well as for loops   

LEARNED:    
- I learned how to use the set method in the ListIterator interface to replace a value
- I learned how to actually change the values of the real list and return it so that changes are actually made to the list
- I learned how to use the replace method by calling iter.next() first and having a mental image of where the cursor is
- I learned that using for each loops does not work when you want to change the actual content of the list
- I learned that 
            
CREDITS: 
https://www.java-examples.com/replace-element-arraylist-using-java-listiterator-example
- This website showed me the logic behind using the set method in the ListIterator interface so I could change the content of the actual list
****************************************************************************************************************/

 // NOTE:  use for-each loops or iterators, not regular for-loops
   import java.io.*;
   import java.util.*;
    public class Pd5GuoJonathanIteratorLab_shell
   {
       public static void main(String[] args)
      {
         System.out.println("Iterator Lab\n");
         int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
         for(int n : rawNumbers )
            System.out.print(n + " ");    
         ArrayList<Integer> numbers = createNumbers(rawNumbers);
         System.out.println("ArrayList: "+ numbers);      //Implicit Iterator!
         System.out.println("Count negative numbers: " + countNeg(numbers));
         System.out.println("Average: " + average(numbers));
         System.out.println("Replace negative numbers: " + replaceNeg(numbers));
         System.out.println("Delete zeros: " + deleteZero(numbers));
         String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
         ArrayList<String> movies = createMovies(rawMovies);
         System.out.println("Movies: " + movies);
         System.out.println("Movies: " +  removeDupes(movies));
      }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
       public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
      {
         ArrayList <Integer> values = new ArrayList <Integer>();
         for(int v: rawNumbers)
         {
            values.add(v);
         }
         return values;        
      }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
       public static ArrayList<String> createMovies(String[] rawWords) 
      {
        ArrayList <String> movies = new ArrayList <String>();
        for (String s: rawWords)
        {
           movies.add(s);
        }
        return movies;
      }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
       public static int countNeg(ArrayList<Integer> a)
      {
         int count = 0;
         for (int v: a)
         {
            if (v < 0)
            {
               count++;
            }
         }
         return count;
      }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
       public static double average(ArrayList<Integer> a)
      {
         int sum = 0;
         for (int v: a)
         {
            sum += v;
         }
         return sum/a.size();
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
       public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
      {
         ListIterator iter = a.listIterator();
         while(iter.hasNext())
         {
            if((int)iter.next() < 0)
            {
               iter.set(new Integer (0));
            }
         }
         return a;
      }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
       public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
      {
         Iterator iter = a.iterator();
         while(iter.hasNext())
         {
            if((int)iter.next() == 0)
            {
               iter.remove();
            }
         }
         return a;       
      }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return ArrayList without duplicate movie titles
		// strategy: start with an empty array and add movies as needed
       public static ArrayList<String> removeDupes(ArrayList<String> a)
      {
         ArrayList <String> movies = new ArrayList <String>();
         Iterator iter = a.iterator();
         while(iter.hasNext())
         {
            String s = (String)iter.next();
            if(!(movies.contains(s)))
            {
               movies.add(s);
            }
         }
         return movies;             
      }
   }

/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanIteratorLab_shell
 Iterator Lab
 
 -9 4 2 5 -10 6 -4 24 20 -28 ArrayList: [-9, 4, 2, 5, -10, 6, -4, 24, 20, -28]
 Count negative numbers: 4
 Average: 1.0
 Replace negative numbers: [0, 4, 2, 5, 0, 6, 0, 24, 20, 0]
 Delete zeros: [4, 2, 5, 6, 24, 20]
 Movies: [High_Noon, High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No, Dr_No, Mary_Poppins, High_Noon, Tron]
 Movies: [High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No]
 
  ----jGRASP: operation complete.
 
*/