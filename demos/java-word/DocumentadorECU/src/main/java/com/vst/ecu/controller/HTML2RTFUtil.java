package com.vst.ecu.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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
        
        public static String toRtf2(String html) {
			ByteArrayOutputStream strBuffer = new ByteArrayOutputStream();
        	try {
        		RTFEditorKit rtf_edit = new RTFEditorKit();
        		DefaultStyledDocument rtf_doc = new DefaultStyledDocument();
        		JTextPane jtp_rtf = new JTextPane();
//        		jtp_rtf.setContentType( "text/html" );
        		JEditorPane editor = new JEditorPane();
        		editor.setContentType( "text/html" );
        		StyledDocument editdoc = (StyledDocument) editor.getDocument();
        		EditorKit editkit = editor.getEditorKit();
    			StringReader strReader = new StringReader(html);
    			editkit.read(strReader, editdoc, 0);
    			// getContentPane().add(editor); //uncomment it to check the
    			// behaviour
    			int len = editdoc.getLength();
    			for (int i = 0; i < len; i++) {
    				AttributeSet a = editdoc.getCharacterElement(i).getAttributes();
    				MutableAttributeSet attr = new SimpleAttributeSet();
    				StyleConstants.setFontFamily(attr, StyleConstants.getFontFamily(a));
    				StyleConstants.setFontSize(attr, StyleConstants.getFontSize(a));
    				StyleConstants.setUnderline(attr, StyleConstants.isUnderline(a));
    				StyleConstants.setBold(attr, StyleConstants.isBold(a));
    				StyleConstants.setItalic(attr, StyleConstants.isItalic(a));
    				StyleConstants.setForeground(attr, StyleConstants.getForeground(a));
    				String s = editor.getText(i, 1);
    				jtp_rtf.setCharacterAttributes(attr, true);
    				rtf_doc.insertString(i, s, attr);
    			}
    			jtp_rtf.setStyledDocument(rtf_doc);
    			rtf_edit.write(strBuffer, rtf_doc, 0, rtf_doc.getLength());
    			StringReader reader = new StringReader(strBuffer.toString());
    			JTextPane pane = new JTextPane();
    			RTFEditorKit kit = new RTFEditorKit();
    			pane.setEditorKit(kit);
    			StyledDocument doc = new DefaultStyledDocument();
    			kit.read(reader, doc, 0);
    			pane.setStyledDocument(doc);
//    			getContentPane().add(pane);

    			System.out.println(strBuffer.toString());
    			System.out.println("Converted Successfully");
    		} catch (Exception ex) {
    			System.out.println("Error: " + ex.toString());
    			ex.printStackTrace();
    		}
        	return strBuffer.toString();
        }
       static  String data = "<HTML><HEAD>"
				+ "<TITLE></TITLE>"
				+ "</HEAD>"
				+ "<BODY BGCOLOR=\"WHITE\">"
				+ "<P STYLE=\"margin-top:0px;margin-bottom:0px\" ALIGN=\"center\"><FONT FACE=\"Times New Roman\" SIZE=\"3\"><B>STATEMENT OF ADDITIONAL<BR> INFORMATION </B></FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT "
				+ "SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\" ALIGN=\"center\"><FONT FACE=\"Times New Roman\" SIZE=\"3\"><B>M<SMALL>ERRILL</SMALL> L<SMALL>YNCH</SMALL>"
				+ "B<SMALL>OND</SMALL> F<SMALL>UND</SMALL>, I<SMALL>NC</SMALL>. </B></FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\" ALIGN=\"center\"><FONT FACE=\"Times New Roman\""
				+ "SIZE=\"2\"><B>P.O. Box 9011, Princeton, New Jersey 08543-9011 • Phone No. (609) 282-2800 </B></FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT FACE=\"Times New Roman\" SIZE=\"2\">This Statement of Additional <BR>Information of Merrill Lynch Bond Fund, Inc. (the “Fund” is not a prospectus and should be read in"
				+ "conjunction with the Prospectus of the Fund, dated January <BR>, 2004, which has been filed with the Securities and Exchange Commission (the “commission” and can be obtained, without charge, by calling 1-800-MER-FUND or by writing to the Fund"
				+ "at the above address. The fund’s prospectus<BR> is incorporated by reference into this Statement of Additional Information, and Part I of this Statement of Additional Information and the portions of Part II of this Statement of Additional"
				+ "Information that relate to the Fund have been incorporated by <BR>reference into the Fund’s Prospectus. The portions of Part II of this Statement of Additional Information that do not relate to the Fund, do not form a part of the Fund’s"
				+ "Statement of Additional Information, have not been incorporated by<BR> reference into the Fund’s Prospectus and should not be relied upon by investors in the Fund. The Fund’s audited financial statements are incorporated by reference into this"
				+ "Statement of Additional Information by reference to <BR>the Fund’s 2003 Annual Report. You may request a copy of the Annual Report at no charge by calling 1-800-637-3863 between 8:30 a.m. and 5:30 p.m. Eastern time on any business day. </FONT></P>"
				+ "</BODY></HTML>";
        
        public static void main(String[] args) {
			System.out.println(toRtf2(data));
		}
        
}