package com.vst.deocecu.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;

public class Util {

	private static final Logger logger = LoggerFactory.getLogger(Util.class);
	
	private static ByteArrayOutputStream os;
	private static ITextRenderer renderer;
	private static byte[] b;
	
	public static byte[] convertirHTMLaPDFbytes(String html) throws DocumentException, IOException {		
			logger.info("convertirHTMLaPDFbytes html:\n"+html);
			if(html!=null && !html.equals("")){
				html = unicodeHTML(html);
				os = new ByteArrayOutputStream();
				renderer = new ITextRenderer();
				renderer.setDocumentFromString(html);
				renderer.layout();
				renderer.createPDF(os);
				os.close();
				b = os.toByteArray();
				os = null;
				renderer = null;				
				if(b!=null){
					logger.info("html convertido en pdf bytes:"+b.length);
					return b;
				}else{
					logger.info("no se pudo convertir");
					return null;
				}
			}else{
				logger.info("el argumento html es null o vacio");
				return null;
			}			
	}

	public static String unicodeHTML(String html) {
		return  StringEscapeUtils.unescapeHtml4(html);
	}
	
	
	

}
