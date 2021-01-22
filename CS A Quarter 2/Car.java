/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Car
Purpose of Program: To show the user different features of car including its make, year, mileage, and cost

What I learned: I learned how to use the Scanner class to customize a variable such as mileage by 
using a modifier method after the user took the car out for a test drive.
******************************************************************/
import java.util.Scanner;

public class Car
{
   private String make;
   private int year;
   private double mileage;
   private double cost;    
   
   public Car (String make, int year, double mileage, double cost)
   { x
      this.make = make;
      this.year = year;
      this.mileage = mileage;
      this.cost = cost;
   }
   
   public double testDrive (double milesDriven)
   {
      return mileage += milesDriven;
   }
   
   public String toString ()
   {
      return "Car information: \n\nMake: " + make + "\nYear: " + year + "\nMileage: " + mileage + "\nCost: " + cost;   
   }


   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      Car hondaAccord = new Car ("Honda", 2003, 2325.5, 21000);
      System.out.println  (hondaAccord);  
      System.out.println ("\nHow many miles did you test drive the car for?");
      hondaAccord.testDrive (console.nextDouble());
      System.out.println (hondaAccord);
   }
}

/*
Output:
 
  ----jGRASP exec: java Car
 Car information: 
 
 Make: Honda
 Year: 2003
 Mileage: 2325.5
 Cost: 21000.0
 
 How many miles did you test drive the car for?
 50
 Car information: 
 
 Make: Honda
 Year: 2003
 Mileage: 2375.5
 Cost: 21000.0
 
  ----jGRASP: operation complete.
 
*/