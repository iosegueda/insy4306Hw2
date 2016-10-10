//Iris Osegueda 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Hw2 extends JFrame
{
    private JDesktopPane desktop;  
    File file = null;

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
                file = chooseFile();
                
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
        fileStatsMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String fileStatsInfo = fileStats(file);

                JInternalFrame fileStatsFrame = new JInternalFrame("File Stats", true, true, true, true);

                fileStatsPanel fsp = new fileStatsPanel(fileStatsInfo);
                fileStatsFrame.add(fsp);

                fileStatsFrame.pack();
                desktop.add(fileStatsFrame);
                fileStatsFrame.setVisible(true);
            }
        });

        JMenu findNumbersMenuOption = new JMenu("Find Numbers");
        findMenuOption.add(findNumbersMenuOption);
                
        JMenuItem phoneNumbersMenuItem = new JMenuItem("Phone Numbers");
        findNumbersMenuOption.add(phoneNumbersMenuItem);
        phoneNumbersMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String content = readFile(file.toString());
                System.out.print(content);
                /*//String myPattern = "(\\d\\d\\d)\\s\\d\\d\\d-\\d\\d\\d\\d";
                String myPattern = "war";
                Pattern p = Pattern.compile(myPattern);
                Matcher m = p.matcher(content);

                if (m.find()) 
                {
                    System.out.println(m.group(1));
                }
                */
                JInternalFrame findPhoneNumbersFrame = new JInternalFrame("Phone Numbers Found", 
                    true, true, true, true);

                findPhoneNumbersPanel fnp = new findPhoneNumbersPanel();
                findPhoneNumbersFrame.add(fnp);

                findPhoneNumbersFrame.pack();
                desktop.add(findPhoneNumbersFrame);
                findPhoneNumbersFrame.setVisible(true);

            }
        });
        
        JMenuItem socialSecurityNumbersMenuItem = new JMenuItem("Social Security Numbers");
        findNumbersMenuOption.add(socialSecurityNumbersMenuItem);
        socialSecurityNumbersMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JInternalFrame socialSecurityNumbersFrame = new JInternalFrame("Social Security Numbers Found", true, true, true, true);

                socialSecurityNumbersPanel ssnp = new socialSecurityNumbersPanel();
                socialSecurityNumbersFrame.add(ssnp);

                socialSecurityNumbersFrame.pack();
                desktop.add(socialSecurityNumbersFrame);
                socialSecurityNumbersFrame.setVisible(true);

            }
        });
               
        JMenu aboutMenuOption = new JMenu("About");
        aboutMenuOption.setMnemonic('a');
        JMenuItem versionMenuOption = new JMenuItem("Version");
        versionMenuOption.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                versionMenuPanel vmp = new versionMenuPanel();
            }
        });
        aboutMenuOption.add(versionMenuOption);

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
        demo.setSize(1000,500); 
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = demo.getSize().width;
        int h = demo.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        demo.setLocation(x, y);
        demo.setVisible(true);    
    }
    
    public File chooseFile()
    {
        JFileChooser fileChooser = new JFileChooser();
                    
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result= fileChooser.showOpenDialog(this);
        
        if(result == JFileChooser.CANCEL_OPTION)
        {
			System.exit(0);
		}    
		
        File file = fileChooser.getSelectedFile();
        System.out.println(file);
        return file;  
    }

    public String readFile(String fileName)
    {
        String content = ""; 

        try
        {
            BufferedReader reader = new BufferedReader( new FileReader( fileName ) );

            String line = reader.readLine();
            

            while ( line != null )
            {
                line = reader.readLine();
                content = content + line + "\n"; 
            }
        }
        catch ( IOException ioe )
        {
            System.out.println( "Cannot Open File" );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return content;
    }

    private class wordCountPanel extends JPanel
    {
        private JLabel findLabel;
        private JTextField findField;
        private JLabel findNowLabel;
        private JButton findNowButton;
        private JLabel resultsLabel;
        private JTextArea resultsField;
        //private JTextArea myArea;

        public wordCountPanel()
        {
            setLayout(new GridLayout(2,2));

            findLabel = new JLabel("    Find: ");
            findField = new JTextField(25);
            findNowButton = new JButton ("    Find Now");
			resultsLabel = new JLabel("    # of times found: ");
			resultsField = new JTextArea(10,8);
			resultsField.setEditable(false);

            //add(findLabel);
			add(findField);
            add(findNowButton);
			add(resultsLabel);
			add(resultsField);
        }
    }
    
    private class fileStatsPanel extends JPanel
    {
        private JTextArea resultsField;

        public fileStatsPanel(String fileStatsInfo)
        {
            setLayout(new FlowLayout());
            
            resultsField = new JTextArea(15, 20);
            resultsField.setEditable(false);
			resultsField.setText(fileStatsInfo);

            add (resultsField);

        }
    }

    private class findPhoneNumbersPanel extends JPanel
    {
        private JTextArea resultsField;

        public findPhoneNumbersPanel()
        {
            setLayout(new FlowLayout());
            
            resultsField = new JTextArea(25, 30);
            resultsField.setEditable(false);

            add (resultsField);

        }
    }

    public String fileStats(File file)
    {
        int wordCount = 0; 
        int lineCount = 0; 
        int charCount = 0;
        String allCounts = "";
        
        try
        {
            BufferedReader reader = new BufferedReader( new FileReader( file ) );
                
            String line = reader.readLine();
            
            while ( line != null )
            {
                lineCount++;
                
                String[] words = line.split( "\\s" );
                
                wordCount += words.length;
                
                for( int i = 0; i < words.length; i++ )
                    charCount += words[ i ].length();
                    
                line = reader.readLine();
            }
            
            
            reader.close();
            
            /*System.out.println( "\nNo. of lines: " + lineCount +
                                "\nNo. of words = " + wordCount +
                                "\nNo. of char = " + charCount );   */
            
            allCounts = ( "\nNumber of lines: " + lineCount +
                            "\nNumber of words: " + wordCount +
                            "\nNumber of characters:  " + charCount );

            System.out.println(allCounts);
        }
        catch ( IOException ioe )
        {
            System.out.println( "Cannot Open File" );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return allCounts;
    }

    private class versionMenuPanel extends JPanel
    {
        public versionMenuPanel()
        {
            setLayout(new FlowLayout());
            
            JOptionPane.showMessageDialog( null, "\tVersion: 1.1\n\t Author: Iris Osegueda");
        }
        
    }
    private class socialSecurityNumbersPanel extends JPanel
    {
        private JTextArea resultsField;

        public socialSecurityNumbersPanel()
        {
            setLayout(new FlowLayout());
            
            resultsField = new JTextArea(25, 30);
            resultsField.setEditable(false);

            add (resultsField);
        }
      
    }
}
