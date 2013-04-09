package pe.com.sf.re.fi.plugins;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

public class Liste {

	private JFrame frameApplikation;
	private Container containerApplikation;

	private JList liste;

	private DefaultListModel modell;

	public Liste() {

		frameApplikation = new JFrame();
		frameApplikation.setTitle("Beispiel einer Liste mit bunter Schrift");

		liste = new JList();
		modell = new DefaultListModel();

		liste.setModel(modell);
		liste.setCellRenderer(new PersonListCellRenderer());

		Person person1 = new Person("Stefan Raab", Color.BLACK);
		Person person2 = new Person("Oliver Pocher", Color.BLACK);
		Person person3 = new Person("Elton", Color.BLACK);
		Person person4 = new Person("Hans-Martin", Color.BLACK);

		modell.addElement(person1);
		modell.addElement(person2);
		modell.addElement(person3);
		modell.addElement(person4);

		containerApplikation = frameApplikation.getContentPane();
		containerApplikation.add(liste);

		frameApplikation.pack();
		frameApplikation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameApplikation.setVisible(true);
	}

	public static void main(String[] args) {
		new Liste();
	}
}

class Person {

	private String name;
	private Color schriftfarbe;

	public Person(String name, Color schriftfarbe) {
		this.name = name;
		this.schriftfarbe = schriftfarbe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getSchriftfarbe() {
		return schriftfarbe;
	}

	public void setSchriftfarbe(Color schriftfarbe) {
		this.schriftfarbe = schriftfarbe;
	}
}

class PersonListCellRenderer extends JLabel implements ListCellRenderer {

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Person person = (Person) value;
		this.setText(person.getName());
		this.setOpaque(true);
		if (isSelected) {
			this.setForeground(UIManager.getColor("List.selectionForeground"));
			this.setBackground(UIManager.getColor("List.selectionBackground"));
		} else {
			this.setForeground(person.getSchriftfarbe());
			this.setBackground(UIManager.getColor("List.background"));
		}
		return this;
	}
}
