/*********************************************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Combination Lock
Purpose of Program: To use if statements to see if the locker combination the user entered
is equal to the actual locker combination. 

What I learned: I learned that for all if statements in methods beside main you need to have a 
return statement. I also learned that you can use a boolean method which returns true or false.

*********************************************************************************************/

import java.util.Scanner;

public class Lock
{
   private static Scanner console = new Scanner (System.in);
   public static void main (String [] args)
   {
      int first, second, third; 
   
      first = (int)(Math.random() * 50 + 1);
      second = (int)(Math.random() * 50 + 1);
      third = (int)(Math.random() * 50 + 1);
   
      System.out.println (first + ", " + second + ", " + third);
      
      theLockisOpen (first, second, third);
   }
   
   public static boolean theLockisOpen (int firstNum, int secondNum, int thirdNum)
   {
      
      System.out.print ("Enter the first number: ");
      int a = console.nextInt();
      System.out.print ("Enter the second number: ");
      int b = console.nextInt();
      System.out.print ("Enter the third number: ");
      int c = console.nextInt();
      if (firstNum == a && secondNum == b && thirdNum == c)
      {
         System.out.println ("\nLock opens");
         return true;
      }
      else 
      { 
         System.out.println ("\nIncorrect");
         return false;
      }
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Lock
 8, 36, 35
 Enter the first number: 8
 Enter the second number: 36
 Enter the third number: 35
 
 Lock opens
 
  ----jGRASP: operation complete.


  ----jGRASP exec: java Lock
 3, 16, 47
 Enter the first number: 0
 Enter the second number: 10
 Enter the third number: 50
 
 Incorrect
 
  ----jGRASP: operation complete.
  
 
  ----jGRASP exec: java Lock
 4, 8, 39
 Enter the first number: 4
 Enter the second number: 8
 Enter the third number: 39
 
 Lock opens
 
  ----jGRASP: operation complete.
*/