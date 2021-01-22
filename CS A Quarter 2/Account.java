/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Account Class
Purpose of Program: 
- To learn what return types different types of methods 
- To learn how to write a class with constructors
- To Learn how to create objects

What I learned: I learned how to create new objects such as Account "a" and also how to 
use constructor methods such as deposit and withdraw to keep track of a variable such as balance.
******************************************************************/
import java.util.Scanner;

public class Account 
{
   
   private double balance;
   
   public Account ()
   {
      balance = 0;
   }
   
   public Account (double balance)
   {
      this.balance = balance;
   }
   
   public void withdraw (double amount)
   {
      if (amount > balance)
      {
         System.out.println ("Not enough money in balance, no money is withdrawn.");
      }
      else
      {
         balance -= amount;
      }
   }
   
   public void deposit (double amount)
   {
      balance += amount;
   }
   
   public double checkBalance()
   {
      return balance;
   }
   
   public String toString()
   {
      return "Your current balance is: " + balance;
   }
   
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      Account a = new Account (100);
      
      System.out.print ("Press 0 to withdraw money, 1 to deposit money, and 2 to check the current balance: ");
      int option = console.nextInt();
      if (option == 0)
      {
         System.out.print ("How much money do you wish to withdraw? ");
         a.withdraw(console.nextInt());
      }
      else if (option == 1)
      {
         System.out.print ("How much money do you wish to deposit? ");
         a.deposit(console.nextInt());   
      }
      System.out.print ("Balance is $" + a.checkBalance());   
   }
}

/*
Output:
 
  ----jGRASP exec: java Account
 Press 0 to withdraw money, 1 to deposit money, and 2 to check the current balance: 2
 Balance is $100.0
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Account
 Press 0 to withdraw money, 1 to deposit money, and 2 to check the current balance: 0
 How much money do you wish to withdraw? 50
 Balance is $50.0
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Account
 Press 0 to withdraw money, 1 to deposit money, and 2 to check the current balance: 0
 How much money do you wish to withdraw? 125
 Not enough money in balance, no money is withdrawn.
 Balance is $100.0
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Account
 Press 0 to withdraw money, 1 to deposit money, and 2 to check the current balance: 1
 How much money do you wish to deposit? 300
 Balance is $400.0
  ----jGRASP: operation complete.
 

*/