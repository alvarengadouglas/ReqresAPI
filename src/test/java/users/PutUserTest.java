package users;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PutUserTest {
	
	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in";
		basePath = "/api";
	}
	
	@Test
	public void putUser() {
		given()
			.contentType("application/json")
			.body("{\"name\": \"Douglas\", \"job\": \"QA\"}")
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.body("name", is("Douglas"))
			.body("job", is("QA"))
			.body("updatedAt", is(not("")))
		;
	}

}


