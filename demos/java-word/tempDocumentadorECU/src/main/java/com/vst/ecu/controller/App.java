package com.vst.ecu.controller;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
  
  
  public class App {   
    public void newWordDoc(String filename, String fileContent)   
         throws Exception {   
       XWPFDocument document = new XWPFDocument();   
       XWPFParagraph tmpParagraph = document.createParagraph();   
       XWPFRun tmpRun = tmpParagraph.createRun();   
       tmpRun.setText(fileContent);   
       tmpRun.setFontSize(18);   
       FileOutputStream fos = new FileOutputStream(new File(filename + ".doc"));   
       document.write(fos);   
       fos.close(); 

       FileOutputStream fos2 = new FileOutputStream(new File(filename + "2.docx"));   
       document.write(fos2);   
       fos2.close(); 
       
       
       
//       HWPFDocumentCore wordDocument = WordToHtmlUtils.loadDoc(new FileInputStream(filename + "2.docx"));
//
//       WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
//               DocumentBuilderFactory.newInstance().newDocumentBuilder()
//                       .newDocument());
//       wordToHtmlConverter.processDocument(wordDocument);
//       Document htmlDocument = wordToHtmlConverter.getDocument();
//       ByteArrayOutputStream out = new ByteArrayOutputStream();
//       DOMSource domSource = new DOMSource(htmlDocument);
//       StreamResult streamResult = new StreamResult(out);
//
//       TransformerFactory tf = TransformerFactory.newInstance();
//       Transformer serializer = tf.newTransformer();
//       serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//       serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//       serializer.setOutputProperty(OutputKeys.METHOD, "html");
//       serializer.transform(domSource, streamResult);
//       out.close();
//
//       String result = new String(out.toByteArray());
//       System.out.println(result);
       
    }   
    public static void main(String[] args) throws Exception {   
         App app = new App();   
         app.newWordDoc("testfile", "Hello World!");   
    }   
  }   