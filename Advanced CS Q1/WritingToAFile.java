import java.io.*;
import java.util.*;

public class WritingToAFile
{
   public static void main(String argv[])throws IOException
   {
      System.out.print ("Name of the output file: ");
      Scanner input = new Scanner (System.in);
      String name = input.next();
      
      File outputFile = new File (name);
      if (outputFile.exists())
      {
         System.out.println (name + "already exists");
         System.out.println (1);
      }
      
   
      PrintWriter pw = new PrintWriter (outputFile);	
      // write formatted output to the file
      pw.println ("2");           // number of lines in the file
      pw.print("123 ");
      pw.println ("John Smith");
      
      pw.print("678 ");
      pw.println ("Paul Simon");
      pw.close();		
   
   } // main
} // ReadingFromFiles