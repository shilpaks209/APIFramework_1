package testcases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.APIHelper;
import core.APIRequest;
import io.restassured.response.Response;

public class PatchTestCase {
	APIHelper apiHelper = new APIHelper();
	//testcase11
	@Test(enabled = false)
	
	 public void testPartiallyUpdateUserDetails() {
		
	HashMap<String, String> headers = new HashMap<String, String>();
	headers.put("Content-Type", "text/plain");
	JSONObject requestObject = new JSONObject();
	requestObject.put("name","morpheus");
	requestObject.put("job","zion resident");
	APIRequest apiRequestPost = new APIRequest("post","/api/users/2",headers,requestObject);
	Response response = apiHelper.hitAPI(apiRequestPost);
	Assert.assertEquals(201, response.getStatusCode());
	 Assert.assertEquals("HTTP/1.1 201 Created",response.getStatusLine());

	 System.out.println(response.asPrettyString());
		
		
	}
	
	
	

}
