import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchBar {
	public static ArrayList<Application> search(Application[] data, String find) {
		ArrayList<Application> output = new ArrayList<Application>();
		for(int i = 0; i < data.length; i++) {
			if (data[i].search(find)) {
				output.add(data[i]);
			}
		}
		return output;
	}
	
	public static ArrayList<Application> searchWithFilter(Application[] data, String find) {
		ArrayList<Application> output = new ArrayList<Application>();
		//to-Do
		
		
		
		
		return output;
	}
	
	public static ArrayList<Application> sortedResult(Application[] data, String find) {
		ArrayList<Application> output = new ArrayList<Application>();
		//to-Do
		
		
		
		
		return output;
	}
}

