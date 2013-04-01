package prueb1;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.ListCellRenderer;

public class TweetCellRenderer extends JEditorPane implements ListCellRenderer {

    public Component getListCellRendererComponent(
        javax.swing.JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus
    ) {

        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 6));

        StringBuffer sb = new StringBuffer();

        setContentType("text/html");

        sb.append("<html><body>");
        sb.append("<img src='http://www.google.co.uk/images/firefox/video.png' />");

        sb.append("</body></html>");

        System.out.println(sb);

        setText(sb.toString());  

//        setBackground(isSelected ? SELECTED_BG : BG);        
//        setForeground(isSelected ? SELECTED_FG : FG);

        return this;
    }
}