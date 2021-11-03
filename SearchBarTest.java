import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SearchBarTest {
	   Application apps[] = {
	            new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS"),
	            new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android"),
	            new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android"),
	            new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS"),
	            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android"),
	            new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS")
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
		ArrayList<Application> result1 = SearchBar.searchWithFilter(apps, "game");
		ArrayList<Application> result2 = SearchBar.searchWithFilter(apps, "games");
		ArrayList<Application> result3 = SearchBar.searchWithFilter(apps, "bank");
		ArrayList<Application> result4 = SearchBar.searchWithFilter(apps, "banking");
		ArrayList<Application> result5 = SearchBar.searchWithFilter(apps, "banking system");
		ArrayList<Application> noResult1 = SearchBar.searchWithFilter(apps, "sport");
		ArrayList<Application> noResult2 = SearchBar.searchWithFilter(apps, "dating");
		assertTrue(result1.size() == 1);
		assertTrue(result2.size() == 1);
		assertTrue(result3.size() == 1);
		assertTrue(result4.size() == 1);
		assertTrue(result5.size() == 1);
		assertTrue(noResult1.size() == 0);
		assertTrue(noResult2.size() == 0);
	}
	
	//Added 11/3/2021
	@Test
	void testSortedSearch() {
		ArrayList<Application> result1 = SearchBar.search(apps, "ood");
		ArrayList<Application> result2 = SearchBar.search(apps, "tra");
		assertEquals(result1.get(0), apps[5]);
	    assertEquals(result1.get(1), apps[4]);
	    assertEquals(result2.get(0), apps[1]);
	    assertEquals(result2.get(1), apps[4]);
	    
	}
	
}
