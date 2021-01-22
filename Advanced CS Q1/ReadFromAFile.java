import java.io.*;
import java.util.*;

/***************  aug31_2 file content ********************
2
123 John Smith
678 Paul Simon
**********************************************************/
public class ReadFromAFile
{
   public static void main(String argv[])throws IOException
   {
      System.out.print ("Name of the input file: ");  // enter aug31_2
      Scanner input = new Scanner (System.in);
      String name = input.next();
      
      File inFile = new File (name);
      if (!inFile.exists())
      {
         System.out.println (name + " does not exist");
         System.exit(1);
      }
      
      Scanner in = new Scanner (inFile);
      // start reading information from inFile
      int  numOfLines = Integer.parseInt(in.nextLine());
      
      for (int i = 0; i < numOfLines ; i++)
      {
         System.out.print (in.nextInt());
         System.out.println (in.nextLine());
      } 
   } // main
} // ReadFromAFile