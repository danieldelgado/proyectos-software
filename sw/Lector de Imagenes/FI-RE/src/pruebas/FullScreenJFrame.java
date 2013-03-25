package pruebas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FullScreenJFrame extends JFrame
{
  public FullScreenJFrame( String title )
  {
      super(title);

      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      setUndecorated(true);
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setBounds(0,0,screenSize.width/2, screenSize.height/2);
      getContentPane().add(new JLabel("A JFrame Kiosk"), BorderLayout.NORTH);
      JButton closeButton = new JButton("Close");
      closeButton.addActionListener( new ActionListener()
          {
              public void actionPerformed( ActionEvent ae )
              {
                  System.out.println("Close button Pressed");
                  FullScreenJFrame.this.setVisible(false);
                  System.exit(0);
              }
          });
      getContentPane().add(closeButton, BorderLayout.CENTER);
  }

  public static void main( String[] args )
  {
      FullScreenJFrame frame = new FullScreenJFrame("");
      frame.setVisible(true);
  }
}