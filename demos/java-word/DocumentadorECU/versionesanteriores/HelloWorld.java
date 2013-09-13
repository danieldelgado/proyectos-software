package com.vst.ecu.controller;
import java.io.*;

import com.lowagie.text.*;
import com.lowagie.text.rtf.*;

public class HelloWorld {
    public static void main(String[] args) {
        
        System.out.println("This example generate a RTF file name Sample.rtf");
        
        // Create Document object
        Document myDoc = new Document();
        
        try {
            
            // Create writer to listen document object
            // and directs RTF Stream to the file Sample.rtf
            RtfWriter2.getInstance(myDoc, new FileOutputStream("Sample.rtf"));

            // open the document object
            myDoc.open();
            
            // Create a paragraph 
	    Paragraph p = new Paragraph();
	    p.add("Helloworld in Rtf file..amazing isn't");
		
	    // Add the paragraph to document object
	    myDoc.add(p);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        //close the document
        myDoc.close();
    }
} 