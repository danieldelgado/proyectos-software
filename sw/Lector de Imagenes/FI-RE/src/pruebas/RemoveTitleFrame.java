package pruebas;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class RemoveTitleFrame{
  public static void main(String[] args) {
  JFrame frame = new JFrame("Removing the Title Bar of a Frame");
  frame.setUndecorated(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(400,400);
  frame.setVisible(true);
//  getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
  
  }
}