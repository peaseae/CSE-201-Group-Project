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
 * Class creating a sign up screen
 * @author - Hiep Cao
 * @author - Abigail Pease
 * @author - Kenten Egbert
 * @author - Caleb McConnell
 * 
 */
public class SignUp extends JFrame {

    /**
     * The JPanel displaying the sign up screen
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
	 * The frame displaying the signup screen
	 */
	public static SignUp frame = new SignUp();
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
	public SignUp() {
		setBackground(new Color(210, 225, 225));
        getContentPane().setLayout(null);
        setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name: ");
		lblNewLabel.setBounds(46, 83, 148, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(46, 144, 122, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome!");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(256, 24, 129, 27);
		contentPane.add(lblNewLabel_2);
		
		userField = new JTextField();
		userField.setBounds(168, 96, 310, 22);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(168, 157, 310, 22);
		contentPane.add(passField);
		passField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(238, 214, 97, 40);
		contentPane.add(btnNewButton);
		
		// Check username and password when log in button is pressed
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CSVReadWrite.signUp("logins.csv", userField.getText(), passField.getText())) {
					dispose();
					JOptionPane.showMessageDialog(null, "Sign up succesfully!");
					new Demo1();
				}
				else {
					JOptionPane.showMessageDialog(null, "Username has existed!");
				}
			}
		});
	}
}
