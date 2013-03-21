package com.vst.lie.plugins;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;

import com.vst.lie.controller.AnalizarArchivoController;
import com.vst.lie.gui.impl.Principal;

public class ProcesoCarga extends Thread {
	private static int DELAY = 100;

	JProgressBar progressBar;
	File[] files = null;
	List<BufferedImage> lstBufferedImages = null;

	public ProcesoCarga(JProgressBar bar) {
		progressBar = bar;
	}

	public void run() {
		lstBufferedImages = new ArrayList<BufferedImage>();

		int minimum = progressBar.getMinimum()+1;
		int maximum = progressBar.getMaximum();
		if (files != null && files.length > 0) {
			for (int i = minimum; i < maximum; i++) {
				try {
					System.out.println("lectura : " + i + ":" + files[i]);
					if (files[i].isFile() && files[i].canRead()) {
						BufferedImage img = ImageIO.read(files[i]);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								progressBar.setValue(progressBar.getValue() + 1);
							}
						});
						sleep(100);
						lstBufferedImages.add(img);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public synchronized List<BufferedImage> obtenerCargaBufferImage() {
		files = AnalizarArchivoController.getFiles();
		progressBar.setMinimum(0);
		progressBar.setMaximum(files.length - 1);
		System.out.println(" 01 ");
		start();
		System.out.println(" 01 ");
		return lstBufferedImages;
	}
}