/**
Name: Jonathan Guo
Due: 10/20/19
Date Submitted: 10/20/19
What I learned:  
 -  I learned how to write the read method and start storing values from the file in the 2d array from the second line because the first line has the number dimensions
 -  How to not get stack overflow error by checking if the value about to filled is equal to ch, and then call ch method
 -  How to implement the base case in the if statements to follow. 
   My original base case was if g[r][c] == ch, then set g[r][c] to *. However, this caused my program to just stop after the first call to the method and the recursion never happened
How I feel about this lab: 
 - I feel like this lab was really good for me and I learned a new aspect of recursion. I learned how to write the method without finding a specific base case but instead checking for the case in the following if statements.

What I wonder: 
 - I wonder if there is anyway to do the lab with the base case if g[r][c] == ch. I could not do it because I would end up with stack overflow errors or ending the method after the first call.

Credits (person/websites and which part of your lab you got help from):  
None

Students I helped: 
None
**/

import java.util.Scanner;
import java.io.*;
public class Pd5GuoJonathanAreaFill_shell
{
   public static char[][] grid = null;

   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Filename: ");
      String filename = sc.next();
      grid = read(filename);
      display(grid);
      System.out.print("\nEnter ROW COL to fill from: ");
      int row = sc.nextInt();
      int col = sc.nextInt(); 
      fill(grid, row, col, grid[row][col]);
      display(grid);
      sc.close();
   }
   public static char[][] read(String filename)throws FileNotFoundException
   {
      File inFile = new File (filename);
      if (!inFile.exists())
      {
         System.out.println (filename + " does not exist");
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
   
   public static void display(char[][] g)
   {              
      for (int i = 0; i < g.length; i++)
      {
         for (int j = 0; j <g[0].length; j++)
         {
            System.out.print (g[i][j]);  
         }
         System.out.println ("");
      }
   }
   public static void fill(char[][] g, int r, int c, char ch) //recursive method
   {  
      g[r][c] = '*';
      if (r - 1 >= 0 && g[r - 1][c] == ch)
      {
         fill (g, r - 1, c, ch);
      } 
      if (r + 1 < g.length && g[r + 1][c] == ch)
      {
         fill (g, r + 1, c, ch);
      }
      if (c - 1 >= 0 && g[r][c - 1] == ch)
      {
         fill (g, r, c - 1, ch);
      }
      if (c + 1 < g[0].length && g[r][c + 1] == ch)
      {
         fill (g, r, c + 1, ch);
      }
   }
}

/*
Outputs:
 
  ----jGRASP exec: java Pd5GuoJonathanAreaFill_shell
 Filename: area2.txt
 ..........00
 ...0....0000
 ...000000000
 0000.....000
 ............
 ..#########.
 ..#...#####.
 ......#####.
 ...00000....
 
 Enter ROW COL to fill from: 1 2
 **********00
 ***0****0000
 ***000000000
 0000.....000
 ............
 ..#########.
 ..#...#####.
 ......#####.
 ...00000....
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Pd5GuoJonathanAreaFill_shell
 Filename: area.txt
 xxxx............................
 ...xx...........................
 ..xxxxxxxxxxxx..................
 ..x.........xxxxxxx.............
 ..x...........0000xxxx..........
 ..xxxxxxxxxxxx0..000............
 ..xxxxxxxxx...0...00.....0000000
 ..........xx.......0000000000000
 .....xxxxxxxxx........0.........
 ....xx.................00000....
 ....xx.....................00...
 .....xxxxxxxxxxxxxxxxxx....00...
 ......................xx...00...
 .......................xxxx00000
 ............................0000
 
 Enter ROW COL to fill from: 1 2
 xxxx............................
 ***xx...........................
 **xxxxxxxxxxxx..................
 **x.........xxxxxxx.............
 **x...........0000xxxx..........
 **xxxxxxxxxxxx0..000............
 **xxxxxxxxx...0...00.....0000000
 **********xx.......0000000000000
 *****xxxxxxxxx........0.........
 ****xx.................00000....
 ****xx.....................00...
 *****xxxxxxxxxxxxxxxxxx....00...
 **********************xx...00...
 ***********************xxxx00000
 ****************************0000
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Pd5GuoJonathanAreaFill_shell
 Filename: area3.txt
 +++
 @+@
 @+@
 @@@
 
 Enter ROW COL to fill from: 1 2
 +++
 *+*
 *+*
 ***
 
  ----jGRASP: operation complete.
 
*/