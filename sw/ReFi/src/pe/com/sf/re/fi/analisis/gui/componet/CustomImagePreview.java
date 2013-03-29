package pe.com.sf.re.fi.analisis.gui.componet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CustomImagePreview extends JPanel  {
	
    private Image img;
    
    public CustomImagePreview( ) {
        setPreferredSize(new Dimension(200,200));
    }

    public void propertyChange(File path) {
        try {
            updateImage(path);
            System.out.println(" update ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void updateImage(File file) throws IOException {
        if(file == null) {
            return;
        }
        img = ImageIO.read(file);
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0,0,getWidth(),getHeight());
        if(img != null) {
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            int side = Math.max(w,h);
            double scale = 200.0/(double)side;
            w = (int)(scale * (double)w);
            h = (int)(scale * (double)h);
            g.drawImage(img,0,0,w,h,null);
            String dim = w + " x " + h;
            g.setColor(Color.black);
            g.drawString(dim,31,196);
            g.setColor(Color.white);
            g.drawString(dim,30,195);
        } else {
            g.setColor(Color.black);
            g.drawString("Not an image",30,100);
        }
    }


}
