package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonProcessor {
	public static String jsonObjectToString(JSONObject obj) {
         //System.out.println(obj.toJSONString());
		return obj.toJSONString();
		
	}

	public static JSONObject stringToJsonObject(String inputString) {
		JSONObject obj= new JSONObject();

		JSONParser parser = new JSONParser();
		try {
			 obj = (JSONObject) parser.parse(inputString);
			 System.out.println(obj.getClass());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		return obj;

	}
	public static JSONObject readFromJsonFile(String filePath)  {
		
		JSONParser parser = new JSONParser();
		FileReader fileReader;
		JSONObject jsonObject=null;
		try {
			fileReader = new FileReader(filePath);
			 jsonObject=(JSONObject) parser.parse(fileReader);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return jsonObject;
	
		
		
	}
	


}
