public class TriangleDriver
{
   public static void main (String [] args)
   {
      try
      {
         Triangle t = new Triangle (10, 2, 2);
      }
      catch (IllegalTriangleException e)
      {
         System.out.println ("Illegal Triangle try again");
      }
      
   
   }
}