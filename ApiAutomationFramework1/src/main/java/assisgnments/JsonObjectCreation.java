package assisgnments;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectCreation {
	public static void createJsonObject() {
		
		JSONObject obj=new JSONObject();
		JSONObject address=new JSONObject();
		obj.put("name", "shilpa");
		obj.put("age", 29);
		obj.put("isEmployed",true);
		obj.put("Height", 153.0f);
		//json object
		address.put("houseNumber",23);
		address.put("streetName","Hartley Road");
		address.put("county","Luton");
		address.put("zipcode","LU2OHX");
		obj.put("address", address);
		
	    System.out.println(obj);
	   System.out.println(obj.toJSONString());
	   System.out.println(obj.get("name"));
	  System.out.println(obj.get("address"));
	    ObjectMapper obj1=new ObjectMapper();
	    try {
	    	AddressResponse obj2=obj1.readValue(obj.toString(), AddressResponse.class);
	    	System.out.println(obj2.getAddress().getStreetName());
	    }
	    catch(JsonMappingException e)
	    {
	    	e.printStackTrace();
	    }
	    catch(JsonProcessingException e) {
	    	e.printStackTrace();
	    }
	}
	public static void main(String[] args) {
		createJsonObject();

	}
		}

