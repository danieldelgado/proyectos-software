package pe.com.sf.re.fi.analisis.gui.componet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import pe.com.sf.re.fi.analisis.gui.PanelCentral;
import pe.com.sf.re.fi.util.Constantes;

@SuppressWarnings("serial")
public class ListaImagenesPreview extends CustomPanel {

	private JEditorPane pane;
	private String fileName;
	private JScrollPane scroller;
	private JSeparator separdor;
	private String imgSelecionado;
	private Map<Integer, File> lstArchivos;
	private String html = null;
	private File htmlTemp = null;
	private StringBuffer sbfHtml = null;
	private final static Logger _log = Logger.getLogger(PanelCentral.class.getName());
	
	public ListaImagenesPreview() {
		setLayout(new BorderLayout());
		pane = new JEditorPane();
		scroller = new JScrollPane();
		separdor = new JSeparator();
		pane.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent r) {
				try {
					imgSelecionado = r.getURL().getRef();
					_log.info("Key imgSelecionado:"+imgSelecionado);
				} catch (Exception e) {

				}
			}
		});
		pane.setEditable(false);
		pane.setPreferredSize(new Dimension(200, 20));
		pane.setMinimumSize(new Dimension(100, 20));
		pane.setMaximumSize(new Dimension(600, 2147483647));
		scroller.setPreferredSize(new Dimension(200, 20));
		scroller.setMinimumSize(new Dimension(100, 20));
		scroller.setMaximumSize(new Dimension(600, 2147483647));
		scroller.setViewportView(pane);
		add(scroller, BorderLayout.CENTER);
		add(separdor, BorderLayout.SOUTH);
	}

	public void createHtmlTemp(Map<Integer, File> lstArchivos) {
		this.lstArchivos = lstArchivos;
		fileName = Constantes.HTML_TEMP+(new Date())+".html";
		html = null;
		html = obtenerHTMLArchivos();
		_log.info("html generado");
		_log.info(html);		
		try {
			htmlTemp = new File(fileName);
			if (htmlTemp.exists()) {
				htmlTemp.delete();
			}
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(htmlTemp));
			bufferedWriter.write(html);
			if (bufferedWriter != null) {
				bufferedWriter.flush();
				bufferedWriter.close();
				_log.info("archivo guardado.. listo para leer editor pane");
			}
			htmlTemp = null;
			htmlTemp = null;
			bufferedWriter = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String obtenerHTMLArchivos() {
		File arc = null;
		String arefElemnt="";
		sbfHtml = null;
		sbfHtml = new StringBuffer();
		sbfHtml.append("<html>\r\n");
		sbfHtml.append("<body>\r\n ");
		sbfHtml.append("<div>\r\n");
		for (int i = 0; i < lstArchivos.size(); i++) {
			arc = lstArchivos.get(i);
			if(arc!=null){
				arefElemnt = "<a id='"+i+"' href='#"+i+"'> <img src='file://"+arc.getAbsolutePath()+"'   width='100' height='100'  > </a><br>\r\n";
				sbfHtml.append(arefElemnt);
			}				
		}
		sbfHtml.append("</div>\r\n");
		sbfHtml.append("</body>\r\n");
		sbfHtml.append("</html>\r\n");
		return sbfHtml.toString();
	}

	public void cargarEditorPane() {
		try {
			pane.setPage("");
			pane.setPage("file://" + new File(fileName).getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
