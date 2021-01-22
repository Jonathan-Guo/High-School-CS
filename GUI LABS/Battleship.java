/**********************************************************
Name: Jonathan Guo
Period: 8
Lab: Battleship
Purpose: To create an interactive game of battleship that the user can play by using a graphical user interface
Due date: 30 May, 2019
What I learned:
   a. The logic for randomly assigning the ship as vertical and horizontal as well as keeping it in bounds.
   b. How to use and create a method that implements Actionlistener
   c. How to use "setEnabled" to decide whether or not the user can select that button
   d. How to use setText to change the text of an area 
***********************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Battleship extends JPanel
{
   private JButton[][] board;
   private int[][] matrix;
   private int hits, torpedoes;
   private JLabel label;
   private JButton reset;
   public Battleship()
   {
      setLayout(new BorderLayout());
      hits = 0;
      torpedoes = 20;
   
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("You have 20 torpedoes.");
      north.add(label);
   
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(10,10));
      add(center, BorderLayout.CENTER);
      board = new JButton[10][10];
      matrix = new int[10][10];
      for(int r = 0; r < 10; r++) {
         for (int c = 0; c < 10; c++) {
            matrix[r][c] = 0;
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.blue);
            board[r][c].addActionListener(new Handler1(r, c));
            center.add(board[r][c]);
         }
      }
   
      reset = new JButton("Reset");
      reset.addActionListener( new Handler2() );
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
   
      placeShip();
   }

   private void placeShip()
   {
      // your code goes here
      reset.setEnabled(false);
      int coin = (int) (Math.random() * 2 + 1);
     
      if (coin == 1)
      {
         int row = (int) (Math.random() * (matrix.length - 3)); //prevents ship from going out of bounds by making the coordinate of the row starting point 4 less than the max
         int col = (int) (Math.random() * (matrix.length));
      
         //creates random battleship and changes status of the coordinates of the ship to 1
         for(int r = row; r < row + 4; r++) 
            matrix [r][col] = 1;
      }
      else
      {
         int row = (int) (Math.random()  * (matrix.length));
         int col = (int) (Math.random() * (matrix.length - 3)); //prevents ship from going out of bounds by making the coordinate of the column starting point 4 less than the max
      
         for (int c = col; c < col + 4; c++) 
            matrix[row][c] = 1;
      }
   }

   private class Handler1 implements ActionListener
   {
      private int myRow, myCol;
      public Handler1(int r, int c)
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
         // The following two statements are for debugging purpose
         System.out.println (myRow);
         System.out.println (myCol);
      
         // your code goes here
         torpedoes--; 
         label.setText ("You have " + torpedoes + " torpedoes");
         if (torpedoes >= 0) 
         {         
            if (matrix[myRow][myCol] == 1) 
            {
               hits++;
               board[myRow][myCol].setEnabled (false);
               board[myRow][myCol].setBackground(Color.RED);
            }
            else 
            {
               board[myRow][myCol].setEnabled (false);
               board[myRow][myCol].setBackground(Color.WHITE);
            }
         }
      
         if (hits == 4) //win condition
         {
            label.setText("Congratulations! You won!");
            for (int r = 0; r < board.length; r++)
            {
               for (int c = 0; c < board.length; c++)
               {
                  board[r][c].setEnabled (false); //no buttons are selectable
               }
            }
            reset.setEnabled (true); //reset button becomes selectable
         } 
         else if(hits < 4 && torpedoes <= 0) //lose condition
         {
            label.setText("You lose...");
            for (int r = 0; r < board.length; r++)
            {
               for (int c = 0; c < board[0].length; c++)
               {
                  board[r][c].setEnabled (false);
                  if (matrix[r][c] == 1)
                     board[r][c].setBackground (Color.red);
               }
            }
            reset.setEnabled (true);
         }
      
      }   // actionPerformed of Handler
   }

   // Handling the Reset button
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         for (int r = 0; r < matrix.length; r++)
         {
            for (int c = 0; c < matrix.length; c++)
            {
               matrix[r][c] = 0; //resets status of all coordinates back to 0
               board[r][c].setEnabled(true); //allows each button to be selectable again
               board[r][c].setBackground(Color.blue); //resets the color of the board
            }
         }
         placeShip(); //creates random new board
         //reset torpedoes and hits
         torpedoes = 20;
         hits = 0;
         label.setText("You have 20 torpedoes");
      }  // actionPerformed of Handler2
   }


   public static void main(String[] args)
   {   
      JFrame frame = new JFrame("Battleship!");
      frame.setSize(400, 400);
      frame.setLocation(200, 100);
      frame.setContentPane(new Battleship());
      frame.setVisible(true);
   }
}
