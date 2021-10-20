import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SearchBar {
	private static String[] data = {"apple", "boat", "candy", "delta", "epsilon", "either", "dipper"};
	private static int size = data.length;


	public static String[] search(String[] data) {
		String[] output = new String[1];
		Scanner input = new Scanner(System.in);
		System.out.println("Search: ");
		String find = input.nextLine();
			for(int i = 0; i < size; i++) {
				int place = 0;
				if (find.equals(data[i])) {
					output[place] = data[i];
					place++;
				}
			}
		if (output[0] == null) {	
			output[0] = "There is no such application.";
			return output;
		} else {
			return output;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(search(data)));
	}
}

/*
import java.util.*;

public class SearchBar {
	private static String[] data = {"apple", "boat", "candy", "delta", "epsilon", "either", "dipper"};
	private static int size = data.length;


	public static ArrayList<String> search(String[] data) {
		ArrayList<String> output = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		System.out.println("Search: ");
		String find = input.nextLine(); 
			for(int i = 0; i < size; i++) {
				if (find.equals(data[i])) {
					output.add(data[i]);
				}
			}
			input.close();
			if (output.size() == 0) {	
				output.add("There is no such application.");
			return output;
			} else {
				return output;
			}
		}

	public static void main(String[] args) {
		System.out.println(search(data));
	}
}
*/
