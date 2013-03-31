package pe.com.sf.re.fi.analisis.gui.componet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.jdesktop.swingx.JXPanel;

@SuppressWarnings("serial")
public class CustomPanel extends JXPanel implements ActionListener, KeyListener, ItemListener , ComponentListener{

	public CustomPanel() {
	}

	public void itemStateChanged(ItemEvent e) {}
	public void keyPressed(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	public void actionPerformed(ActionEvent e) {}	
	public void componentHidden(ComponentEvent e) {}	
	public void componentMoved(ComponentEvent e) {}	
	public void componentResized(ComponentEvent e) {}	
	public void componentShown(ComponentEvent e) {}

}
