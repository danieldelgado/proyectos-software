package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListCellRenderer;

import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;

@SuppressWarnings("serial")
public class ListaImagenesName extends CustomPanel {

	private JList listNombresImagenesComponet = new JList();
	private JScrollPane scroller;
	private JSeparator separdor;

	private Map<Integer, File> lstArchivos = null;
	ObjetoFilaImagen o = null;

	private final static Logger _log = Logger.getLogger(PanelCentral.class.getName());

	@SuppressWarnings("unused")
	private PanelCentral panelCentral;

	public ListaImagenesName(final PanelCentral panelCentral) {
		_log.info("  cargando ListaImagenesName ");
		setLayout(new BorderLayout());
		this.panelCentral = panelCentral;
		listNombresImagenesComponet = new JList();
		listNombresImagenesComponet.setCellRenderer(new ObjetoFilaImagenCellRenderer());
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					int index = listNombresImagenesComponet.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						o = (ObjetoFilaImagen) listNombresImagenesComponet.getModel().getElementAt(index);
						_log.info("Imagen Selecionada on: " + o.getId() + "  - " + o.getImagePath());
						panelCentral.mostrarImagenSeleccionada(o.getId());
					}
				}
			}
		};
		listNombresImagenesComponet.addMouseListener(mouseListener);
		scroller = new JScrollPane();
		separdor = new JSeparator();
		scroller.setPreferredSize(new Dimension(200, 20));
		scroller.setMinimumSize(new Dimension(100, 20));
		scroller.setMaximumSize(new Dimension(600, 2147483647));
		scroller.setViewportView(listNombresImagenesComponet);
		add(scroller, BorderLayout.CENTER);
		add(separdor, BorderLayout.SOUTH);
	}

	public void cargarListaImagenes(Map<Integer, File> lst) {
		_log.info("  cargar Lista Imagenes ... ");
		this.lstArchivos = lst;
		ObjetoFilaImagen[] lsoi = obtenerObjetoImagen();
		if (lsoi != null && lsoi.length > 0) {
			listNombresImagenesComponet.setListData(lsoi);
		}
	}

	private ObjetoFilaImagen[] obtenerObjetoImagen() {
		File f = null;
		ObjetoFilaImagen oi = null;
		List<ObjetoFilaImagen> l = new ArrayList<ObjetoFilaImagen>();
		for (int i = 0; i < lstArchivos.size(); i++) {
			f = lstArchivos.get(i);
			if (f != null) {
				oi = new ObjetoFilaImagen(i, f.getName());
				l.add(oi);
			}
		}
		f = null;
		oi = null;
		if (l != null && l.size() > 0) {
			_log.info(" lst ObjetoFilaImagen : " + l);
			return l.toArray(new ObjetoFilaImagen[l.size()]);
		}
		return null;
	}

	public void limpiarLista() {
		_log.info("  limpiar Lista ...");
		ObjetoFilaImagen[] a = new ObjetoFilaImagen[0] ;
		listNombresImagenesComponet.setListData(a);
	}


}

@SuppressWarnings("serial")
class ObjetoFilaImagenCellRenderer extends JLabel implements ListCellRenderer {

	public ObjetoFilaImagenCellRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		ObjetoFilaImagen entry = (ObjetoFilaImagen) value;
		setText(entry.getImagePath());
		return this;
	}
}

class ObjetoFilaImagen {
	private final Integer id;

	private final String imagePath;

	public ObjetoFilaImagen(Integer id, String imagePath) {
		this.id = id;
		this.imagePath = imagePath;
	}

	public Integer getId() {
		return id;
	}

	public String getImagePath() {
		return imagePath;
	}

}
