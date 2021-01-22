/*********************************************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Baggage Burgers
Purpose of Program: To print out the take-home pay of an employee who works an inputted 
number of hours after factoring in the hourly pay and taxes.

What I learned: I learned how to use variables in the for loop and how to use a total 
variable to keep track of the total amount of money earned.

Credits: Akshath Burra taught me the logic behind using a total variable to store all the 
values created from the for loop to print the final amount of all 4 weeks.
*********************************************************************************************/
import java.util.Scanner;
import java.text.DecimalFormat;

public class Burger
{
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      DecimalFormat d = new DecimalFormat ("0.000");
      double total = 0;
      for (int week = 1; week < 5; week++)
      {
         System.out.print ("How many hours did you work in week " + week + "? ");
         int hours = console.nextInt();
         double wage = hours * 5.15 - hours * 5.15 * .30;
         total = total + wage;
         System.out.println ("Your take-home pay is: $" + d.format (wage) + "\n");   
      }
      System.out.println ("Your total pay for the month is $" + d.format (total));
      System.out.print ("Hope you enjoy working at Baggage Burgers!");
   }
}

/*
Outputs: 

  ----jGRASP exec: java Burger
 How many hours did you work in week 1? 35
 Your take-home pay is: $126.175
 
 How many hours did you work in week 2? 41
 Your take-home pay is: $147.805
 
 How many hours did you work in week 3? 37
 Your take-home pay is: $133.385
 
 How many hours did you work in week 4? 45
 Your take-home pay is: $162.225
 
 Your total pay for the month is $569.59
 Hope you enjoy working at Baggage Burgers!
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Burger
 How many hours did you work in week 1? 45
 Your take-home pay is: $162.225
 
 How many hours did you work in week 2? 50
 Your take-home pay is: $180.250
 
 How many hours did you work in week 3? 35
 Your take-home pay is: $126.175
 
 How many hours did you work in week 4? 45
 Your take-home pay is: $162.225
 
 Your total pay for the month is $630.875
 Hope you enjoy working at Baggage Burgers!
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Burger
 How many hours did you work in week 1? -20
 Your take-home pay is: $-72.100
 
 How many hours did you work in week 2? -10
 Your take-home pay is: $-36.050
 
 How many hours did you work in week 3? 5
 Your take-home pay is: $18.025
 
 How many hours did you work in week 4? 10
 Your take-home pay is: $36.050
 
 Your total pay for the month is $-54.075
 Hope you enjoy working at Baggage Burgers!
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Burger
How many hours did you work in week 1? 0
Your take-home pay is: $0.000

How many hours did you work in week 2? 0
Your take-home pay is: $0.000

How many hours did you work in week 3? 0
Your take-home pay is: $0.000

How many hours did you work in week 4? 0
Your take-home pay is: $0.000

Your total pay for the month is $0.000
Hope you enjoy working at Baggage Burgers!
 ----jGRASP: operation complete.
*/