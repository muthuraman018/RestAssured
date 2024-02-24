package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {

	//@Test
	void testXMLResponse1() {
		//Approach one
		
		given().
		
		when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[1].name", equalTo("AS"))
		;
		
	}
	//approach two
	@Test
	void testXMLResponse2() {
		
 Response res = given().
		
		when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
// Assert.assertEquals(res.getStatusCode(),200);
//Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
//String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
//Assert.assertEquals(pageNo, "1");
//String travellerName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
//Assert.assertEquals(travellerName, "AS");	
 XmlPath xmlobj = new XmlPath(res.asString());
 List<String> travellers= xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
Assert.assertEquals(travellers.size(), 10) ;
//verify traveller name present in response

boolean status= false;
List<String> travellers_name= xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
for(String traveller_name:travellers_name) {
if (traveller_name.equals("AS")) {
	status = true;
	break;
}


}
Assert.assertEquals(status, true);

	}
}
