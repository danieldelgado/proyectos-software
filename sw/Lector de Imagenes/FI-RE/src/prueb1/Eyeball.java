package prueb1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
import java.net.*;
import java.io.*;

public class Eyeball extends JFrame
implements ListSelectionListener, HyperlinkListener
{
   static String filename, filename2;
   static File dir = new File("/home/crossfire/Documentos/files/archivos y resultado de las pruebas /");
   File[] files;
   JList usernameList;
   JEditorPane display, display2;

   public Eyeball()
   {
      setTitle("Eyeball");

      // Read usernames from directory.
      String[] usernames;
      files = dir.listFiles(new DirFilter());
      Arrays.sort(files);
      usernames = new String[files.length];
      for (int i=0; i<files.length; i++) usernames[i] = files[i].getName();

      //Create the list of usernames and put it in a scroll pane.
      usernameList = new JList(usernames);
      usernameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      usernameList.setSelectedIndex(0);
      usernameList.addListSelectionListener(this);
      JScrollPane usernameScrollPane = new JScrollPane(usernameList);
      Dimension minimumSize = new Dimension(100, 50);
      usernameScrollPane.setMinimumSize(minimumSize);

      // Initialise the display
      display = new JEditorPane();
      display.setEditable(false);
      display.addHyperlinkListener(this);
      JScrollPane scroller = new JScrollPane(display);
//    scroller.setPreferredSize(new Dimension(768, 576));
      scroller.setMinimumSize(new Dimension(100, 50));
      read(display, files[0], filename);

      // Initialise the display, if there is a second filename.
      JScrollPane scroller2 = null;
      if (filename2 != null)
      {
         display2 = new JEditorPane();
         display2.setEditable(false);
         display2.addHyperlinkListener(this);
         scroller2 = new JScrollPane(display2);
         scroller2.setMinimumSize(new Dimension(100, 50));
         read(display2, files[0], filename2);
      }

      // Create the right component as one or two displays.
      JComponent right = scroller;
      if (display2 != null)
      {
         JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
            scroller, scroller2);
         rightPane.setOneTouchExpandable(true);
         rightPane.setDividerLocation(150);
         right = rightPane;
      }

      //Create a split pane with the lists and display(s) in it.
      JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                 usernameScrollPane, right);
      splitPane.setOneTouchExpandable(true);
      splitPane.setDividerLocation(150);
      splitPane.setPreferredSize(new Dimension(400, 200));

      add(splitPane);
   }

   public void valueChanged(ListSelectionEvent e)
   {
      if (e.getValueIsAdjusting()) return;

      JList theList = (JList)e.getSource();
      if (theList.isSelectionEmpty())
      {
         read(display, "Nothing selected.");
      }
      else
      {
         int index = theList.getSelectedIndex();
         read(display, files[index], filename);
         if (display2 != null) read(display2, files[index], filename2);
      }
   }

   // Read a file into a display window.
   private void read(JEditorPane display, File username, String filename)
   {
      File file = new File(username, filename);
      try
      {
         if (! file.exists())
         {
            read(display,"Can't find " + file.getPath());
            return;
         }
         URL page = file.toURL();
         display.setPage(page);
      }
      catch (Exception err)
      {
         read(display, "Can't display " + file.getPath());
      }
   }

   // read text into a display window (there is a big if tou just use setText)
   private void read(JEditorPane display, String text)
   {
      StringReader reader = new StringReader(text);
      try { display.read(reader, null); }
      catch (Exception e) { }
   }

   // Respond to the user following a link on the help pages.
   public void hyperlinkUpdate(HyperlinkEvent event)
   {
      if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
      {
         try
         {
            display.setPage(event.getURL());
         }
         catch(Exception e)
         {
         }
      }
   }

   private static void createAndShowGUI()
   {
      //Make sure we have nice window decorations.
      JFrame.setDefaultLookAndFeelDecorated(true);
      JDialog.setDefaultLookAndFeelDecorated(true);

      //Create and set up the window.
      JFrame frame = new Eyeball();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Display the window.
      frame.pack();
      frame.setVisible(true);
   }

   public static void main(String[] args)
   {
//      if (args.length == 1) filename = args[0];
//      else if (args.length == 2)
//      {
//         filename = args[0];
//         filename2 = args[1];
//      }
//      else if (args.length == 3 && args[0].equals("-d"))
//      {
//         dir = new File(args[1]);
//         filename = args[2];
//      }
//      else if (args.length == 4 && args[0].equals("-d"))
//      {
//         dir = new File(args[1]);
//         filename = args[2];
//         filename2 = args[3];
//      }
//      else
//      {
//         System.err.println("Usage: java Eyeball [-d dir] filename [filename]");
//         System.exit(1);
//      }
//	   dir="-d";
	   filename = "/home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png";
	   filename2 = "/home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png";
	   
	   
      javax.swing.SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            createAndShowGUI();
         }
      });
   }

   private static class DirFilter implements FileFilter
   {
      public boolean accept(File file)
      {
         return file.isDirectory();
      }
   }
}