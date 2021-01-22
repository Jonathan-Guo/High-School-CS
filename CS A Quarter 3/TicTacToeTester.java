/******************************************************************
Name: Jonathan Guo   Period: 8
Name of Lab: TicTacToe
Purpose of Program: Allow two players to play each other in tic tac toe by using 2D arrays

What I learned: 
- I learned how to check specific cases to see if one of the players had gotten 3 in a row
- I learned how to check if there was a tie by checking to see if the entire board was filled up
- I learned that you have to reset the values of r and c after conducting a check because otherwise the values will not be 0 after the for loops

Credits:
- Shell code

******************************************************************/
import javax.swing.JOptionPane;

public class TicTacToeTester
{
   public static void main (String [] args)
   {
      char player = 'x';
      TicTacToe game = new TicTacToe();
      while (true)
      {
         System.out.println (game);
         String input = JOptionPane.showInputDialog ("Row for " +
                        player + " (from 0-2 and press Cancel to exit)");
         if (input == null) System.exit(0);
      	
         int row = Integer.parseInt (input);
         input = JOptionPane.showInputDialog ("Column for " + player +
                                              " from 0-2 and press Cancel to exit)") ;
         int column = Integer.parseInt (input);
         game.set (row, column, player);
         if (player == 'x')
            player = 'o';
         else
            player = 'x';
            
         if (game.getWinner() == 'x')
         {
            System.out.println (game);
            System.out.println ('x' + " is the winner!");
            break;
         }
         else if (game.getWinner() == 'o')
         {
            System.out.println (game);
            System.out.println ('o' + " is the winner!");
            break;
         }
         else if (game.getWinner() == 't')
         {
            System.out.println (game);
            System.out.println ("Tie game!");
            break;
         }
      } // while
      System.out.println ("Thank you for playing!");
   }  // main
} // TicTacToeTester

/*
Ouputs:
  ----jGRASP exec: java TicTacToeTester
 | | | |
 | | | |
 | | | |
 
 | | | |
 | |x| |
 | | | |
 
 | | |o|
 | |x| |
 | | | |
 
 | | |o|
 | |x| |
 |x| | |
 
 |o| |o|
 | |x| |
 |x| | |
 
 |o|x|o|
 | |x| |
 |x| | |
 
 |o|x|o|
 | |x|o|
 |x| | |
 
 |o|x|o|
 | |x|o|
 |x|x| |
 
 x is the winner!
 Thank you for playing!
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java TicTacToeTester
 | | | |
 | | | |
 | | | |
 
 | |x| |
 | | | |
 | | | |
 
 | |x| |
 | |o| |
 | | | |
 
 | |x|x|
 | |o| |
 | | | |
 
 |o|x|x|
 | |o| |
 | | | |
 
 |o|x|x|
 | |o|x|
 | | | |
 
 |o|x|x|
 | |o|x|
 | | |o|
 
 o is the winner!
 Thank you for playing!
 
 
  ----jGRASP exec: java TicTacToeTester
 | | | |
 | | | |
 | | | |
 
 | |x| |
 | | | |
 | | | |
 
 | |x| |
 | |o| |
 | | | |
 
 | |x| |
 | |o|x|
 | | | |
 
 | |x|o|
 | |o|x|
 | | | |
 
 | |x|o|
 | |o|x|
 |x| | |
 
 | |x|o|
 | |o|x|
 |x| |o|
 
 |x|x|o|
 | |o|x|
 |x| |o|
 
 |x|x|o|
 |o|o|x|
 |x| |o|
 
 |x|x|o|
 |o|o|x|
 |x|x|o|
 
 Tie game!
 Thank you for playing!
 
  ----jGRASP: operation complete.
     
  ----jGRASP exec: java TicTacToeTester
 | | | |
 | | | |
 | | | |
 
 |x| | |
 | | | |
 | | | |
 
 |x| | |
 | |o| |
 | | | |
 
 |x| | |
 | |o| |
 | | |x|
 
 |x|o| |
 | |o| |
 | | |x|
 
 |x|o| |
 | |o| |
 |x| |x|
 
 |x|o|o|
 | |o| |
 |x| |x|
 
 |x|o|o|
 | |o|x|
 |x| |x|
 
 |x|o|o|
 |o|o|x|
 |x| |x|
 
 |x|o|o|
 |o|o|x|
 |x|x|x|
 
 x is the winner!
 Thank you for playing!
 
  ----jGRASP: operation complete.
 
*/