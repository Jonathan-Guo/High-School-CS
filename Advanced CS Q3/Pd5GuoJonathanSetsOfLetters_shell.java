//Name: Jonathan Guo  
//Date: 3/8/2020
// What I learned:
// - I learned how to use the addAll() and retainAll() methods to figure out the common lower case letters. To retain information in the set that is repeated in the next line.
// - I learned how to create a set and the methods add and clear to modify data in the set
//  
// How I feel about this lab:
// - I feel like I am comfortable with set methods and the basics of how to modify a set and display information from a set.
// What I wonder:
// - I wonder when which type of set would be best to implement. When should I use a treeset verses a hashset
// Question:  If Java didn't implement Sets, how would you solve this programming problem?  Be creative!
// - If java didn't implement sets, you could solve this programming problem by just using lists.
import java.util.*;
import java.io.*;
public class Pd5GuoJonathanSetsOfLetters_shell
{
   public static void main(String[] args) throws FileNotFoundException
   {
           // for each line read, convert the String to a character array by using toCharArrays() of String class
           // need to create 3 sets of Character:  lower case, upper case, punctuation marks
           
           // for each character in each line, check if it is a letter (use Character.isLetter() AND lower case (use Character.isLowerCase()
           //                                                                                                                                                  upper case  (use Character.isUpperCase()
           //                                                                       otherwise, it is a punctuation mark put each to its corresponding set.
           // 
           // Need to check the common characters in each group:  lower, upper, punctuation marks.
           // You need to use an iterator to iterate over each set.  You might need to use the contains
           // and remove methods of Set.
           
      Scanner sc = new Scanner (new File ("DeclarationLast.txt"));
      int  lines = 16;
      Set<Character> upper = new TreeSet<Character>();
      Set<Character> lower = new TreeSet<Character>();
      Set<Character> other = new TreeSet<Character>();
      Set<Character> commonUpper = new TreeSet<Character>();
      Set<Character> commonLower = new TreeSet<Character>();
      Set<Character> commonOther = new TreeSet<Character>();
      
      for (int i = 0; i < lines; i++)
      {
         String s = sc.nextLine();
         System.out.println (s);
         for(int j = 0; j < s.length(); j++) 
         {
            Character c = s.charAt(j);
            if (Character.isLetter(c) && Character.isUpperCase(c))
            { 
               upper.add(c);
            }
            else if (Character.isLetter(c) && Character.isLowerCase(c)) 
            {
               lower.add(c);
            }
            else 
            {
               other.add(c);
            }
         }    
      
         if (i == 0) 
         {
            commonLower.addAll(lower);
            commonUpper.addAll(upper);
            commonOther.addAll(other);
         }  
         
         System.out.println ("Lower Case: " + lower.toString());
         System.out.println ("Upper Case: " + upper.toString());
         System.out.println ("Other: " + other.toString());
         System.out.println ();
         
         commonUpper.retainAll(upper);
         commonLower.retainAll(lower);
         commonOther.retainAll(other);  
         upper.clear();
         lower.clear();
         other.clear();
      }//end for loop 
      
      System.out.println ("Common Lower Case: " + commonLower.toString());
      System.out.println ("Common Upper Case: " + commonUpper.toString());
      System.out.println ("Common Other: " + commonOther.toString());   	
   }
}
/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanSetsOfLetters_shell
 We, therefore, the Representatives of the united States of 
 Lower Case: [a, d, e, f, h, i, n, o, p, r, s, t, u, v]
 Upper Case: [R, S, W]
 Other: [ , ,]
 
 America, in General Congress, Assembled, appealing to the 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, p, r, s, t]
 Upper Case: [A, C, G]
 Other: [ , ,]
 
 Supreme Judge of the world for the rectitude of our intentions,
 Lower Case: [c, d, e, f, g, h, i, l, m, n, o, p, r, s, t, u, w]
 Upper Case: [J, S]
 Other: [ , ,]
 
 do, in the Name, and by the Authority of the good People of 
 Lower Case: [a, b, d, e, f, g, h, i, l, m, n, o, p, r, t, u, y]
 Upper Case: [A, N, P]
 Other: [ , ,]
 
 these Colonies, solemnly publish and declare, That these United 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, u, y]
 Upper Case: [C, T, U]
 Other: [ , ,]
 
 Colonies are, and of Right ought to be Free and Independent 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, p, r, s, t, u]
 Upper Case: [C, F, I, R]
 Other: [ , ,]
 
 States; that they are Absolved from all Allegiance to the 
 Lower Case: [a, b, c, d, e, f, g, h, i, l, m, n, o, r, s, t, v, y]
 Upper Case: [A, S]
 Other: [ , ;]
 
 British Crown, and that all political connection between them 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, w]
 Upper Case: [B, C]
 Other: [ , ,]
 
 and the State of Great Britain, is and ought to be totally 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, r, s, t, u, y]
 Upper Case: [B, G, S]
 Other: [ , ,]
 
 dissolved; and that as Free and Independent States, they have 
 Lower Case: [a, d, e, h, i, l, n, o, p, r, s, t, v, y]
 Upper Case: [F, I, S]
 Other: [ , ,, ;]
 
 full Power to levy War, conclude Peace, contract Alliances, 
 Lower Case: [a, c, d, e, f, i, l, n, o, r, s, t, u, v, w, y]
 Upper Case: [A, P, W]
 Other: [ , ,]
 
 establish Commerce, and to do all other Acts and Things which 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, r, s, t, w]
 Upper Case: [A, C, T]
 Other: [ , ,]
 
 Independent States may of right do. And for the support of this 
 Lower Case: [a, d, e, f, g, h, i, m, n, o, p, r, s, t, u, y]
 Upper Case: [A, I, S]
 Other: [ , .]
 
 Declaration, with a firm reliance on the protection of divine 
 Lower Case: [a, c, d, e, f, h, i, l, m, n, o, p, r, t, v, w]
 Upper Case: [D]
 Other: [ , ,]
 
 Providence, we mutually pledge to each other our Lives, our 
 Lower Case: [a, c, d, e, g, h, i, l, m, n, o, p, r, s, t, u, v, w, y]
 Upper Case: [L, P]
 Other: [ , ,]
 
 Fortunes and our sacred Honor.
 Lower Case: [a, c, d, e, n, o, r, s, t, u]
 Upper Case: [F, H]
 Other: [ , .]
 
 Common Lower Case: [d, e, n, o, r, t]
 Common Upper Case: []
 Common Other: [ ]
 
  ----jGRASP: operation complete.
 

*/