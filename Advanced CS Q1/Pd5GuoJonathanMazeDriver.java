/*********************************************************************************
NAME: Jonathan Guo
PERIOD: 5
DATE SUBMITTED: 10/27
DUE DATE: 10/27
ASSIGNMENT:Maze Lab

PURPOSE(how it works): Find a path from start to end of the maze and marks it with stars and keeps track of how many steps it took
PURPOSE (student purpose): Learn more about recursion and how to implement backtracking so it changes everything back to stars and keeps track of count

MISTAKES:
- It would change the beginning start from S to *. Added a condition to only execute if value was not equal to 'S'.
- Stack overflow error because if I called markTheCorrectPath (r - 1, c) and then it would call markTheCorrectPath (r + 1, c), it would just keep going. 
  I needed to add the initial condition return false if maze[r][c] == 'o' in order to stop this
- SOPed count in the if statement that marked the correct path with '*'. This printed count everytime and decremented it because the code was backtracking. Learned that there is no need to backtrack for count in this case.


NEW CONCEPTS INCLUDED IN THIS LAB: 
- Write backtracking code included in the if statement so once the correct path is found, it goes back returning true for all the previous calls changing the path to stars and incrementing count
HOW I FEEL: 
   I feel that I learned a lot from this lab and how to execute a condition with backtracking to only change the correct path into stars. 
   I learned how to implement the recursive method into the if statement to check and find the only path that worked.
CREDITS: 
None
STUDENTS WHOM I HELPED: 
None
*/

import java.util.*;
import java.io.*;
public class Pd5GuoJonathanMazeDriver
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename: ");
      char[][] retArr = buildCharArr(sc.next());
      Maze m = new Maze(retArr);
      m.display();
      System.out.println();
   
      System.out.println("1: Mark only the correct path. If no path exists, display 'No path exists'.");
      System.out.println("2: Mark only the correct path, and display the count of STEPs.");
      System.out.print("\nPlease make a selection: ");
      m.solve(sc.nextInt());
      m.display();  
   } 
   //take in a filename (without .txt), and return a char[][]
   public static char[][] buildCharArr(String fileName) throws FileNotFoundException
   {
      File inFile = new File (fileName);
      if (!inFile.exists())
      {
         System.out.println (fileName + " does not exist");
         System.exit(1);
      }
      
      Scanner in = new Scanner (inFile);
      String first = in.nextLine();
      int count = 0;
      while (in.hasNext())
      {
         first = in.nextLine();
         count++;
      }
      char [][] values = new char [count][first.length()];
      
      Scanner sc = new Scanner (inFile);
      first = sc.nextLine();
      int row = 0;
      while (sc.hasNext())
      {
         first = sc.nextLine();
         for (int j = 0; j < first.length(); j++)
         {
            values [row][j] = first.charAt(j);
         }
         row++;
      }
      return values;
   }
}


class Maze
{
   //Constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;
   private boolean S_Exists=false, E_Exists=false;
   //constructor initializes all the fields
   public Maze(char[][] inCharArr)    
   {
      maze = inCharArr;
      for (int i = 0; i < maze.length; i++)
      {
         for (int j = 0; j < maze[0].length; j++)
         {
            if (maze[i][j] == 'S')
            {
               startRow = i;
               startCol = j;  
            }
         } 
      }           
   }
   
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }
   public void solve(int n)
   {
      if(n==1)
      {
         markTheCorrectPath(startRow, startCol);
      }
      else if(n==2)
      {
         markCorrectPathAndCountStars(startRow, startCol, 0);
      }
      else System.out.println("invalid submission");
   }
   

   /*  recur until you find E, then mark the True path */
   private boolean markTheCorrectPath(int r, int c)
   {
      if (c < 0 || c > maze[0].length - 1 || r < 0 || r > maze.length - 1 || maze[r][c] == 'W' || maze[r][c] == 'o')
         return false;
      if (maze[r][c] == 'E')
         return true;
      if (maze[r][c] == '.' || maze[r][c] == 'S')
      { 
         if (maze[r][c] != 'S') //Doesn't change Start point to an o
            maze[r][c] = 'o';
         if (markTheCorrectPath (r, c + 1) || markTheCorrectPath (r, c - 1) || markTheCorrectPath (r - 1, c) || markTheCorrectPath (r + 1, c)) //goes through all 4 options. When correct path is found, changes value to star and then backtracks.
         {
            if (maze[r][c] != 'S')  //Changes everything in path to '*' excluding the start
            {
               maze[r][c] = '*';
               return true;
            }
         }
         else if (maze[r][c] == 'o') //changes all o's not in the path back to a '.'
         {
            maze[r][c] = '.'; 
         }
      }
      return false;
   }

   private boolean markCorrectPathAndCountStars(int r, int c, int count)
   {
      if (c < 0 || c > maze[0].length - 1 || r < 0 || r > maze.length - 1 || maze[r][c] == 'W' || maze[r][c] == 'o')
         return false;
      if (maze[r][c] == 'E')
      {
         System.out.println ("Amount of Steps: " + count); //prints total amount of stars + 1 because it takes another step to go from final star to the end
         return true;
      }
      if (maze[r][c] == '.' || maze[r][c] == 'S')
      { 
         if (maze[r][c] != 'S')
            maze[r][c] = 'o';
         if (markCorrectPathAndCountStars (r, c + 1, count + 1) || markCorrectPathAndCountStars (r, c - 1, count + 1) || markCorrectPathAndCountStars (r - 1, c, count + 1) || markCorrectPathAndCountStars (r + 1, c, count + 1))
         {
            if (maze[r][c] != 'S')
            {
               maze[r][c] = '*';
               return true;
            }
         }
         else if (maze[r][c] == 'o')
         {
            maze[r][c] = '.'; 
         }
      }
      return false;
   }
}

