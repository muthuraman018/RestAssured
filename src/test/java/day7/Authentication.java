package day7;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Authentication {
//@Test(priority =1)	
 void testBasicAuthentication() {
	 
	given().auth().basic("postman", "password")
	
	.when()
	.get("https://postman-echo.com/basic-auth")
	
	.then().statusCode(200).body("authenticated",equalTo(true)).log().all();
 }
//@Test(priority=2)
void testDigestAuthentication() {
	 
	given().auth().digest("postman", "password")
	
	.when()
	.get("https://postman-echo.com/basic-auth")
	
	.then().statusCode(200).body("authenticated",equalTo(true)).log().all();
}

//@Test(priority=3)
void testPreemptiveAuthentication() {
	 
	given().auth().preemptive().basic("postman", "password")
	
	.when()
	.get("https://postman-echo.com/basic-auth")
	
	.then().statusCode(200).body("authenticated",equalTo(true)).log().all();
}

//@Test(priority =4)
 void testBearerToken() {
	 String BearerToken = "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";
	 given().header("Authorization","Bearer "+BearerToken)
	 
	 .when().get("https://github.com/repo")
	 
	 .then().statusCode(200).log().all();
	 
	 
 }
@Test
 void test_OAuth1() {
	 given().auth().oauth("consumer key", "consumer secret", "access token", "token secreare")
	 .when()
.then().statusCode(DEFAULT_PORT).log().all();
	 }
 
 void testOAuth2() {
	 given().auth().oauth2("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")
	 .when().get("https://github.com/repo")
.then().statusCode(200).log().all();
	 }
 
 @Test
 void testAPIkey() {
//	 key name  qury parameter
	 given().queryParam("keyname", "keyvalue").when().get("url").then().statusCode(200).log().all();
	 
	 
	 
 }
 
 }

