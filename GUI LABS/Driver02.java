import javax.swing.*;

public class Driver02
{
   public static void main (String[]args)
   {
      JFrame frame = new JFrame ("Lab 2");
      frame.setSize (400, 350);
      frame.setLocation (200, 200);
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setContentPane (new Panel02());
      frame.setVisible (true); 
   }
}