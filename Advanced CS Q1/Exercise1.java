import java.io.*;
import java.util.*;
public class Exercise1
{
   public static void main (String [] args) throws IOException
   {
      System.out.print ("Name of the input file: ");  
      Scanner input = new Scanner (System.in);
      String name = input.next();
      
      File file = new File (name);
      if (!file.exists())           //checks to see if this file exists
      {
         System.out.println (name + " does not exist");
         System.exit(1);            //exits if file DNE
      }
      
      Scanner sc = new Scanner (file);
      PrintWriter output = new PrintWriter("Test");
      String s1 = sc.nextLine(); n  
      
      while (sc.hasNext())          //checks to see if there is a next line
      {
         String s2 = sc.nextLine();
         if (s2.length() > 0 && s2.charAt(s2.length() - 1) == '{') //check to see if the line is only the brace
         {
            s1 = s1 + "{";          //adds brace to previous line
            s2 = "";                //empties line with brace
            System.out.print(s1);   //Test in console
            output.print(s1);       //output line with brace 
         }
         else
         {
            System.out.println(s1);
            output.println(s1);     //prints out normal line
         }
         s1 = s2;                   //set s1 to next line
      } 
      System.out.print(s1);         
      output.print(s1);             //prints out final brace since while loop ends one early
      output.close();               //closes printwriter
   }
}

/*Output:
 
  ----jGRASP exec: java Exercise1
 Name of the input file: Test.java
 public class Test{
    public static void main (String [] args){
    }
 }
  ----jGRASP: operation complete.
 
*/