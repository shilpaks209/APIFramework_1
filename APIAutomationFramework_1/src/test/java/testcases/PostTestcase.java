package testcases;

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
import io.restassured.response.Response;
import pojo.CreateUser;

public class PostTestcase extends BaseTester  {
	APIHelper apiHelper = new APIHelper();
	//testcase7
	 @Test(enabled = false)
		
	 public void testCreateUser() {

		 HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "text/plain");
			JSONObject requestObject = new JSONObject();
			requestObject.put("name", "morpheus");
			requestObject.put("job", "leader");
			APIRequest apiRequestPost = new APIRequest("post", "/api/users", headers, requestObject);
			Response response = apiHelper.hitAPI(apiRequestPost);
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

	 
		//testcase8 
	 @Test(enabled = true)
		
	 public void RegisterSucessfull1() {

		 HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "text/plain");
			JSONObject requestObject = new JSONObject();
			requestObject.put("email", "eve.holt@reqres.in");
			requestObject.put("password", "pistol");
			APIRequest apiRequestPost = new APIRequest("post", "/api/users", headers, requestObject);
			Response response = apiHelper.hitAPI(apiRequestPost);
			Assert.assertEquals(201, response.getStatusCode());
			
			 System.out.println(response.asPrettyString());
			 Assert.assertEquals("HTTP/1.1 201 Created",response.getStatusLine());
			 
			 
			
		}
	 
	 
	 
		//testcase9
	 @Test(enabled = false)
		public void testRegisterSucessfull2() {
		 HashMap<String,String> metaInfo=new HashMap<String,String>();
		 metaInfo.put("email", "shilpaks209@gmail.com");
		 metaInfo.put("password", "shilpa123");
		 APIRequest apiRequestPost = new APIRequest(ip+File.separator +"RegisterSuccessfull1.json",metaInfo);
			Response response = apiHelper.hitAPI(apiRequestPost);
			System.out.println(response.getStatusCode());
			Assert.assertEquals(400, response.getStatusCode());
			System.out.println(response.asPrettyString());
	 }
		//testcase10
	 @Test(enabled = false)
		public void testRegisterUnsucessfull() {
		 HashMap<String,String>header=new HashMap<String,String>();
		 header.put("Content-Type","text/plain");
		 
		 APIRequest apiRequestPost = new APIRequest(ip+File.separator+"RegisterUnsucessfull.json",header);
			Response response = apiHelper.hitAPI(apiRequestPost);
			
			Assert.assertEquals(400, response.getStatusCode());
			
		    System.out.println(response.asPrettyString());
			System.out.println(response.getStatusLine());
			
			
	 } 

}
