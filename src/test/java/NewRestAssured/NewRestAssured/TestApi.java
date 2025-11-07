package NewRestAssured.NewRestAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import NewRestAssured.NewRestAssured.Pojo.Pojo.ChildMainPojo;
import NewRestAssured.NewRestAssured.Pojo.Pojo.MainDs;
import NewRestAssured.NewRestAssured.Pojo.Pojo.MainPojo;



public class TestApi {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		RequestSpecification req=new RequestSpecBuilder().
				setContentType("application/json").build();
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).build();
		
		MainPojo mp=new MainPojo();
		mp.setAccuracy(50);
		mp.setLanguage("French-IN");
		ChildMainPojo pst=new ChildMainPojo();
		pst.setLat(-38.383494);
		pst.setLng(33.427362);
		mp.setLocation(pst);
		mp.setName("Frontline house");
		mp.setPhone_number("(+91) 983 893 3937");
		ArrayList<String>st=new ArrayList<String>();
		st.add("shoe park");
		st.add("shop");
		mp.setTypes(st);
		mp.setWebsite("http://google.com");
		
		
		MainDs abc=given().spec(req).body(mp).queryParam("key", "qaclick123").log().all().when().post("/maps/api/place/add/json").
		then().log().all().spec(res).assertThat().extract().response().as(MainDs.class);
		/*
		 * JsonPath js=new JsonPath(abc); System.out.println( js.getString("status"));
		 * System.out.println( js.getString("place_id")); System.out.println(
		 * js.getString("scope")); System.out.println( js.getString("reference"));
		 * System.out.println( js.getString("id"));
		 */
	System.out.println(	abc.getId());
	System.out.println(	abc.getPlace_id());
	System.out.println(	abc.getReference());
	System.out.println(	abc.getScope());
	System.out.println(	abc.getStatus());

	}

}
