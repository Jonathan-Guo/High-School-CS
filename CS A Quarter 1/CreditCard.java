/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Credit Card Bill
Purpose of Program: Tells the user the balance of how much money is owed after a certain number of 
months. This calculation is based off of the users inputed amount of money they wish to pay per month.

What I learned: I learned how to use variables more effectively to keep the program organized and use them 
better to store the values of different things. For example, I used the variable monthBefore to store the 
value of the final payment so that when I outputted the final payment I could use that variable instead of 
working backwards to find it.
******************************************************************/
import java.util.Scanner;
import java.text.DecimalFormat;

public class CreditCard
{
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      DecimalFormat d = new DecimalFormat ("0.0");
      int month = 1;
      double balance = 1000;
      double totalPayment = 0;
      double monthBefore = 0;
      System.out.print ("Enter the monthly payment: ");
      double monthPayment = console.nextDouble();
      while (balance > 0)
      {
         if (balance > monthPayment)
         {
            totalPayment = totalPayment + monthPayment;
         }
         else
         {
            totalPayment = totalPayment + balance;
            monthBefore = balance;
         }
         balance = balance + balance * 1.5/100 - monthPayment; 
         System.out.println ("Month: " + month + "\tbalance: " + balance + "\ttotal payments: " + d.format (totalPayment));
         month++;
      }
      System.out.print ("\nFinal payment in the 11th month: " + d.format (monthBefore));  
   }
}

/*
Outputs:
 
  ----jGRASP exec: java CreditCard
 Enter the monthly payment: 100
 Month: 1	balance: 915.0	total payments: 100.0
 Month: 2	balance: 828.725	total payments: 200.0
 Month: 3	balance: 741.155875	total payments: 300.0
 Month: 4	balance: 652.273213125	total payments: 400.0
 Month: 5	balance: 562.057311321875	total payments: 500.0
 Month: 6	balance: 470.4881709917031	total payments: 600.0
 Month: 7	balance: 377.54549355657866	total payments: 700.0
 Month: 8	balance: 283.20867595992735	total payments: 800.0
 Month: 9	balance: 187.4568060993263	total payments: 900.0
 Month: 10	balance: 90.26865819081618	total payments: 1000.0
 Month: 11	balance: -8.377311936321576	total payments: 1090.3
 
 Final payment in the 11th month: 90.3
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java CreditCard
 Enter the monthly payment: 50
 Month: 1	balance: 965.0	total payments: 50.0
 Month: 2	balance: 929.475	total payments: 100.0
 Month: 3	balance: 893.417125	total payments: 150.0
 Month: 4	balance: 856.8183818750001	total payments: 200.0
 Month: 5	balance: 819.6706576031252	total payments: 250.0
 Month: 6	balance: 781.965717467172	total payments: 300.0
 Month: 7	balance: 743.6952032291796	total payments: 350.0
 Month: 8	balance: 704.8506312776173	total payments: 400.0
 Month: 9	balance: 665.4233907467815	total payments: 450.0
 Month: 10	balance: 625.4047416079832	total payments: 500.0
 Month: 11	balance: 584.785812732103	total payments: 550.0
 Month: 12	balance: 543.5575999230845	total payments: 600.0
 Month: 13	balance: 501.7109639219308	total payments: 650.0
 Month: 14	balance: 459.2366283807597	total payments: 700.0
 Month: 15	balance: 416.12517780647113	total payments: 750.0
 Month: 16	balance: 372.3670554735682	total payments: 800.0
 Month: 17	balance: 327.95256130567174	total payments: 850.0
 Month: 18	balance: 282.8718497252568	total payments: 900.0
 Month: 19	balance: 237.11492747113567	total payments: 950.0
 Month: 20	balance: 190.67165138320271	total payments: 1000.0
 Month: 21	balance: 143.53172615395076	total payments: 1050.0
 Month: 22	balance: 95.68470204626001	total payments: 1100.0
 Month: 23	balance: 47.11997257695391	total payments: 1150.0
 Month: 24	balance: -2.1732278343917812	total payments: 1197.1
 
 Final payment in the 11th month: 47.1
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java CreditCard
 Enter the monthly payment: 225
 Month: 1	balance: 790.0	total payments: 225.0
 Month: 2	balance: 576.85	total payments: 450.0
 Month: 3	balance: 360.50275	total payments: 675.0
 Month: 4	balance: 140.91029125	total payments: 900.0
 Month: 5	balance: -81.97605438125001	total payments: 1040.9
 
 Final payment in the 11th month: 140.9
  ----jGRASP: operation complete.
 
*/