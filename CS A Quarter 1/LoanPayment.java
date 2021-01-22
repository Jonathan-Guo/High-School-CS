/*********************************************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Loan Payments
Purpose of Program: The purpose of the program is for you to insert an amount of money
you intend to borrow for an item, the annual interest rate in perecentage of that item, and 
the length of the loan in years. Then the program identifies how much you need to pay per month 
in order to pay off your loans loans.

What I learned: In this lab I learned how to use return statements in double and int methods
in a practical manner. I also learned how to use the DecimalFormat in order to reduce the amount 
of decimals in an answer to the amount of decimals that you want the answer to have.

Credits: Jerry Wei helped me figure out how to use the void method properly since I forgot 
that void methods do not return anything.
*********************************************************************************************/
import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanPayment
{
   private static Scanner console = new Scanner (System.in);
   public static void main (String [] args)
   {
      int years; 
      double amount, rate, payment;
      amount = getAmount ();
      rate = getRate ();
      years = getYears ();
      payment = findPayment (amount, rate, years);
      displayPayment (payment);
   }
   
   public static double getAmount ()
   {
      System.out.print ("Enter amount to be borrowed: ");
      double a = console.nextDouble ();
      if (a < 0 || a > 100000)
      {
         System.out.print ("invalid. Enter Amount: ");
         a = console.nextDouble ();
      }
      return a;
   }  
   
   public static double getRate ()
   {
      System.out.print ("Enter the annual interest rate as a percent: ");
      return console.nextDouble () / 1200 ;
   }
   
   public static int getYears ()
   {
      System.out.print ("Enter the length of the loan in years: ");
      return console.nextInt (); 
   }
   
   public static double findPayment (double amount, double rate, int years)
   {
      return amount * rate * (Math.pow (rate + 1, years * 12.0) / (Math.pow (rate + 1, years * 12.0) - 1));
   }
   
   public static void displayPayment (double payment)
   {
      DecimalFormat d = new DecimalFormat ("0.00");
      System.out.print ("Monthly Payment: $" + d.format(payment));
   }
}

/**************************************************
Outputs:
 
  ----jGRASP exec: java LoanPayment
 Enter amount to be borrowed: 10500
 Enter the annual interest rate as a percent: 9.5
 Enter the length of the loan in years: 4
 Monthly Payment: $263.79
  ----jGRASP: operation complete.
 

  ----jGRASP exec: java LoanPayment
 Enter amount to be borrowed: 50
 Enter the annual interest rate as a percent: 5
 Enter the length of the loan in years: 2
 Monthly Payment: $2.19
  ----jGRASP: operation complete.
 

  ----jGRASP exec: java LoanPayment
 Enter amount to be borrowed: 100000000
 invalid. Enter Amount: 250
 Enter the annual interest rate as a percent: 10
 Enter the length of the loan in years: 3
 Monthly Payment: $8.07
  ----jGRASP: operation complete.
 
**************************************************/
