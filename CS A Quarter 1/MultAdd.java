/*********************************************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: MultAdd 
Purpose of Program: The purpose of the program is to multiply 2 doubles together (a and b), 
and then add the value of another double (c) to the product of a and b.

What I learned: I learned how to use a whole new variety of Math functions in java
such as Math.log and Math.sin in order to compute a value using those mathematical 
operations. I also learned that you can call a method in other methods beside the main method.

Credits: I used stack.overflow.com to help me learn how to use log in java.
*********************************************************************************************/
public class MultAdd
{
   public static void main (String [] args)
   {
      System.out.println ("multAdd (1,2,3) = " + multAdd (1., 2., 3.)); 
      System.out.println ("multAdd (sin (pi/4) + (cos pi/4)/2) = " + multAdd (Math.cos (Math.toRadians (45)), .5, Math.sin (45 * Math.PI / 180.0)));
      System.out.println ("multAdd (log 10 + log 20) = " + multAdd (Math.log (10), 1.0, Math.log (20)));
      
      System.out.println ("yikes (0) = " + yikes (0.0));  
      System.out.println ("yikes (1) = " + yikes (1.0)); 
       
   }
   
   public static double multAdd (double a, double b, double c)
   {
      return (a * b + c);  
   }
   
   public static double yikes (double x)
   {
      return multAdd (x, Math.exp (-x), Math.sqrt (1 - Math.exp (-x))) ;
   } 
}

/***************************************************************
Ouputs:

multAdd (1,2,3) = 5.0
multAdd (sin (pi/4) + (cos pi/4)/2) = 1.0606601717798212
multAdd (log 10 + log 20) = 5.298317366548037
yikes (0) = 0.0
yikes (1) = 1.1629395387920924
***************************************************************/