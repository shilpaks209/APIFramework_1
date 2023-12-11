package testcase2;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.restassured.response.Response;
import pojo.ListUsers;

public class TestCase1 extends BaseTester {
	APIHelper apiHelper = new APIHelper();
  @Test(enabled = true)
	public void testGetListUsers() {
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(ip+File.separator +"ListUsers.json");
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		Response response = apiHelper.hitAPI(apiRequest);
		//JSONObject jsonObj= JsonProcessor.stringToJsonObject(response.asString());
		Assert.assertEquals(200, response.getStatusCode());
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
		
		Assert.assertEquals(2,listUsers.getPage());
		Assert.assertEquals("https://reqres.in/#support-heading", listUsers.getSupport().url);
		if(listUsers.data.get(1).getId()==8 && listUsers.data.get(1).getFirst_name()=="Lindsay")
				{
			Assert.assertEquals("lindsay.ferguson@reqres.in",(listUsers.data.get(1).getEmail()));
		}		
	}
  @Test(enabled = false)
	public void testGetSingleUsersNotFound() {
	
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(ip+File.separator +"SingleUserNotFound.json");
		System.out.println(jsonObject.get("requestType"));
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		Response response = apiHelper.hitAPI(apiRequest);
		Assert.assertEquals(404, response.getStatusCode());
		
		Assert.assertEquals("{}", response.body().asString());
	
	}
  
  @Test(enabled = true)
	public void testGetListResourses() {
	
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(ip+File.separator +"ListResourses.json");
		System.out.println(jsonObject.get("requestType"));
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		Response response = apiHelper.hitAPI(apiRequest);
		Assert.assertEquals(200, response.getStatusCode());
	}
  
  
		
	}

