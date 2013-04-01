package prueb1;
import javax.swing.*;
import java.awt.*;

public class InlineImage {

    public InlineImage() {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JEditorPane edit=new JEditorPane();
        frame.getContentPane().add(edit);
        edit.setContentType("text/html");

        String html = "<html><body>Local image<br><img src=\"file:///home/crossfire/Documentos/files/archivos y resultado de las pruebas /archivos de prueba/01_04.png\"></body></html>";
        edit.setText(html);

        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {new InlineImage();}
}