/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Dispenser
Purpose of Program: To output the correct amount of change and correct coins
when a vending machine item under $1 is bought.

What I learned: In this lab, I learned how to use the mod operator effectively
instead of repeatedly using the division operator. This allowed me to reach the
same result with much simpler code.
Credits: Worksheet 3 and Class Notes
******************************************************************/
import java.util.Scanner;

public class Dispenser
{
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      int cost, change, quarters, dimes, nickels, pennies; 
              
      System.out.println ("Price of item (in cents): ");
      
      cost = console.nextInt();
      change = 100 - cost;
      quarters = change / 25;
      dimes = change % 25 / 10; 
      nickels = change % 25 % 10 / 5;
      pennies = change % 25 % 10 % 5;
           
      System.out.println ("You bought an item for " + cost + 
      " cent(s) and gave me a dollar, so your change is:\n");
      
      System.out.println (quarters + " quarter(s), " + dimes + 
      " dime(s), " + nickels + " nickel(s), " + pennies + " penny(ies)");   
   }    
}
/**************************************************************************** 
   Price of item (in cents): 
   31
   You bought an item for 31 cent(s) and gave me a dollar, so your change is:

   2 quarter(s), 1 dime(s), 1 nickel(s), 4 penny(ies)
****************************************************************************/

