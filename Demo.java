import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextArea;

public class Demo {
    @SuppressWarnings("deprecation")
    Application apps[] = {
            new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29)),
            new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android", new Date(2018, 2, 20)),
            new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android", new Date(2008, 1, 9)),
            new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS", new Date(2020, 11, 7)),
            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android", new Date(2015, 8, 5)),
            new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS", new Date(2020, 9, 23))
    };
    
    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Demo window = new Demo();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Demo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(210, 225, 225));
        frame.getContentPane().setLayout(null);
        
        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(558, 21, 100, 25);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Sign up");
        btnNewButton_1.setBounds(670, 21, 100, 25);
        frame.getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel = new JLabel("Application's Name");
        lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
        lblNewLabel.setBounds(40, 13, 189, 36);
        frame.getContentPane().add(lblNewLabel);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBackground(Color.white);
        scroll.setBounds(40, 195, 532, 302);
        frame.getContentPane().add(scroll);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnNewButton_2 = new JButton("Search");
        
        // Makes sure the scroll bar starts at the top
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textArea.setText("");
                String key = textField.getText();
                ArrayList<Application> output = new ArrayList<Application>();
                output = SearchBar.search(apps, key);
                try {
                    if (output.size() == 0) {
                        textArea.setText("No results found.");
                    }
                    for (Application app : output) {
                        textArea.append(app.display() + "\n");
                    }
                }
                catch (Exception e) {
                    textArea.setText("No results found. (Error)");
                }
            }
        });
        
        btnNewButton_2.setBounds(614, 129, 124, 42);
        frame.getContentPane().add(btnNewButton_2);
        
        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textArea.setText("");
                String key = textField.getText();
                ArrayList<Application> output = new ArrayList<Application>();
                output = SearchBar.search(apps, key);
                try {
                    for (Application app : output) {
                        textArea.append(app.display() + "\n");
                    }
                }
                catch (Exception e) {
                    textArea.setText("No results founds.");
                }
            }
        });
        textField.setBounds(40, 129, 532, 42);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        

    }
}