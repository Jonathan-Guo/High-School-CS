/***********************************************************************
Name: Jonathan Guo     
Period: 5
Date: 12/18   
What I Learned:
 - I learned how to convert an int to a String by using String.valueOf(int)
 - how to use remove(obj)
 - using peek() add() and those methods
           
Credit (person who helped me): None
Student(s) whom I helped (to what extent): None
************************************************************************/    
	
   import java.io.*;
   import java.util.*;
   
   public class Pd5GuoJonathanPrintQueue_Shell
   {
      private static Scanner in;
      private static Queue<String> q;
      private static int jobNumber =100;
      
      public static void main(String[] args) throws Exception
      {
         q = new LinkedList<String>();
         in = new Scanner(System.in);
         String prompt = "Add, Print, Delete, eXit:  ";
         System.out.print(prompt);
         String str = in.next();
         while(!str.equals("X"))
         {
            if(str.equals("A"))
               add();
            else if(str.equals("P"))
               printJob();  
            else if(str.equals("D"))
               delete();
            else
               System.out.println("   invalid command");
            printQueue();
            System.out.print(prompt);
            str = in.next();
         }
         in.close();
      }
      
      public static void add()
      {
         q.add(String.valueOf(jobNumber));
         jobNumber++;
       }
      public static void printJob()
      {
         System.out.println ("First job is: " + q.peek());
      }
   			
      public static void delete()
      {
         System.out.print ("What job number would you like to delete ");
         int value = in.nextInt();
         q.remove(String.valueOf(value));
         
      }
      public static void printQueue()
      {
         System.out.println (q);
      }
   }