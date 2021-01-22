
public class Ex1Student
{
   private class MyException extends Exception 
   {
    
    /** Constructor: an instance with message m*/
      public MyException(String m) {
         super(m);
      }
    
    /** Constructor: an instance with no message */
      public MyException() {
         super();
      }
   }
   public static void first() 
   {
      second();
   } // first

   public static void second()  
   {
      try {
         int [] a = new int [2];
         a[0] = 1;
         a[3] = 3;
         third ();
         
      }
      catch (ArrayIndexOutOfBoundsException e)   // what should we put here?
      {
         System.out.println ("here!");
      }
      catch (ArithmeticException e)  // what should we put here?
      {
         System.out.println ("Got you! and the Exception is: " + e.toString());
      }
      finally
      {
         System.out.println ("Finally!");
      }
   } //
   
   public static void third() //throws ArithmeticException
   {
      throw new ArithmeticException ("Oh, no!");
   }
   
   public static void main (String [] args) //throws ArithmeticException
   {
      first();
      System.out.println ("In main and after first");
   } // main
}  // Ex1Student
/********************** Outputs   *******************

 ----jGRASP exec: java Ex1
 here!
 Finally!
 In main and after first
 
  ----jGRASP: operation complete.


*****************************************************/