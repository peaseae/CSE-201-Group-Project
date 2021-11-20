import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Date: 11/19/21
 * Class used to search, sort, and filter applications
 * @author - Hiep Cao
 * @author - Abigail Pease
 * @author - Kenten Egbert
 * @author - Caleb McConnell
 * 
 */
public class SearchBar {

    /**
     * A simplified search using only the search box
     * @param data An array of applications to be searched through
     * @param find String the key to find
     * @return An arraylist of all search results matching the key
     */
	public static ArrayList<Application> search(Application[] data, String find) {
		ArrayList<Application> output = new ArrayList<Application>();
		for(int i = 0; i < data.length; i++) {
			if (data[i].search(find)) {
				output.add(data[i]);
			}
		}
		return output;
	}
	
	/**
	 * A full search using search box, filters, and sorting methods
	 * @param data ArrayList of data to be searched through
	 * @param find String key to be searched for
	 * @param price String The selected price filter
	 * @param platform String The selected platform filter
	 * @param sort String The selected sorting method
	 * @return An arraylist of applications resulting from the search
	 */
	public static ArrayList<Application> search(ArrayList<Application> data, String find, String price, String platform, String sort) {
		ArrayList<Application> output = new ArrayList<Application>();
		double[] prices = convertPriceKey(price);
		for(int i = 0; i < data.size(); i++) {
            if (data.get(i).search(find)
                    && (platform.equals("Select Platform") || platform.equals(data.get(i).getPlatform()))
                    && data.get(i).getPrice() >= prices[0] && data.get(i).getPrice() <= prices[1]) {
                output.add(data.get(i));
            }
        }
		// sort if necessary
		switch (sort) {
            case "App Name A - Z":
                Collections.sort(output, AppNameComparator);
                break;
            case "App Name Z - A":
                Collections.sort(output, AppNameReverseComparator);
                break;
            case "Date Added (Newest)":
                Collections.sort(output, AppDateComparator);
                break;
            case "Date Added (Oldest)":
                Collections.sort(output, AppDateReverseComparator);
                break;
        }
		return output;
	}
	
	/**
	 * A method to convert a String price range into an upper and lower bound
	 * @param priceKey String the range of prices in string format
	 * @return An array of doubles containing a lower bound and an upper bound
	 */
	public static double[] convertPriceKey(String priceKey) {
	    double[] prices = new double[2];
	    switch (priceKey) {
    	    case "Select Price":
    	        prices[0] = Integer.MIN_VALUE;
    	        prices[1] = Integer.MAX_VALUE;
    	        break;
    	    case "free":
    	        prices[0] = 0;
                prices[1] = 0;
                break;
    	    case "$0.00 - $0.99":
                prices[0] = 0;
                prices[1] = 0.99;
                break;
            case "$1.00 - $4.99":
                prices[0] = 1;
                prices[1] = 4.99;
                break;
            case "$5.00 or more":
                prices[0] = 5;
                prices[1] = Integer.MAX_VALUE;
                break;
	    }
	    return prices;
	}
	
	/**
	 * Comparator used for sorting alphabetically.
	 */
	public static Comparator<Application> AppNameComparator = new Comparator<Application>() {
           public int compare(Application a1, Application a2) {
               String AppName1 = a1.getName().toUpperCase();
               String AppName2 = a2.getName().toUpperCase();
               
               return AppName1.compareTo(AppName2);
           }
   };
   
   /**
    * Comparator used for sorting reverse alphabetically.
    */
   public static Comparator<Application> AppNameReverseComparator = new Comparator<Application>() {
       public int compare(Application a1, Application a2) {
           String AppName1 = a1.getName().toUpperCase();
           String AppName2 = a2.getName().toUpperCase();
           
           return AppName2.compareTo(AppName1);
       }
   };
   
   /**
    * Comparator used for sorting by date newest to oldest.
    */
   public static Comparator<Application> AppDateComparator = new Comparator<Application>() {
       public int compare(Application a1, Application a2) {
           Date AppDateAdded1 = a1.getDateAdded();
           Date AppDateAdded2 = a2.getDateAdded();
           return AppDateAdded1.compareTo(AppDateAdded2);
       }
   };
   
   /**
    * Comparator used for sorting by date oldest to newest.
    */
   public static Comparator<Application> AppDateReverseComparator = new Comparator<Application>() {
       public int compare(Application a1, Application a2) {
           Date AppDateAdded1 = a1.getDateAdded();
           Date AppDateAdded2 = a2.getDateAdded();
           return AppDateAdded2.compareTo(AppDateAdded1);
       }
   };
}

