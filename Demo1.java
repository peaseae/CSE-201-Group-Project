import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Demo1 {
	@SuppressWarnings("deprecation")
	public static ArrayList<Application> apps = new ArrayList<Application>(){{
		add(new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29)));
		add(new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android", new Date(2018, 2, 20)));
		add(new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android", new Date(2008, 1, 9)));
		add(new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS", new Date(2020, 11, 7)));
		add(new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android", new Date(2015, 8, 5)));
		add(new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food. Over 10 different restaurants are available, and some might be near you! Download now to find out!", 0.00, "iOS", new Date(2020, 9, 23)));
		add(new Application("Texting", "App Essentials", "5.0", "http://text.com", "Text all of your best friends with this one cool app! iOS only. In-app purchases included.", 0.00, "iOS", new Date(2001, 12, 29)));
		add(new Application("Student App", "Miami University", "5.3.4", "http://miamistudent.com/app", "Miami-exclusive app for all your student needs. Register for classes, order food on campus, and track the buses. Available only on Windows.", 0.00, "Windows", new Date(2020, 12, 20)));
		add(new Application("Meditation Guide", "Mental Health for You", "1.2.4", "http://healthy.com/meditate", "A guide to over 20 different meditation sets to relax your mind and train your body.", 11.99, "Android", new Date(2010, 1, 9)));
		add(new Application("Linux Pro", "Experts of Computers", "3.4.1", "http://linux.com/pro", "Get this app for Linux to improve your experience and become a pro!", 1.49, "Linux", new Date(2005, 5, 9)));
		add(new Application("Mountain Climber Expert Challenge", "Extreme Games", "4.5.3", "http://extremegames.com/climb", "Challenge yourself and compare your rank to your friends! Only the strongest will make it to the top. Download now to find out if you have what it takes to become king of the mountain!", 1.99, "iOS", new Date(2018, 9, 7)));
	}};

	private static JFrame frame;
	private static JTextField searchField;
	public static ArrayList<Application> output = new ArrayList<Application>();
	public static boolean hasLogin = false;
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

	public static void loggedIn(){
		frame.dispose();
		hasLogin = true;
		Demo1 window = new Demo1();
		window.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */


	private static void initialize() {
		// create frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 225, 225));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create log in and sign up buttons
		if (!hasLogin) {
			JButton loginBtn = new JButton("Login");
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LogInSc window3 = new LogInSc();
					//frame.dispose();
					window3.setVisible(true); 
				}
			});
			loginBtn.setBounds(558, 21, 100, 25);
			frame.getContentPane().add(loginBtn);

			JButton signUpBtn = new JButton("Sign up");
			signUpBtn.setBounds(670, 21, 100, 25);
			frame.getContentPane().add(signUpBtn);
			signUpBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SignUp window2 = new SignUp();
					//frame.dispose();
					window2.setVisible(true);
				}
			});
		}
		
		if (hasLogin) {
			JButton signOutBtn = new JButton("Sign out");
			signOutBtn.setBounds(670, 21, 100, 25);
			frame.getContentPane().add(signOutBtn);
			signOutBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					hasLogin = false;
					Demo1 window = new Demo1();
					window.frame.setVisible(true);
				}
			});
		}

		// create title that functions as home button
		JLabel applicationsLabel = new JLabel("Browse App");
		applicationsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					frame.setVisible(false);
					Demo1 window = new Demo1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		applicationsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		applicationsLabel.setBounds(40, 13, 189, 50);
		frame.getContentPane().add(applicationsLabel);

		// create scrolling result panel
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.white);
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane(resultPanel);
		scroll.setBackground(Color.white);
		scroll.setBounds(40, 195, 532, 302);
		frame.getContentPane().add(scroll);

		// create platform filter
		JComboBox platformBox = new JComboBox();
		String[] platforms = {"Select Platform", "iOS", "Android", "Windows", "Linux"};
		for (String platform: platforms) {
			platformBox.addItem(platform);
		}
		platformBox.setBounds(614, 195, 124, 42);
		frame.getContentPane().add(platformBox);

		// create price filter
		JComboBox priceBox = new JComboBox();
		String[] prices = {"Select Price", "Free", "$0.00 - $0.99", "$1.00 - $4.99", "$5.00 or more"};
		for (String price: prices) {
			priceBox.addItem(price);
		}
		priceBox.setBounds(614, 261, 124, 42);
		frame.getContentPane().add(priceBox);

		// create sort option
		JComboBox sortBox = new JComboBox();
		String[] sorts = {"Sort by...", "App Name A - Z", "App Name Z - A", "Date Added (Newest)", "Date Added (Oldest)"};
		for (String sort: sorts) {
			sortBox.addItem(sort);
		}
		sortBox.setBounds(614, 327, 124, 42);
		frame.getContentPane().add(sortBox);

		// create search button and search field
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(614, 129, 124, 42);
		frame.getContentPane().add(searchBtn);
		searchField = new JTextField();
		searchField.setBounds(40, 129, 532, 42);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);

		// create panel to show individual app details
		JPanel appPanel = new JPanel();
		appPanel.setLayout(new BoxLayout(appPanel, BoxLayout.Y_AXIS));
		JScrollPane scroll2 = new JScrollPane(appPanel);
		scroll2.setBounds(40, 195, 532, 302);

		// create panel to show app adding form
		JPanel addAppPanel = new JPanel();
		//JScrollPane scroll3 = new JScrollPane(addAppPanel);
		addAppPanel.setBounds(40, 195, 532, 302);
		addAppPanel.setLayout(new GridLayout(0,4));

		// create add app button
		JButton addAppBtn = new JButton("Add New App");
		addAppBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// bring up adding app scroll panel
				if (!hasLogin) {
					JOptionPane.showMessageDialog(null, "You need to log in to submit an app");
				}
				else {
				frame.getContentPane().remove(scroll);
				frame.getContentPane().remove(scroll2);
				frame.getContentPane().add(addAppPanel);
				// clear panel of any old search results
				addAppPanel.removeAll();
				addAppPanel.revalidate();
				addAppPanel.repaint();
				// display fields to be filled in
				JLabel nameLabel = new JLabel("    App Name:");
				addAppPanel.add(nameLabel);
				JTextField nameInput = new JTextField();
				addAppPanel.add(nameInput);
				JLabel orgLabel = new JLabel("    Organization:");
				addAppPanel.add(orgLabel);
				JTextField orgInput = new JTextField();
				addAppPanel.add(orgInput);
				JLabel versionLabel = new JLabel("    Version:");
				addAppPanel.add(versionLabel);
				JTextField versionInput = new JTextField();
				addAppPanel.add(versionInput);
				JLabel linkLabel = new JLabel("    External Link:");
				addAppPanel.add(linkLabel);
				JTextField linkInput = new JTextField();
				addAppPanel.add(linkInput);
				JLabel descLabel = new JLabel("    Description:");
				addAppPanel.add(descLabel);
				JTextField descInput = new JTextField();
				addAppPanel.add(descInput);
				JLabel priceLabel = new JLabel("    Price in dollars:");
				addAppPanel.add(priceLabel);
				JTextField priceInput = new JTextField();
				addAppPanel.add(priceInput);
				JLabel platformLabel = new JLabel("    Platform:");
				addAppPanel.add(platformLabel);
				JComboBox platformInput = new JComboBox();
				String[] platforms = {"iOS", "Android", "Windows", "Linux"};
				for (String platform: platforms) {
					platformInput.addItem(platform);
				}
				platformInput.setBackground(Color.WHITE);
				addAppPanel.add(platformInput);
				JLabel empty1 = new JLabel("");
				addAppPanel.add(empty1);
				JLabel empty2 = new JLabel("");
				addAppPanel.add(empty2);
				JLabel empty3 = new JLabel("");
				addAppPanel.add(empty3);
				JLabel empty4 = new JLabel("");
				addAppPanel.add(empty4);
				JLabel message = new JLabel("");
				addAppPanel.add(message);
				JButton submit = new JButton("Submit App");
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// take in inputed fields

						String name = nameInput.getText();
						String org = orgInput.getText();
						String version = versionInput.getText();
						String link = linkInput.getText();
						String desc = descInput.getText();
						String price = priceInput.getText();
						String platform = (String)(platformInput.getSelectedItem());
						// make sure no fields are left blank
						if (name.equals("") || org.equals("")|| version.equals("")
								|| link.equals("") || desc.equals("") || price.equals("")) {
							message.setForeground(Color.RED);
							message.setFont(new Font("SansSerif", Font.PLAIN, 11));
							message.setText("Please complete all fields.");
						} else {
							try {
								// convert price to double
								double priceInt = Double.parseDouble(price);
								apps.add(new Application(name, org, version, link, desc, priceInt, platform, new Date()));
								message.setForeground(new Color(120, 175, 155));
								message.setFont(new Font("SansSerif", Font.BOLD, 12));
								message.setText("App added!");
								nameInput.setText("");
								orgInput.setText("");
								versionInput.setText("");
								linkInput.setText("");
								descInput.setText("");
								priceInput.setText("");
							} catch (Exception e) {
								// if price cannot be converted to a double
								message.setForeground(Color.RED);
								message.setFont(new Font("SansSerif", Font.PLAIN, 11));
								message.setText("Price must be a number.");
							}

						}
					}
				});

				addAppPanel.add(submit);
				}
			}
		});
		addAppBtn.setBounds(614, 432, 124, 64);
		addAppBtn.setBackground(new Color(150, 195, 175));
		frame.getContentPane().add(addAppBtn);

		// create action listener to display search results in result panel
		ActionListener searchAction = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().remove(scroll2);
				frame.getContentPane().remove(addAppPanel);
				frame.getContentPane().add(scroll);
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
						// display each app as a button
						JButton temp = new JButton(app.displayHtml());
						temp.setHorizontalAlignment(SwingConstants.LEFT);
						temp.setBackground(Color.WHITE);
						resultPanel.add(temp);
						temp.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								// bring up details scroll panel
								frame.getContentPane().remove(scroll);
								frame.getContentPane().remove(addAppPanel);
								frame.getContentPane().add(scroll2);
								// clear panel of any old search results
								appPanel.removeAll();
								appPanel.revalidate();
								appPanel.repaint();
								// display information
								JTextArea textMessage = new JTextArea();
								textMessage.setLineWrap(true);
								textMessage.setWrapStyleWord(true);
								textMessage.setText(app.display());
								appPanel.add(textMessage);
							}
						});
					}
				}
				catch (Exception e) {
					JTextArea textMessage = new JTextArea();
					textMessage.setText("No results found.");
					resultPanel.add(textMessage);
				}
			}
		};
		// do search action when search button is clicked or enter is pressed
		searchBtn.addActionListener(searchAction);
		searchField.addActionListener(searchAction);
	}

}