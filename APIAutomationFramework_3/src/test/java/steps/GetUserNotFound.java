package steps;

import org.json.simple.JSONObject;
import org.testng.Assert;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class GetUserNotFound {
	Response response;
	 APIHelper apiHelper = new APIHelper();
	 String apiEndPoint;
	 @Given("the api end point and request type using json file")
	 public void getApi()
	 {
		 JsonProcessor obj = new JsonProcessor();
			JSONObject jsonObject = obj.readFromJsonFile(
					"C:\\Users\\ACER\\git\\ApiFramework\\ApiAutomationFramework1\\src\\main\\resources\\api\\SingleUserNotFound.json");
			System.out.println(jsonObject.get("requestType"));
			APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
					jsonObject.get("requestApiPath").toString());
			response = apiHelper.hitAPI(apiRequest);
			
	 }
	
	@Then("validate the api response")
	public void validateApi() {
		Assert.assertEquals(404, response.getStatusCode());
		
		Assert.assertEquals("{}", response.body().asString());
		
		
	}
	
	

}
