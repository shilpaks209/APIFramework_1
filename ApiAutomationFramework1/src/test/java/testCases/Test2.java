package testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;



import core.APIRequest;
import core.JsonProcessor;


public class Test2 {
	public static String ip;
@BeforeTest()
	public static void filePathExtractor() {
          ip = System.getProperty("user.dir")+ File.separator + "src"+ File.separator + "main"+ File.separator + "resources"+File.separator + "api";
		System.out.println("ip:" + ip);
       
	}

	@Test(enabled = true)
	public void testGet() {
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(ip+File.separator +"api.json");
		   
		
	}

}
