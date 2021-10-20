
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
	
	public String display(Application a) {
		return "Name: " + getName() + "/n" 
				+ "Organization: " + getOrganization() + "/n" 
				+ "Version: " + getVersion() + "/n" 
				+ "External Link: " + getExternalLink() + "/n"
				+ "Description: " + getDescription() + "/n"
				+ "Price: $" + getPrice() + "/n"
				+ "Platform: " + getPlatform() + "/n";
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
