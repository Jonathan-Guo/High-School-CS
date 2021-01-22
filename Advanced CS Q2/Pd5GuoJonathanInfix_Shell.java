/***********************************************************************
Name: Jonathan Guo      
Period: 5
Date: 12/10/19   
What I Learned:   
- how to check if it was a parenthesis and then pop it without adding it to the new string
- the logic behind the conditions when to push an operator into the stack as opposed to popping an operator         
Credit (person who helped me): None
Student(s) whom I helped (to what extent): None
************************************************************************/ 
import java.util.*;
public class Pd5GuoJonathanInfix_Shell
{
   public static void main(String[] args)
   {
      System.out.println("Enter an infix expression, single digits");
      System.out.println("such as 1+2*3 or (1+2)*3");
      Scanner keyboard = new Scanner(System.in);    //  (3*(4+5)-2)/5
      String s = keyboard.next();  
      while (!s.equals ("-1"))
      {
         String  postfixExp = trans(s);
         System.out.println (s + " --> " + postfixExp + " --> " + Pd5GuoJonathanPostfix_Shell.eval (postfixExp) + "\n");
         //System.out.println(s + "  -->  " + postfixExp + "  -->  " + Pd5GuoJonathanPostfix.eval(postfixExp) + "\n");
         s = keyboard.next();  
      }
   }  // end of main
   
   
   public static String trans(String x)
   {
      String operators = "*+-/()";
      String lowOp = "+-";
      String highOp = "*/";
      String newS = "";
      Stack <String> stk = new Stack <String> ();
      for (int i = 0; i < x.length(); i ++)
      {
         boolean high = true;
         if (highOp.contains(x.substring(i, i + 1)))
         {
            high = false;
         }
         if (!operators.contains(x.substring(i, i + 1)))
         {
            newS += x.substring (i, i + 1);
         }
         else if (x.substring (i, i + 1).equals (")"))
         {
            while (!stk.peek().equals("("))
            {
               newS += stk.pop();
            }
            stk.pop();
         }
         else// if (operators.contains(x.substring(i, i + 1)))
         {
            if (x.substring(i, i + 1).equals ("("))
            {
               stk.push (x.substring (i, i + 1));
            }
            else if (!stk.isEmpty())
            {
               if (stk.peek().equals("(") || !high)
               {
                  stk.push(x.substring (i, i + 1));
               } 
               else
               {
                  newS += stk.pop();
                  stk.push(x.substring(i, i + 1));               
               }
            }
            else
            {
               stk.push (x.substring (i, i + 1));
            }
         }
      }
      while (!stk.isEmpty())
      {
         newS += stk.pop();
      }
      return newS;
   }  // end of trans
}  // end of Infix_Shell

/*
Outputs:
Enter an infix expression, single digits
 such as 1+2*3 or (1+2)*3
 1+2*3
 1+2*3 --> 123*+ --> 0
 
 
  ----jGRASP exec: java Pd5GuoJonathanInfix_Shell
 Enter an infix expression, single digits
 such as 1+2*3 or (1+2)*3
 (1+2)*3
 (1+2)*3 --> 12+3* --> 0
 
 
  ----jGRASP: process ended by user.
 
  ----jGRASP exec: java Pd5GuoJonathanInfix_Shell
 Enter an infix expression, single digits
 such as 1+2*3 or (1+2)*3
 2*(3+8/2)-5
 2*(3+8/2)-5 --> 2382/+*5- --> 0
 
 
  ----jGRASP: process ended by user.
 
  ----jGRASP exec: java Pd5GuoJonathanInfix_Shell
 Enter an infix expression, single digits
 such as 1+2*3 or (1+2)*3
 1+((2+3)*4+5)*6
 1+((2+3)*4+5)*6 --> 123+4*5+6*+ --> 0
 
 
  ----jGRASP: process ended by user.

 ----jGRASP exec: java Pd5GuoJonathanInfix_Shell
 Enter an infix expression, single digits
 such as 1+2*3 or (1+2)*3
 (3*(4+5)-2)/5
 (3*(4+5)-2)/5 --> 345+*2-5/ --> 0
 
 
  ----jGRASP: process ended by user.
 
*/