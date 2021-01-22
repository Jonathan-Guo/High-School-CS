import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Panel02 extends JPanel
{
   private JPanel eastPanel;
   private JPanel southPanel;
   private JLabel slabel;
   private JTextArea southText; //declare texfield object - before construct

   public Panel02()
   {
      setLayout (new GridLayout (3,1));
      
      JPanel northPanel = new JPanel (new FlowLayout());
      add (northPanel, BorderLayout.NORTH);
      eastPanel = new JPanel ();
      add (eastPanel, BorderLayout.EAST);
      southPanel = new JPanel (new FlowLayout());
      add (southPanel, BorderLayout.SOUTH);
      
      //slabel = new JLabel ("hello");
      //southPanel.add (slabel);
      
      JButton eButton1 = new JButton ("1");
      eastPanel.add (eButton1);
      eButton1.addActionListener (new Listener1 ());
      
      JButton eButton2 = new JButton ("2");
      eastPanel.add (eButton2);
      
      JButton nButton1 = new JButton ("A");
      northPanel.add (nButton1);
      JButton nButton2 = new JButton ("B");
      northPanel.add (nButton2);
      
      slabel = new JLabel ("Hello"); //instantiate the object with 240 column
      southPanel.add(slabel); 
   }

   
   private class Listener1 implements ActionListener 
   {
      public void actionPerformed (ActionEvent e)
      {
         slabel.setText ("You clicked the button 1");
      }
   }
}