/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Dice
Purpose of Program: Simulate rolling a dice and print out the die's current side

What I learned: I learned how to use the Math.random() operator and how to 
create the interval for which a random number can be generated between.
******************************************************************/
public class Dice 
{
   private int side;
      
   public Dice ()
   {
      side = 1;
   }
   
   public void roll ()
   {
      side = (int) (Math.random() * 6 + 1); 
   }
   
   public int currentSide ()
   {
      return side;
   }
   
   public static void main (String [] args)
   {
      Dice d = new Dice ();
      System.out.println (d.currentSide());
      
      for (int k = 1; k<= 5; k++)
      {
         d.roll();
         System.out.println ("\nCurrent side: " + d.currentSide());
      }
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Dice
 1
 
 Current side: 2
 
 Current side: 6
 
 Current side: 1
 
 Current side: 2
 
 Current side: 4
 
  ----jGRASP: operation complete.
 

 
  ----jGRASP exec: java Dice
 1
 
 Current side: 4
 
 Current side: 1
 
 Current side: 2
 
 Current side: 5
 
 Current side: 1
 
  ----jGRASP: operation complete.
 


*/