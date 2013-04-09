package pe.com.sf.re.fi.plugins;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class DetachedMagnifyingGlass extends JComponent implements MouseMotionListener {

	double zoom;
	JComponent comp;
	Point point;
	Dimension mySize;
	Robot robot;

	public DetachedMagnifyingGlass(JComponent comp, Dimension size, double zoom) {
		this.comp = comp;
		// flag to say don't draw until we get a MouseMotionEvent
		point = new Point(-1, -1);
		comp.addMouseMotionListener(this);
		this.mySize = size;
		this.zoom = zoom;
		// if we can't get a robot, then we just never
		// paint anything
		try {
			robot = new Robot();
		} catch (AWTException awte) {
			System.err.println("Can't get a Robot");
			awte.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		if ((robot == null) || (point.x == -1)) {
			g.setColor(Color.blue);
			g.fillRect(0, 0, mySize.width, mySize.height);
			return;
		}
		Rectangle grabRect = computeGrabRect();
		BufferedImage grabImg = robot.createScreenCapture(grabRect);
		Image scaleImg = grabImg.getScaledInstance(mySize.width, mySize.height, Image.SCALE_FAST);
		g.drawImage(scaleImg, 0, 0, null);
	}

	private Rectangle computeGrabRect() {
		// width, height are size of this comp / zoom
		int grabWidth = (int) ((double) mySize.width / zoom);
		int grabHeight = (int) ((double) mySize.height / zoom);
		// upper left corner is current point
		return new Rectangle(point.x, point.y, grabWidth, grabHeight);
	}

	public Dimension getPreferredSize() {
		return mySize;
	}

	public Dimension getMinimumSize() {
		return mySize;
	}

	public Dimension getMaximumSize() {
		return mySize;
	}

	// MouseMotionListener implementations
	public void mouseMoved(MouseEvent e) {
		Point offsetPoint = comp.getLocationOnScreen();
		e.translatePoint(offsetPoint.x, offsetPoint.y);
		point = e.getPoint();
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

}