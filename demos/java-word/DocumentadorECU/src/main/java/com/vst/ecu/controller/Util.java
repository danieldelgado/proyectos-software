package com.vst.ecu.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;

public class Util {

	private static Pattern htmlTrimPattern = Pattern.compile(".*<body>(.*)</body>.*", Pattern.DOTALL);

	public static String toHtml(String rtf) {
		ByteArrayInputStream input = new ByteArrayInputStream(rtf.getBytes());
		StringWriter writer = new StringWriter();
		try {
			RTFEditorKit rtfEditorKit = new RTFEditorKit();
			HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
			Document doc = rtfEditorKit.createDefaultDocument();
			rtfEditorKit.read(input, doc, 0);
			htmlEditorKit.write(writer, doc, 0, doc.getLength());
		} catch (Exception ex) {
			// log.error("Error during converting rtf 2 html!", ex);
		}
		String html = writer.toString();
		Matcher m = htmlTrimPattern.matcher(html);

		// html content
		html = m.group(1);

		System.out.println(rtf + "\nrtf->html\n" + html);

		return html;
	}

	public static String toRtf(String html) {
		ByteArrayInputStream input = new ByteArrayInputStream(html.getBytes());
		StringWriter writer = new StringWriter();
		try {
			RTFEditorKit rtfEditorKit = new RTFEditorKit();
			HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
			Document htmlDoc = htmlEditorKit.createDefaultDocument();
			htmlEditorKit.read(input, htmlDoc, 0);
			rtfEditorKit.write(writer, htmlDoc, 0, htmlDoc.getLength());
		} catch (Exception ex) {
			// log.error("Error during converting html 2 rtf!", ex);
		}
		System.out.println(html + "\nhtml->rtf\n" + writer.toString());
		return writer.toString();
	}

	public static String convertHTMLtoRFT(String html) {
		JEditorPane editor = new JEditorPane();
		RTFEditorKit rtf_edit = new RTFEditorKit();
		DefaultStyledDocument rtf_doc;
		StyledDocument editdoc;
		EditorKit editkit;
		JTextPane jtp_rtf = new JTextPane();
		StringReader strReader;
		// StringReader reader;
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
			// reader = new StringReader(strBuffer.toString());

		} catch (Exception e) {
		}
		return strBuffer.toString();
	}

}
