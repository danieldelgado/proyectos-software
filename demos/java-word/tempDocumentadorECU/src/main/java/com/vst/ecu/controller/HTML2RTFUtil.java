package com.vst.ecu.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;

public class HTML2RTFUtil {
//        private static final Logger log = Logger.getLogger(HTML2RTFUtil.class);
        private static Pattern htmlTrimPattern = Pattern.compile(".*<body>(.*)</body>.*", Pattern.DOTALL);
       
        public static String rtfToHtml2(Reader rtf) throws IOException {
    		JEditorPane p = new JEditorPane();
    		p.setContentType("text/rtf");
    		EditorKit kitRtf = p.getEditorKitForContentType("text/rtf");
    		try {
    			kitRtf.read(rtf, p.getDocument(), 0);
    			kitRtf = null;
    			EditorKit kitHtml = p.getEditorKitForContentType("text/html");
    			Writer writer = new StringWriter();
    			kitHtml.write(writer, p.getDocument(), 0, p.getDocument().getLength());
    			return writer.toString();
    		} catch (BadLocationException e) {
    			e.printStackTrace();
    		}
    		return null;
    	}
        
        public static String toHtml(String rtf) {
                ByteArrayInputStream input= new ByteArrayInputStream(rtf.getBytes());
                StringWriter writer = new StringWriter();
                try {
                        RTFEditorKit rtfEditorKit = new RTFEditorKit();
                        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                        Document doc = rtfEditorKit.createDefaultDocument();
                        rtfEditorKit.read(input, doc, 0);
                        htmlEditorKit.write(writer, doc, 0, doc.getLength());
                } catch (Exception ex) {
//                        log.error("Error during converting rtf 2 html!", ex);
                }
                String html = writer.toString();
                Matcher m = htmlTrimPattern.matcher(html);
               
                // html content
                html=m.group(1);
               
                System.out.println(rtf+"\nrtf->html\n"+html);
               
                return html;
        }
       
        public static String toRtf(String html) {
                ByteArrayInputStream input= new ByteArrayInputStream(html.getBytes());
                StringWriter writer = new StringWriter();
                try {
                        RTFEditorKit rtfEditorKit = new RTFEditorKit();
                        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                        Document htmlDoc = htmlEditorKit.createDefaultDocument();
                        htmlEditorKit.read(input, htmlDoc, 0);
                        rtfEditorKit.write(writer, htmlDoc, 0, htmlDoc.getLength());
                } catch (Exception ex) {
//                        log.error("Error during converting html 2 rtf!", ex);
                }
                System.out.println(html+"\nhtml->rtf\n"+writer.toString());
                return writer.toString();
        }
}