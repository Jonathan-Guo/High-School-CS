/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: EmployeeNames
Purpose of Program: Generate a list of employee names based on their last name

What I learned: 
- That when identifying the length of an item in an array, you still call it with the parenthesis. Ex: last[i].length()
- When returning the array you only return the name not the brackets too
- When you initiate an array and already know the values in it, you do not need to say "new" in the declaration
- I learned how to avoid the out of bounds error when the last names array is not full by using an if statement to check if it was empty

Credits:
- No one helped me
******************************************************************/
public class EmployeeNames
{
   private String [] last = new String [10]; 
   public static String [] convertName (String [] last)
   {
      for (int i = 0; i < last.length; i++)
      {
         if (!(last[i].equals ("")))
         {
            String first = last[i].substring (last[i].length() - 1);
            String middle = last[i].substring (last[i].length() - 2, last[i].length() - 1);
            last[i] = first + ". " + middle + ". " + last[i];
         }
      }
      return last;
   }
}