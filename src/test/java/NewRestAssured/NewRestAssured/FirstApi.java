package NewRestAssured.NewRestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*; 

public class FirstApi{
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/api/users/2";
	String ab	=given().when().log().all().
		get().then().log().all().
		assertThat().extract().response().asString();
		JsonPath js=new JsonPath(ab);
		int kbc=js.getInt("data.id");
		System.out.println("value of id" +kbc);
	}
}