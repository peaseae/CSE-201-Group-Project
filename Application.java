import java.util.ArrayList;

public class Application {
	private String name;
	private String organization;
	private String version;
	private String externalLink;
	private String description;
	private double price;
	private String platform;
	
	public Application(String name, String organization, String version, String externalLink, String description,
			double price, String platform) {
		super();
		this.name = name;
		this.organization = organization;
		this.version = version;
		this.externalLink = externalLink;
		this.description = description;
		this.price = price;
		this.platform = platform;
	}
	
	public Application(String name, String organization, String description, double price, String platform) {
		super();
		this.name = name;
		this.organization = organization;
		this.description = description;
		this.version = "Updating...";
		this.externalLink = "Updating...";
		this.price = price;
		this.platform = platform;
	}

    @Override
    public String toString() {
        String result = "Name: " + getName()
                + "\nOrganization: " + getOrganization()
                + "\nVersion: " + getVersion()
                + "\nExternal Link: " + getExternalLink()
                + "\nDescription: " + getDescription()
                + "\nPrice: $" + getPrice()
                + "\nPlatform: " + getPlatform();
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
    public boolean equals(String a) {
        return this.name.toUpperCase().equals(a.toUpperCase());
    }
	public String display() {
		if (price == 0) {
			return getName() + "\n" 
					+ getOrganization() + "\n" 
					+ "Free!" + "\n"
					+ getPlatform() + "\n" ;
		}
        else 
        	return  getName() + "\n" 
        			+ getOrganization() + "\n$" 
        			+ getPrice() + "\n" 
        			+ getPlatform() + "\n" ;
	}
	
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
	
}
