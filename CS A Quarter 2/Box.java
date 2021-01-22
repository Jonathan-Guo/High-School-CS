/*
Jonathan Guo     Period: 8

purpose: 
*/

public class Box
{
   private int width, length, height;
   
   public Box ()
   {
      // same as: width = 1; length = 1; height = 1;
    -  this.width = 1; this.length = 1; this.height = 1;
   }
   
   public Box (int width, int length, int height)
   {
      this.width = width;
      this.length = length;
      this.height = height;
   }
   
   
   public String toString ()
   {
      return "\nWidth: " + width +
             "\nLength: " + length +
             "\nHeight: " + height;
   }
   
   
   public static void main (String [] args)
   {
      Box defaultBox = new Box ();
      Box box = new Box (1, 2, 3);
      
      System.out.println (defaultBox);
      System.out.println (box);
      
   }  // end of main method
} // end of Box class

/*
Ouput:

Box@2c13da15
Box@77556fd/


Width: 1
Length: 1
Height: 1

Width: 1
Length: 2
Height: 3
//8444
*/
