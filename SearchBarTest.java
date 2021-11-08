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
    
    Application appArrayMood[] = {
            new Application("Mood Tracker", "Mental Health for You", "2.3.1", "http://healthy.com/mood", "Used to track your moods and emotions.", 1.99, "Android"),
    };
    
    Application appArrayTree[] = {
            new Application("Tree Identifier", "Explorers Inc.", "4.3", "http://explorersinc.com/treeidapp", "Used to identify tree species.", 0.99, "iOS"),
    };
    
    Application empty[] = {
    };
    
    @Test
    final void testSearch() {
        // All results
        // Test with searching an empty string -- should be all results (6)
        ArrayList<Application> result = SearchBar.search(appArray, "");
        Assert.assertEquals(result.get(0).getName(), appArray[0].getName());
        Assert.assertEquals(result.get(0), appArray[0]);
        Assert.assertEquals(result.get(1), appArray[1]);
        Assert.assertEquals(result.get(2), appArray[2]);
        Assert.assertEquals(result.get(3), appArray[3]);
        Assert.assertEquals(result.get(4), appArray[4]);
        Assert.assertEquals(result.get(5), appArray[5]);
        Assert.assertEquals(result.size(), appArray.length);
        Assert.assertEquals(result.size(), 6);
        
        // Some results
        // Test with searching "ood" -- should be Mood Tracker and Food Ordering (2)
        result = SearchBar.search(appArray, "ood");
        Assert.assertEquals(result.get(0).getName(), appArrayOod[0].getName());
        Assert.assertEquals(result.get(0), appArrayOod[0]);
        Assert.assertEquals(result.get(1), appArrayOod[1]);
        Assert.assertEquals(result.size(), appArrayOod.length);
        Assert.assertEquals(result.size(), 2);
        
        // No results
        // Test with "1000" -- should be no results (0)
        result = SearchBar.search(appArray, "1000");
        Assert.assertEquals(result.size(), empty.length);
        Assert.assertEquals(result.size(), 0);
        
        // No results with multiple words
        // Test with "1000 candy" -- should be no results (0)
        result = SearchBar.search(appArray, "1000 candy");
        Assert.assertEquals(result.size(), empty.length);
        Assert.assertEquals(result.size(), 0);
        
        // Not case sensitive
        // Test with "mood tracker" -- should be Mood Tracker (1)
        result = SearchBar.search(appArray, "mood tracker");
        Assert.assertEquals(result.get(0).getName(), appArrayMood[0].getName());
        Assert.assertEquals(result.get(0), appArrayMood[0]);
        Assert.assertEquals(result.size(), appArrayMood.length);
        Assert.assertEquals(result.size(), 1);
        
        // Can search by description
        // Test with "species." -- should be Tree Identifier (1)
        result = SearchBar.search(appArray, "species.");
        Assert.assertEquals(result.get(0).getName(), appArrayTree[0].getName());
        Assert.assertEquals(result.get(0), appArrayTree[0]);
        Assert.assertEquals(result.size(), appArrayTree.length);
        Assert.assertEquals(result.size(), 1);
        
        // With multiple words, display results of each word
        // Test with "slide mood tiger food" -- should be Mood Tracker and Food Ordering (2)
        result = SearchBar.search(appArray, "slide mood tiger food");
        Assert.assertEquals(result.get(0).getName(), appArrayOod[0].getName());
        Assert.assertEquals(result.get(0), appArrayOod[0]);
        Assert.assertEquals(result.get(1), appArrayOod[1]);
        Assert.assertEquals(result.size(), appArrayOod.length);
        Assert.assertEquals(result.size(), 2);
        
    }

}
