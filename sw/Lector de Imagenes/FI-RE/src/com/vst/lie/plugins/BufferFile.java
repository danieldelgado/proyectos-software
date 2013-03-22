package com.vst.lie.plugins;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferFile {
	
	public static BufferedImage readFile(File file) {
		try {
			return  ImageIO.read(file);
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		return null;
	}
	
	
	
}
