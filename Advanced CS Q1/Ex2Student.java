public class Ex2Student
{
   public static void first()  throws MyException
   {
      second();
   } // first

   public static void second() throws MyException 
   {
      third();
   }
   
   public static void third() throws MyException 
   {
      throw new MyException ("yours");
      
   }
   
   public static void main (String [] args) 
   {

         try
         {
         first();
         }
         catch (MyException e)
         {}

      System.out.println ("In main and after first");
   }
}  // Ex2Student

class MyException extends Exception {
    
    /** Constructor: an instance with message m*/
   public MyException(String m) {
      super(m);
   }
    
    /** Constructor: an instance with no message */
   public MyException() {
      super();
   }
}


