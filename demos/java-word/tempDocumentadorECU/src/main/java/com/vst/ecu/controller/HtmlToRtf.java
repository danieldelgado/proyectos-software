package com.vst.ecu.controller;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.rtf.*;
import javax.swing.text.html.*;
import java.io.*;

public class HtmlToRtf extends JFrame {
	public static void main(String[] s) {
		new HtmlToRtf();
	}

	public HtmlToRtf() {
		convertHtmlToRtf();
		setSize(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		show();
	}

	public void convertHtmlToRtf() {
		RTFEditorKit rtf_edit = new RTFEditorKit();
		JTextPane jtp_rtf = new JTextPane();
		JEditorPane editor = new JEditorPane();
		DefaultStyledDocument rtf_doc;
		jtp_rtf.setEditorKit(rtf_edit);
		jtp_rtf.setContentType("html/rtf");
		editor.setContentType("text/html");
		StyledDocument editdoc = (StyledDocument) editor.getDocument();
		EditorKit editkit = editor.getEditorKit();
		rtf_doc = new DefaultStyledDocument();

		String data = "<HTML><HEAD>"
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

		try {
			StringReader strReader = new StringReader(data);
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
			ByteArrayOutputStream strBuffer = new ByteArrayOutputStream();
			rtf_edit.write(strBuffer, rtf_doc, 0, rtf_doc.getLength());
			StringReader reader = new StringReader(strBuffer.toString());
			JTextPane pane = new JTextPane();
			RTFEditorKit kit = new RTFEditorKit();
			pane.setEditorKit(kit);
			StyledDocument doc = new DefaultStyledDocument();
			kit.read(reader, doc, 0);
			pane.setStyledDocument(doc);
			getContentPane().add(pane);

			System.out.println(strBuffer.toString());
			System.out.println("Converted Successfully");
		} catch (Exception ex) {
			System.out.println("Error: " + ex.toString());
		}
	}
};