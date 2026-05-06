package prep.restassured.epam;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class RunnerClass {

	@Test
	public void serializationDemo() {
		UserPOJO userPojo = new UserPOJO("Thomas", 29);
		System.out.println(userPojo);
		// Serialization - Java Object to Json
		// Gson is a class
		Gson gson = new Gson();
		String data = gson.toJson(userPojo);
		System.out.println(data);
		// Deseriliazation - Json to JavaObject
		String jsonData = """
				{"name":"Uday","age":39}
				""";
		UserPOJO newUser = gson.fromJson(jsonData, UserPOJO.class);
		System.out.println(newUser);
	}

	@Test
	public void serializationAndDesrializationUsingJackson() throws JsonProcessingException {
		UserPOJO userPojo = new UserPOJO("Blake", 41);
		System.out.println(userPojo);
		// Jackson
		// serialization
		ObjectMapper mapper = new ObjectMapper();
		String data = mapper.writeValueAsString(userPojo);
		System.out.println(data);
		String formattedData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userPojo);
		System.out.println(formattedData);
		// deserialization
		String jsonData = """
				{"name":"Luke","age":49}
				""";
		UserPOJO newUser = mapper.readValue(jsonData, UserPOJO.class);
		System.out.println(newUser);

	}

}