/*
Outputs:
     
  ----jGRASP exec: java Pd5GuoJonathanMazeDriver
 Enter the maze's filename: maze1.txt
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 
 1: Mark only the correct path. If no path exists, display 'No path exists'.
 2: Mark only the correct path, and display the count of STEPs.
 
 Please make a selection: 1
 WWWWWWWW
 W....W.W
 WW.WW..W
 W***.W.W
 W*W*WW*E
 S*W*WW*W
 WW.****W
 WWWWWWWW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Pd5GuoJonathanMazeDriver
 Enter the maze's filename: maze1.txt
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 
 1: Mark only the correct path. If no path exists, display 'No path exists'.
 2: Mark only the correct path, and display the count of STEPs.
 
 Please make a selection: 2
 Amount of steps: 14
 WWWWWWWW
 W....W.W
 WW.WW..W
 W***.W.W
 W*W*WW*E
 S*W*WW*W
 WW.****W
 WWWWWWWW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Pd5GuoJonathanMazeDriver
 Enter the maze's filename: maze2.txt
 WWWSWWWWWW
 W....W.W.W
 WWWW.....W
 W...W.WW.W
 W.W....W.W
 WEWWWWWWWW
 
 
 1: Mark only the correct path. If no path exists, display 'No path exists'.
 2: Mark only the correct path, and display the count of STEPs.
 
 Please make a selection: 1
 WWWSWWWWWW
 W..**W.W.W
 WWWW**...W
 W***W*WW.W
 W*W***.W.W
 WEWWWWWWWW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Pd5GuoJonathanMazeDriver
 Enter the maze's filename: maze2.txt
 WWWSWWWWWW
 W....W.W.W
 WWWW.....W
 W...W.WW.W
 W.W....W.W
 WEWWWWWWWW
 
 
 1: Mark only the correct path. If no path exists, display 'No path exists'.
 2: Mark only the correct path, and display the count of STEPs.
 
 Please make a selection: 2
 Amount of steps: 13
 WWWSWWWWWW
 W..**W.W.W
 WWWW**...W
 W***W*WW.W
 W*W***.W.W
 WEWWWWWWWW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Pd5GuoJonathanMazeDriver
 Enter the maze's filename: maze3.txt
 ..WW
 W..S
 E.WW
 
 
 1: Mark only the correct path. If no path exists, display 'No path exists'.
 2: Mark only the correct path, and display the count of STEPs.
 
 Please make a selection: 1
 ..WW
 W**S
 E*WW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java Pd5GuoJonathanMazeDriver
 Enter the maze's filename: maze3.txt
 ..WW
 W..S
 E.WW
 
 
 1: Mark only the correct path. If no path exists, display 'No path exists'.
 2: Mark only the correct path, and display the count of STEPs.
 
 Please make a selection: 2
 Amount of steps: 4
 ..WW
 W**S
 E*WW
 
 
  ----jGRASP: operation complete.
 


*/