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
import javax.swing.JComboBox;

public class Demo1 {
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
    public ArrayList<Application> output = new ArrayList<Application>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Demo1 window = new Demo1();
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
    public Demo1() {
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
        
        // Makes sure the scroll bar starts at the top
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        
        JComboBox comboBox = new JComboBox();
        String[] platforms = {"Select Platform", "iOS", "Android", "Window", "Linux"};
        for (String platform: platforms) {
            comboBox.addItem(platform);
        }
        comboBox.setBounds(614, 195, 124, 42);
        frame.getContentPane().add(comboBox);
        
        JComboBox comboBox_1 = new JComboBox();
        String[] prices = {"Select Price", "Free", "$0.00 - $0.99", "$1.00 - $4.99", "$5.00 or more"};
        for (String price: prices) {
            comboBox_1.addItem(price);
        }
        comboBox_1.setBounds(614, 261, 124, 42);
        frame.getContentPane().add(comboBox_1);
        
        JComboBox comboBox_2 = new JComboBox();
        String[] sorts = {"Sort by...", "A - Z by App Name", "Z - A by App Name", "Date Added (Newest)", "Date Added (Oldest)"};
        for (String sort: sorts) {
            comboBox_2.addItem(sort);
        }
        comboBox_2.setBounds(614, 327, 124, 42);
        frame.getContentPane().add(comboBox_2);
        
//        comboBox.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                textArea.setText("");
//                String key = (String)(comboBox.getSelectedItem());
//                ArrayList<Application> curOutput = SearchBar.searchWithFilterPlatform(output, key);
//                try {
//                    if (curOutput.size() == 0) {
//                        textArea.setText("No results found.");
//                    }
//                    for (Application app : curOutput) {
//                        textArea.append(app.display() + "\n");
//                    }
//                }
//                catch (Exception e) {
//                    textArea.setText("No results founds.");
//                }
//                
//            }
//        });
        
        
        
        // Search button
        JButton btnNewButton_2 = new JButton("Search");
        
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textArea.setText("");
                String key = textField.getText();
                String platformKey = (String)(comboBox.getSelectedItem());
                String priceRangeKey = (String)(comboBox_1.getSelectedItem());
                String sortKey = (String)(comboBox_2.getSelectedItem());
                output = SearchBar.search(apps, key, priceRangeKey, platformKey, sortKey);
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
                    textArea.setText("No results founds.");
                }
            }
        });
        textField.setBounds(40, 129, 532, 42);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
    }
}
