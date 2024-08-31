package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.StageEndpoints;
import api.payload.Stage;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Datadriventestcase 
{
@Test(dataProvider = "Data", dataProviderClass = DataProviders.class)
public void poststage(String name)
{
	Stage payload=new Stage();
	payload.setName(name);
	Response rs=StageEndpoints.Stagecreate(payload);
	System.out.println(rs.asString());
	AssertJUnit.assertEquals(rs.getStatusCode(), 200);
}
}
