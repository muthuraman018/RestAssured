package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CookiesDemo {
	@Test
	void testCookies() {
		
		given()
	
		.when()
		.get("\r\n"
				+ "https://www.google.com/")
		
		.then()
		.cookie("AEC","Ackid1SRcfH6z4UmuCG7MYp15-wSR0XeCtqxO8plYomz1SGxGdl0eNvDnA")
		.log().all()
		;
	}
	
	@Test
	void getCookies() {
		
		Response res= given()
	
		.when()
		.get("\r\n"
				+ "https://www.google.com/");
		
		//get single cookie info
//		String cookie_value = res.getCookie("AEC");
//		System.out.println("The value of the cookie is - "+ cookie_value);
		
		
		//get all cookkie info
		Map<String,String> cookies_values = res.getCookies();
		System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet()) {
			String cookie_value = res.getCookie(k);
			System.out.println(k+"     "+cookie_value);
		}
		
		
	}
	
	

}
