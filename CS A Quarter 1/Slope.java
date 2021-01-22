/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Slope  
Purpose of Program: To output the slope when given the coordinates of two points 
and also to identify special cases such as when the slope is vertical or horizontal.

What I learned: In this lab, I learned how to use a class variable by declaring the 
variable Scanner console in the public class Slope. I also learned how to use the 
boolean operator != to evaulate if a number was not equal to another number.
Credits: No one helped me.
******************************************************************/
import java.util.Scanner;

public class Slope
{
   private static Scanner console = new Scanner (System.in);
   public static void main (String [] args)
   {
      double x1, y1, x2, y2, slope, b;
      System.out.print ("Enter the coordinates of point 1 (x, y): ");
      x1 = console.nextInt();
      y1 = console.nextInt();
      
      System.out.print ("Enter the coordinates of point 2 (x, y): ");
      x2 = console.nextInt();
      y2 = console.nextInt();
      slope = (y2 - y1) / (x2 - x1);
      b = y1 - slope * x1;
      
      if (y2 - y1 == 0)
      {
         System.out.println ("Alert! The line is horizontal.\nEquation of the line is: y = " + y1);
      }
      else if (x2 - x1 == 0)
      {
         System.out.println ("Alert! the line is vertical.\nEquation of the line is: x = " + x1);
      }
      else if (y2 - y1 / x2 - x1 != 0)
      {
         System.out.println ("Equation of the line: y = " + slope + "x + " + b );       
      }
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Slope
 Enter the coordinates of point 1 (x, y): 6 -8
 Enter the coordinates of point 2 (x, y): 6 12
 Alert! the line is vertical.
 Equation of the line is: x = 6.0
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Slope
 Enter the coordinates of point 1 (x, y): -3 7
 Enter the coordinates of point 2 (x, y): 5 7
 Alert! The line is horizontal.
 Equation of the line is: y = 7.0
 
  ----jGRASP: operation complete.
 

  ----jGRASP exec: java Slope
 Enter the coordinates of point 1 (x, y): 3 5 
 Enter the coordinates of point 2 (x, y): 5 8
 Equation of the line: y = 1.5x + 0.5
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Slope
 Enter the coordinates of point 1 (x, y): 1 5 
 Enter the coordinates of point 2 (x, y): 3 2
 Equation of the line: y = -1.5x + 6.5
 
  ----jGRASP: operation complete.
 
*/