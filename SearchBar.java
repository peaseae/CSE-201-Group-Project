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
	
	// Lower price and upper price are -1 if no price constraint
	// Platform is "" if no platform constraint
	// Sorted is an integer; 0 if unsorted, 1 if sorted alphabetically, 2 if sorted by date
	public static ArrayList<Application> search(Application[] data, String find, double lowerPrice, double upperPrice, String platform, int sorted) {
		ArrayList<Application> output = new ArrayList<Application>();
		for(int i = 0; i < data.length; i++) {
            if (data[i].search(find)) {
                if ((lowerPrice==-1 || data[i].getPrice() > lowerPrice) && (upperPrice==-1 || data[i].getPrice() < upperPrice)) {
                    if (platform.equals("") || data[i].getPlatform().equals(platform))
                        output.add(data[i]);
                }
            }
        }
		if (sorted == 1)
		    Collections.sort(output, AppNameComparator);
		if (sorted == 2)
		    Collections.sort(output, AppDateComparator);
		return output;
	}
	
	public static Comparator<Application> AppNameComparator = new Comparator<Application>() {
           public int compare(Application a1, Application a2) {
               String AppName1 = a1.getName().toUpperCase();
               String AppName2 = a2.getName().toUpperCase();
               
               return AppName1.compareTo(AppName2);
           }
   };
   
   public static Comparator<Application> AppDateComparator = new Comparator<Application>() {
       public int compare(Application a1, Application a2) {
           Date AppDateAdded1 = a1.getDateAdded();
           Date AppDateAdded2 = a2.getDateAdded();
           return AppDateAdded1.compareTo(AppDateAdded2);
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

}

