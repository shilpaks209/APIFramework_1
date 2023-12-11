package assignmentTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import assisgnments.Address;
import core.JsonProcessor;
import core.RandomData;
import pojo.ListUsers;


public class JsonProcessorTester {
	JSONObject obj = new JSONObject();
	JSONObject address=new JSONObject();
	
  @Test(enabled=true)
  public void f() {
	 
		
		//json object
		address.put("houseNumber",23);
		address.put("streetName","Hartley Road");
		address.put("county","Luton");
		address.put("zipcode","LU2OHX");
		obj.put("address", address);
		
		String actualJsonString = JsonProcessor.jsonObjectToString(obj);
		System.out.println(actualJsonString);
		ObjectMapper om = new ObjectMapper();
		 Address address=null;
		  try {
			  address = om.readValue(actualJsonString.toString(),Address.class);
			  System.out.print(address);
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		//String expectedJsonString="{"address":{"zipcode":"LU2OHX","streetName":"Hartley Road","houseNumber":23,"county":"Luton"},"name":"shilpa","Height":153.0,"isEmployed":true,"age":29}";
		//Assert.assertEquals(actualJsonString, expectedJsonString);
	   
  }
  @Test(enabled=true)
  public void convertStringToJsonObj() {


	  	obj.put("name", "shilpa");
		obj.put("age", 29);
		obj.put("isEmployed",true);
		obj.put("Height", 153.0f);
	
		String jsonString=JsonProcessor.jsonObjectToString(obj);

		JSONObject actualObj= JsonProcessor.stringToJsonObject(jsonString);

		System.out.println(actualObj.getClass());
		Assert.assertEquals(actualObj, obj);

  }
  @Test(enabled=false)
  public void verifyRandomData() {
	  RandomData email=new RandomData();
	  email.getRandomAddress();
	    
  }
  
  }

