package login;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
	
	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in";
		basePath = "/api";
	}
	
	@Test
	public void loginSucessful() {
		given()
			.contentType("application/json")
			.body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}")
		.when()
			.post("/login")
		.then()
			.statusCode(200)
			.body("token", is("QpwL5tke4Pnpja7X4"))
		;
	}
	
	@Test
	public void loginUnsucessful() {
		given()
			.contentType("application/json")
			.body("{\"email\": \"test@test.com\"}")
		.when()
			.post("/login")
		.then()
			.statusCode(400)
			.body("error", is("Missing password"))
		;
	}
	
	@Test
	public void loginUnsucessfulUserNotFound() {
		given()
			.contentType("application/json")
			.body("{\"email\": \"test@test.com\", \"password\": \"teste\"}")
		.when()
			.post("/login")
		.then()
			.statusCode(400)
			.body("error", is("user not found"))
		;
	}
	
	

}
