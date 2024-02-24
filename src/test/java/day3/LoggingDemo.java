package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class LoggingDemo {
	@Test
	void testlogging() {
		given()
		
		.when()
		.get("\r\n"
				+ "https://reqres.in/api/users?page=2")
		.then()
		.log().cookies()
		;
	}

}
