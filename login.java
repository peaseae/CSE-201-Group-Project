/**
 * Date: 11/19/21
 * Class containing username and password together to represent one account
 * @author - Hiep Cao
 * @author - Abigail Pease
 * @author - Kenten Egbert
 * @author - Caleb McConnell
 * 
 */
public class login {

	public String username;
	public String password;
	
	/**
	 * Constructor
	 * @param username String the inputted username
	 * @param password String the inputted password
	 */
	public login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return this.getUsername() + "," + this.getPassword();
	}

}



