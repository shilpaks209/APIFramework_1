package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {
	
	public Response hitAPI(APIRequest apiRequest) {
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile("C:/Users/ACER/git/ApiFramework/APIAutomationFramework_1/src/test/resources/config.json");
		
	
		RestAssured.baseURI = (String) jsonObject.get("baseURI");
		RequestSpecification request = RestAssured.given();
		Header header=null;
		if(apiRequest.getHeaders()!=null) {
		header=new Header("Content-Type",apiRequest.getHeaders().get("Content-Type"));
	
		}
		
		Response response = null;
		if (apiRequest.getRequestType().equalsIgnoreCase("get")) {
		response = request.get(apiRequest.getApiPath());
		

		}

		else if (apiRequest.getRequestType().equalsIgnoreCase("post")) {
			request.body(apiRequest.getRequestBody());
			 response = request.post(apiRequest.getApiPath());
			
			
		}
		else if (apiRequest.getRequestType().equalsIgnoreCase("delete")) {
			response = request.delete(apiRequest.getApiPath());
			
		}
		else if (apiRequest.getRequestType().equalsIgnoreCase("put")) {
			response = request.put(apiRequest.getApiPath());
		}
		else if (apiRequest.getRequestType().equalsIgnoreCase("patch")) {
			response = request.patch(apiRequest.getApiPath());
		}
		
		return response;
	}
}
