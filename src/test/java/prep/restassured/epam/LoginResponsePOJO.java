package prep.restassured.epam;

public class LoginResponsePOJO {
	private String message;
	private Data data;

	public LoginResponsePOJO() {

	}

	public LoginResponsePOJO(String message, Data data) {
		super();
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "LoginResponsePOJO [message=" + message + ", data=" + data + "]";
	}

}
