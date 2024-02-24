package day2;

//using hashmap
//using org.json
//using pojo
//using external json file
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import  org.testng.annotations.Test;

public class WaysToCreatePostRequestBody {
	int id;
//@Test(priority =1)	
void testPostUsingHashmap() {
	HashMap data = new HashMap();
	data.put("name","morpheus");
	data.put("job", "leader");
	
	id = given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://reqres.in/api/users")
	.jsonPath().getInt("id")
	
	;
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://reqres.in/api/users")
	
	
	.then()
	.statusCode(201)
	.body("name",equalTo("morpheus"))
	.body("job",equalTo("leader"))
	.header("Content-Type","application/json; charset=utf-8")
	.log().all()
	;
	
	
}
//@Test
void testDelete() {
	
	given()
	
	.when()
	.delete("https://reqres.in/api/users/"+id)
	
	.then()
	.statusCode(204);
	
}

//using org.jsonLibrary
//@Test(priority=1)
void testPostUsingOrgJson() {
	JSONObject data = new JSONObject();
	data.put("name", "morpheus");
	data.put("job", "leader");
	
	given()
	.contentType("application/json")
	.body(data.toString())
	
	.when()
	.post("https://reqres.in/api/users")
	
	
	.then()
	.statusCode(201)
	.body("name",equalTo("morpheus"))
	.body("job",equalTo("leader"))
	.header("Content-Type","application/json; charset=utf-8")
	.log().all()
	;
	
	
}
//@Test(priority=2)
void testDeleteOrgJson() {
	
	given()
	
	.when()
	.delete("https://reqres.in/api/users/"+id)
	
	.then()
	.statusCode(204);
	
}


//using POJO class
@Test(priority=1)
void testPostUsingPojo() {
	Pojo_postRequest data = new Pojo_postRequest();
	data.setName("morpheus");
	data.setJob("leader");
	
	
	id = given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id")
			
			;
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://reqres.in/api/users")
	
	
	.then()
	.statusCode(201)
	.body("name",equalTo("morpheus"))
	.body("job",equalTo("leader"))
	.header("Content-Type","application/json; charset=utf-8")
	.log().all()
	;
	
	
}
@Test(priority=2)
void testDeletePojo() {
	
	given()
	
	.when()
	.delete("https://reqres.in/api/users/"+id)
	
	.then()
	.statusCode(204);
	
}

}
