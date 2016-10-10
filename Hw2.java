import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Hw2 extends JFrame //implements ActionListener
{
	private JDesktopPane desktop;  
		
	public Hw2()
	{
		super( "GUI App" );
		try
        {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        }
		catch ( Exception e ) {}
		
		desktop = new JDesktopPane();
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenuOption = new JMenu( "File" );
        fileMenuOption.setMnemonic( 'F' );
        
		JMenuItem openMenuItemOption = new JMenuItem("Open");
		openMenuItemOption.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				File fileName = readFile();
				
			}
		});
        fileMenuOption.add(openMenuItemOption);
		
		JMenuItem exitMenuItemOption = new JMenuItem("Exit");
		exitMenuItemOption.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				
				System.exit(0);
			}
			
		});
		fileMenuOption.add(exitMenuItemOption);
		
		JMenu findMenuOption = new JMenu( "Find" );
        findMenuOption.setMnemonic( 'i' );
		
		JMenuItem wordCountMenuItem = new JMenuItem("Word Count");
		wordCountMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JInternalFrame wordCountFrame = new JInternalFrame("Word Count", true, true, true, true);

				wordCountPanel wcp = new wordCountPanel();
				wordCountFrame.add(wcp);

				wordCountFrame.pack();
				desktop.add(wordCountFrame);
				wordCountFrame.setVisible(true);

			}
		});
		findMenuOption.add(wordCountMenuItem);
		
		JMenuItem fileStatsMenuItem = new JMenuItem("File Stats");
		findMenuOption.add(fileStatsMenuItem);
		
		JMenu findNumbersMenuOption = new JMenu("Find Numbers");
		findMenuOption.add(findNumbersMenuOption);
		
		
		JMenuItem phoneNumbersMenuItem = new JMenuItem("Phone Numbers");
		findNumbersMenuOption.add(phoneNumbersMenuItem);
		phoneNumbersMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JInternalFrame findPhoneNumbersFrame = new JInternalFrame("Word Count", true, true, true, true);

				findPhoneNumbersPanel fnp = new findPhoneNumbersPanel();
				findPhoneNumbersFrame.add(fnp);

				findPhoneNumbersFrame.pack();
				desktop.add(findPhoneNumbersFrame);
				findPhoneNumbersFrame.setVisible(true);

			}
		});
		
		JMenuItem socialSecurityNumbersMenuItem = new JMenuItem("Social Security Numbers");
		findNumbersMenuOption.add(socialSecurityNumbersMenuItem);
		
		
		
		JMenu aboutMenuOption = new JMenu("About");
		aboutMenuOption.setMnemonic('a');
		
		JMenuItem versionMenuOption = new JMenuItem("Version");

		menuBar.add(fileMenuOption);
		menuBar.add(findMenuOption);
		menuBar.add(aboutMenuOption);
		setJMenuBar(menuBar);
		
		
		add( desktop );
		
		
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
	
	private class wordCountPanel extends JPanel
	{
		private JLabel findLabel;
		private JTextField findField;
		private JLabel findNowLabel;
		private JButton findNowButton;
		private JLabel resultsLabel;
		private JTextField resultsField;
		private JTextArea myArea;

		public wordCountPanel()
		{
			setLayout(new FlowLayout());

			findLabel = new JLabel("    Find: ");
			findField = new JTextField(30);
			findNowButton = new JButton ("    Find Now");

			myArea = new JTextArea();

			Handeler myHandeler = new Handeler();
			findNowButton.addActionListener(myHandeler);

			add(findLabel);
			//add(nameField);
			add(myArea);
			//add(findNowLabel);
			add(findNowButton);
		}
		class Handeler implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println(findField.getText());
			}
		}
	}
	
	
	private class findPhoneNumbersPanel extends JPanel
	{
		private JTextField resultsField;
		private JButton doneButton;
		private JTextArea myArea;

		public findPhoneNumbersPanel()
		{
			setLayout(new FlowLayout());
			
			resultsField = new JTextField("");
			doneButton = new JButton("    Done");

			myArea = new JTextArea();

			//Handeler myHandeler = new Handeler();
			//findNowButton.addActionListener(myHandeler);

			add (resultsField);
			//add(nameField);
			add(myArea);
			add(doneButton);
		}
		/*class Handeler implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println(findField.getText());
			}
		}*/
	}
}
