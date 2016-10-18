//Iris Osegueda  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Validate extends JFrame
{
	private JDesktopPane desktop;
	
	private JLabel domainLabel;
	private JTextField domainField;
	
	private JLabel ipLabel;
	private JTextField ipField;
	
	private JLabel usernameLabel;
	private JTextField usernameField;
	
	private JLabel passwordLabel;
	private JTextField passwordField;
	
	private JButton cancelButton;
	private JButton loginButton;
	
	public Validate()
	{
		super( "GUI App" );
        
		setLayout(new GridLayout(5,2));
		
		domainLabel = new JLabel("    Domain: ");
		domainField = new JTextField(20);
		
		ipLabel = new JLabel("    IP Address: ");
		ipField = new JTextField(20);
		
		usernameLabel = new JLabel("    Username: ");
		usernameField = new JTextField(20);
		
		passwordLabel = new JLabel("    Password: ");
		passwordField = new JTextField(20);
		
		cancelButton = new JButton("\tCancel");
		loginButton = new JButton("\tLogin");
		
		add(domainLabel);
		add(domainField);
		add(ipLabel);
		add(ipField);
		add(usernameLabel);
		add(usernameField);
		add(passwordLabel);
		add(passwordField);
		add(cancelButton);
		add(loginButton);
	}
	
	public static void main (String args[])
	{
		Validate demo= new Validate();
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.setLocationRelativeTo(null);
        demo.setSize(500,250); 
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = demo.getSize().width;
        int h = demo.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        demo.setLocation(x, y);
        demo.setVisible(true);  
	}
} 