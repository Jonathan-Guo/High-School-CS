/**
Name: Jonathan Guo
Due: 10/9/19
Date Submitted: 10/10/19
What I learned:  
 - In the power of three method I need to have a case to check if x == 0 and return false otherwise the code would never end
 - I learned how to write the base 5 method by using the mod operator to store the value in terms of base 5 and printing it at the end of the recursive call so that the digits are printed in the correct order
 - I learned that for void recursive methods you need to use an if else statement since it does not return anything and all the code will always be run
 - I learned how to convert from a long to a string using String.getValueOf (long)
 
How I feel about this lab: 
 - I feel like this lab was relatively simple but was very helpful because it introduced me to new concepts of returning a String when the parameter of the method is not a String.
 - I feel that this was very good practice with recursive methods and showed me how writing recursively can sometimes be much easier than using iteration

What I wonder: Do I have to use String.getValueOf(long) for the reverse method or is there another way of writing the method without having to convert the long value to a String

Credits (person/websites and which part of your lab you got help from):  

https://www2.cs.arizona.edu/~mercer/Presentations/17B-RecursiveNumberConversion.pdf
   - This website helped me with the logic to learn how to use the mod operator in the base5 method to print the inputted value in terms of base 5. The website showed me how to 
     print the remainder from the mod operator and how to call the method again so that it works in terms of any base. I then adapted this logic to the base5 method. 
     
https://javadevnotes.com/java-long-to-string-examples
    - Showed me how to convert from a long to a string

Students I helped: None
**/
import java.util.Scanner;   
public class Pd5GuoJonathanRecursionLab
{
   //Pre: c is a lower case letter - Post: all lower case letters a-char c are printed 
   public static void letters(char c)
   {
      if (c == 'a')
      {
         System.out.print ('a');
      }
      else
      {
         letters ((char)(c-1));
         System.out.print (c);
      }
   }
	//Pre: none - Post: returns number of times two can go into x
   public static int twos(int x)
   {
      if (x-2 <= 1)
      {
         return 1;
      }
      else
      {
         return 1 + twos (x-2);
      }
      
   }
	//Pre: none - Post: returns if x is a power of 3
   public static boolean powerof3(int x)    {
      if (x == 0)
         return false;      
      if (x == 1)
         return true;
      return (x % 3 == 0 && powerof3 (x/3));
   }
	//Pre: none - Post: returns String of x reversed 
   public static String reverse(long x)
   {
      String s = String.valueOf (x);
      if (s.length() == 1)
         return s;
      return (s.charAt(s.length()-1) + reverse (x / 10));
   }
	//Pre: x > 0 - Post: Prints x in base 5
   public static void base5(int x)
   {
      if (x == 0)
      {
         System.out.print ("");
      }
      else
      {
         base5 (x/5);
         System.out.print (x%5);  
      }
   }
	// Pre: x > 0 - Post: Prints x with commas
   public static void printWithCommas(long x)
   {
      if (x == 0)
      {
         System.out.print ("");
      }
      else
      {
         printWithCommas (x/10);
         System.out.print (x%10 + ", ");   
      }
   }
	
	
   public static void main(String []args)
   {
      Scanner scan = new Scanner (System.in);
      int choice;
      do
      {
         System.out.println("\n\n1)Letters"+
                           "\n2)Twos"+
                           "\n3)Power Of 3"+
                           "\n4)Reverse"+
                           "\n5)Base 5"+
                           "\n6)Print With Commas"+
                           "\n7)Exit");
         choice = scan.nextInt();
         if (choice == 1)
         {
            System.out.println("Enter a letter");
            char charA = scan.next().charAt(0);
            if (charA < 'a' || charA > 'z')
               System.out.println("That letter not valid");
            else
               letters(charA);
         }
         else if (choice == 2)
         {
            System.out.println("Enter a number");
            System.out.println(twos(scan.nextInt()));
         }
         else if (choice == 3)
         {
            System.out.println("Enter a number");
            System.out.println(powerof3(scan.nextInt()));
         }
         else if (choice == 4)
         {
            System.out.println("Enter a number");
            System.out.println(reverse(scan.nextLong()));
         }
         else if (choice == 5)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               base5(number);
            else
               System.out.println("That number is not valid");
         }
         else if (choice == 6)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               printWithCommas(number);
            else
               System.out.println("That number is not valid");
         }
      }while(choice != 7);
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanRecursionLab
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 1
 Enter a letter
 z
 abcdefghijklmnopqrstuvwxyz
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 2
 Enter a number
 20
 10
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 2
 Enter a number
 21
 10
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 3
 Enter a number
 81
 true
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 3
 Enter a number
 70
 false
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 4
 Enter a number
 12345678
 87654321
 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 5
 Enter a number
 24
 44
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 5
 Enter a number
 25
 100
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 6
 Enter a number
 12345678
 1, 2, 3, 4, 5, 6, 7, 8, 
 
 1)Letters
 2)Twos
 3)Power Of 3
 4)Reverse
 5)Base 5
 6)Print With Commas
 7)Exit
 7
 
  ----jGRASP: operation complete.
 
*/