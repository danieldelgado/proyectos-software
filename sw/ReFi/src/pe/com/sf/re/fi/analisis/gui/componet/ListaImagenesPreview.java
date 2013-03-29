package pe.com.sf.re.fi.analisis.gui.componet;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import pe.com.sf.re.fi.util.Constantes;

@SuppressWarnings("serial")
public class ListaImagenesPreview extends CustomPanel {

	JEditorPane pane;
	String fileName;
	JScrollPane scroller;
	String imgSelecionado = "";

	public ListaImagenesPreview() {
		setLayout(new BorderLayout());
		pane = new JEditorPane();
		scroller = new JScrollPane(pane);
		pane.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent r) {
				try {
					imgSelecionado = r.getURL().getRef();					
				} catch (Exception e) {
					
				}
			}
		});
		pane.setEditable(false);
		add(scroller, BorderLayout.CENTER);
	}

	public void createHtmlTemp() {
		fileName = Constantes.HTML_TEMP;
		StringBuffer a = new StringBuffer();
		a.append("<html>\r\n");
		a.append("<body>\r\n ");
		a.append("<div>\r\n");
		a.append("<a id='#img1' href='#img1'> <img src='file:///home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png'   width='100' height='100'  > </a><br>\r\n");
		a.append("<a id='#img2' href='#img2'> <img src='file:///home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png'   width='100' height='100'  > </a><br>\r\n");
		a.append("<a id='#img3' href='#img3'> <img src='file:///home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png'   width='100' height='100'  >  </a><br>\r\n");
		a.append("</div>\r\n");
		a.append("</body>\r\n");
		a.append("</html>\r\n");
		File htmlTemp = new File(fileName);
		if(htmlTemp.exists()){
			htmlTemp.delete();
		}
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(htmlTemp));
			bufferedWriter.write(a.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.flush();
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public void cargarEditorPane() {
		try {
			pane.setPage("file://" + new File(fileName).getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
