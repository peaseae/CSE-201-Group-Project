import java.util.Date;

public class Application {
	private String name;
	private String organization;
	private String version;
	private String externalLink;
	private String description;
	private double price;
	private String platform;
	private Date dateAdded;
	
	/**
	 * Full constructor for Application
	 * @param name String The name of the application
	 * @param organization String The organization which created the application
	 * @param version String The current version of the app, eg. 2.0
	 * @param externalLink String A link to the app's website
	 * @param description String A description of the app
	 * @param price Double The price of the app
	 * @param platform String The platform the app was made for, such as iOS, Android, Windows, or Linux
	 * @param dateAdded Date The date and time that the app was added to BrowseApp
	 */
	public Application(String name, String organization, String version, String externalLink, String description,
			double price, String platform, Date dateAdded) {
		super();
		this.name = name;
		this.organization = organization;
		this.version = version;
		this.externalLink = externalLink;
		this.description = description;
		this.price = price;
		this.platform = platform;
		this.dateAdded = dateAdded;
	}
	
	/**
	 * Partial constructor for Application which does not include date added, version, or external link
	 * @param name String The name of the application
	 * @param organization String The organization which created the application
	 * @param description String A description of the app
	 * @param price Double The price of the app
	 * @param platform String The platform the app was made for, such as iOS, Android, Windows, or Linux
	 */
	public Application(String name, String organization, String description, double price, String platform) {
		super();
		this.name = name;
		this.organization = organization;
		this.description = description;
		this.version = "Updating...";
		this.externalLink = "Updating...";
		this.price = price;
		this.platform = platform;
		this.dateAdded = new Date(0000, 00, 00);
	}

    @Override
    public String toString() {
        String result = "Name: " + getName()
                + "\nOrganization: " + getOrganization()
                + "\nVersion: " + getVersion()
                + "\nExternal Link: " + getExternalLink()
                + "\nDescription: " + getDescription()
                + "\nPrice: $" + getPrice()
                + "\nPlatform: " + getPlatform()
                + "\nDate Added: " + getDateAdded();
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Application)) {
            return false;
        }
        Application a = (Application)o;
        return (this.name.toUpperCase().equals(a.getName().toUpperCase())
             && this.organization.toUpperCase().equals(a.getOrganization().toUpperCase())
             && this.version.toUpperCase().equals(a.getVersion().toUpperCase())
             && this.externalLink.toUpperCase().equals(a.getExternalLink().toUpperCase())
             && this.description.toUpperCase().equals(a.getDescription().toUpperCase())
             && this.price == a.getPrice()
             && this.platform.toUpperCase().equals(a.getPlatform().toUpperCase()));
    }
    
    /**
     * Method used in testing to compare an app's name to a string
     * @param a String to be compared to
     * @return True if they match (non case sensitive), false otherwise
     */
    public boolean equals(String a) {
        return this.name.toUpperCase().equals(a.toUpperCase());
    }
    
    /**
     * Method used to display all of an application's information
     * @return String displaying the information
     */
	public String display() {
		if (price == 0) {
			return " " + getName()
			        + "\n------------------------------------------------------------------------------------------------------------------------------------"
                    + "\n External Link: " + getExternalLink()
                    + "\n Price: Free!"
                    + "\n Organization: " + getOrganization()
					+ "\n Version: " + getVersion()
					+ "\n Platform: " + getPlatform()
			        + "\n Date Added: " + getDateAdded()
			        + "\n Description: " + getDescription();
		}
        else {
        	return  " " + getName()
                	+ "\n------------------------------------------------------------------------------------------------------------------------------------"
                    + "\n External Link: " + getExternalLink()
                    + "\n Price: $" + getPrice()
                	+ "\n Organization: " + getOrganization()
                    + "\n Version: " + getVersion()
                    + "\n Platform: " + getPlatform()
                    + "\n Date Added: " + getDateAdded()
                    + "\n Description: " + getDescription();
        }
	}
    
	/**
	 * Method used to display all of an app's information in HTML form
	 * so it can be used within a button
	 * @return String displaying the information in HTML form
	 */
	public String displayHtml() {
        if (price == 0) {
            return "<html>" + getName() + "<br>" 
                    + getOrganization() + "<br>" 
                    + "Free!" + "<br>"
                    + getPlatform() + "<br>"
                    + "</html>";
        }
        else 
            return  "<html>" + getName() + "<br>" 
                    + getOrganization() + "<br>$" 
                    + getPrice() + "<br>" 
                    + getPlatform() + "<br>"
                    + "</html>";
    }
	
	/**
	 * Method to see if the name of an app contains a given search key
	 * @param a String to be searched for
	 * @return True if the string can be found, false otherwise
	 */
	public boolean search(String a) {
		String[] str = a.split(" ");
		for (String s: str) {
			if (name.toUpperCase().contains(s.toUpperCase()) ||
				description.toUpperCase().contains(s.toUpperCase()))
				return true;
			}
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getExternalLink() {
		return externalLink;
	}
	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Date getDateAdded() {
	    return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
	
}
