package omdbApiTest;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import utils.EnvProperties;

public class BaseTest {

	@BeforeClass
	public void init()
	{
		RestAssured.baseURI=EnvProperties.getProperties().get("baseUrl");
	}
	
	protected <T> T sendRequest(Map<String,String> params, Class<T> responseClass){
		return  given()
					 .queryParams(params)
				   .when()
				   	 .get()
				   .then()
				   	  .statusCode(200)
				   	  .extract().response().as(responseClass);
	}
}
