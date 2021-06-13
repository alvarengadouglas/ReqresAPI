package users;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class PatchUser {

	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in";
		basePath = "/api";
	}
	
	@Test
	public void patchUser() {
		given()
			.contentType("application/json")
			.body("{\"name\": \"Usuario\"}")
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.body("name", is("Usuario"))
			.body("updatedAt", is(not("")))
		;
	}
}
