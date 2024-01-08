package steps;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.Assert;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class DeleteUser {
	Response response;
	APIHelper apiHelper = new APIHelper();
	@When("admin send a DELETE request to {string}")
	public void sendDeleteRequest(String endpoint) {
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile("C:/Users/ACER/git/ApiFramework/APIAutomationFramework_1/src/main/resources/api/DeleteUser.json");
		System.out.println(jsonObject.get("requestType"));
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		
		response = apiHelper.hitAPI(apiRequest);
		}

		@Then("the response status code should be {int}")
		public void validate_status_code(Integer expectedStatusCode) {
			Assert.assertEquals(204, response.getStatusCode());
		}

}
