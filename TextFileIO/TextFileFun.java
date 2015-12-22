import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextFileFun extends JFrame implements ActionListener
{
	private JButton B1, B2;
	private JTextArea text;
   private Container pane;
   private String filename;
   private String textLine;
   
   FileWriter fw;//for printing to file
   PrintWriter pw;//will use for printing 
   FileReader fr;//for reading from file
   BufferedReader br;//for reading from file
   
	public TextFileFun()
	{
		//use JFrame's constructor to title window
		super("Text Area and File Fun");
      
      filename = "textFunFile.txt"; // filename for text area data

		setBounds(400,100,400,500); //position and size of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      pane = getContentPane(); // reference to the contentPane of window

		//create JButtons and JLabel
		B1 = new JButton("Load");
		B2 = new JButton("Save");
      text = new JTextArea(10,40);
		
		//add the controls to the contentPane
      this.add(B1, BorderLayout.LINE_START); //this instead of pane or even nothing?
		//pane.add(B1, BorderLayout.LINE_START);
		pane.add(text, BorderLayout.CENTER);      
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
         try
         {
         fr = new FileReader("textFunFile.txt");
         br = new BufferedReader(fr);
         
         textLine = br.readLine();
         while (textLine != null )
            {
               textLine = br.readLine();
               text.append(textLine); //why setText is not working?
            }
         
         br.close();
         fr.close();
         }
         catch(Exception e)
         {System.out.println(e);}
      }
      else if ( ae.getSource()==B2 )
      {
         try
         {
         fw = new FileWriter("textFunFile.txt", true);
         pw = new PrintWriter(fw, true);
         
         pw.println(text.getText());
         
         pw.close();
         fw.close();         
         }
         catch(Exception e)
         {System.out.println(e);}
      }
	}


	public static void main(String args[])
	{
		TextFileFun f = new TextFileFun();
	}
}