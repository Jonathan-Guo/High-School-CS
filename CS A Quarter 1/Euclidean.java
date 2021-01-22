/*********************************************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Euclidean Algorithm
Purpose of Program: To find the greatest common factor among two integers using the Euclidean Algorithm.

What I learned: I learned that a while loop operates until the condition specified is false. I 
also learned that while loops also use curly brackets like to if statements and for loops to extend their scope.
*********************************************************************************************/

import java.util.Scanner;

public class Euclidean
{
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      int a, b, remainder;
      System.out.print ("Enter the first integer: ");
      a = console.nextInt();
      System.out.print ("Enter the second integer: ");
      b = console.nextInt();
      if (a > b)
      {
         while (b != 0)
         {
            remainder = a % b;
            System.out.println ("Larger number is " + a + ", Smaller number is " + b);
            System.out.println ("Remainder is: " + remainder); 
            a = b;
            b = remainder;
         }
         System.out.println ("Greatest common factor is: " + a);
      }
      else
      {
         while (a != 0)
         {
            remainder = b % a;
            System.out.println ("Larger number is " + b + ", Smaller number is " + a);
            System.out.println ("Remainder is: " + remainder);
            b = a;
            a = remainder;
         }
         System.out.println ("Greatest common factor is: " + b);
      }
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Euclidean
 Enter the first integer: 45
 Enter the second integer: 36
 Larger number is 45, Smaller number is 36
 Remainder is: 9
 Larger number is 36, Smaller number is 9
 Remainder is: 0
 Greatest common factor is: 9
 
  ----jGRASP: operation complete.
 
 
 ----jGRASP exec: java Euclidean
 Enter the first integer: 100
 Enter the second integer: 40
 Larger number is 100, Smaller number is 40
 Remainder is: 20
 Larger number is 40, Smaller number is 20
 Remainder is: 0
 Greatest common factor is: 20
 
  ----jGRASP: operation complete.
 

  ----jGRASP exec: java Euclidean
 Enter the first integer: 38
 Enter the second integer: 17
 Larger number is 38, Smaller number is 17
 Remainder is: 4
 Larger number is 17, Smaller number is 4
 Remainder is: 1
 Larger number is 4, Smaller number is 1
 Remainder is: 0
 Greatest common factor is: 1
 
  ----jGRASP: operation complete.
 
*/