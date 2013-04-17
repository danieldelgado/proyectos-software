package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;
import pe.com.sf.re.fi.memory.ImageResize;
import pe.com.sf.re.fi.memory.ListaImageResize;

@SuppressWarnings("serial")
public class ImagePreviewSelecionado extends CustomPanel {

	private Image img;
	private BufferedImage origin;
	private ImageIcon icon;
	private JLabel lblImage;
	private int original_width, original_height, bound_width, bound_height, new_width, new_height   ;
	private File file = null;
	private Point inicioArrastre;
	private Point finArrastre;
	private Shape rectangulo = null;
	private boolean dibujando = false;
	private final static Logger _log = Logger.getLogger(ImagePreviewSelecionado.class.getName());
	private ListaImageResize listaImageResize;
	
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
			listaImageResize = new ListaImageResize(img);			
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

	private Rectangle2D.Float crearRectangulo(int x1, int y1, int x2, int y2) {
		return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

	public void paint(Graphics g) {
		super.paint(g);

		if (dibujando) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.RED);
			if (rectangulo != null) {
				g2.draw(rectangulo);
			}
			if (inicioArrastre != null && finArrastre != null) {
				rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
				_log.info( " paint puntos del rectanglo señalado  x:" + inicioArrastre.x + " y:" + inicioArrastre.y + "   arrastrado x: "+ finArrastre.x + " arrastrador y :" +finArrastre.y );
				listaImageResize.addList(new ImageResize(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y));
				g2.draw(rectangulo);
			}
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

	public void habilitarDibujoCuadrado() {		
		dibujando = true;
	}

	public void deshabilitarDibujoCuadrado() {
		dibujando = false;
	}

	public void mousePressed(MouseEvent e) {
		if (dibujando) {
			rectangulo = null;
			inicioArrastre = new Point(e.getX(), e.getY());
			finArrastre = inicioArrastre;
			repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (!dibujando) {
			if (inicioArrastre != null && finArrastre != null) {				
				rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
				inicioArrastre = null;
				finArrastre = null;
				repaint();
			}
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (dibujando) {
			finArrastre = new Point(e.getX(), e.getY());
			repaint();
		}
	}
}
