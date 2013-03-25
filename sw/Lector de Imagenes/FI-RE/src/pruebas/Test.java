package pruebas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();

                JMenuBar menubar = new JMenuBar();
                JMenu menu = new JMenu("File");
                menu.add(new JMenuItem("New"));
                menubar.add(menu);
                frame.setJMenuBar(menubar);

                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}