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

public class LogInSc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		
		JLabel lblNewLabel = new JLabel("User Name: ");
		lblNewLabel.setBounds(46, 83, 148, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(46, 144, 122, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome back!");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(256, 24, 129, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(168, 96, 310, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 157, 310, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(238, 214, 97, 40);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 280, 331, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setBackground(null);
		textField_2.setBorder(null);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CSVReadWrite.checkLogin("logins.csv", textField.getText(), textField_1.getText())) {
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
