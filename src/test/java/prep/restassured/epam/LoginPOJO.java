package prep.restassured.epam;

public class LoginPOJO {
	private String username;
	private String password;
	
	public LoginPOJO() {
		
	}

	public LoginPOJO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginPOJO [username=" + username + ", password=" + password + "]";
	}
	
	

}
