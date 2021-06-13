package users;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GetUsersTest {
	
	@BeforeClass
	public static void setup() {
		baseURI = "https://reqres.in";
		basePath = "/api";
	}
	
	@Test
	public void getSingleUser() {
		given()
		.when()
			.get("/users/2")
		.then()
			.statusCode(200)
			.body("support.url", is("https://reqres.in/#support-heading"))
			.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
			.body("data.id", is(2))
			.body("data.email", is("janet.weaver@reqres.in"))
			.body("data.first_name", is("Janet"))
			.body("data.last_name", is("Weaver"))
			.body("data.avatar", is("https://reqres.in/img/faces/2-image.jpg"))
			;
	}
	
	@Test
	public void getListUsersPageOne() {
		given()
		.when()
			.get("/users")
		.then()
			.statusCode(200)
			.body("support.url", is("https://reqres.in/#support-heading"))
			.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
			.body("page", is(1))
			.body("total", is(12))
			.body("per_page", is(6))
			.body("total_pages", is(2))
			.body("data[0].id", is(1))
			.body("data[0].email", is("george.bluth@reqres.in"))
			.body("data[0].first_name", is("George"))
			.body("data[0].last_name", is("Bluth"))
			.body("data[0].avatar", is("https://reqres.in/img/faces/1-image.jpg"))
			.body("data[2].id", is(3))
			.body("data[2].email", is("emma.wong@reqres.in"))
			.body("data[2].first_name", is("Emma"))
			.body("data[2].last_name", is("Wong"))
			.body("data[2].avatar", is("https://reqres.in/img/faces/3-image.jpg"))
		;
	}
	
	@Test
	public void getListUsersPageTwo() {
		given()
		.when()
			.get("/users?page=2")
		.then()
			.statusCode(200)
			.body("support.url", is("https://reqres.in/#support-heading"))
			.body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
			.body("page", is(2))
			.body("total", is(12))
			.body("per_page", is(6))
			.body("total_pages", is(2))
			.body("data[0].id", is(7))
			.body("data[0].email", is("michael.lawson@reqres.in"))
			.body("data[0].first_name", is("Michael"))
			.body("data[0].last_name", is("Lawson"))
			.body("data[0].avatar", is("https://reqres.in/img/faces/7-image.jpg"))
		;
	}

	@Test
	public void getSingleUserNotFound() {
		given()
		.when()
			.get("/users/23")
		.then()
			.statusCode(404)
		;
	}
	

}
