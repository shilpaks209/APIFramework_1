package testcases;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.restassured.response.Response;

public class DeleteTestCase extends BaseTester{
	APIHelper apiHelper = new APIHelper();
	//testcase12
	@Test(enabled = true)
	public void testDeleteUser() {
	
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(ip+File.separator +"DeleteUser.json");
		System.out.println(jsonObject.get("requestType"));
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		
		Response response = apiHelper.hitAPI(apiRequest);
		System.out.println(response.getStatusCode());
		Assert.assertEquals(204, response.getStatusCode());
		
		
	
	}	
}
