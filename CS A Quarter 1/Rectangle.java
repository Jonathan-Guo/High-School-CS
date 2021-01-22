/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Rectangle  
Purpose of Program: To output the area and perimeter of a rectangle
when the user inputs the width and length of the rectangle.

What I learned: In this lab, I learned how to import the scanner class and
use it so that the user could input values for a rectangle. I also learned that
you can declare multiple variables in the same line of code.
Credits: No one helped me
******************************************************************/
import java.util.Scanner;

public class Rectangle
{
   public static void main (String [] args) 
   {
      Scanner console = new Scanner (System.in);
      int width, length;
      int area, perimeter;      
      System.out.println ("Enter width: ");
      width = console.nextInt();  
      System.out.println ("Enter length: ");
      length = console.nextInt();    
      area = width * length;
      System.out.println("The area of the rectangle is: " + area);
      perimeter = 2 * (width + length);
      System.out.println("The perimeter of the rectangle is: " + perimeter);
   }  
}