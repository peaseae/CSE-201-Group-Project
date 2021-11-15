import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;



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
	
	public static ArrayList<Application> search(Application[] data, String find, String price, String platform, String sort) {
		ArrayList<Application> output = new ArrayList<Application>();
		double[] prices = convertPriceKey(price);
		for(int i = 0; i < data.length; i++) {
            if (data[i].search(find)
                    && (platform.equals("Select Platform") || platform.equals(data[i].getPlatform()))
                    && data[i].getPrice() >= prices[0] && data[i].getPrice() <= prices[1]) {
                output.add(data[i]);
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
                Collections.sort(output, AppDateReverseComparator);
                break;
            case "Date Added (Oldest)":
                Collections.sort(output, AppDateComparator);
                break;
        }
		return output;
	}
	
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
	
	public static Comparator<Application> AppNameComparator = new Comparator<Application>() {
           public int compare(Application a1, Application a2) {
               String AppName1 = a1.getName().toUpperCase();
               String AppName2 = a2.getName().toUpperCase();
               
               return AppName1.compareTo(AppName2);
           }
   };
   
   public static Comparator<Application> AppNameReverseComparator = new Comparator<Application>() {
       public int compare(Application a1, Application a2) {
           String AppName1 = a1.getName().toUpperCase();
           String AppName2 = a2.getName().toUpperCase();
           
           return AppName2.compareTo(AppName1);
       }
   };
   
   public static Comparator<Application> AppDateComparator = new Comparator<Application>() {
       public int compare(Application a1, Application a2) {
           Date AppDateAdded1 = a1.getDateAdded();
           Date AppDateAdded2 = a2.getDateAdded();
           return AppDateAdded1.compareTo(AppDateAdded2);
       }
   };
   
   public static Comparator<Application> AppDateReverseComparator = new Comparator<Application>() {
       public int compare(Application a1, Application a2) {
           Date AppDateAdded1 = a1.getDateAdded();
           Date AppDateAdded2 = a2.getDateAdded();
           return AppDateAdded2.compareTo(AppDateAdded1);
       }
   };
   
//	public static ArrayList<Application> sortedResultTitle(Application[] data, String find) {
//	    ArrayList<Application> output = new ArrayList<Application>();
//        for(int i = 0; i < data.length; i++) {
//            if (data[i].search(find)) {
//                output.add(data[i]);
//            }
//        }
//        Collections.sort(output, AppNameComparator);
//        return output;
//	}
	

	
//	public static ArrayList<Application> sortedResultDate(Application[] data, String find) {
//        ArrayList<Application> output = new ArrayList<Application>();
//        for(int i = 0; i < data.length; i++) {
//            if (data[i].search(find)) {
//                output.add(data[i]);
//            }
//        }
//        Collections.sort(output, AppDateComparator);
//        return output;
//    }
	public static ArrayList<Application> searchWithFilterPlatform(ArrayList<Application> data, String platf) {
		//to-Do
		ArrayList<Application> output = new ArrayList<Application>();
		for(int i = 0; i < data.size(); i++) {
			if (data.get(i).getPlatform().toUpperCase().equals(platf.toUpperCase())) {
				output.add(data.get(i));
			}
		}
		return output;
	}
	
	public static ArrayList<Application> searchWithFilterPrice(ArrayList<Application> data, double p1, double p2) {
        //to-Do
        ArrayList<Application> output = new ArrayList<Application>();
        for(int i = 0; i < data.size(); i++) {
            if ((data.get(i).getPrice() > p1) && (data.get(i).getPrice() < p2)) {
                output.add(data.get(i));
            }
        }
        return output;
    }
}

