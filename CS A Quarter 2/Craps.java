/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Craps

What I learned: I learned how to call an instance method through an object and also how to use variables 
like setPoint to keep track of an important value. Furthermore, this lab allowed tme to practice using the 
break statement as well as creating a boolean variable to keep track of whether or not the user had won.
******************************************************************/
public class Craps{

   private int side;
      
   public Craps ()
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
      Dice a = new Dice ();
      Dice b = new Dice ();
      int sum;
      int setPoint;
      boolean win = false;
      
      System.out.println ("Welcome to our Craps game extraordinaire!");
      System.out.println ("Here's how you play.");
      System.out.println ("A first roll of 7 or 11 wins.");
      System.out.println ("A first roll of 2 or 12 loses.");
      System.out.println ("Any other first roll becomes the set point");
      System.out.println ("Subsequent rolls of 7 or 11 lose.");
      System.out.println ("On subsequent rolls the set point wins!");
      System.out.println ("You are limited to 5 rolls max.");
      System.out.println ("Here's what happened for you!");
      
      a.roll();
      b.roll();
      setPoint = a.currentSide() + b.currentSide();
      
      for (int k = 1; k<= 5; k++)
      {
         //a.roll();
         //b.roll();
         System.out.println ("\nROLL #" + k + "\nYou rolled a: " + a.currentSide() + " and " + b.currentSide());
         sum = a.currentSide() + b.currentSide();
         if (k == 1 && (sum == 7 || sum == 11))
         {
            System.out.print ("Game Over, You WON in " + k + " rolls!\nThanks for playing!");
            win = true;
            break; 
         }
         else if (k == 1 && (sum == 2 || sum == 12))
         {
            System.out.println ("I am sorry - you rolled a " + sum + " to lose.\nThanks for playing!");
            System.out.print ("\nGame over, you LOST in " + k + " roll");
            break;
         }
         else if (k == 1)
         {
            System.out.println ("Your set point is " + sum);
         
         }
         else if (sum == 7 || sum == 11)
         {
            System.out.println ("I am sorry - you rolled a " + sum + " to lose.\nThanks for playing!");
            System.out.print ("\nGame over, you LOST in " + k + " rolls");
            break;
         }
         else if (a.currentSide() + b.currentSide() == setPoint)
         {
            System.out.print ("\nGame Over, You WON in " + k + " rolls!\nThanks for playing!");
            win = true;
            break;
         }
         else if (k == 5 && win == false)
         {
            System.out.print ("Game over, you LOST because you ran out of rolls");
         }
         a.roll();
         b.roll();
      }
   }
}

/*
Outputs:

  ----jGRASP exec: java Craps
 Welcome to our Craps game extraordinaire!
 Here's how you play.
 A first roll of 7 or 11 wins.
 A first roll of 2 or 12 loses.
 Any other first roll becomes the set point
 Subsequent rolls of 7 or 11 lose.
 On subsequent rolls the set point wins!
 You are limited to 5 rolls max.
 Here's what happened for you!
 
 ROLL #1
 You rolled a: 3 and 1
 Your set point is 4
 
 ROLL #2
 You rolled a: 1 and 1
 
 ROLL #3
 You rolled a: 6 and 4
 
 ROLL #4
 You rolled a: 5 and 4
 
 ROLL #5
 You rolled a: 3 and 6
 Game over, you LOST because you ran out of rolls
  ----jGRASP: operation complete.
 

 
  ----jGRASP exec: java Craps
 Welcome to our Craps game extraordinaire!
 Here's how you play.
 A first roll of 7 or 11 wins.
 A first roll of 2 or 12 loses.
 Any other first roll becomes the set point
 Subsequent rolls of 7 or 11 lose.
 On subsequent rolls the set point wins!
 You are limited to 5 rolls max.
 Here's what happened for you!
 
 ROLL #1
 You rolled a: 2 and 1
 Your set point is 3
 
 ROLL #2
 You rolled a: 5 and 5
 
 ROLL #3
 You rolled a: 6 and 5
 I am sorry - you rolled a 11 to lose.
 Thanks for playing!
 
 Game over, you lost in 3 rolls
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Craps
 Welcome to our Craps game extraordinaire!
 Here's how you play.
 A first roll of 7 or 11 wins.
 A first roll of 2 or 12 loses.
 Any other first roll becomes the set point
 Subsequent rolls of 7 or 11 lose.
 On subsequent rolls the set point wins!
 You are limited to 5 rolls max.
 Here's what happened for you!
 
 ROLL #1
 You rolled a: 6 and 4
 Your set point is 10
 
 ROLL #2
 You rolled a: 6 and 6
 
 ROLL #3
 You rolled a: 5 and 3
 
 ROLL #4
 You rolled a: 2 and 3
 
 ROLL #5
 You rolled a: 5 and 5
 
 Game Over, You Won in 5 rolls!
 Thanks for playing!
  ----jGRASP: operation complete.
 

  ----jGRASP exec: java Craps
 Welcome to our Craps game extraordinaire!
 Here's how you play.
 A first roll of 7 or 11 wins.
 A first roll of 2 or 12 loses.
 Any other first roll becomes the set point
 Subsequent rolls of 7 or 11 lose.
 On subsequent rolls the set point wins!
 You are limited to 5 rolls max.
 Here's what happened for you!
 
 ROLL #1
 You rolled a: 5 and 6
 Game Over, You WON in 1 rolls!
 Thanks for playing!
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Craps
 Welcome to our Craps game extraordinaire!
 Here's how you play.
 A first roll of 7 or 11 wins.
 A first roll of 2 or 12 loses.
 Any other first roll becomes the set point
 Subsequent rolls of 7 or 11 lose.
 On subsequent rolls the set point wins!
 You are limited to 5 rolls max.
 Here's what happened for you!
 
 ROLL #1
 You rolled a: 3 and 2
 Your set point is 5
 
 ROLL #2
 You rolled a: 2 and 1
 
 ROLL #3
 You rolled a: 1 and 4
 
 Game Over, You WON in 3 rolls!
 Thanks for playing!
  ----jGRASP: operation complete.
 
*/