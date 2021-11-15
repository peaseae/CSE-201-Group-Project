import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
    private JTextField searchField;
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
        
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(558, 21, 100, 25);
        frame.getContentPane().add(loginBtn);
        
        JButton signUpBtn = new JButton("Sign up");
        signUpBtn.setBounds(670, 21, 100, 25);
        frame.getContentPane().add(signUpBtn);
        
        JLabel applicationsLabel = new JLabel("Browse App");
        applicationsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        applicationsLabel.setBounds(40, 13, 189, 36);
        frame.getContentPane().add(applicationsLabel);
        
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.white);
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        
        JScrollPane scroll = new JScrollPane(resultPanel);
        scroll.setBackground(Color.white);
        scroll.setBounds(40, 195, 532, 302);
        frame.getContentPane().add(scroll);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComboBox platformBox = new JComboBox();
        String[] platforms = {"Select Platform", "iOS", "Android", "Window", "Linux"};
        for (String platform: platforms) {
            platformBox.addItem(platform);
        }
        platformBox.setBounds(614, 195, 124, 42);
        frame.getContentPane().add(platformBox);
        
        JComboBox priceBox = new JComboBox();
        String[] prices = {"Select Price", "Free", "$0.00 - $0.99", "$1.00 - $4.99", "$5.00 or more"};
        for (String price: prices) {
            priceBox.addItem(price);
        }
        priceBox.setBounds(614, 261, 124, 42);
        frame.getContentPane().add(priceBox);
        
        JComboBox sortBox = new JComboBox();
        String[] sorts = {"Sort by...", "App Name A - Z", "App Name Z - A", "Date Added (Newest)", "Date Added (Oldest)"};
        for (String sort: sorts) {
            sortBox.addItem(sort);
        }
        sortBox.setBounds(614, 327, 124, 42);
        frame.getContentPane().add(sortBox);
        
        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(614, 129, 124, 42);
        frame.getContentPane().add(searchBtn);
        
      searchBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
              // clear panel of any old search results
              resultPanel.removeAll();
              resultPanel.revalidate();
              resultPanel.repaint();
              // take in search input
              String key = searchField.getText();
              // take in platform, price range, and sorting method from combo boxes
              String platformKey = (String)(platformBox.getSelectedItem());
              String priceRangeKey = (String)(priceBox.getSelectedItem());
              String sortKey = (String)(sortBox.getSelectedItem());
              // create output using the search word, filters, and sorting method
              output = SearchBar.search(apps, key, priceRangeKey, platformKey, sortKey);
              // display
              try {
                  if (output.size() == 0) {
                      JTextArea textMessage = new JTextArea();
                      textMessage.setText("\n  No results found.\n  Maybe try searching something else?");
                      resultPanel.add(textMessage);
                  }
                  for (Application app : output) {
                      JButton temp = new JButton(app.displayHtml());
                      temp.setHorizontalAlignment(SwingConstants.LEFT);
                      temp.setBackground(Color.WHITE);
                      resultPanel.add(temp);
                  }
              }
              catch (Exception e) {
                  JTextArea textMessage = new JTextArea();
                  textMessage.setText("No results found.");
                  resultPanel.add(textMessage);
              }
          }
      });
        
//        searchBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                textArea.setText("");
//                String key = searchField.getText();
//                // take in platform, price range, and sorting method from combo boxes
//                String platformKey = (String)(platformBox.getSelectedItem());
//                String priceRangeKey = (String)(priceBox.getSelectedItem());
//                String sortKey = (String)(sortBox.getSelectedItem());
//                // create output using the search word, filters, and sorting method
//                output = SearchBar.search(apps, key, priceRangeKey, platformKey, sortKey);
//                // display
//                try {
//                    if (output.size() == 0) {
//                        textArea.setText("No results found.");
//                    }
//                    for (Application app : output) {
//                        textArea.append(app.display() + "\n");
//                        JButton appButton = new JButton(app.getName());
//                        scroll.add(appButton);
//                    }
//                }
//                catch (Exception e) {
//                    textArea.setText("There was an error displaying the output.");
//                }
//            }
//        });
        
        
        
        searchField = new JTextField();
//        searchField.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                textArea.setText("");
//                String key = searchField.getText();
//                output = SearchBar.search(apps, key);
//                try {
//                	if (output.size() == 0) {
//                        textArea.setText("No results found.");
//                    }
//                    for (Application app : output) {
//                        textArea.append(app.display() + "\n");
//                    }
//                }
//                catch (Exception e) {
//                    textArea.setText("No results founds.");
//                }
//            }
//        });
        searchField.setBounds(40, 129, 532, 42);
        frame.getContentPane().add(searchField);
        searchField.setColumns(10);
    }
}
