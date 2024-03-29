package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class PathAndQueryParams {
	@Test
	void testQueryAndPathParameter() {
		
		
		given()
		
		.pathParam("mypath", "users") //path parameter
		.queryParam("page", 2)// query params
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
