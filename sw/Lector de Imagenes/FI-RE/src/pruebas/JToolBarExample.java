package pruebas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class JToolBarExample extends JFrame
                             implements ItemListener {
  private BrowserToolBar toolbar;
  private JCheckBox labelBox;
  
  public static void main(String[] args) {
    new JToolBarExample();
  }

  public JToolBarExample() {
    super("JToolBar Example");
//    WindowUtilities.setNativeLookAndFeel();
//    addWindowListener(new ExitListener());
    Container content = getContentPane();
    content.setBackground(Color.white);
    toolbar = new BrowserToolBar();
    content.add(toolbar, BorderLayout.NORTH);
    labelBox = new JCheckBox("Show Text Labels?");
    labelBox.setHorizontalAlignment(SwingConstants.CENTER);
    labelBox.addItemListener(this);
    content.add(new JTextArea(10,30), BorderLayout.CENTER);
    content.add(labelBox, BorderLayout.SOUTH);
    pack();
    setVisible(true);
  }

  public void itemStateChanged(ItemEvent event) {
    toolbar.setTextLabels(labelBox.isSelected());
    pack();
  }
}