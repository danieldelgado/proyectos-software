package pe.com.sf.re.fi.plugins;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase DibujarRectangulos
 * 
 * @author Daniel Alvarez (a3dany)
 */
public class DibujarRectangulos extends JPanel {

	private Point inicioArrastre;
	private Point finArrastre;
	private Shape rectangulo = null;

	public DibujarRectangulos() {
		super();
		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) { 
				rectangulo = null;
				inicioArrastre = new Point(e.getX(), e.getY());
				finArrastre = inicioArrastre;
				repaint();
			}

			public void mouseReleased(MouseEvent e) { 
				rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
				inicioArrastre = null;
				finArrastre = null;
				repaint();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) { 
				finArrastre = new Point(e.getX(), e.getY());
				repaint();
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		if (rectangulo != null){
			g2.draw(rectangulo);
		}
		if (inicioArrastre != null && finArrastre != null) { 
			rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
			g2.draw(rectangulo);
		}
	}

	private Rectangle2D.Float crearRectangulo(int x1, int y1, int x2, int y2) {
		return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

	public static void main(String[] a3d) {
		JFrame ventana = new JFrame("Dibujar Rectangulos");
		ventana.setSize(400, 300);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(new DibujarRectangulos());
		ventana.setVisible(true);
	}
}