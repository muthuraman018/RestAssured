package day8;
import static io.restassured.RestAssured.*;
public class CreateUSer {
	
	void creatuser() {
		Pojo_class jc = new Pojo_class();
		jc.setName("name");
		jc.setJob("occupation");
		
		given().header(DEFAULT_BODY_ROOT_PATH, jc, null)
		
		.when()
		
		.then();
	}
	

}
