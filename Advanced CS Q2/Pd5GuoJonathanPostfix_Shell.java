/***********************************************************************
Name: Jonathan Guo     
Period: 5
Date: 12/12    
What I Learned:
   - how to convert a character to string using Character.toString(char)
   - to evaluate postifx you have to use the second popped value and then operate on the first (Ex: 84/ = 8/4)            
Credit (person who helped me): None
Student(s) whom I helped (to what extent): None
************************************************************************/    
import java.util.*;
public class Pd5GuoJonathanPostfix_Shell
{
   public static void main(String[] args)
   {
      System.out.println("Enter a valid postfix expression (single digits only),");
      System.out.println("such as 35*1+");
      Scanner keyboard = new Scanner(System.in);
      String s = keyboard.next();  
      while(!s.equals("-1"))
      { 
         System.out.println(s + "  --->  " + eval(s) + "\n");
      // //        System.out.println((s = "354*+7*") + " = " + eval(s) + "\n");
      // //          System.out.println((s = "82-") + " = " + eval(s) + "\n");
      // //          System.out.println((s = "82/") + " = " + eval(s) + "\n");
         s = keyboard.next();
      }
   }
   public static int eval(String x)
   {
      Stack <Integer> stk = new Stack <Integer> ();
      for (int i = 0; i < x.length(); i++)
      {
         if (!isOperator(x.charAt(i)))
         {
            stk.push(Integer.parseInt(x.substring (i, i + 1)));
         }
         else
         {
            stk.push (eval (stk.pop(), stk.pop(), x.charAt(i)));
         }
      }
      return stk.pop();
   }
   public static int eval(int a, int b, char ch)
   {
      if (ch == '+')
         return b + a;
      else if (ch == '-')
         return b - a;
      else if (ch == '*')
         return b * a;
      else
         return b / a;
   }
   public static boolean isOperator(char ch)
   {
      String operators = "*/+-";
      if (operators.contains(Character.toString(ch)))
         return true;
      return false;      
      }
}

/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanPostfix_Shell
 Enter a valid postfix expression (single digits only),
 such as 35*1+
 35*1+
 35*1+  --->  16
 
 345*+
 345*+  --->  23
 
 34*5+
 34*5+  --->  17
 
 45+53*-
 45+53*-  --->  -6
 
 34+56+*
 34+56+*  --->  77
 
 345+*2-5/
 345+*2-5/  --->  5
 
 812*+93/-
 812*+93/-  --->  7
 

*/