// CharacterTracer.java
// Copyright (c) 2010 William Whitney
// All rights reserved.
// This software is released under the BSD license.
// Please see the accompanying LICENSE.txt for details.
package pruebas.net.sourceforge.javaocr.ocrPlugins;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import pruebas.net.sourceforge.javaocr.scanner.DocumentScanner;
import pruebas.net.sourceforge.javaocr.scanner.DocumentScannerListenerAdaptor;
import pruebas.net.sourceforge.javaocr.scanner.PixelImage;

/**
 * Saves all the characters in an image to an output directory individually.
 * 
 * @author William Whitney
 */
public class CharacterTracer extends DocumentScannerListenerAdaptor {

	private DocumentScanner documentScanner = new DocumentScanner();
	private BufferedImage bfImage;
	private Graphics2D bfImageGraphics;

	public BufferedImage getTracedImage(File inputImage) {

		try {

			bfImage = ImageIO.read(inputImage);
			try {

				ImageIO.write(bfImage, "jpg", new File("/home/daniel/Documentos/archivosprueba/modificado/wdwddqwd354357" + ".png"));
			} catch (Exception e) {
				System.out.println(e);
			}
			bfImageGraphics = bfImage.createGraphics();

			Image img = ImageIO.read(inputImage);
			PixelImage pixelImage = new PixelImage(img);
			pixelImage.toGrayScale(true);
			pixelImage.filter();
			try {

				ImageIO.write(bfImage, "jpg", new File("/home/daniel/Documentos/archivosprueba/modificado/wdwddqw456468" + ".png"));
			} catch (Exception e) {
				System.out.println(e);
			}
			documentScanner.scan(pixelImage, this, 0, 0, pixelImage.width, pixelImage.height);
			try {

				ImageIO.write(bfImage, "jpg", new File("/home/daniel/Documentos/archivosprueba/modificado/wdwddqw4542439" + ".png"));
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (IOException ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
		bfImageGraphics.dispose();
		try {

			ImageIO.write(bfImage, "jpg", new File("/home/daniel/Documentos/archivosprueba/modificado/wdwddqw45234329" + ".png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return bfImage;
	}

	@Override
	public void processChar(PixelImage pixelImage, int x1, int y1, int x2, int y2, int rowY1, int rowY2) {
		try {
			bfImageGraphics.setStroke(new BasicStroke(4));
			bfImageGraphics.setColor(Color.red);
			bfImageGraphics.drawRect(x1, y1, x2 - x1, y2 - y1);
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void processSpace(PixelImage pixelImage, int x1, int y1, int x2, int y2) {
		try {
			bfImageGraphics.setStroke(new BasicStroke(4));
			bfImageGraphics.setColor(Color.yellow);
			bfImageGraphics.drawRect(x1, y1, x2 - x1, y2 - y1);
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
	}

	private static final Logger LOG = Logger.getLogger(CharacterTracer.class.getName());
}
