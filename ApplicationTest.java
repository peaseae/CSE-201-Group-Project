import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ApplicationTest {
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
	void testContructor() {
		 Application app = new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29));
	}
	@Test
	void testContructor2() {
		Application app = new Application("Compass", "Explorers Inc.", "An app that works as a compass.", 0.99, "iOS");
	}
	@Test
	void testToString() {
		assertEquals(apps[0].toString(), "Name: " + apps[0].getName()
        + "\nOrganization: " + apps[0].getOrganization()
        + "\nVersion: " + apps[0].getVersion()
        + "\nExternal Link: " + apps[0].getExternalLink()
        + "\nDescription: " + apps[0].getDescription()
        + "\nPrice: $" + apps[0].getPrice()
        + "\nPlatform: " + apps[0].getPlatform()
        + "\nDate Added: " + apps[0].getDateAdded());
	}
	@Test
	void testEquals() {
		Application app = new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29));
		assertTrue(app.equals(apps[0]));
	}
	@Test
	void testNameEquals() {
		Application app = new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29));
		assertTrue(app.equals(apps[0].getName()));
		assertTrue(app.equals(app));
		assertFalse(app.equals("long"));
	}
	@Test
	void testDisplay() {
		Application app = new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29));
		assertEquals(app.display(), " " + app.getName()
                	+ "\n------------------------------------------------------------------------------------------------------------------------------------"
                    + "\n External Link: " + app.getExternalLink()
                    + "\n Price: $" + app.getPrice()
                	+ "\n Organization: " + app.getOrganization()
                    + "\n Version: " + app.getVersion()
                    + "\n Platform: " + app.getPlatform()
                    + "\n Date Added: " + app.getDateAdded()
                    + "\n Description: " + app.getDescription());
		
		Application app1 = new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android", new Date(2018, 2, 20));
		assertEquals(app1.display(), " " + app1.getName()
    	+ "\n------------------------------------------------------------------------------------------------------------------------------------"
        + "\n External Link: " + app1.getExternalLink()
        + "\n Price: Free!"
    	+ "\n Organization: " + app1.getOrganization()
        + "\n Version: " + app1.getVersion()
        + "\n Platform: " + app1.getPlatform()
        + "\n Date Added: " + app1.getDateAdded()
        + "\n Description: " + app1.getDescription());
	}
	@Test
	void testDisplayHtml() {
		Application app = new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29));
		assertEquals(app.displayHtml(), "<html>" + app.getName() + "<br>" 
                    + app.getOrganization() + "<br>$" 
                    + app.getPrice() + "<br>" 
                    + app.getPlatform() + "<br>"
                    + "</html>");
		
		Application app1 = new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android", new Date(2018, 2, 20));
		assertEquals(app1.displayHtml(), "<html>" + app1.getName() + "<br>" 
                + app1.getOrganization() + "<br>" 
                + "Free!" + "<br>" 
                + app1.getPlatform() + "<br>"
                + "</html>");
		
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
	@Test
	void testSetters() {
		Application app = new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS", new Date(2011, 12, 29));
		app.setName("Money Transfer");
		app.setOrganization("29th Bank");
		app.setVersion("1.3.4");
		app.setExternalLink("http://bank29.com/app");
		app.setDescription("Allows you to transfer money to a friend.");
		app.setPrice(0.0);
		app.setPlatform("Android");
		app.setDateAdded(new Date(2018, 2, 20));
		assertTrue(app.equals(apps[1]));
	}
}