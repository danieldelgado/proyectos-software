package prueb1;
import java.awt.*;
import javax.swing.*;

public class EditorPaneTest2 extends JFrame
{
    public EditorPaneTest2()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);        

        TweetCellRenderer t =  new TweetCellRenderer();
        JScrollPane scrollPane = new JScrollPane(t);     

     
        add(scrollPane, BorderLayout.CENTER);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new EditorPaneTest2();
            }
        });
    }
}