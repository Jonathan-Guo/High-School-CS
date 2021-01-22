public class TicTacToe
{
   private char [] [] board;
   private static final int ROWS = 3, COLUMNS = 3;
   public TicTacToe()
   {
      board = new char [ROWS][COLUMNS];
      for (int i = 0; i < ROWS; i++)
      {
         for (int j = 0; j < COLUMNS; j++)
            board[i][j] = ' ';
      }
   }  // default constructor
   
   public char getWinner ()
   {
      //checks each row to see if a player has reached 3 in a row
      int r = 0, c = 0; 
      for (r = 0; r < ROWS; r++)
      {
         if (board[r][c] == 'x' && board [r][c + 1] == 'x' && board [r][c + 2] == 'x')
            return 'x'; 
         else if (board[r][c] == 'o' && board [r][c + 1] == 'o' && board [r][c + 2] == 'o')
            return 'o';
      }
      
      //checks each column to see if a player has reached 3 in a row
      r = 0; c = 0;      
      for  (c = 0; c < COLUMNS; c++)
      {
         if (board[r][c] == 'x' && board[r + 1][c] == 'x' && board[r + 2][c] == 'x')
            return 'x';
         else if (board[r][c] == 'o' && board[r + 1][c] == 'o' && board[r + 2][c] == 'o')
            return 'o';
      }
      
      // checks to see if a player has reached 3 in a row in the major diagonal
      r = 0; c = 0;      
      if (board[r][c] == 'x' && board[r + 1][c + 1] == 'x' && board[r + 2][c + 2] == 'x')
         return 'x';
      else if (board [r][c] == 'o' && board[r + 1][c + 1] == 'o' && board[r + 2][c + 2] == 'o')
         return 'o';
      
      //checks to see if a player has gotten 3 in a row in the other diagonal
      r = 0; c = 0;
      if (board[r + 2][c] == 'x' && board[r + 1][c + 1] == 'x' && board[r][c+2] == 'x')
         return 'x';
      else if (board[r + 2][c] == 'o' && board[r + 1][c + 1] == 'o' && board[r][c+2] == 'o')
         return 'o';
      
      //checks to see if the board is completely full, if not then the game continues. If it is, then there is a tie.    
      int count= 0;   
      for (c = 0; c < COLUMNS; c++)
      {
         for (r = 0; r < ROWS; r++) 
         {
            if (board [r][c] == 'x' || board [r][c] == 'o')
               count++;
         }
      }    
       
      if (count == 9)
         return 't';
      else
         return ' ';
   }

// post-condition: set a field in the board. The field must be unoccupied
   public void set (int i, int j, char player)
   {
      if (board [i][j] != ' ')
         throw new IllegalArgumentException ("Position occupied");
      board[i][j] = player;
   }  // set

   public String toString()
   {
      String r = "";
      for (int i = 0; i < ROWS; i++)
      {
         r = r + "|";
         for (int j = 0; j < COLUMNS; j++)
         {
            r = r + board[i][j] + "|";
         }
         r = r + "\n";
      }
      return r;
   } // toString
}