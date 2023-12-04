package testCases;


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

public class Test1 {
	APIHelper apiHelper=new APIHelper();
  @Test (enabled=false)
  public void testGet() {
	 
	  APIRequest apiRequest=new APIRequest("C:\\Users\\ACER\\git\\ApiFramework\\ApiAutomationFramework1\\src\\main\\resources\\api\\api1.json");
	Response response=apiHelper.hitAPI(apiRequest);
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getStatusLine());
	  System.out.println(response.body());
	  System.out.println(response.asPrettyString());
	  //JSONObject obj=  JsonProcessor.stringToJsonObject(response.asString());
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
	  System.out.println(listUsers.getPage());
  }
  @Test (enabled=true)
  public void testPost2() {
	  
	  HashMap<String,String> headers=new HashMap<String,String>();
	  headers.put("Content-Type", "text/plain");
	  JSONObject requestObject=new JSONObject();
	  requestObject.put("name","morpheus");
	  requestObject.put("job","leader");
	  APIRequest apiRequestPost=new APIRequest("post","/api/users",headers,requestObject);
	  Response response=apiHelper.hitAPI(apiRequestPost);
	  Assert.assertEquals(201,response.getStatusCode());
	  
	 
  }
  
  @Test (enabled=false)
  public void testGetSingleUser() {
	 
	  /*APIRequest apiRequest=new APIRequest("get","/api/users/2");
	Response response=apiHelper.hitAPI(apiRequest);
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getStatusLine());
	  System.out.println(response.body());
	  System.out.println(response.asPrettyString());*/
	  JsonProcessor obj=new JsonProcessor();
	  JSONObject jsonObject=obj.readFromJsonFile("C:\\Users\\ACER\\git\\ApiFramework\\ApiAutomationFramework1\\src\\main\\resources\\api\\api.json");
	 
	  System.out.println(jsonObject.get("requestType"));
	  
  }
  @Test (enabled=true)
  public void testPost() {
	  
	  /*HashMap<String,String> headers=new HashMap<String,String>();
	  headers.put("Content-Type", "text/plain");
	  JSONObject requestObject=new JSONObject();
	  requestObject.put("name","morpheus");
	  requestObject.put("job","leader");*/
	  APIRequest apiRequestPost=new APIRequest("C:\\Users\\ACER\\git\\ApiFramework\\ApiAutomationFramework1\\src\\main\\resources\\api\\api3.json");
	  Response response=apiHelper.hitAPI(apiRequestPost);
	  System.out.println(response.getStatusCode());
	  Assert.assertEquals(201,response.getStatusCode());
	  
	 
  }
  
}
