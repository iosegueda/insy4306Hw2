import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Hw2 extends JFrame //implements ActionListener
{
	private JDesktopPane desktop; 
			Container container;
			JMenuBar menuBar;
			JMenu file;
			JMenuItem open;
			JMenuItem exit; 
			JMenu find;
			JMenuItem wordCount;
			JMenuItem fileStats;
			JMenu findNumbers;
			JMenu about; 
			JMenuItem version;
			JMenuItem phoneNumbers;
			JMenuItem socialSecurityNumbers;
			
		
	public Hw2()
	{
		super( "GUI App" );
		try
        {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        }
		catch ( Exception e ) {}
		
		container = getContentPane();
		menuBar = new JMenuBar();
		file = new JMenu( "File" );
        file.setMnemonic( 'F' );
        
		JMenuItem open= new JMenuItem("Open");
		open.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				File fileName = readFile();
				
			}
		});
        file.add(open);
		
		exit=new JMenuItem("Exit");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				
				System.exit(0);
			}
			
		});
		file.add(exit);
		
		find = new JMenu( "Find" );
        find.setMnemonic( 'i' );
		
		wordCount = new JMenuItem("Word Count");
		find.add(wordCount);
		
		fileStats = new JMenuItem("File Stats");
		find.add(fileStats);
		
		findNumbers = new JMenu("Find Numbers");
		find.add(findNumbers);

		phoneNumbers = new JMenuItem("Phone Numbers");
		findNumbers.add(phoneNumbers);
		
		socialSecurityNumbers = new JMenuItem("Social Security Numbers");
		findNumbers.add(socialSecurityNumbers);
		
		
		
		about = new JMenu("About");
		about.setMnemonic('a');
		
		version = new JMenuItem("Version");

		menuBar.add(file);
		menuBar.add(find);
		menuBar.add(about);
		setJMenuBar( menuBar );
		desktop = new JDesktopPane();
		container.add( desktop );
		
		
	}
	
	public static void main (String args[])
	{
		Hw2 demo= new Hw2();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setLocationRelativeTo(null);
		demo.setSize(800,390); 
		demo.setVisible(true);
		
	}
	
	public File readFile()
	{
		JFileChooser fileChooser = new JFileChooser();//create filechooser
					
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int result= fileChooser.showOpenDialog(this);
		//popup as a dialog on this JFRAme
		
		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(0);//if cancel exit
		
		File fileName = fileChooser.getSelectedFile();//else if select a file open that file
		System.out.println(fileName);
		return fileName;
						
	}
}
