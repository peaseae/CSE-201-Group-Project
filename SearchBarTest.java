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
	//Filters need to be added still
//	@Test
//	void testSearchWithFilter() {
//		ArrayList<Application> result1 = SearchBar.search(apps, "game", 0, 5, "", 0);
//		ArrayList<Application> result2 = SearchBar.search(apps, "games", 0, 1, "", 0);
//		ArrayList<Application> result3 = SearchBar.search(apps, "bank", 0.01, 5, "", 0);
//		ArrayList<Application> result4 = SearchBar.search(apps, "banking", -1, -1, "iOS", 0);
//		ArrayList<Application> result5 = SearchBar.search(apps, "banking system", -1, -1, "", 0);
//		ArrayList<Application> noResult1 = SearchBar.search(apps, "sport", -1, -1, "", 0);
//		ArrayList<Application> noResult2 = SearchBar.search(apps, "dating", -1, -1, "", 0);
//		assertTrue(result1.size() == 1);
//		assertTrue(result2.size() == 1);
//		assertTrue(result3.size() == 1);
//		assertTrue(result4.size() == 1);
//		assertTrue(result5.size() == 1);
//		assertTrue(noResult1.size() == 0);
//		assertTrue(noResult2.size() == 0);
//	}
//	
//	//Added 11/3/2021
//	@Test
//	void testSortedSearch() {
//		ArrayList<Application> result1 = SearchBar.search(apps, "ood");
//		ArrayList<Application> result2 = SearchBar.search(apps, "tra");
//		assertEquals(result1.get(0), apps[5]);
//	    assertEquals(result1.get(1), apps[4]);
//	    assertEquals(result2.get(0), apps[1]);
//	    assertEquals(result2.get(1), apps[4]);
//	    
//	}
	
}
