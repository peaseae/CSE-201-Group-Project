import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class SearchBarTest {
	@SuppressWarnings("deprecation")
    Application apps[] = {
	            new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29)),
	            new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android", new Date(2018, 2, 20)),
	            new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android", new Date(2008, 1, 9)),
	            new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS", new Date(2020, 11, 7)),
	            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android", new Date(2015, 8, 5)),
	            new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS", new Date(2020, 9, 23))
	    };
		
	@Test
	void testSearch() {
		ArrayList<Application> result = SearchBar.search(apps, "ood");
		ArrayList<Application> noResult = SearchBar.search(apps, "asfa");
        assertEquals(result.get(0), apps[4]);
        assertEquals(result.get(1), apps[5]);
        assertTrue(noResult.size() == 0);
	}

	//Added 11/3/2021
	
	@Test
	void testSearchWithFilter() {
		ArrayList<Application> apps2 = new ArrayList<Application>();
		apps2.add(new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29)));
		apps2.add(new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android", new Date(2018, 2, 20)));
		apps2.add(new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Linux", new Date(2008, 1, 9)));
		apps2.add(new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS", new Date(2020, 11, 7)));
		apps2.add(new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android", new Date(2015, 8, 5)));
		apps2.add(new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS", new Date(2020, 9, 23)));
		
		ArrayList<Application> result1 = SearchBar.search(apps2, "", "free", "Select Platform", "Sort by...");
		ArrayList<Application> result2 = SearchBar.search(apps2, "", "$0.00 - $0.99", "Select Platform", "Sort by...");
		ArrayList<Application> result3 = SearchBar.search(apps2, "", "$1.00 - $4.99", "Select Platform", "Sort by...");
		ArrayList<Application> result4 = SearchBar.search(apps2, "", "$5.00 or more", "Select Platform", "Sort by...");
		ArrayList<Application> result5 = SearchBar.search(apps2, "", "Select Price", "iOS", "Sort by...");
		ArrayList<Application> result6 = SearchBar.search(apps2, "", "Select Price", "Android", "Sort by...");
		ArrayList<Application> result7 = SearchBar.search(apps2, "", "Select Price", "Linux", "Sort by...");
		ArrayList<Application> result8 = SearchBar.search(apps2, "", "Select Price", "Windows", "Sort by...");
		assertTrue(result1.size() == 2);
		assertTrue(result2.size() == 4);
		assertTrue(result3.size() == 2);
		assertTrue(result4.size() == 0);
		assertTrue(result5.size() == 3);
		assertTrue(result6.size() == 2);
		assertTrue(result7.size() == 1);
		assertTrue(result8.size() == 0);
	}
	
//	//Added 11/3/2021
	@Test
	void testSortedSearch() {
		ArrayList<Application> apps2 = new ArrayList<Application>();
		apps2.add(new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29)));
		apps2.add(new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android", new Date(2018, 2, 20)));
		apps2.add(new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android", new Date(2008, 1, 9)));
		apps2.add(new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS", new Date(2020, 11, 7)));
		apps2.add(new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android", new Date(2015, 8, 5)));
		apps2.add(new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS", new Date(2020, 9, 23)));
		
		ArrayList<Application> result1 = SearchBar.search(apps2, "", "Select Price", "Select Platform", "App Name A - Z");
		ArrayList<Application> result2 = SearchBar.search(apps2, "", "Select Price", "Select Platform", "App Name Z - A");
		ArrayList<Application> result3 = SearchBar.search(apps2, "", "Select Price", "Select Platform", "Date Added (Newest)");
		ArrayList<Application> result4 = SearchBar.search(apps2, "", "Select Price", "Select Platform", "Date Added (Oldest)");
		assertEquals(result1.get(0), apps[2]);
		assertEquals(result1.get(5), apps[3]);
		assertEquals(result2.get(0), apps[3]);
		assertEquals(result2.get(5), apps[2]);
		assertEquals(result3.get(0), apps[2]);
		assertEquals(result3.get(5), apps[3]);
		assertEquals(result4.get(0), apps[3]);
		assertEquals(result4.get(5), apps[2]);
	}
	
}
