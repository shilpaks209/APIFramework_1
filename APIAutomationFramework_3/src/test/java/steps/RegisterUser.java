package steps;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class RegisterUser {
	 Response response;
	 APIHelper apiHelper = new APIHelper();
	 String apiEndPoint;
	 String requestBody;
	 @Given("the  endpoint of the api is {string}")
	 public void the_endpoint_of_the_api_is(String apiEndPoint) {
	     
		 this.apiEndPoint=apiEndPoint;
	 }
	

    @Given("the request body is:")
    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    @When("Admin send a the api  request for register user")
    public void sendPostRequest() {
    	 HashMap<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type","application/json");
		 JSONObject requestObject= JsonProcessor.stringToJsonObject(requestBody);
		 System.out.println("111111111"+requestObject);
         APIRequest apiRequestPost = new APIRequest("post",apiEndPoint,headers,requestObject);
		 
		 apiHelper = new APIHelper();
		 response = apiHelper.hitAPI(apiRequestPost);
		
    }
    @Then("verify the response status code should be {int}")
    public void verify_the_response_status_code_should_be(Integer int1) {
    	Assert.assertEquals(400, response.getStatusCode());
    }

   
}
