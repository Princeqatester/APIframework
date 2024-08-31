package api.endpoints;
import static io.restassured.RestAssured.*;

import java.lang.reflect.Array;
import java.util.HashMap;

import org.testng.ITestContext;

import api.payload.Stage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StageEndpoints 
{
	public static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjU3M2NkYjY4YTYwMTgxN2ZmMTFmNDUiLCJlbWFpbCI6ImFkbWluQGFkYW14LmNvbSIsImZpcnN0TmFtZSI6IkFkYW14IiwibGFzdE5hbWUiOiJBZG1pbiIsImFjdGl2ZSI6dHJ1ZSwiY3JlYXRlZEF0IjoiMjAyNC0wNS0yOVQxNDozNDowMy4yNTBaIiwidXBkYXRlZEF0IjoiMjAyNC0wNS0yOVQxNDozNDowMy4yNTBaIiwiX192IjowLCJpYXQiOjE3MjMyNjYxMDJ9.T611HjLr3Y_KZIElJQpCViS1Zqw8pVbhmoszFkZWNmM";
public static Response createStage(Stage payload, ITestContext context)
{
	Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Authorization","Bearer "+token).body(payload).when().post(Routes.post_stage);
	String id=response.jsonPath().get("data._id");
	context.setAttribute("stageid", id);
	System.out.println(id);
	return response;
}
public static Response readStage()
{
	Response response=given().header("Authorization","Bearer "+token).when().get(Routes.get_stage);
	return response;
}
public static Response updateStage(ITestContext context,Stage payload)
{
	String id=(String) context.getAttribute("stageid");
	System.out.println(id);
	String url = Routes.put_stage.replace("{stageid}", id);
	Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Authorization","Bearer "+token).body(payload).when().put(url);
	return response;
}
public static Response deleteStage(ITestContext context)
{
	String id=(String)context.getAttribute("stageid");
	System.out.println("Extracted id ater hitting post request"+id);
	String[]deleteid= {id};
	HashMap hash=new HashMap();
	hash.put("ids", deleteid);
	Response response=given().contentType(ContentType.JSON).header("Authorization","Bearer "+token).body(hash).when().delete(Routes.del_stage);
	return response;
}
/*
 *public static Response readStage(String id)
{
	Response response=given().header("Authorization","Bearer "+token).when().get(Routes.get_stage);
	return response;
}
 */
public static Response Stagecreate(Stage payload)
{
	Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Authorization","Bearer "+token).body(payload).when().post(Routes.post_stage);
	System.out.println(response);
	return response;
}
}
