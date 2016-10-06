import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Hw2 extends JFrame //implements ActionListener
{
	private JDesktopPane desktop; 
			Container container;
			//JMenuBar menuBar;
			/*JMenu file;
			JMenu find;
			JMenu about; 
			JMenuItem exit; 
			JMenuItem open;
			JMenuItem wordCount;
			JMenuItem fileStats;*/
		
	public Hw2()
	{
		super( "GUI App" );
		desktop = new JDesktopPane();
		
        try
        {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        }
		catch ( Exception e ) {}

		
		
	}
	
	public static void main (String args[])
	{
		Hw2 demo= new Hw2();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setLocationRelativeTo(null);
		demo.setSize(800,390);
		demo.setVisible(true);
		
	}
}