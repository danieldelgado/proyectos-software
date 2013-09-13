package com.vst.ecu.controller;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class ConvertHTMLToPDF {

	public static byte[] htmltopdfBytes(String html) {
		try {
			// File f = new File("example.pdf");
			// OutputStream os = new FileOutputStream(f);
			html = "<html><body>" + html + "</body></html>";
			System.out.println("html");
			System.out.println(html);

			Document document = new Document(PageSize.A4);
			document.open();
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(html));
			document.close();
			System.out.println("Done");

			// html = htmlparser.
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ITextRenderer renderer = new ITextRenderer();
//			renderer.setd
			renderer.setDocumentFromString(html);
			// renderer.setDocument((org.w3c.dom.Document) document, null);
			renderer.layout();
			renderer.createPDF(os);
			os.close();

			return os.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static void main(String[] args) {

		// System.out.println(htmltopdfBytes(HtmlToPdf.str));

		Document document = new Document();
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, os);

			document.addAuthor("betterThanZero");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("MySampleCode.com");
			document.addTitle("Demo for iText XMLWorker");
			document.setPageSize(PageSize.LETTER);

			// open document
			document.open();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// String pdfFilename = "";
		// ConvertHTMLToPDF convertHTMLToPDF = new ConvertHTMLToPDF();
		// if (args.length < 1) {
		// System.err.println("Usage: java " +
		// convertHTMLToPDF.getClass().getName() + " PDF_Filename");
		// System.exit(1);
		// }

		// pdfFilename = "plantilla1.pdf";
		// convertHTMLToPDF.createPDF(pdfFilename);

	}

	private void createPDF(String pdfFilename) {

		// path for the PDF file to be generated
		String path = pdfFilename;
		PdfWriter pdfWriter = null;

		// create a new document
		Document document = new Document();

		try {

			// get Instance of the PDFWriter
			pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));

			// document header attributes
			document.addAuthor("betterThanZero");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("MySampleCode.com");
			document.addTitle("Demo for iText XMLWorker");
			document.setPageSize(PageSize.LETTER);

			// open document
			document.open();

			// To convert a HTML file from the filesystem
			// String File_To_Convert = "docs/SamplePDF.html";
			// FileInputStream fis = new FileInputStream(File_To_Convert);

			// URL for HTML page
			URL myWebPage = new URL("http://demo.mysamplecode.com/");
			InputStreamReader fis = new InputStreamReader(myWebPage.openStream());

			// get the XMLWorkerHelper Instance
			XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
			// convert to PDF
			worker.parseXHtml(pdfWriter, document, fis);

			// close the document
			document.close();
			// close the writer
			pdfWriter.close();

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}