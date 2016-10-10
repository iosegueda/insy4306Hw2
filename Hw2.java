import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Hw2 extends JFrame //implements ActionListener
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
                /*int wordCount = 0;
                int lineCount = 0;
                int charCount = 0;

                String content = readFile(file.toString());

                while ( line != null )
                {
                    // update the line count
                    lineCount++;
                    
                    // split the line into words
                    String[] words = line.split( "\\s" );
                    
                    wordCount += words.length;
                    
                    for( int i = 0; i < words.length; i++ )
                        charCount += words[ i ].length();
                }*/

                /*String content = ""; 

                try
                {
                    // open the file for reading
                    BufferedReader reader = new BufferedReader( new FileReader( fileName ) );

                    String line = reader.readLine();
                    
                    while ( line != null )
                    {
                        // update the line count
                        lineCount++;
                        
                        // split the line into words
                        String[] words = line.split( "\\s" );
                        
                        wordCount += words.length;
                        
                        for( int i = 0; i < words.length; i++ )
                            charCount += words[ i ].length();
                            
                        line = reader.readLine();
                }
                    
                    
                reader.close();
                    
                System.out.println( "File: " + filename +
                                    "\nNo. of lines: " + lineCount +
                                    "\nNo. of words = " + wordCount +
                                    "\nNo. of char = " + charCount );  
                    }
                catch ( IOException ioe )
                {
                    System.out.println( "Cannot Open File" );
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }*/ 
                fileStats(file);

                JInternalFrame fileStatsFrame = new JInternalFrame("File Stats", true, true, true, true);

                fileStatsPanel fsp = new fileStatsPanel();
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
        demo.setSize(1000,500); 
        demo.setVisible(true);
        
    }
    
    public File chooseFile()
    {
        JFileChooser fileChooser = new JFileChooser();//create filechooser
                    
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result= fileChooser.showOpenDialog(this);
        //popup as a dialog on this JFRAme
        
        if(result == JFileChooser.CANCEL_OPTION)
            System.exit(0);//if cancel exit
        
        File file = fileChooser.getSelectedFile();//else if select a file open that file
        System.out.println(file);
        return file;
                        
    }

    public String readFile(String fileName)
    {
        String content = ""; 

        try
        {
            // open the file for reading
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
    
    private class fileStatsPanel extends JPanel
    {
        private JTextArea resultsField;

        public fileStatsPanel()
        {
            setLayout(new FlowLayout());
            
            resultsField = new JTextArea(25, 30);
            resultsField.setEditable(false);

            //Handeler myHandeler = new Handeler();
            //findNowButton.addActionListener(myHandeler);

            add (resultsField);

        }
        /*class Handeler implements ActionListener
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println(findField.getText());
            }
        }*/
    }

    private class findPhoneNumbersPanel extends JPanel
    {
        private JTextArea resultsField;

        public findPhoneNumbersPanel()
        {
            setLayout(new FlowLayout());
            
            resultsField = new JTextArea(25, 30);
            resultsField.setEditable(false);

            //Handeler myHandeler = new Handeler();
            //findNowButton.addActionListener(myHandeler);

            add (resultsField);

        }
        /*class Handeler implements ActionListener
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println(findField.getText());
            }
        }*/
    }

    public String fileStats(File file)
    {
        int wordCount = 0; 
        int lineCount = 0; 
        int charCount = 0;
        String allCounts = "";
        
        try
        {
            // open the file for reading
            BufferedReader reader = new BufferedReader( new FileReader( file ) );
                
            // read the first line
            String line = reader.readLine();
            
            while ( line != null )
            {
                // update the line count
                lineCount++;
                
                // split the line into words
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
            
            allCounts = ( "\nNo. of lines: " + lineCount +
                            "\nNo. of words = " + wordCount +
                            "\nNo. of char = " + charCount );

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
}
