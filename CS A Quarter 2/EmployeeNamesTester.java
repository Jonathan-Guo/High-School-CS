import java.util.Scanner;

public class EmployeeNamesTester
{
   public static void main (String [] args)
   {
      Scanner console = new Scanner (System.in);
      //String [] lastNames = {"Lopez", "Smith", "Guo", "Banerji", "Badger", "White", "Tikhe"};
      String [] lastNames = new String [7];
      for (int i = 0; i < lastNames.length; i++)
      {
         System.out.print ("Enter the employee last name: ");
         lastNames [i] = console.nextLine();
      }
      String [] formattedNames = new String [lastNames.length];
      formattedNames = EmployeeNames.convertName (lastNames); 
      System.out.println ("\nEmployee Names:"); 
      for (int i = 0; i < formattedNames.length; i++)
         System.out.println (formattedNames[i]);
   }
}

/*
Outputs:
 
  ----jGRASP exec: java EmployeeNamesTester
 Enter the employee last name: Lopez
 Enter the employee last name: Smith
 Enter the employee last name: Guo
 Enter the employee last name: Banerji
 Enter the employee last name: Badger
 Enter the employee last name: White
 Enter the employee last name: Tikhe
 
 Employee Names:
 z. e. Lopez
 h. t. Smith
 o. u. Guo
 i. j. Banerji
 r. e. Badger
 e. t. White
 e. h. Tikhe
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java EmployeeNamesTester
 Enter the employee last name: Lau
 Enter the employee last name: Lopez
 Enter the employee last name: Smith
 Enter the employee last name: 
 Enter the employee last name: 
 Enter the employee last name: Guo
 Enter the employee last name: 
 
 Employee Names:
 u. a. Lau
 z. e. Lopez
 h. t. Smith
 
 
 o. u. Guo
 
 
  ----jGRASP: operation complete.
 
*/