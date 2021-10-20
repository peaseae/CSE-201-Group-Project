
public class SearchPage {
    public static void main(String[] args) {
        
        // initialize array with 6 app examples
        Application appArray[] = new Application[6];
        Application compass = new Application("Compass", "Explorers Inc.", "An app that works as a compass.", 0.99, "iOS");
        Application moneyTransfer = new Application("Money Transfer", "29th Bank", "Allows you to transfer money to a friend.", 0.00, "Android");
        Application fishTank = new Application("Calming Fish Tank", "The Games Company", "A relaxing game where you watch swimming fish.", 2.99, "Android");
        Application treeId = new Application("Tree Identifier", "Explorers Inc.", "Used to identify tree species.", 0.99, "iOS");
        Application moodTracker = new Application("Mood Tracker", "Mental Health for You", "Used to track your moods and emotions.", 1.99, "Android");
        Application foodOrder = new Application("Food Ordering", "Convenient US", "Connects you to someone to deliver your food.", 0.00, "iOS");
        appArray[0]=compass;
        appArray[1]=moneyTransfer;
        appArray[2]=fishTank;
        appArray[3]=treeId;
        appArray[4]=moodTracker;
        appArray[5]=foodOrder;
        
        // display each quality (except description)
        for (Application a: appArray) {
            System.out.println(a.getName());
            System.out.println(a.getOrganization());
            if (a.getPrice()==0) 
                System.out.println("Free!");
            else
                System.out.println("$"+a.getPrice());
            System.out.println(a.getPlatform());
            System.out.println();
        }
    }

}
