import javax.swing.*;

public class BattleshipDriver 
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame ("Battleship");
      frame.setSize (500, 500);
      frame.setLocation (200, 200);
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setContentPane (new Battleship( ));
      frame.setVisible(true);
   }
}
