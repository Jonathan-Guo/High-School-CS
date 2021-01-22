//Name: Jonathan Guo  
//Date: 3/12/2020
// What I learned: I learned how to use all the basic methods in the Map interface, put, get, containsKey, and keySet. I
// also learned how to add a list as the value that the key refers to and then to chain values onto that list. Thus, if
// there is ever a key that points to multiple values, I learned how to add them all to a list.
// How I feel about this lab: I feel pretty good and confident that I can manipulate data in a map.

// I am wondering: I am wondering when it is best to use a map, a set, or a list
import java.util.*;
public class Pd5GuoJonathanActingSchool_shell
{
   public static void main(String[] args)
   {
      Map<String, String> sGrades = new HashMap<String, String>();     //HashMap
   
      sGrades.put("Jack Nicholson", "A-");
      sGrades.put("Humphrey Bogart", "A+");
      sGrades.put("Audrey Hepburn", "A");
      sGrades.put("Meryl Streep", "A-");
      sGrades.put("Jimmy Stewart", "A");
   
   	//display initial data
      for (String key: sGrades.keySet())
      {
         System.out.println (key + " (" + sGrades.get(key) + ")");
      }
           
   	//reverse the map    //TreeMap
      Map <String, ArrayList <String>> reverse = new TreeMap <String, ArrayList <String>>();
      for (String key: sGrades.keySet())
      {
         String grade = sGrades.get (key);
         if (reverse.containsKey (grade))
         {
            reverse.get(grade).add(key);
         }
         else
         {
            reverse.put (grade, new ArrayList <String> ());
            reverse.get(grade).add(key);
         } 
      }
   	
      System.out.println();
      //display the reversed map
      for (String key: reverse.keySet())
      {
         System.out.println (key + ": " + reverse.get(key));
      }
   }
}

/**********************
Ouputs I got:
 
  ----jGRASP exec: java Pd5GuoJonathanActingSchool_shell
 Audrey Hepburn (A)
 Meryl Streep (A-)
 Jimmy Stewart (A)
 Humphrey Bogart (A+)
 Jack Nicholson (A-)
 
 A: [Audrey Hepburn, Jimmy Stewart]
 A+: [Humphrey Bogart]
 A-: [Meryl Streep, Jack Nicholson]
 
  ----jGRASP: operation complete.
 


 Audrey Hepburn (A)
 Humphrey Bogart (A+)
 Jack Nicholson (A-)
 Jimmy Stewart (A)
 Meryl Streep (A-)
 
 A: [Audrey Hepburn, Jimmy Stewart]
 A+: [Humphrey Bogart]
 A-: [Jack Nicholson, Meryl Streep]
 
 *********************/