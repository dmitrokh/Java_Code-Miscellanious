import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextFileIO extends JFrame implements ActionListener
{
	private JButton B1, B2, B3;
	private JTextArea text;
   private Container pane;
   private String filename;
   private String textLine;
   private JScrollPane scrollPane;
     
   static private final String newline = "\n";
   
   private FileWriter fw;//for printing to file
   private PrintWriter pw;//will use for printing 
   private FileReader fr;//for reading from file
   private BufferedReader br;//for reading from file
   private JFileChooser fc;//file chooser
   
	public TextFileIO()
	{
		//use JFrame's constructor to title window
		super("Text Area and File Fun");
      
	   setBounds(400,100,400,500); //position and size of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      pane = getContentPane(); // reference to the contentPane of window

		//create JButtons and JLabel
		B1 = new JButton("Load");
		B2 = new JButton("Save");
      
      fc = new JFileChooser(); 
      fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      
      text = new JTextArea(10,40);
      scrollPane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      pane.add(scrollPane, BorderLayout.CENTER);
      		
		//add the controls to the contentPane
		pane.add(B1, BorderLayout.LINE_START);
      //pane.add(text, BorderLayout.CENTER);
      //pane.add(scrollPane, BorderLayout.CENTER);
      pane.add(B2, BorderLayout.LINE_END);
      
		//connect the buttons to the listener
		//listener is in this object
		B1.addActionListener( this );
		B2.addActionListener( this );
               
      addWindowFocusListener(new WindowAdapter() 
      {
        public void windowGainedFocus(WindowEvent e) 
        {
          text.requestFocusInWindow();
        }
      });
      
      pack();
		setVisible(true);
	}// end of constructor


	public void actionPerformed(ActionEvent ae)
	{
		if ( ae.getSource()==B1 )
      {
         int returnVal = fc.showOpenDialog(getParent());
         //int returnVal = fc.showDialog(null, "Open File");

         if (returnVal == JFileChooser.APPROVE_OPTION) 
         {
             File file = fc.getSelectedFile();
             //This is where application opens a file.
             try
               {
                  fr = new FileReader(file);
                  br = new BufferedReader(fr);
                  
                  do
                  {
                  textLine = br.readLine();
                  text.append(textLine);
                  }
                  while (textLine != null );
                  
                  br.close();
                  fr.close();
               }
               catch(Exception e)
               {System.out.println(e);}

             text.append("Opening: " + file.getName() + "." + newline);
             
         } 
         else 
         {
             text.append("Open command cancelled by user." + newline);
         }
         text.setCaretPosition(text.getDocument().getLength());
      }
      else if (ae.getSource() == B2) 
      {
         int returnVal = fc.showSaveDialog(null);
         if (returnVal == JFileChooser.APPROVE_OPTION) 
         {
             //This is where application saves a file.
             File file = fc.getSelectedFile();
             try
             {
               fw = new FileWriter(file, false);
               pw = new PrintWriter(fw, true);
            
               pw.println(text.getText());
            
               pw.close();
               fw.close();         
             }
             catch(Exception e)
             {System.out.println(e);}
   
             text.append("Saving: " + file.getName() + "." + newline);
         } 
         else 
         {
             text.append("Save command cancelled by user." + newline);
         }
         text.setCaretPosition(text.getDocument().getLength());
     }
   }   

	public static void main(String args[])
	{
		TextFileIO f = new TextFileIO();
   }
}