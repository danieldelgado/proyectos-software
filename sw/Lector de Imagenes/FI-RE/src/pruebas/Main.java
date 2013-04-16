package pruebas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class Main {
 
    public static void main(String[] args) {
        final int MAX = 100;
        final JFrame frame = new JFrame("JProgress Demo");
 
        // creates progress bar
        final JProgressBar pb = new JProgressBar();
        pb.setMinimum(0);
        pb.setMaximum(MAX);
        pb.setStringPainted(true);
 
        // add progress bar
        frame.setLayout(new FlowLayout());
        JButton a =new JButton("preubabtn");
        a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Thread a = new Thread(new Runnable() {
					public void run() {
						 for (int i = 0; i <= MAX; i++) {
					            final int currentValue = i;
					            try {
					                SwingUtilities.invokeLater(new Runnable() {
					                    public void run() {
					                        pb.setValue(currentValue);
					                    }
					                });
					                java.lang.Thread.sleep(100);
					            } catch (InterruptedException asd) {
					                JOptionPane.showMessageDialog(frame,asd.getMessage());
					            }
					        }
					        
					}
				});
		       a.start();
		        
			}
		});
        frame.getContentPane().add(a);
        frame.getContentPane().add(new JButton("preuba"));
        frame.getContentPane().add(new JButton("preub1a"));
        frame.getContentPane().add(new JButton("preub2a"));
        frame.getContentPane().add(new JButton("preub3a"));
        frame.getContentPane().add(pb);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
 
       
 
    }
}