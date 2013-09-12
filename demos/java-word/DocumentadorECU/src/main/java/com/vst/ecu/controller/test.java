package com.vst.ecu.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

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

//http://java-sl.com/advanced_rtf_editor_kit.html
	//http://code.google.com/p/jrtf/
//http://pd4ml.com/cookbook/html_to_rtf_conversion.htm
//http://stackoverflow.com/questions/4521557/automatically-convert-style-sheets-to-inline-style
public class test {

	public static String str = "<HTML> <HEAD><TITLE></TITLE> </HEAD>  <BODY>    <P>  fwefwef wefvwe </P>  </BODY></HTML>";
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
	 static  String data2 = "<HTML><HEAD>"
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

	 static  String data3 = "<HTML><HEAD>"
				+ "<TITLE></TITLE>"
				+ "</HEAD>"
				+ "<BODY BGCOLOR=\"WHITE\">"
				+ "<P STYLE=\"margin-top:0px;margin-bottom:0px\" ALIGN=\"center\"><FONT FACE=\"Times New Roman\" SIZE=\"3\"><B>STATEMENT OF ADDITIONAL<BR> INFORMATION </B></FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT "
				+ "SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\" ALIGN=\"center\"><FONT FACE=\"Times New Roman\" SIZE=\"3\"><B>M<SMALL>ERRILL</SMALL> L<SMALL>YNCH</SMALL>"
				+ "B<SMALL>OND</SMALL> F<SMALL>UND</SMALL>, I<SMALL>NC</SMALL>. </B></FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\" ALIGN=\"center\"><FONT FACE=\"Times New Roman\""
				+ "SIZE=\"2\"><B>P.O. Box 9011, Princeton, New Jersey 08543-9011 • Phone No. (609) 282-2800 </B></FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT SIZE=\"1\"> </FONT></P> <P STYLE=\"margin-top:0px;margin-bottom:0px\"><FONT FACE=\"Times New Roman\" SIZE=\"2\">This Statement of Additional <BR>Information of Merrill Lynch Bond Fund, Inc. (the “Fund”  is not a prospectus and should be read in"
				+ "conjunction with the Prospectus of the Fund, dated January <BR>, 2004, which has been filed with the Securities and Exchange Commission (the “commission”  and can be obtained, without charge, by calling 1-800-MER-FUND or by writing to the Fund"
				+ "at the above address. The fund’s prospectus<BR> is incorporated by reference into this Statement of Additional Information, and Part I of this Statement of Additional Information and the portions of Part II of this Statement of Additional"
				+ "Information that relate to the Fund have been incorporated by <BR>reference into the Fund’s Prospectus. The portions of Part II of this Statement of Additional Information that do not relate to the Fund, do not form a part of the Fund’s"
				+ "Statement of Additional Information, have not been incorporated by<BR> reference into the Fund’s Prospectus and should not be relied upon by investors in the Fund. The Fund’s audited financial statements are incorporated by reference into this"
				+ "Statement of Additional Information by reference to <BR>the Fund’s 2003 Annual Report. You may request a copy of the Annual Report at no charge by calling 1-800-637-3863 between 8:30 a.m. and 5:30 p.m. Eastern time on any business day. </FONT></P>"
				+ "</BODY></HTML>";
	
	 public static String convertHTMLtoRFT(String html){
		 JEditorPane editor = new JEditorPane();
			RTFEditorKit rtf_edit = new RTFEditorKit();
			DefaultStyledDocument rtf_doc;
			 StyledDocument editdoc ;
			 EditorKit editkit;
			 JTextPane jtp_rtf = new JTextPane();
			 StringReader strReader;
//			 StringReader reader;
			ByteArrayOutputStream strBuffer = new ByteArrayOutputStream();
			try {
			strReader = new StringReader(html);
			jtp_rtf.setEditorKit(rtf_edit);
			jtp_rtf.setContentType("html/rtf");
			editor.setContentType("text/html");
			editdoc = (StyledDocument) editor.getDocument();
			editkit = editor.getEditorKit();
			rtf_doc = new DefaultStyledDocument();
			strReader = new StringReader(html);
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
//			reader = new StringReader(strBuffer.toString());

			} catch (Exception e) {
			}
			return strBuffer.toString();
		}
	 
	public static void main(String[] args) {
		try {

			System.out.println(convertHTMLtoRFT(data));
			System.out.println("--------------");
			System.out.println(convertHTMLtoRFT(str));
			System.out.println("--------------");
			System.out.println(convertHTMLtoRFT(data3));			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
