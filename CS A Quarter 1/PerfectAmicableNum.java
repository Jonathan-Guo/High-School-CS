/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: Perfect and Amicable Numbers
Purpose of Program: To find all perfect numbers between 2 and 500 
inclusive, and to find all amicable pairs between 2 and 500 inclusive.

What I learned: I learned how to use nested for loops and also how to 
write a boolean method that returns true or false.
******************************************************************/
public class PerfectAmicableNum
{
   public static void main (String [] args)
   {
      System.out.print ("Perfect numbers between 2 and 500 inclusive are: ");
      for (int i = 2; i <= 500; i++)
      {
         if (isPerfect(i))
            System.out.print (i + " ");
      }
      System.out.println ("\nAmicable pairs between 2 and 500 inclusive are: ");
      for (int j = 2; j <= 500; j++)
      {
         for(int k = 2; k <= 500; k++)
         {
            if (aliquotSum(j) == k && aliquotSum(k) == j)
               System.out.println (j + ", " + k);
         }
      }

   }
   
   public static int aliquotSum (int n)
   {  
      int sum = 0;
      for (int i = 1; i < n; i++)
      {
         if (n % i == 0)
         {
            sum += i;
         }
      }   
      return sum;
   }
   
   public static boolean isPerfect (int n)
   {
      if (aliquotSum(n) == n)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}

/*
Output:
 
  ----jGRASP exec: java PerfectAmicableNum
 Perfect numbers between 2 and 500 inclusive are: 6 28 496 
 Amicable pairs between 2 and 500 inclusive are: 
 6, 6
 28, 28
 220, 284
 284, 220
 496, 496
 
  ----jGRASP: operation complete.
 

*/