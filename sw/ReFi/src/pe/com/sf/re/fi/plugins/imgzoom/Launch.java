package pe.com.sf.re.fi.plugins.imgzoom;
import java.awt.Dimension;
 
import javax.swing.JFrame;
 
public class Launch {
 
 private static void createAndShowGUI() {
  JFrame frame = new JFrame("Zoom a imagen");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
//  ZoomPanel zoom = new ZoomPanel("images/ER.jpg");
  
  ZoomPanel zoom = new ZoomPanel("/home/daniel/Documentos/archivosprueba/01_03.png");
  frame.add(zoom);
  frame.setPreferredSize(new Dimension(485,300));
 
  frame.pack();
  frame.setVisible(true);
 }
 
 public static void main(String[] args) {
  // Schedule a job for the event dispatch thread:
  // creating and showing this application's GUI.
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    createAndShowGUI();
   }
  });
 }
 
}