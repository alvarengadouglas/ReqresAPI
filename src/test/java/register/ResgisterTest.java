package register;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ResgisterTest {

	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in";
		basePath = "/api";
	}
	
	@Test
	public void registerSucessful() {
		given()
			.contentType("application/json")
			.body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}")
		.when()
			.post("/register")
		.then()
			.statusCode(200)
			.body("id", is(4))
			.body("token", is("QpwL5tke4Pnpja7X4"))
		;
	}
	
	@Test
	public void registerUnsucessful() {
		given()
			.contentType("application/json")
			.body("{\"email\": \"eve.holt@reqres.in\"}")
		.when()
			.post("/register")
		.then()
			.statusCode(400)
			.body("error", is("Missing password"))
		;
	}
	
	

}
