package pruebas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class PruebaJToolBar {
    public static void main(String[] args) {
        new PruebaJToolBar();
    }

    public PruebaJToolBar() {
        JFrame ventanaPrincipal = new JFrame("Prueba JToolBar");
        JTextArea componentePrincipal = new JTextArea(25, 80);

        JToolBar toolBar = getToolBar();
        JToolBar toolBar1 = getToolBar();
        JToolBar toolBar2 = getToolBar();

        JPanel a = new JPanel();
        a.setLayout(new FlowLayout());
        a.add(toolBar);
        a.add(toolBar1);
        a.add(toolBar2);
        
        ventanaPrincipal.getContentPane().add(componentePrincipal);
        ventanaPrincipal.getContentPane().add(a, BorderLayout.NORTH);
        ventanaPrincipal.pack();
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }

    private JToolBar getToolBar() {
        JToolBar barraBotones = new JToolBar();
        barraBotones.add(new JButton("1"));
        barraBotones.add(new JButton("2"));
        barraBotones.add(new JButton("3"));
        barraBotones.add(new JButton("4"));
        barraBotones.add(new JButton("5"));
        return barraBotones;
    }
}