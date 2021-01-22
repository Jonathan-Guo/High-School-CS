/******************************************************************************
* Name:  Jonathan Guo
* Period:   5
* Date: 12/3/19
 
* What I learned: 
 - how to create a stack and modify a stack by using the push and pop methods
 - how to print information out from a stack and how to access information since it is linear
   
* How I feel about this lab: I feel that this lab helped me learn the basics of stacks and was good practice

* What I wonder: 
   - When would we use stacks versus other lists such as linked lists or arraylists
* Credits:  
   None
*********************************************************************************/

import java.io.*;
import java.util.*;
public class Pd5GuoJonathanTextEditor
{
   public static void main (String [] args)
   {
      Scanner sc = new Scanner (System.in);
      boolean again = true;
      while (again)
      {
         System.out.print ("\nEnter a line of text: ");
         String s = sc.nextLine();
         Stack <String> stk = new Stack <String> ();
         Stack <String> end = new Stack <String> ();
         for (int i = 0; i < s.length(); i++)
         {
            stk.push(s.substring(i, i + 1));
         }
         while (!stk.isEmpty())
         {
            int count = 0;
            while (stk.peek().equals("-"))
            {
               stk.pop();
               count++;
            }
            for (int i = 0; i < count; i ++)
            {
               stk.pop();
            }
            if (stk.peek().equals("$"))
            {
               while (!stk.isEmpty())
                  stk.pop();
            }
            else
            {
               String temp = stk.peek();
               end.push(temp);
               stk.pop();
            }
         }
         System.out.print ("Here is the line you entered: ");
         while (!end.isEmpty())
            System.out.print(end.pop());
         System.out.println();
         System.out.print ("\nAgain (y/n)? ");
         if (sc.nextLine().equals("n"))
            again = false;
      }
   }
   
}
/*
Ouputs:
 
  ----jGRASP exec: java Pd5GuoJonathanTextEditor
 
 Enter a line of text: Ca-noe$Ra3-fx-t
 Here is the line you entered: Raft
 
 Again (y/n)? y
 
 Enter a line of text: AP$$-Compp-utee-r Sic--cei--ience
 Here is the line you entered: Computer Science
 
 Again (y/n)? n
 
  ----jGRASP: operation complete.
 
*/