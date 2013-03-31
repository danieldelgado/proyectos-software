package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;

@SuppressWarnings("serial")
public class ImagePreviewSelecionado extends CustomPanel {

	private Image img;
	private BufferedImage origin;
	private ImageIcon icon;
	private JLabel lblImage;
	private int original_width, original_height,  bound_width,  bound_height , new_width , new_height; 
	private File file = null;
	
	private final static Logger _log = Logger.getLogger(ImagePreviewSelecionado.class.getName());
		
	public ImagePreviewSelecionado() {
		lblImage = new JLabel();
		icon = new ImageIcon();
		setLayout(new BorderLayout());
		add(lblImage,BorderLayout.CENTER);
		addComponentListener(this);
	}

	public void propertyChange(File file) {
		if (file == null) {
			return;
		}
		this.file = file;
		_log.info(" file : " + file ); 
		imagePreview();
	}
	
	public void getScaledDimension(int original_width, int original_height, int bound_width, int bound_height) {
		_log.info("original_width:" + original_width + " original_height:" + original_height + " bound_width ;" + bound_width	+ " bound_height:" + bound_height);
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
		g2d.drawImage(src, 0, 0, result.getWidth(), result.getHeight(), null);
		g2d.dispose();
		return result;
	}
	
	public void imagePreview(){
		try {
			img = null;
			origin = null;
			img = ImageIO.read(file);
			original_width = img.getWidth(null);
			original_height = img.getHeight(null);
			bound_width = getWidth()-5;
			bound_height = getHeight()-5;
			getScaledDimension(original_width, original_height, bound_width, bound_height);
			origin = (BufferedImage) img;
			origin = resize(new_width, new_height, origin);
			icon.setImage(origin);
			lblImage.setIcon(icon);
		} catch (Exception e) {
			_log.warning("  e : "+ e);
			e.printStackTrace();
		}		
	}
		
	@Override
	public void componentResized(ComponentEvent e) {
		if (img != null) {	
			try {
				imagePreview();
			} catch (Exception e2) {
				_log.warning("  e2 : "+ e2);
				e2.printStackTrace();
			}
			
		}
	}

}
