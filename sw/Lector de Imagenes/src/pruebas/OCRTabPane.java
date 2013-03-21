// OCRTabPane.java
// Copyright (c) 2010 William Whitney
// All rights reserved.
// This software is released under the BSD license.
// Please see the accompanying LICENSE.txt for details.
package pruebas;

import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Provides a tabbed pane to hold the separate capabilities of the system.
 * 
 * @author William Whitney
 */
public class OCRTabPane extends JTabbedPane {

	public static final long serialVersionUID = 0;
	MainFrame a = null;

	public OCRTabPane(MainFrame m) {
		a = m;
		JPanel characterTracer = new CharacterTracerPanel(a);
		this.add("Character Tracer", characterTracer);

	}

	private static final Logger LOG = Logger.getLogger(OCRTabPane.class.getName());
}
