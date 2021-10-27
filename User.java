import java.util.ArrayList;
import java.util.Scanner;

public class User {

	public static void main(String[] args) {
	    Application appArray[] = {
	            new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS"),
	            new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android"),
	            new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android"),
	            new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS"),
	            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android"),
	            new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS")
	    };
	    
	    Scanner input = new Scanner(System.in);
	    // loop through search page
	    while (true) {
	        System.out.print("Search: ");
	        String find = input.nextLine();
	        // use searchbar to reduce the array to only relevant apps, then display them.
	        ArrayList<Application> output = SearchBar.search(appArray, find);
	        SearchPage.displaySearchPage(output, input);
	        // if there are results, have user choose a result to look at more closely.
	        if (output.size()!=0) {
	            System.out.println("_______________________\n");
	            // loop through result page -- keep prompting for result if input is invalid
	            while (true) {
    	            System.out.print("Choose Result Number: ");
    	            String choice = input.next();
    	            
    	            
    	            try {
    	                int choiceNum = Integer.parseInt(choice);
    	                if (choiceNum > 0 && choiceNum <= output.size()) {
                            System.out.println("_______________________\n");
                            System.out.println(output.get(choiceNum-1));
                            System.out.println("_______________________\n");
                            break;
                        } else {
                            System.out.println("_______________________\n");
                            System.out.print("No such result number.\n");
                            System.out.println("_______________________\n");
                            continue;
                        }
    	            } catch (Exception e) {
    	                System.out.println("_______________________\n");
                        System.out.print("Input must be a number.\n");
                        System.out.println("_______________________\n");
                        continue;
    	            }
    	        }
	            break;
	        }
	    }
	    input.close();

	}

}