package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;

@SuppressWarnings("serial")
public class ImagePreviewSelecionado extends CustomPanel implements MouseMotionListener {

	private Image img;
	private BufferedImage origin;
	private ImageIcon icon;
	private JLabel lblImage;
	private int original_width, original_height, bound_width, bound_height, new_width, new_height;
	private File file = null;

	private final static Logger _log = Logger.getLogger(ImagePreviewSelecionado.class.getName());

	public ImagePreviewSelecionado() {
		_log.info("  cargando Image Preview Selecionado ");
		lblImage = new JLabel();
		icon = new ImageIcon();
		setLayout(new BorderLayout());
		addMouseListener(this);
		addMouseMotionListener(this);
		addComponentListener(this);
		add(lblImage, BorderLayout.CENTER);
	}

	public void propertyChange(File file) {
		if (file == null) {
			return;
		}
		this.file = file;
		_log.info(" propertyChange file : " + file);
		limpiarImagen();
		imagePreview();
	}

	public void limpiarImagen() {
		_log.info(" limpiar Imagen ");
		img = null;
		origin = null;
		original_width = 0;
		original_height = 0;
		bound_width = 0;
		bound_height = 0;
		new_width = 0;
		new_height = 0;
		lblImage.setIcon(null);
		repaint();
	}

	public void getScaledDimension(int original_width, int original_height, int bound_width, int bound_height) {
		_log.info("original_width:" + original_width + " original_height:" + original_height + " bound_width ;" + bound_width + " bound_height:"
				+ bound_height);
		new_width = original_width;
		new_height = original_height;
		if (original_width > bound_width) {
			new_width = bound_width;
			new_height = (new_width * original_height) / original_width;
		}
		if (new_height > bound_height) {
			new_height = bound_height;
			new_width = (new_height * original_width) / original_height;
		}
		_log.info("new_width:" + new_width + " new_height:" + new_height);
	}

	public BufferedImage resize(int targetWidth, int targetHeight, BufferedImage src) {
		double scaleW = (double) targetWidth / (double) src.getWidth();
		double scaleH = (double) targetHeight / (double) src.getHeight();
		double scale = scaleW < scaleH ? scaleW : scaleH;
		BufferedImage result = new BufferedImage((int) (src.getWidth() * scale), (int) (src.getHeight() * scale), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = result.createGraphics();
		g2d.drawImage(src, 5, 5, result.getWidth(), result.getHeight(), null);
		g2d.dispose();
		return result;
	}

	public void imagePreview() {
		try {
			img = null;
			origin = null;
			img = ImageIO.read(file);
			original_width = img.getWidth(null);
			original_height = img.getHeight(null);
			bound_width = getWidth() - 5;
			bound_height = getHeight() - 5;
			getScaledDimension(original_width, original_height, bound_width, bound_height);
			origin = (BufferedImage) img;
			origin = resize(new_width, new_height, origin);
			icon.setImage(origin);
			lblImage.setIcon(icon);
			repaint();
		} catch (Exception e) {
			_log.warning("  e : " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void componentResized(ComponentEvent e) {
		if (img != null) {
			try {
				imagePreview();
			} catch (Exception e2) {
				_log.warning("  e2 : " + e2);
				e2.printStackTrace();
			}

		}
	}

	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Entered " + arg0.getComponent());
	}

	public void mouseExited(MouseEvent arg0) {
		System.out.println("Exited " + arg0.getComponent());
	}

	public void mousePressed(MouseEvent ev) {
		System.out.println("Pressed " + ev.getComponent());
		System.out.println(ev.getPoint());
		System.out.println(ev.getButton());
		System.out.println(this.getMousePosition());
		if (ev.getButton() == MouseEvent.BUTTON1) {
			System.out.println(" 1 ");
		} else if (ev.getButton() == MouseEvent.BUTTON2) {
			System.out.println(" 2 ");
		} else if (ev.getButton() == MouseEvent.BUTTON3) {
			System.out.println(" 3 ");
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		System.out.println("Released " + arg0.getComponent());
	}

}
