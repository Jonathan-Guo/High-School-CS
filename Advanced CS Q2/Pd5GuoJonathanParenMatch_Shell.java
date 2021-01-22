/***********************************************************************
Name: Jonathan Guo      
Period: 5
Date: 12/8/19    
What I Learned: How to use a stack and compare values in the stack to the value in the string. Then, by popping values in the stack and
eventually ending with an empty stack, you can tell that the parentheses do match up properly.

Credit (person who helped me): None
Student(s) whom I helped (to what extent): None
************************************************************************/   
import java.util.*;
public class Pd5GuoJonathanParenMatch_Shell
{
   public static final String left  = "([{<";
   public static final String right = ")]}>";
   public static void main(String[] args)
   {
   
      System.out.println("Enter an expression with grouping symbols,");
      System.out.println("such as (2+3)-[5*(6+1)]IndexMals");
      Scanner keyboard = new Scanner(System.in);
      String s = keyboard.next();  
      while(!s.equals("-1"))
      {
         boolean flag = check(s);
         if(flag)
            System.out.println(s + " is good.");
         else
            System.out.println("No, no, no.  Bad.  " + s);
         System.out.println();
         s = keyboard.next();
      }
   }
   // precondition: String is entered
   // postcondition: returns true if grouping symbols match, false if they don't.
   public static boolean check(String s)
   {
      Stack <String> stk = new Stack <String> ();
      for (int i = 0; i < s.length(); i++)
      {
         if (left.contains(s.substring (i, i + 1)))
         {
            stk.push(s.substring (i, i + 1));
         }
         else if (right.contains(s.substring (i, i + 1)))
         {
            if (stk.isEmpty())
            {
               return false;
            }             
            else if ((stk.peek().equals("(") && s.substring(i, i + 1).equals(")")) || (stk.peek().equals("[") && s.substring(i, i + 1).equals("]")) || (stk.peek().equals("{") && s.substring(i, i + 1).equals("}")) || (stk.peek().equals("<") && s.substring(i, i + 1).equals(">")))
            {
               stk.pop();
            }
            else
            {
               return false;
            }
         }
      }
      if (stk.isEmpty())
         return true;
      else
         return false;
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanParenMatch_Shell
 Enter an expression with grouping symbols,
 such as (2+3)-[5*(6+1)]IndexMals
 5+7
 5+7 is good.
 
 (5+7)
 (5+7) is good.
 
 )5+7(
 No, no, no.  Bad.  )5+7(
 
 ((5+7)*3) 
 ((5+7)*3) is good.
 
 [(5+7)*]3
 [(5+7)*]3 is good.
 
 <{5+7}*3>
 <{5+7}*3> is good.
 
 (5+7)*3
 (5+7)*3 is good.
 
 5+(7*3) 
 5+(7*3) is good.
 
 ((5+7)*3 
 No, no, no.  Bad.  ((5+7)*3
 
 [(5+7]*3)
 No, no, no.  Bad.  [(5+7]*3)
 
 [(5+7)*3])
 No, no, no.  Bad.  [(5+7)*3])
 
 ([(5+7)*3]
 No, no, no.  Bad.  ([(5+7)*3]
 
 

*/