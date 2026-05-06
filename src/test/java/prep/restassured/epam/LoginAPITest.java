package prep.restassured.epam;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.response.Response;

public class LoginAPITest {

	@Test
	public void loginTest() {
		baseURI = "http://64.227.160.186:9000/v1";
		LoginPOJO login = new LoginPOJO("iamfd", "password");
		String payload = convertToJson(login);
		Response response = given().baseUri(baseURI).and().header("Content-Type", "application/json").and()
				.body(payload).when().post("/login").then().statusCode(200).extract().response();
		System.out.println(response.asPrettyString());
		// Deserialization - Jackson Library is used for deserialization
		LoginResponsePOJO loginResponse = response.as(LoginResponsePOJO.class);
		System.out.println(loginResponse);
		System.out.println("Message: " + loginResponse.getMessage());
		System.out.println("Token: " + loginResponse.getData().getToken());
	}

	public String convertToJson(Object src) {
		Gson gson = new Gson();
		return gson.toJson(src);
	}
}
