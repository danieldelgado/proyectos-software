package pruebas;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class MainClass extends Applet {
	Image i, j, k, l;

	public void init() {
		MediaTracker mt = new MediaTracker(this);
		i = getImage(getDocumentBase(), "/home/daniel/Documentos/archivosprueba/pruibaImg.jpg");
		mt.addImage(i, 0);
		try {
			mt.waitForAll();
			int width = i.getWidth(this);
			System.out.println("width:" + width);
			int height = i.getHeight(this);
			System.out.println("height:" + height);
			int pixels[] = new int[width * height];
			System.out.println("pixels:" + pixels);
			System.out.println("pixels:" + pixels.length);
			PixelGrabber pg = new PixelGrabber(i, 0, 0, width, height, pixels, 0, width);
			System.out.println(pg.grabPixels());
			if (pg.grabPixels() && ((pg.status() & ImageObserver.ALLBITS) != 0)) {
				j = createImage(new MemoryImageSource(width, height, rowFlipPixels(pixels, width, height), 0, width));
				k = createImage(new MemoryImageSource(width, height, colFlipPixels(pixels, width, height), 0, width));
				l = createImage(new MemoryImageSource(height, width, rot90Pixels(pixels, width, height), 0, height));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		g.drawImage(i, 10, 10, this); // regular
		if (j != null)
			g.drawImage(j, 150, 10, this); // rowFlip
		if (k != null)
			g.drawImage(k, 10, 60, this); // colFlip
		if (l != null)
			g.drawImage(l, 150, 60, this); // rot90
	}

	private int[] rowFlipPixels(int pixels[], int width, int height) {
		int newPixels[] = null;
		if ((width * height) == pixels.length) {
			newPixels = new int[width * height];
			int newIndex = 0;
			for (int y = height - 1; y >= 0; y--)
				for (int x = width - 1; x >= 0; x--)
					newPixels[newIndex++] = pixels[y * width + x];
		}
		return newPixels;
	}

	private int[] colFlipPixels(int pixels[], int width, int height) {
		int newPixels[] = null;
		if ((width * height) == pixels.length) {
			newPixels = new int[width * height];
			int newIndex = 0;
			for (int y = 0; y < height; y++)
				for (int x = width - 1; x >= 0; x--)
					newPixels[newIndex++] = pixels[y * width + x];
		}
		return newPixels;
	}

	private int[] rot90Pixels(int pixels[], int width, int height) {
		int newPixels[] = null;
		if ((width * height) == pixels.length) {
			newPixels = new int[width * height];
			int newIndex = 0;
			for (int x = width - 1; x >= 0; x--)
				for (int y = 0; y < height; y++)
					newPixels[newIndex++] = pixels[y * width + x];
		}
		return newPixels;
	}
}