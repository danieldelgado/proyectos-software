package pe.com.sf.re.fi.plugins;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JListSelection {

	public static void main(String[] args) {

		JFrame listDemo = new JFrame("JList Selection Disable");
		JPanel testPanel = new JPanel();
		GridBagLayout gridbagLayoutSettings = new GridBagLayout();

		testPanel.setLayout(gridbagLayoutSettings);
		// Creating Shape objects array and passing it to the JList.

		Shape[] shapeList = { new Shape("Square", "C:\\image\\square.jpg"), new Shape("Triangle", "C:\\image\\triangle.jpg"),
				new Shape("Rectangle", "C:\\image\\rectangle.jpg") };
		JList listEx = new JList(shapeList);
		listEx.setCellRenderer(new DefaultListCellRenderer() { // Setting the
																// DefaultListCellRenderer

			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Shape shape = (Shape) value; // Using value we are getting the
												// object in JList
				setText(shape.getType()); // Setting the text
				setIcon(shape.getImage()); // Setting the Image Icon
				return this;
			}
		});
		JScrollPane scrollList = new JScrollPane(listEx);
		scrollList.setPreferredSize(new Dimension(250, 80));
		testPanel.add(scrollList);
		listDemo.add(testPanel);
		listDemo.setSize(300, 300);
		listDemo.setVisible(true);

	}

}

// Shape object creation.
class Shape {

	private final String type;

	private final String imagePath;

	private ImageIcon imageIcon;

	public Shape(String typeStr, String imagePath) {
		this.type = typeStr;
		this.imagePath = imagePath;
	}

	public ImageIcon getImage() {
		if (imageIcon == null) {
			imageIcon = new ImageIcon(imagePath);
		}
		return imageIcon;
	}

	public String getType() {
		return type;
	}

}