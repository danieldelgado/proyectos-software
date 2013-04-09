package pe.com.sf.re.fi.analisis.gui.componet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ImageViewer extends JFrame implements ActionListener , ComponentListener{

	private int original_width, original_height, bound_width, bound_height;
	private int new_width, new_height;
	private Dimension dimImag;
	JPanel panel = null;
	JScrollPane scroll = null;
	Image img = null;
	ImageIcon icon = new ImageIcon();
	int count = 0;

	public ImageViewer() {
		setTitle("ImageViewer");
		setSize(300, 400);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar mbar = new JMenuBar();
		JMenu m = new JMenu("File");
		dimImag = new Dimension();
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.addComponentListener(this);	
		scroll = new JScrollPane();
		openItem = new JMenuItem("Open");
		openItem.addActionListener(this);
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);
		label = new JLabel();
		m.add(openItem);
		m.add(exitItem);
		mbar.add(m);
		setJMenuBar(mbar);
		panel.add(label,BorderLayout.CENTER);
		scroll.setViewportView(panel);
		add(scroll,BorderLayout.CENTER);
	}

	public void getScaledDimension(int original_width, int original_height, int bound_width, int bound_height) {
		System.out.println("original_width:" + original_width + " original_height:" + original_height + " bound_width ;" + bound_width
				+ " bound_height:" + bound_height);
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
		dimImag.setSize(new_width, new_height);
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

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == openItem) {
			JFileChooser chooser = new JFileChooser();
			int r = chooser.showOpenDialog(this);
			if (r == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				try {
					this.img = ImageIO.read(file);
					this.original_width = img.getWidth(null);
					this.original_height = img.getHeight(null);
					this.bound_width = panel.getWidth()-5;
					this.bound_height = panel.getHeight()-5;
					getScaledDimension(original_width, original_height, bound_width, bound_height);
					BufferedImage origin = (BufferedImage) img;
					BufferedImage originalImage = resize(dimImag.width, dimImag.height, origin);
					icon.setImage(originalImage);
					label.setIcon(icon);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (source == exitItem)
			System.exit(0);
	}

	public static void main(String[] args) {
		JFrame frame = new ImageViewer();
		frame.show();
	}

	private JLabel label;

	private JMenuItem openItem;

	private JMenuItem exitItem;

	@Override
	public void componentHidden(ComponentEvent e) {
		System.out.println(" componentHidden ");		
	}

	@Override
	public void componentMoved(ComponentEvent e) {		
		System.out.println(" componentMoved ");
	}

	@Override
	public void componentResized(ComponentEvent e) {
		System.out.println(" componentResized :" + (count++));
		if(img!=null){
			System.out.println(" resize ");
			this.bound_width = panel.getWidth();
			this.bound_height = panel.getHeight();
			getScaledDimension(original_width, original_height, bound_width, bound_height);
			BufferedImage origin = (BufferedImage) this.img;
			BufferedImage originalImage = resize(dimImag.width, dimImag.height, origin);
			icon.setImage(originalImage);
			label.setIcon(icon);			
		}	
	}

	@Override
	public void componentShown(ComponentEvent e) {	
		System.out.println(" componentShown ");	
	}
}
