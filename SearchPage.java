
import java.util.ArrayList;
import java.util.Scanner;

public class SearchPage {
    public static void main(String[] args) {
        
        // initialize array with 6 app examples
        Application appArray[] = {
                new Application("Compass", "Explorers Inc.", "An app that works as a compass.", 0.99, "iOS"),
                new Application("Money Transfer", "29th Bank", "Allows you to transfer money to a friend.", 0.00, "Android"),
                new Application("Calming Fish Tank", "The Games Company", "A relaxing game where you watch swimming fish.", 2.99, "Android"),
                new Application("Tree Identifier", "Explorers Inc.", "Used to identify tree species.", 0.99, "iOS"),
                new Application("Mood Tracker", "Mental Health for You", "Used to track your moods and emotions.", 1.99, "Android"),
                new Application("Food Ordering", "Convenient US", "Connects you to someone to deliver your food.", 0.00, "iOS")
        };
        
        // display each quality (except description)
        // displaySearchPage(appArray);
        
    }
    
    public static void displaySearchPage(ArrayList<Application> appArray, Scanner input) {
        System.out.println("_______________________\n");
        int i=1;
        for (Application a: appArray) {
            System.out.println("Result "+i);
            i++;
            System.out.println(a.display());
        }
        if (appArray.size() == 0) {
            System.out.println("No results.\n");
            System.out.println("_______________________\n");
        }
    }   
}
