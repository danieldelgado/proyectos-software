package pruebas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MDIGridBag extends JFrame implements ActionListener{

   private GridBagLayout gbLayout;
   private GridBagConstraints gbConstraints;
   private Container container;
   private int crapsTotal;
   private JTextField crapsTotalText;
   private JComboBox comboBox;
   private FileInputStream infile;

   private static final long serialVersionUID = 1L;
   public static void main (String args[]){
      MDIGridBag myMDIGridBag = new MDIGridBag();
      myMDIGridBag.init(); 
//130
  }
  public void init() {

  
      JFrame frame = new JFrame("MDIGridBag");
      container = frame.getContentPane();
      gbLayout = new GridBagLayout();
      container.setLayout( gbLayout );
  
   
      // instantiate gridbag constraints
      gbConstraints = new GridBagConstraints();

      // create GUI components
      String gamingRules[] = { "House Rules",
                            "Las Vegas Rules", "Atlantic City Rules"};
      comboBox = new JComboBox( gamingRules );

      JTextArea textArea = new JTextArea(getDataFromFile());
//150
      String maxBet[] = { "$10000", "$12000", "$14000" };
      JList list = new JList( maxBet );

      String names[] =
         { "Play Craps", "Play Rock-Scissor-Paper", "Play Go-Fish"};

      JLabel crapsTotalLabel = new JLabel("Sum of Craps Totals "
                                           +"sent by Craps Games.");
      crapsTotalText = new JTextField( 5 );
      crapsTotalText.setEditable( false );

      JButton buttons[] = new JButton[ names.length ];

      for ( int i = 0; i < buttons.length; i++ ){
           buttons[ i ] = new JButton( names[ i ] );
           buttons[i].addActionListener(this);
         }

       // define GUI component constraints for textArea
//170     
      gbConstraints.weightx = 1;  // relative weight of horizontal growth
      gbConstraints.weighty = 1;  // relative weight of vertical growth
      gbConstraints.fill = GridBagConstraints.BOTH;
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( new JScrollPane(textArea) );

      // buttons[0] -- weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = 1; // 1 column
      addComponent( buttons[ 0 ] );

      // buttons[1] -- weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( buttons[ 1 ] );  //goes next to previous component(RELATIVE)

      // buttons[2] -- weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( buttons[ 2 ] );   // last on current row (since REMAINDER)

      // comboBox -- weightx is 1: fill is BOTH
//190      
      gbConstraints.weighty = 0;
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( comboBox );

      // list -- weightx and weighty are 1: fill is BOTH
      gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
      addComponent( list );


      gbConstraints.gridx = 0;  // can also specify particular column
      gbConstraints.gridy = 5;  // and a specific row
      gbConstraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( crapsTotalLabel );

      gbConstraints.gridx = 2;
      gbConstraints.gridy = 5;
      gbConstraints.gridwidth = GridBagConstraints.RELATIVE;
      addComponent( crapsTotalText );
      crapsTotalText.setText(Integer.toString(crapsTotal));
//210      
      frame.setSize(400,250);
      frame.setVisible(true);

   }   // end init

   // addComponent is programmer-defined
   private void addComponent( Component c )
   {
      gbLayout.setConstraints( c, gbConstraints );
      container.add( c );      // add component
   }

 public void actionPerformed(ActionEvent e){

     JOptionPane.showMessageDialog(null,
         "You pressed: " + e.getActionCommand() +
         ".  Program detected that the "
         + comboBox.getSelectedItem()
         + " option was selected from the pulldown menu.");
//230
     if (e.getActionCommand() == "Play Craps"){

         JOptionPane.showMessageDialog(null,
            "Launching Craps Game in a new window, new window contains a link" +
            " back to parent.");

         playCrapsWindow();
      }  // end if

 } // end actionPerformed

  public void playCrapsWindow(){
     // Each instance of Craps launches in its own JFrame
     // See MDICraps constructor
//    MDICraps myCraps = new MDICraps(this);

 }  // end playCrapsWindow

 public void addToCrapsTotal(int amountToAdd){
//250
  crapsTotal += amountToAdd;
  crapsTotalText.setText(Integer.toString(crapsTotal));
 }

 private String getDataFromFile(){
  String readInText = null;
  try {
      infile = new FileInputStream("data.dat"); //assoc file with file handle
      BufferedReader dataFile = new BufferedReader(new InputStreamReader(infile));
      readInText = dataFile.readLine();
      dataFile.close();
      }
      catch (FileNotFoundException e){
         System.out.println("File Not Found" + infile);
      }
      catch (IOException e){
         System.out.println("IOException");
      }
  return readInText;
//270
 }

} // end MIDGridBag class definition