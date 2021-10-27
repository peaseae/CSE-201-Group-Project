import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ApplicationTest {
	Application apps[] = {
            new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS"),
            new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android"),
            new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android"),
            new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS"),
            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android"),
            new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS")
    };
	@Test
	void testContructor() {
		 Application app = new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS");
	}
	@Test
	void testContructor2() {
		Application app = new Application("Compass", "Explorers Inc.", "An app that works as a compass.", 0.99, "iOS");
	}
	@Test
	void testDisplay() {
		 assertEquals(apps[0].display(), "Compass\nExplorers Inc.\n0.99\niOS\n");
		 assertEquals(apps[1].display(), "Money Transfer\n29th Bank\nFree!\nAndroid\n");
	}
	@Test
	void testSearch() {
		assertTrue(apps[0].search("compass"));
		assertTrue(apps[1].search("friend"));
		assertTrue(apps[2].search("calm"));
		assertFalse(apps[3].search("flower"));
		assertTrue(apps[4].search("mood controller"));
		assertTrue(apps[5].search("food app"));
	}
}
