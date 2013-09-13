package com.vst.ecu.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Calendar;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfWriter;
 
public class HTML2PDF {
 
	static String str = "<html><boby><h2></h2>" +
			"<img src='http://upload.wikimedia.org/wikipedia/en/1/1c/Hitchhiker%27s_Guide_%28book_cover%29.jpg' " +
			"style='float:right' height='229' width='140'><h3><br></h3>"+
	        "<p style='padding-left:40px;color:#003366;text-align:right'>'Difficulty?'&nbsp;<span style='color:#000000'>exclaimed Ford.</span> 'Difficulty? What do you mean, difficulty? It's the single simplest machine in the entire Universe!'</p>"+
	       " <p style='padding-left:40px;text-align:right'>The marketing girl soured him with a look.</p>"+
	        "<p style='padding-left:40px'><span style='color:#993333;text-align:right'>'Alright, Mr. Wiseguy,'</span></p><div style='text-align:right'> she said, </div><span style='color:#993333;text-align:right'>'if you're so clever, you tell us what colour it should be.'</span><p></p><p style='padding-left:40px'><span style='color:#993333;text-align:right'></span></p><p style='padding-left:40px;text-align:justify'><span style='color:#333333;text-align:right'>rtjyytjtjgr ergr re rgerg ergergergreg</span></p><p style='padding-left:40px;text-align:justify'><span style='color:#333333;text-align:right'>erg</span></p><p style='padding-left:40px;text-align:justify'><span style='color:#333333;text-align:right'>reg</span></p><p style='padding-left:40px;text-align:justify'><span style='color:#333333;text-align:right'>regergergregergergergregregergergergergerg</span></p>" +
	        "</boby></html>";
	
	public static byte[] read(File file) throws IOException {


	    byte []buffer = new byte[(int) file.length()];
	    InputStream ios = null;
	    try {
	        ios = new FileInputStream(file);
	        if ( ios.read(buffer) == -1 ) {
	            throw new IOException("EOF reached while trying to read the whole file");
	        }        
	    } finally { 
	        try {
	             if ( ios != null ) 
	                  ios.close();
	        } catch ( IOException e) {
	        }
	    }

	    return buffer;
	}
	
	public static byte[] bytesHTMLtoPDF(String data){
		try {			
		  long c = Calendar.getInstance().getTime().getTime();
		  String name = "plantilla"+c+".pdf";
		  File f = new File(name);
		  Document document = new Document(PageSize.A4);
//		  PdfWriter pdfWriter = 
		  PdfWriter.getInstance(document, new FileOutputStream(f.getAbsolutePath()) );
	      document.open();
	      document.addAuthor("Persona creadora");
	      document.addCreator("Software generador");
	      document.addCreationDate();
	      document.addTitle("Titulo del documento");	 
	      HTMLWorker htmlWorker = new HTMLWorker(document);
	      htmlWorker.parse(new StringReader(data)); 
	      document.close();	      
	      byte[] bts = read(f);	      
	      return bts;
	      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
  public static void main(String ... args ) {
    try {
      Document document = new Document(PageSize.A4);
      PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("plantilla.pdf"));
      document.open();
      document.addAuthor("Persona creadora");
      document.addCreator("Software generador");
      document.addCreationDate();
      document.addTitle("Titulo del documento");
 
      HTMLWorker htmlWorker = new HTMLWorker(document);
    /*  String data = "<HTML><HEAD>"
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
				+ "</BODY></HTML>";*/
     
//      String str = "<HTML><HEAD><TITLE></TITLE></HEAD><BODY BGCOLOR=\"WHITE\"> <h2></h2><img src='http://upload.wikimedia.org/wikipedia/en/1/1c/Hitchhiker%27s_Guide_%28book_cover%29.jpg' style='float:left;margin-top:0px;margin-right:20px;margin-left:20px' height='229' width='140'><h3><br></h3><br><br>"+
//					"<p style='padding-left:40px;color:#003366'>'Difficulty?'&nbsp;<span style='color:#000000'>exclaimed Ford.</span> 'Difficulty? What do you mean, difficulty? It's the single simplest machine in the entire Universe!'</p>"+
//					"<p style='padding-left:40px'>The marketing girl soured him with a look.</p>"+
//					"<p style='padding-left:40px'><span style='color:#993333'>'Alright, Mr. Wiseguy,'</span> she said, <span style='color:#993333'>'if you're so clever, you tell us what colour it should be.'</span></p></BODY></HTML>"; 
      htmlWorker.parse(new StringReader(str)); 
      document.close();
    } catch (Exception e) { 
      e.printStackTrace(); 
    } 
  } 
}