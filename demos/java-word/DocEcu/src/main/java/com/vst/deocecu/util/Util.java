package com.vst.deocecu.util;

import java.io.ByteArrayOutputStream;
import org.apache.commons.lang3.StringEscapeUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class Util {

	private static ByteArrayOutputStream os;
	private static ITextRenderer renderer;
	
	public static byte[] convertirHTMLaPDFbytes(String html) {
		try {
			html = unicodeHTML(html);
			os = new ByteArrayOutputStream();
			renderer = new ITextRenderer();
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

	public static String unicodeHTML(String html) {
		return  StringEscapeUtils.unescapeHtml4(html);
	}
	
	
	

}
