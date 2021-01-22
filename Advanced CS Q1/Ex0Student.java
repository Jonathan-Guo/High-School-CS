// Things you are supposed to experience:
// 1. When a checked Exception is thrown in a method, that method
//    must declarethat exception in its method header by using "throws"
// 2. The method that calls the method that throws a checked Exception
//    must also have the "throws" in its method header if the caller
//    does not catch that exception
// 3. If a program never deals with an exception (run-time or checked exception)
//    thrown internally, the program will experience a run time exception error.
public class Ex0Student
{
   public static void first() throws Exception
   {
      throw new Exception();
   } // first

   public static void main (String [] args) throws Exception
   {
      // place a try-catch block below to get rid of the
      // run time error
   
      try
      {
         first();
      }
      catch (Exception e)
      {
      }
   
      System.out.println ("In main and after first");
   } // main
}  // Ex0

