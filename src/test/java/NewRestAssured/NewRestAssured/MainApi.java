package NewRestAssured.NewRestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import NewRestAssured.NewRestAssured.Pojo.ChildPojo;
import NewRestAssured.NewRestAssured.Pojo.MainDes;
import NewRestAssured.NewRestAssured.Pojo.MainPojo; 

public class MainApi{
	public static void main(String[] args) {
	RestAssured.baseURI="https://rahulshettyacademy.com";	
	RequestSpecification req=new RequestSpecBuilder().setContentType("application/json").build();
	ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).build();
	MainPojo mp=new MainPojo();
	mp.setAccuracy(50);
	mp.setLanguage("French-IN");
	
	ChildPojo cp=new ChildPojo();
	cp.setLat(-38.383494);
	cp.setLng(33.427362);
	mp.setLocation(cp);
	mp.setName("Frontline house");
	mp.setPhone_number("(+91) 983 893 3937");
	ArrayList<String> listchar=new ArrayList<String>();
	listchar.add("shoe park");
	listchar.add("shop");
	mp.setTypes(listchar);
	mp.setWebsite("http://google.com");
	
	MainDes redes=given().spec(req).body(mp).queryParam("key", "qaclick123").log().all().
	when().post("/maps/api/place/add/json"). then().spec(res).log().all().assertThat()
	.extract().response().as(MainDes.class);
System.out.println(redes.getId());
System.out.println(redes.getPlace_id());
System.out.println(redes.getReference());
System.out.println(redes.getScope());
System.out.println(redes.getStatus());

  Headers contentType = given().spec(req).body(mp).queryParam("key",
  "qaclick123") .when().post("/maps/api/place/add/json") .getHeaders();
 String kbc= contentType.getValue("Access-Control-Max-Age");
 System.out.println(kbc);
  for(Header head:contentType) { 
	  System.out.println("Content-Type Header: " +head.getValue());
 
		/*
		 * String contentTypeo = given().spec(req).body(mp).queryParam("key",
		 * "qaclick123") .when().post("/maps/api/place/add/json")
		 * .getHeader("contentTypeo");
		 * 
		 * System.out.println("Content-Type Header: " + contentTypeo);
		 * assertEquals("application/json;charset=UTF-8", contentTypeo);
		 */
}
	
	}
}

