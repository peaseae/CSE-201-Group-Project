import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 11/19/21
 * Class used to read and write login information from a CSV file
 * @author - Hiep Cao
 * @author - Abigail Pease
 * @author - Kenten Egbert
 * @author - Caleb McConnell
 * 
 */
public class CSVReadWrite {
   /**
    * Name of the file to be written to and read from
    */
	private static String fileName = "logins.csv";

	/**
	 * Method to check if a file exists and create it if not
	 * @param fileName String The name of the file to check for
	 */
	public static void checkFile(String fileName) {
		File temp = new File(fileName);
		if(!temp.exists()) {
			File file = new File("logins.csv");
		}
		fileName = "logins.csv";
	}

	/**
	 * Method allowing a user to sign up, adding their username and password to the file
	 * @param fileName The file to be written to
	 * @param userName The username to be written
	 * @param password The password to be written
	 * @return True if successful, false otherwise
	 */
	public static boolean signUp(String fileName, String userName, String password) {
		checkFile(fileName);

		login l = new login(userName, password);

		BufferedReader reader = null;
		List<login> logins = new ArrayList<login>();

		try {
			reader = new BufferedReader (new FileReader(fileName));
			String line;

			while((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				if(parts.length > 0) {
					logins.add(new login(parts[0], parts[1]));
				}

				System.out.println(logins);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(login i : logins) {
			if(l.getUsername().equals(i.getUsername())) {
				return false;
			}
		}

		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName, true);
			fw.append(l.getUsername());
			fw.append(",");
			fw.append(l.getPassword());
			fw.append("\n");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * Method to read from the csv file
	 * @param fileName The file to be read from
	 */
	public static void readCsv(String fileName) {
		checkFile(fileName);
		BufferedReader reader = null;
		List<login> logins = new ArrayList<login>();

		try {
			reader = new BufferedReader (new FileReader(fileName));
			String line;

			while((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				if(parts.length > 0) {
					logins.add(new login(parts[0], parts[1]));
				}

				System.out.println(logins);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method used while logging in to check if the given username and password exist in the file
	 * @param fileName The file to be read from
	 * @param user The username to be checked
	 * @param pass The password to be checked
	 * @return True if found, false otherwise
	 */
	public static boolean checkLogin(String fileName, String user, String pass) {
		checkFile(fileName);

		login l = new login(user, pass);

		BufferedReader reader = null;
		List<login> logins = new ArrayList<login>();

		try {
			reader = new BufferedReader (new FileReader(fileName));
			String line;

			while((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				if(parts.length > 0) {
					logins.add(new login(parts[0], parts[1]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (login i : logins) {
			if (i.getUsername().equals(l.getUsername()) && i.getPassword().equals(l.getPassword())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Main method used in testing the file reading and writing
	 * @param args String array of arguments
	 */
	public static void main(String[] args) {
		// System.out.println(signUp(fileName));
		//		readCsv(fileName);
		//		System.out.println(checkLogin(fileName));
	}
}