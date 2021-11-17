import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReadWrite {
	private static String fileName = "logins.csv";
	
	public static void checkFile(String fileName) {
		File temp = new File(fileName);
		if(!temp.exists()) {
			File file = new File("logins.csv");
		}
		fileName = "logins.csv";
	}

	public static void writeCsv(String fileName) {
		checkFile(fileName);

		Scanner obj = new Scanner(System.in);
		System.out.println("Enter Username: ");

		String user = obj.nextLine();

		Scanner obj2 = new Scanner(System.in);
		System.out.println("Enter Password: ");

		String pass = obj2.nextLine();

		login l = new login(user, pass);


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
	}

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
	
	public static boolean checkLogin(String fileName) {
		checkFile(fileName);
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter Username: ");

		String user = obj.nextLine();

		Scanner obj2 = new Scanner(System.in);
		System.out.println("Enter Password: ");

		String pass = obj2.nextLine();

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

	public static void main(String[] args) {
//		writeCsv(fileName);
//		readCsv(fileName);
		System.out.println(checkLogin(fileName));
	}
}
