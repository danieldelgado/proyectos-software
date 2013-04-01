package prueb1;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

public class EditorPaneTest extends JFrame {
	public EditorPaneTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);

		JEditorPane editPane = new JEditorPane();
		JScrollPane scrollPane = new JScrollPane(editPane);

		editPane.setEditable(false);
		editPane.setContentType("text/html");

		editPane.setContentType("text/html");

		StringBuffer a = new StringBuffer();
		a.append("<html><div>"
				+ " <a href=\"123#img1\" > <img src=\"file:///home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png\"   width=\"100\" height=\"100\"  > </a"
				+ "<div>");
		a.append("<div>"
				+ " <a href=\"324#img2\" > <img src=\"file:///home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png\"   width=\"100\" height=\"100\"  > </a"
				+ "<div>");
		a.append("<div>"
				+ " <a href=\"345#img3\" > <img src=\"file:///home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png\"   width=\"100\" height=\"100\"  >  </a"
				+ "<div><html>");
		editPane.addMouseListener(new HyperlinkMouseListener());
		editPane.setText(a.toString());
		editPane.addHyperlinkListener(new texthll());
		add(scrollPane, BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);
	}

	private final class HyperlinkMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("mouseClicked:");
            if (e.getButton() == MouseEvent.BUTTON3) {
                Element h = getHyperlinkElement(e);
                if (h != null) {
                    Object attribute = h.getAttributes().getAttribute(HTML.Tag.A);
                    if (attribute instanceof AttributeSet) {
                        AttributeSet set = (AttributeSet) attribute;
                        String href = (String) set.getAttribute(HTML.Attribute.HREF);
                        System.out.println("href:"+href);
                        if (href != null) {
                            try {
                                Desktop.getDesktop().browse(new URI(href));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            } catch (URISyntaxException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        private Element getHyperlinkElement(MouseEvent event) {
            System.out.println("getHyperlinkElement:");
            JEditorPane editor = (JEditorPane) event.getSource();
            int pos = editor.getUI().viewToModel(editor, event.getPoint());
            if (pos >= 0 && editor.getDocument() instanceof HTMLDocument) {
                HTMLDocument hdoc = (HTMLDocument) editor.getDocument();
                Element elem = hdoc.getCharacterElement(pos);
                if (elem.getAttributes().getAttribute(HTML.Tag.A) != null) {
                    return elem;
                }
            }
            return null;
        }
    }
	
	class texthll implements HyperlinkListener {

		public void hyperlinkUpdate(HyperlinkEvent event) {
			System.out.println("hyperlinkUpdate");
			JEditorPane sad = (JEditorPane) event.getSource();
			URL cs = event.getURL();
			System.out.println(cs);
			if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				JEditorPane pane = (JEditorPane) event.getSource();
				URL url = event.getURL();
				System.out.println(url);
			}
		}
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EditorPaneTest();
			}
		});
	}
}