import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SearchBarTest {
    
    Application appArray[] = {
            new Application("Compass", "Explorers Inc.", "2.0", "http://compass.com", "An app that works as a compass.", 0.99, "iOS"),
            new Application("Money Transfer", "29th Bank", "1.3.4", "http://bank29.com/app", "Allows you to transfer money to a friend.", 0.00, "Android"),
            new Application("Calming Fish Tank", "The Games Company", "1.4", "http://fishgame.com", "A relaxing game where you watch swimming fish.", 2.99, "Android"),
            new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS"),
            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android"),
            new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS")
    };
    
    Application appArrayOod[] = {
            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android"),
            new Application("Food Ordering", "Convenient US", "1.0", "http://getfoodnow.com", "Connects you to someone to deliver your food.", 0.00, "iOS")
    };
    
    @Test
    final void testSearch() {
        ArrayList<Application> result = SearchBar.search(appArray, "ood");
        Assert.assertEquals(result.get(0).getName(), appArrayOod[0].getName());
        Assert.assertEquals(result.get(0), appArrayOod[0]);
        Assert.assertEquals(result.get(1), appArrayOod[1]);
        Assert.assertEquals(result.size(), appArrayOod.length);
        
    }

}
