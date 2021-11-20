import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Date: 11/19/21
 * Class creating a log in screen
 * @author - Hiep Cao
 * @author - Abigail Pease
 * @author - Kenten Egbert
 * @author - Caleb McConnell
 * 
 */
public class LogInSc extends JFrame {

    /**
     * The JPanel displaying the login screen
     */
	private JPanel contentPane;
	/**
	 * Text field where username is inputted
	 */
	private JTextField userField;
	/**
	 * Text field where password is inputted
	 */
	private JTextField passField;
	/**
	 * The frame displaying the login screen
	 */
	public static LogInSc frame = new LogInSc();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInSc() {
		setBackground(new Color(210, 225, 225));
        getContentPane().setLayout(null);
        setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("User Name: ");
		userLabel.setBounds(46, 83, 148, 48);
		contentPane.add(userLabel);
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setBounds(46, 144, 122, 48);
		contentPane.add(passLabel);
		
		JLabel welcomeLabel = new JLabel("Welcome back!");
		welcomeLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		welcomeLabel.setBounds(256, 24, 129, 27);
		contentPane.add(welcomeLabel);
		
		userField = new JTextField();
		userField.setBounds(168, 96, 310, 22);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(168, 157, 310, 22);
		contentPane.add(passField);
		passField.setColumns(10);
		
		JButton loginButton = new JButton("Log In");
		loginButton.setBounds(238, 214, 97, 40);
		contentPane.add(loginButton);
		
		// Check username and password when log in button is pressed
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CSVReadWrite.checkLogin("logins.csv", userField.getText(), passField.getText())) {
					dispose();
					JOptionPane.showMessageDialog(null, "Log in succesfully!");
					Demo1.loggedIn();
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password");
				}
			}
		});
	}
}
