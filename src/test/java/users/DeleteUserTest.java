package users;

import static io.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteUserTest {
	
	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in";
		basePath = "/api";
	}
	
	@Test
	public void deleteUser() {
		given()
		.when()
			.delete("/users/7")
		.then()
			.statusCode(204)
		;
	}

}
