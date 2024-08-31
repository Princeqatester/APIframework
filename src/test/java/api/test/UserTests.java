package api.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StageEndpoints;
import api.payload.Stage;
import io.restassured.response.Response;
import jdk.internal.org.jline.utils.Log;

public class UserTests 
{
Faker faker;
Stage stagepayload;
public Logger logger;

@BeforeClass
public void setupData()
{
	faker=new Faker();
	stagepayload=new Stage();
	stagepayload.setName(faker.name().firstName());
	
	logger=LogManager.getLogger(this.getClass());
	Level log=logger.getLevel();
	System.out.println(log);
}
@Test(priority = 1)
public void testStagepost(ITestContext context)
{
	logger.info("*************Creating the stage**************");
	Response rs=StageEndpoints.createStage(stagepayload,context);
	rs.then().log().all();
	AssertJUnit.assertEquals(rs.getStatusCode(), 200);
	logger.info("************Stage created successfully*********");
}
@Test(priority = 3)
public void testStagedelete(ITestContext context)
{
	logger.info("*************Deleting the stage**************");
	Response rs=StageEndpoints.deleteStage(context);
	rs.then().log().all();
	AssertJUnit.assertEquals(rs.getStatusCode(), 200);
	logger.info("*************Stage deleted successfully**************");
}
@Test(priority = 2)
public void testStageupdate(ITestContext context)
{
	logger.info("*************Updating the stage**************");
	stagepayload.setName(faker.name().firstName());
	Response rs=StageEndpoints.updateStage(context, stagepayload);
	rs.then().log().all();
	logger.info("*************Stage updated successfully**************");
	
	
}
@Test(priority = 4)
public void testStageget()
{
	logger.info("*************Fetching the stages**************");
	Response rs=StageEndpoints.readStage();
	rs.then().log().all();
	AssertJUnit.assertEquals(rs.statusCode(), 200);
	logger.info("*************Stage fetched successfully**************");
	
}
}
