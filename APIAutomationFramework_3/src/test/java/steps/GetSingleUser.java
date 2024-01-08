package steps;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.APIHelper;
import core.APIRequest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.SingleUser;

public class GetSingleUser {
	Response response;
	APIRequest apiRequestGet;

	@Given("request type and api path in a json file")
	public void getSingleUserDetail() {
		apiRequestGet = new APIRequest(System.getProperty("user.dir") + "\\src\\main\\resources\\api\\SingleUser.json");
		

	}

	@When("the admin sends a GET request")
	public void sendApi() {
		APIHelper apiHelper = new APIHelper();
		response = apiHelper.hitAPI(apiRequestGet);
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("verify the respondsbody and status code")
	public void verifyResponseCodeAndBody(){
Assert.assertEquals(200, response.getStatusCode());
		
		SingleUser singleUser = null;
		ObjectMapper om = new ObjectMapper();
		try {
			singleUser = om.readValue(response.asString(), SingleUser.class);
				
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals("https://reqres.in/#support-heading", singleUser.getSupport().url);
		Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", singleUser.getSupport().getText());
		if(singleUser.data.getId()==2 && singleUser.data.getFirst_name()=="Janet")
				{
			Assert.assertEquals("janet.weaver@reqres.in",(singleUser.data.getEmail()));
		}
		
		
	}
	
	
}
