package pruebas;
//
//import java.awt.BorderLayout;
//import java.awt.Cursor;
//import java.awt.Insets;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JProgressBar;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.Timer;
//
//import com.vst.lie.plugins.LongTask;
//
//public class ProgressBarDemo extends JPanel implements ActionListener {
//	public final static int ONE_SECOND = 1000;
//
//	private JProgressBar progressBar;
//	private Timer timer;
//	private JButton startButton;
//	private LongTask task;
//	private JTextArea taskOutput;
//	private String newline = "\n";
//
//	public ProgressBarDemo() {
//		super(new BorderLayout());
//		task = new LongTask();
//
//		startButton = new JButton("Start");
//		startButton.setActionCommand("start");
//		startButton.addActionListener(this);
//
//		progressBar = new JProgressBar(0, task.getLengthOfTask());
//		progressBar.setValue(0);
//		progressBar.setStringPainted(true);
//
//		taskOutput = new JTextArea(5, 20);
//		taskOutput.setMargin(new Insets(5, 5, 5, 5));
//		taskOutput.setEditable(false);
//		taskOutput.setCursor(null);
//
//		JPanel panel = new JPanel();
//		panel.add(startButton);
//		panel.add(progressBar);
//
//		add(panel, BorderLayout.PAGE_START);
//		add(new JScrollPane(taskOutput), BorderLayout.CENTER);
//		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//
//		timer = new Timer(ONE_SECOND, new ActionListener() {
//			public void actionPerformed(ActionEvent evt) {
//				progressBar.setValue(task.getCurrent());
//				String s = task.getMessage();
//				if (s != null) {
//					taskOutput.append(s + newline);
//					taskOutput.setCaretPosition(taskOutput.getDocument().getLength());
//				}
//				if (task.isDone()) {
//					Toolkit.getDefaultToolkit().beep();
//					timer.stop();
//					startButton.setEnabled(true);
//					setCursor(null);
//				}
//			}
//		});
//	}
//
//	public void actionPerformed(ActionEvent evt) {
//		startButton.setEnabled(false);
//		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//		progressBar.setValue(progressBar.getMinimum());
//		taskOutput.setText("");
//		task.go();
//		timer.start();
//	}
//
//	private static void createAndShowGUI() {
//		JFrame frame = new JFrame("ProgressBarDemo");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		JComponent newContentPane = new ProgressBarDemo();
//		newContentPane.setOpaque(true);
//		frame.setContentPane(newContentPane);
//
//		frame.pack();
//		frame.setVisible(true);
//	}
//
//	public static void main(String[] args) {
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				createAndShowGUI();
//			}
//		});
//	}
//}
