package com.vst.ecu.controller;
import java.io.FileOutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker; // deprecated
import com.itextpdf.text.pdf.PdfWriter;

public class HtmlToPDF1 {
  // itextpdf-5.4.1.jar  http://sourceforge.net/projects/itext/files/iText/
	
	
	static String str = "<HTML><HEAD><TITLE></TITLE></HEAD><BODY BGCOLOR=\"WHITE\"> <h2></h2><img src='http://upload.wikimedia.org/wikipedia/en/1/1c/Hitchhiker%27s_Guide_%28book_cover%29.jpg' style='float:left;margin-top:0px;margin-right:20px;margin-left:20px' height='229' width='140'/><h3></h3>"+
			"<p style='padding-left:40px;color:#003366'>'Difficulty?'&nbsp;<span style='color:#000000'>exclaimed Ford.</span> 'Difficulty? What do you mean, difficulty? It's the single simplest machine in the entire Universe!'</p>"+
			"<p style='padding-left:40px'>The marketing girl soured him with a look.</p>"+
			"<p style='padding-left:40px'><span style='color:#993333'>'Alright, Mr. Wiseguy,'</span> she said, <span style='color:#993333'>'if you're so clever, you tell us what colour it should be.'</span></p></BODY></HTML>"; 

	
	
	
	
  public static void main(String ... args ) {
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
//      String str = "<html><head></head><body>"+
//        "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
//        "<h1>Show your support</h1>" +
//        "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, " +
//        "in personal hardware and software costs to set up test environments, and above all," +
//        "the huge amounts of time it takes for one person to design and write the actual content." +
//        "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?" +
//        "<p>Donate using PayPal® to real@rgagnon.com." +
//        "<p>Contributions via PayPal are accepted in any amount " +
//        "<P><br><table border='1'><tr><td>Java HowTo<tr>" +
//        "<td bgcolor='red'>Javascript HowTo<tr><td>Powerbuilder HowTo</table>" +
//        "</body></html>";
      htmlWorker.parse(new StringReader(HtmlToPdf.str));
      document.close();
      System.out.println("Done");
      }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}