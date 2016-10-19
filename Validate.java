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
		super( "Login Form" );
        
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
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
		loginButton = new JButton("\tLogin");
		loginButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent ae)
			{
				String failedValidation = "";
				
				String domainPattern = "[a-z]{3}\\\\[A-Z]{4}\\.[a-z]{3}\\.edu";
				String ipPattern = "\\d{3}\\.\\d{3}\\.\\d{2}\\.\\d{2}";
				String usernamePattern = 
					"[a-z|A-Z]\\w*@[a-z|A-Z]\\w*\\.(com|COM|edu|EDU|ORG|org)";
				String passwordPattern = 
					"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W])\\S{8,})";
				

				boolean domainIsValidated = validateField(domainField.getText(), domainPattern);
				boolean ipIsValidated = validateField(ipField.getText(), ipPattern);
				boolean usernameIsValidated = validateField(usernameField.getText(), usernamePattern);
				boolean passwordIsValidated = validateField(passwordField.getText(), passwordPattern);
				
				if (!domainIsValidated)
				{
					failedValidation += "Please fix your domain field\n";
					domainField.setText("");
					domainField.requestFocusInWindow();
				}
				if(!ipIsValidated)
				{
					failedValidation += "Please fix your IP address field\n";
					ipField.setText("");
					ipField.requestFocusInWindow();
				}
				if(!usernameIsValidated)
				{
					failedValidation += "Please fix your username field\n";
					usernameField.setText("");
					usernameField.requestFocusInWindow();
				}
				if(!passwordIsValidated)
				{
					failedValidation += "Please fix your password field\n";
					passwordField.setText("");
					passwordField.requestFocusInWindow();
				}
				
				
				if (domainIsValidated && ipIsValidated && usernameIsValidated && passwordIsValidated)
				{
					JOptionPane.showMessageDialog( null, "\tYou are logged in!");
				}
				else 
				{
					JOptionPane.showMessageDialog( null, failedValidation);
				}
				
				
			}
		});
		
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


        demo.setLocation(x, y);
        demo.setVisible(true);  
	}
	
	public boolean validateField(String domainEntry, String regexPattern)
	{
		Pattern p = Pattern.compile(regexPattern);
		Matcher m = p.matcher(domainEntry);
		
		return m.matches();
	}
	
} 
