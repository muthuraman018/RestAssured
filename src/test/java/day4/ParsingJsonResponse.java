package day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ParsingJsonResponse {
	
	boolean status = false;
//    @Test
	void testJsonResponse1() {
		
    	//Approach one
    	
//    	given()
//    	.contentType("Content-Type.JSON")
//    	
//    	.when()
//    	.get("https://reqres.in/api/users?page=2")
//    	.then()
//    	.body("data[5].last_name",equalTo("Howell"))
//    	.header("Content-Type", "application/json; charset=utf-8")
//    	;
    	
    	
   
    	
    
    	
	}
//	@Test
	void testJsonResponse2() {
	 	//Approach two
   	 Response res = given()
   	.contentType("Content-Type.JSON")
   	.when()
   	.get("https://reqres.in/api/users?page=2");
   	 
   	 Assert.assertEquals(res.getStatusCode(), 200);
   	 Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
   	String bookname = res.jsonPath().get("support.url").toString();
   	Assert.assertEquals(bookname, "https://reqres.in/#support-heading");
   	
	}
	
	@Test
	void testJsonResponse3() {
	 	//Approach two
   	 Response res = given()
   	.contentType(ContentType.JSON)
   	.when()
   	.get("https://reqres.in/api/users?page=2");
   	 
   //JSONObject class
   	JSONObject jo = new JSONObject(res.asString()); // convert response to json object type
   	for(int i=0;i<jo.getJSONArray("data").length();i++)
   	{
   String bookTitle = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
   if(bookTitle.equals("Michael")) {
	   status = true;
	   break;
   }
   	}
   	Assert.assertEquals(status, true);
   	
   	//validate id

   	for(int i=0;i<jo.getJSONArray("data").length();i++)
   	{
   String id = jo.getJSONArray("data").getJSONObject(i).get("id").toString();
   if(id.equals("7")) {
	   status = true;
	   break;
   }
   	}
   	Assert.assertEquals(status, true);
	}
}
