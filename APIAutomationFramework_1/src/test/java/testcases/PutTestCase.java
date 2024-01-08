package testcases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;



import core.APIHelper;
import core.APIRequest;
import io.restassured.response.Response;


public class PutTestCase {
	APIHelper apiHelper = new APIHelper();
	@Test(enabled = true)
	
	 public void testUpdateUserDetails() {
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

	/*UpdateUserDetails updateUserDetails = null;
	ObjectMapper om = new ObjectMapper();
	try {
		updateUserDetails = om.readValue(response.asString(), UpdateUserDetails.class);
	} catch (JsonMappingException e) {

		e.printStackTrace();
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	
}

}
