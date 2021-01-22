/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: AbstractWarrior
Purpose of Program: Simulate a warrior showdown between different classes of fighters

What I learned: 
- I learned how to incorporate an empty abstract method in the superclass so that methods with the same name in subclasses could be different
- I learned how to use the superclass constructor in order to make it easier to write the subclass constructors
- I learned the logic behind the while loop to check if the indexes of the two warriors fighting were the same

Credits:
- Jason Borst for teaching me the logic behind using the superclass constructor to reduce repeated code in the subclass constructors

******************************************************************/
import java.util.ArrayList;

public class AbstractWarriorDriver
{
   public static void main (String [] args)
   {
      ArrayList <AbstractWarrior> list = new ArrayList <AbstractWarrior> ();
      list.add (new Nerd ("Lucas"));
      list.add(new Jock ("Jonathan"));
      list.add(new Prep("Josh"));
      list.add(new Thug ("Jason"));
      list.add (new Freak ("Jerry"));
      
      list.get(0).generateStats ();
      list.get(1).generateStats ();
      list.get(2).generateStats ();
      list.get(3).generateStats ();
      list.get(4).generateStats ();
      
      for (int i = 0; i < list.size(); i++)
         System.out.println (list.get(i));
      
      while (list.size() != 1)
      {
         int firstWarrIndex = (int)(Math.random() * list.size ());
         int secondWarrIndex = (int)(Math.random() * list.size ());
         while (firstWarrIndex == secondWarrIndex)
            firstWarrIndex = (int)(Math.random() * list.size ());
         System.out.print (list.get(firstWarrIndex).fight (list.get(secondWarrIndex)));
         for (int i = 0; i < list.size (); i++)
            if (list.get(i).isAlive() == false)
               list.remove (i);
      }
      System.out.print ("\n" + list);
   }
}

/*
Output:
 
  ----jGRASP exec: java AbstractWarriorDriver
 Name: Lucas
 IQ: 160
 Strength: 32
 Clique: N
 
 Name: Jonathan
 IQ: 107
 Strength: 89
 Clique: J
 
 Name: Josh
 IQ: 122
 Strength: 44
 Clique: P
 
 Name: Jason
 IQ: 64
 Strength: 93
 Clique: T
 
 Name: Jerry
 IQ: 61
 Strength: 61
 Clique: F
 
 
 Josh beats Jason by IQ!
 Name: Josh
 IQ: 122
 Strength: 44
 Clique: P
 
 Jonathan beats Jerry by IQ!
 Name: Jonathan
 IQ: 107
 Strength: 89
 Clique: J
 
 Lucas beats Josh by IQ!
 Name: Lucas
 IQ: 160
 Strength: 32
 Clique: N
 
 Lucas beats Jonathan by IQ!
 Name: Lucas
 IQ: 160
 Strength: 32
 Clique: N
 
 [Name: Lucas
 IQ: 160
 Strength: 32
 Clique: N
 ]
  ----jGRASP: operation complete.
 
*/
