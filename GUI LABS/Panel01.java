import java.awt.*;
import javax.swing.*;

public class Panel02 extends JPanel
{
   private JButton nButton;
   private Jbutton cButton;
   private ImageIcon picture = new ImageIcon ("karel.gif");
   public Panel02()
   {
      setLayout (new BorderLayout());
      
      nButton = new JButton ("Top");
      add (nButton, BorderLayout.NORTH);
      
      cButton = new JButton (picture);
      add (cButton, BorderLayout.CENTER);
   }
}
   