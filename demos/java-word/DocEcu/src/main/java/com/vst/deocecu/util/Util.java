package com.vst.deocecu.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringEscapeUtils;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;



public class Util {

	static String str = "<!DOCTYPE html><html>"
			+ "<head>"
			+ "</head>"
			+ "<body>"
			+ "<p><span style=\"font-family: 'comic sans ms', sans-serif;\">FWEFEWFWFEWFWEF</span></p>"
			+ "<p><span style=\"font-family: 'comic sans ms', sans-serif;\">E<strong>F</strong></span></p>"
			+ "<p><span style=\"font-family: 'comic sans ms', sans-serif;\"><strong>EWFEW</strong>Fdweqfe</span>w<em>fefewf</em></p>"
			+ "<hr /><hr /><hr />"
			+ "<p></p>"
			+ "<table style=\"width: 1px; float: left;\" border=\"1\" cellspacing=\"1\" cellpadding=\"1\"><caption>qwdqwqfwqf</caption>"
			+ "<tbody>"
			+ "<tr>"
			+ "<td></td>"
			+ "<td>qwfqTest <span style=\"font-family: 'comic sans ms', sans-serif;\">2w</span></td>"
			+ "<td></td>"
			+ "</tr>"
			+ "<tr>"
			+ "<td>qwfwqfqf</td>"
			+ "<td></td>"
			+ "<td><span style=\"font-size: 10pt; color: #ff0000; background-color: #99cc00;\">qfdqwdf</span></td>"
			+ "</tr>" + "</tbody>" + "</table>" 
			+ "</body>" + "</html>";

	public static byte[] getpdftohtmlbytes2(String html) {
		try {
			
//			String afterDecoding = StringEscapeUtils.unescapeHtml4(html);
//			System.out.println("afterDecoding");
//			System.out.println(afterDecoding);
//			String afterDecoding2 = StringEscapeUtils.unescapeHtml3(html);
//			System.out.println("afterDecoding2");
//			System.out.println(afterDecoding2);
//			
//			html = html.replace("&nbsp;"," ");
			html = StringEscapeUtils.unescapeHtml4(html);
			// Document document = new Document(PageSize.A4);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(html);
			renderer.layout();
			renderer.createPDF(os);
			os.close();
			return os.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static byte[] getpdftohtmlbytes(String html) {

		try {
			try {
				String afterDecoding = StringEscapeUtils.unescapeHtml4(html);
				System.out.println("afterDecoding");
				System.out.println(afterDecoding);
				String afterDecoding2 = StringEscapeUtils.unescapeHtml3(html);
				System.out.println("afterDecoding2");
				System.out.println(afterDecoding2);
				
				html = html.replace("&nbsp;"," ");
				 DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				    Document doc = builder.parse(new StringBufferInputStream(html));

				    ITextRenderer renderer = new ITextRenderer();
				    renderer.setDocument(doc, null);

				    String outputFile = "100bottles.pdf";
//				    OutputStream os = new FileOutputStream(outputFile);
				    renderer.layout();
					ByteArrayOutputStream os = new ByteArrayOutputStream();
				    renderer.createPDF(os);
				    os.close();

					return os.toByteArray();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println(getpdftohtmlbytes(str));
	}

}
