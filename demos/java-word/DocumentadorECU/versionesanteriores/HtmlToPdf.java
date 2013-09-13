package com.vst.ecu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextRenderer;

public class HtmlToPdf {

	static String str = "<h2></h2><img src='http://upload.wikimedia.org/wikipedia/en/1/1c/Hitchhiker%27s_Guide_%28book_cover%29.jpg' style='float:left;margin-top:0px;margin-right:20px;margin-left:20px' height='229' width='140'><h3><br></h3><br><br>        <p style='padding-left:40px;color:#003366'>'Difficulty?'&nbsp;<span style='color:#000000'>exclaimed Ford.</span> 'Difficulty? What do you mean, difficulty? It's the single simplest machine in the entire Universe!'</p>        <p style='padding-left:40px'>The marketing girl soured him with a look.</p>        <p style='padding-left:40px'><span style='color:#993333'>'Alright, Mr. Wiseguy,'</span> she said, <span style='color:#993333'>'if you're so clever, you tell us what colour it should be.'</span></p>";
	static String str2 = "<h2></h2><img src='http://upload.wikimedia.org/wikipedia/en/1/1c/Hitchhiker%27s_Guide_%28book_cover%29.jpg' style='float:left;margin-top:0px;margin-right:20px;margin-left:20px' height='229' width='140'><h3><br></h3><br><br>        <p style='padding-left:40px;color:#003366'>'Difficulty?'&nbsp;<span style='color:#000000'>exclaimed Ford.</span> 'Difficulty? What do you mean, difficulty? It's the single simplest machine in the entire Universe!'</p>        <p style='padding-left:40px'>The marketing girl soured him with a look.</p>        <p style='padding-left:40px'><span style='color:#993333'>'Alright, Mr. Wiseguy,'</span> she said, <span style='color:#993333'>'if you're so clever, you tell us what colour it should be.'</span></p>";
	
	public static void main(String[] args) throws Exception {

	
		OutputStream os = new FileOutputStream(new File("example.pdf"));

		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(str2);
		renderer.layout();
		renderer.createPDF(os);

		os.close();

//		File inputFile = new File("holaMundo.xhtml");
//		OutputStream os = new FileOutputStream(new File(
//				"xhtmlToPdf_holaMundo.pdf"));
// 
//		ITextRenderer renderer = new ITextRenderer();
//		renderer.setDocument(inputFile);
//		renderer.layout();
//		renderer.createPDF(os);
// 
//		os.close();
	}

}