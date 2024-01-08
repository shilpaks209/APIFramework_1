package steps;

import java.io.File;

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
import pojo.ListUsers;
import hooks.CustomScenarioHooks;

public class GetListOfUsers {
	String apiUrl = "/api/users?page=2";
	APIHelper apiHelper = new APIHelper();
	ListUsers listUsers = null;
	APIRequest apiRequest;
	Response response;

	// Scenario 1
	@Given("the API endpoint is {string}")
	public void the_api_endpoint_is(String string) {
		// Write code here that turns the phrase above into concrete actions
		this.apiUrl = string;
	}

	@When("admin send a GET request")
	public void i_send_a_get_request() {
		apiRequest = new APIRequest("get", apiUrl);
		response = apiHelper.hitAPI(apiRequest);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body());
		System.out.println(response.asPrettyString());

	}

	@Then("the response code should be {int}")
	public void the_response_code_should_be(Integer int1) {
		Assert.assertEquals(int1, response.getStatusCode());

	}

	@Then("the response should contain the user details like name,email id etc.")
	public void the_response_should_contain_the_user_details_like_name_email_id_etc() {
		// Write code here that turns the phrase above into concrete actions

		ObjectMapper om = new ObjectMapper();
		try {
			listUsers = om.readValue(response.asString(), ListUsers.class);
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(2, listUsers.getPage());
		Assert.assertEquals("https://reqres.in/#support-heading", listUsers.getSupport().url);
		if (listUsers.data.get(1).getId() == 8 && listUsers.data.get(1).getFirst_name() == "Lindsay") {
			Assert.assertEquals("lindsay.ferguson@reqres.in", (listUsers.data.get(1).getEmail()));
		}

	}

	/// scenario 2
	@Given("the API endpoint and request type in a json file")
	public void the_api_endpoint_and_request_type_in_a_json_file() {
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(
				"C:\\Users\\ACER\\eclipse-workspace\\APIAutomationFramework_1\\src\\main\\resources\\api\\ListUsers.json");
		apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());

	}

	@When("admin send the request")
	public void SendRequestUsingJsonFile() {
		response = apiHelper.hitAPI(apiRequest);
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("verify the reponse status code")
	public void verifyResponseCode() {
		Assert.assertEquals(200, response.getStatusCode());

	}

	@Then("verify the reponse body")
	public void verifyDetails() {
		// Write code here that turns the phrase above into concrete actions

		ObjectMapper om = new ObjectMapper();
		try {
			listUsers = om.readValue(response.asString(), ListUsers.class);
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(2, listUsers.getPage());
		Assert.assertEquals("https://reqres.in/#support-heading", listUsers.getSupport().url);
		if (listUsers.data.get(1).getId() == 8 && listUsers.data.get(1).getFirst_name() == "Lindsay") {
			Assert.assertEquals("lindsay.ferguson@reqres.in", (listUsers.data.get(1).getEmail()));
		}

	}

	@Given("A json file having request type and api path")
	public void a_json_file_having_request_type_and_api_path() {
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj
				.readFromJsonFile(System.getProperty("user.dir") + "\\src\\main\\resources\\api\\ListUsers.json");
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		response = apiHelper.hitAPI(apiRequest);
	}

	@When("admin hit the api")
	public void i_hit_the_api() {
		
		Assert.assertEquals(200, response.getStatusCode());
		
	}

	@Then("verify the responde status code and body")
	public void verify_the_responde_status_code_and_body() {
		
		ListUsers listUsers = null;
		ObjectMapper om = new ObjectMapper();
		try {
			listUsers = om.readValue(response.asString(), ListUsers.class);

		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(2, listUsers.getPage());
		Assert.assertEquals("https://reqres.in/#support-heading", listUsers.getSupport().url);
		if (listUsers.data.get(1).getId() == 8 && listUsers.data.get(1).getFirst_name() == "Lindsay") {
			Assert.assertEquals("lindsay.ferguson@reqres.in", (listUsers.data.get(1).getEmail()));
		}
	}

}
