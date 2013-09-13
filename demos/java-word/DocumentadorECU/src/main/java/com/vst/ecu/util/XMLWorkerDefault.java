package com.vst.ecu.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementHandler;
import com.itextpdf.tool.xml.Writable;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.pipeline.WritableElement;

public class XMLWorkerDefault {
	static String str = "<html><header></header><body><h2></h2><img src='http://upload.wikimedia.org/wikipedia/en/1/1c/Hitchhiker%27s_Guide_%28book_cover%29.jpg' style='float:left;margin-top:0px;margin-right:20px;margin-left:20px' height='229' width='140'><h3><br></h3><br><br>        <p style='padding-left:40px;color:#003366'>'Difficulty?'&nbsp;<span style='color:#000000'>exclaimed Ford.</span> 'Difficulty? What do you mean, difficulty? It's the single simplest machine in the entire Universe!'</p>        <p style='padding-left:40px'>The marketing girl soured him with a look.</p>        <p style='padding-left:40px'><span style='color:#993333'>'Alright, Mr. Wiseguy,'</span> she said, <span style='color:#993333'>'if you're so clever, you tell us what colour it should be.'</span></p></body></html>";
	static String data = "<HTML><HEAD>"
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

	 public static void pru2() {
		//create a new document
			Document document = new Document();
			try {
				document.open();
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("loremipsum.pdf"));
				HTMLWorker htmlWorker = new HTMLWorker(document);
				htmlWorker.parse(new StringReader(data));
				writer.setInitialLeading(12.5f);
				document.open();
				
//				FileInputStream fis = new FileInputStream("htmls/loremipsum.htm");
				
//				XMLWorkerHelper.getInstance().parseXHtml(writer, document, fis);
				XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(data));
				document.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			document.close();
	 }
	
	 public static void pru() {
		    try {
		      Document document = new Document(PageSize.A4);
		      PdfWriter.getInstance(document, new FileOutputStream("testpdf1.pdf"));
		      document.open();
		      document.addAuthor("Real Gagnon");
		      document.addCreator("Real's HowTo");
		      document.addSubject("Thanks for your support");
		      document.addCreationDate();
		      document.addTitle("Please read this");
		      HTMLWorker htmlWorker = new HTMLWorker(document);
//		      String str = "<html><head></head><body>"+
//		        "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
//		        "<h1>Show your support</h1>" +
//		        "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, " +
//		        "in personal hardware and software costs to set up test environments, and above all," +
//		        "the huge amounts of time it takes for one person to design and write the actual content." +
//		        "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?" +
//		        "<p>Donate using PayPal® to real@rgagnon.com." +
//		        "<p>Contributions via PayPal are accepted in any amount " +
//		        "<P><br><table border='1'><tr><td>Java HowTo<tr>" +
//		        "<td bgcolor='red'>Javascript HowTo<tr><td>Powerbuilder HowTo</table>" +
//		        "</body></html>";
		      htmlWorker.parse(new StringReader(str));
		      document.close();
		      System.out.println("Done");
		      }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
	
	
	
	
	
	public static void main(String[] args) {
		pru2();
//		defaultExample();
	}
	private static void defaultExample(){
		//create a new document
		Document document = new Document();
		try {
			//create a pdfwriter instance
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("results/loremipsum.pdf"));
			writer.setInitialLeading(12.5f);
			//open the document
			document.open();
			//create a file inputstream to read the html file
			FileInputStream fis = new FileInputStream("htmls/loremipsum.htm");
			//use parseXHtml to parse the file read by the inputstream
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
	}
	private static void elementExample(){
		
		try {
			FileInputStream fis = new FileInputStream("htmls/loremipsum.htm");
			XMLWorkerHelper.getInstance().parseXHtml(new ElementHandler() {
			
				@Override
				public void add(Writable w) {
					// TODO Auto-generated method stub
					 if (w instanceof WritableElement) {
				            List<Element> elements = ((WritableElement)w).elements();
				            // write class names of elements to file
				            recursiveElements(elements);
				        }
				}
			},fis, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void recursiveElements(List<Element> elements){
		List<Element> els = new ArrayList<Element>();
		List<Element> els2 = new ArrayList<Element>();
		 for(Element e:elements){
         	System.out.append(e.getClass().getSimpleName()+"\n");
         	
         		
         		if(e instanceof PdfDiv){
         			els = ((PdfDiv)e).getContent();
         			System.out.append("div\n");
         			System.out.append(els.size()+"\n");
         		}else if(e instanceof Paragraph){
         			els2 = ((Paragraph)e).breakUp();
         			System.out.append(els2.size()+"\n");
         			System.out.append(((Paragraph)e).getContent()+"\n");
         		}
         		if(els.size()>0){
         			recursiveElements(els);
         		}
         	}
	}
}
