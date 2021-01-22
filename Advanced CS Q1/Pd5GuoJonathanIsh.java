import java.util.Scanner;  
public class Pd5GuoJonathanIsh extends Work4
{
   public static void main (String [] args)
   {
      Scanner sc = new Scanner (System.in);
   
      System.out.println ("Input string");
      System.out.println ("Is elfish? " + elfish (sc.nextLine()));
      
      System.out.println ("\nInput 1st string");
      String string1 = sc.nextLine();
      System.out.println ("Input 2nd string");
      String string2 = sc.nextLine();
      System.out.print ("Is xIsh? "+ xIsh (string1, string2));

   }
}

/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanIsh
 Input string
 flesh
 Is elfish? true
 
 Input 1st string
 hello
 Input 2nd string
 ollasdeh
 Is xIsh? true
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Pd5GuoJonathanIsh
 Input string
 f l ish
 Is elfish? false
 
 Input 1st string
 hi
 Input 2nd string
 hello
 Is xIsh? false
  ----jGRASP: operation complete.
 

*/