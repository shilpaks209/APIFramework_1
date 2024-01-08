package steps;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.CreateUser;
import pojo.ListUsers;

//get, put,patch
//validate response body by converting to body

public class CreateUserSteps {
	 Response response;
	 APIHelper apiHelper = new APIHelper();
	 String apiEndPoint;
	 @Given("Given the API endpoint is:")
	 public void apiEndPoint(String apiEndPoint)
	 {
		this.apiEndPoint=apiEndPoint; 
	 }
	
	 @When(" Admin user provides valid user details")
	    public void add_user() {
	        
		 HashMap<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type","application/json");
		
		 JSONObject requestObject = new JSONObject();
		 requestObject.put("name", "morpheus");
			requestObject.put("job", "leader");
		 
		 APIRequest apiRequestPost = new APIRequest("post",apiEndPoint,headers,requestObject);
		 
		 apiHelper = new APIHelper();
		 response = apiHelper.hitAPI(apiRequestPost);
		 
	    }
	    @Then("User should get created")
	    public void user_is_created() {
	    	 Assert.assertEquals(201, response.getStatusCode());
	    	 CreateUser createUser = null;
				ObjectMapper om = new ObjectMapper();
				try {
					createUser = om.readValue(response.asString(), CreateUser.class);
				} catch (JsonMappingException e) {

					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(createUser.getId());
				System.out.println(createUser.getCreatedAt());
				
	    
	    
	    }
	    @Given("the api end point,request body, request type is passed from json file")
		 public void readDataFromJson()
		 {
	    	
			JsonProcessor obj = new JsonProcessor();
			JSONObject jsonObject = obj.readFromJsonFile(
					"C:\\Users\\ACER\\git\\ApiFramework\\ApiAutomationFramework1\\src\\main\\resources\\api\\SingleUser.json");
			System.out.println(jsonObject.get("requestType"));
			APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
					jsonObject.get("requestApiPath").toString());
			response = apiHelper.hitAPI(apiRequest);
		 }
	    @When("Admin user submit valid details ")
	    public void sendApi() {
			
	    	 CreateUser createUser = null;
			
			ObjectMapper om = new ObjectMapper();
			try {
				createUser = om.readValue(response.asString(), CreateUser.class);
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
			
     @Then("the user should be created")
     public void userCreated() {
    	 
    	 Assert.assertEquals(201, response.getStatusCode());
     }
     
}
