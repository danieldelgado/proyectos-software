package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;

@SuppressWarnings("serial")
public class ListaImagenesName extends CustomPanel implements DropTargetListener, PropertyChangeListener {

	private JList listNombresImagenesComponet;
	@SuppressWarnings("unused")
	private DropTarget dropTarget;
	private JScrollPane scroller;
	private JSeparator separdor;

	private Map<Integer, File> lstArchivos = null;
	ObjetoFilaImagen o = null;

	private final static Logger _log = Logger.getLogger(PanelCentral.class.getName());

	@SuppressWarnings("unused")
	private PanelCentral panelCentral;

	public ListaImagenesName(final PanelCentral panelCentral) {
		setLayout(new BorderLayout());
		_log.info("  cargando ListaImagenesName ");
		listNombresImagenesComponet = new JList();
		dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this, true, null);
		scroller = new JScrollPane();
		separdor = new JSeparator();
		this.panelCentral = panelCentral;

		listNombresImagenesComponet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		ObjetoFilaImagen[] a = new ObjetoFilaImagen[0];
		listNombresImagenesComponet.setListData(a);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("propertyChange");
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		System.out.println("dragEnter");
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		System.out.println("DropTargetDragEvent");
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		System.out.println("dropActionChanged");

	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		System.out.println("dragExit");
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {

		System.out.println(" drop : ");
		System.out.println(" dtde.getDropAction()  : " + dtde.getDropAction());
		// Check the drop action
		if ((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE) != 0) {
			// Accept the drop and get the transfer data
			dtde.acceptDrop(dtde.getDropAction());
			DataFlavor[] flavors = dtde.getCurrentDataFlavors();
			System.out.println(flavors);
			Transferable transferable = dtde.getTransferable();

			try {
				boolean result = false;

				// if (draggingFile) {
				// result = dropFile(transferable);
				// } else {
				System.out.println(" transferable : " + transferable);
				result = dropContent(transferable, dtde);
				// }

				dtde.dropComplete(result);
			} catch (Exception e) {
				dtde.rejectDrop();
			}
		} else {
			dtde.dropComplete(false);
		}
	}

	protected boolean dropContent(Transferable transferable, DropTargetDropEvent dtde) {
		// if (!pane.isEditable()) {
		// // Can't drop content on a read-only text control
		// return false;
		// }
		System.out.println(" dropContent  ");
		try {
			// Check for a match with the current content type
			DataFlavor[] flavors = dtde.getCurrentDataFlavors();

			DataFlavor selectedFlavor = null;

			// Look for either plain text or a String.
			for (int i = 0; i < flavors.length; i++) {
				DataFlavor flavor = flavors[i];
				// DnDUtils2.debugPrintln("Drop MIME type " +
				// flavor.getMimeType() + " is available");
				if (flavor.equals(DataFlavor.plainTextFlavor) || flavor.equals(DataFlavor.stringFlavor)) {
					selectedFlavor = flavor;
					break;
				}
			}

			if (selectedFlavor == null) {
				// No compatible flavor - should never happen
				System.out.println(" selectedFlavor : " + selectedFlavor);
				return false;
			}

			// DnDUtils2.debugPrintln("Selected flavor is " +
			// selectedFlavor.getHumanPresentableName());

			// Get the transferable and then obtain the data
			Object data = transferable.getTransferData(selectedFlavor);
			System.out.println(" data 1 :" + data);
			// DnDUtils2.debugPrintln("Transfer data type is " +
			// data.getClass().getName());

			String insertData = null;
			if (data instanceof InputStream) {
				// Plain text flavor
				String charSet = selectedFlavor.getParameter("charset");
				InputStream is = (InputStream) data;
				byte[] bytes = new byte[is.available()];
				is.read(bytes);
				try {
					insertData = new String(bytes, charSet);
				} catch (UnsupportedEncodingException e) {
					// Use the platform default encoding
					insertData = new String(bytes);
					System.out.println(" insertData 1 data catch :" + insertData);
				}
			} else if (data instanceof String) {
				// String flavor
				insertData = (String) data;
				System.out.println(" insertData data :" + insertData);
			}

			if (insertData != null) {
				// int selectionStart = pane.getCaretPosition();
				// pane.replaceSelection(insertData);
				// pane.select(selectionStart, selectionStart +
				// insertData.length());
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

}

@SuppressWarnings("serial")
class ObjetoFilaImagenCellRenderer extends JLabel implements ListCellRenderer {

	public ObjetoFilaImagenCellRenderer() {
		setOpaque(true);
		setIconTextGap(12);
		setBackground(UIManager.getColor("List.background"));
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		ObjetoFilaImagen entry = (ObjetoFilaImagen) value;
		setText(entry.getImagePath());
		if (isSelected) {
			this.setForeground(UIManager.getColor("List.selectionForeground"));
			this.setBackground(UIManager.getColor("List.selectionBackground"));
		} else {
			this.setForeground(UIManager.getColor("List.foreground"));
			this.setBackground(UIManager.getColor("List.background"));
		}
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
