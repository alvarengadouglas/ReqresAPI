package users;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PostUserTest {
	
	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in";
		basePath = "/api";
	}
	
	@Test
	public void createUser() {
		given()
			.contentType("application/json")
			.body("{\"name\": \"Jos�\", \"job\": \"QA\"}")
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.body("name", is("Jos�"))
			.body("job", is("QA"))
			.body("id", is(not("")))
			.body("createdAt", is(not("")))
		;
	}
	
//	O cenario abaixo (createUserUnsucessful) deveria retornar um erro de cria��o
//	Comportamento pendente implementa��o na API
	
//	@Test
//	public void createUserUnsucessful() {
//		given()
//		.contentType("application/json")
//		.body("{\"job\": \"QA\"}")
//	.when()
//		.post("/users")
//	.then()
//		.log().all()
//		.statusCode(201)
//		;
//	}
	
	
	
	
}





