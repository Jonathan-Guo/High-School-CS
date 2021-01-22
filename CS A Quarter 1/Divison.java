/*********************************************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Divison
Purpose of Program: To use if statements to identify which of two inputed numbers is 
larger. Then the program divides the larger number by the smaller number and finds the answer 
in terms of quotient and remainder.

What I learned: I learned that if you are writing if statements without extra methods, you do 
not need a return statement.

*********************************************************************************************/
import java.util.Scanner;

public class Divison
{
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      int a, b;
      System.out.print ("Enter the first number: ");
      a = console.nextInt();
      System.out.print ("Enter the second number: ");
      b = console.nextInt();
      if (a > b)
      {
         System.out.println (a + " divided by " + b + " = " + a / b + "r" + a % b);
      } 
      else 
      {
         System.out.println (b + " divided by " + a + " = " + b / a + "r" + b % a); 
      }
   }
} 

/*************************************
Outputs:

  ----jGRASP exec: java Divison
 Enter the first number: 9
 Enter the second number: 2
 9 divided by 2 = 4r1
 
  ----jGRASP: operation complete.
 
     
  ----jGRASP exec: java Divison
 Enter the first number: 7
 Enter the second number: 24
 24 divided by 7 = 3r3
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Divison
 Enter the first number: 35
 Enter the second number: 6
 35 divided by 6 = 5r5
 
  ----jGRASP: operation complete.
*****************************************/


