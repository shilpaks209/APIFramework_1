package testCases;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import core.JsonProcessor;

public class Test2 {
	public String ip = null;

	public void filePathExtractor() {
		ip = System.getProperty("user.dir")+ File.separator + "src"+ File.separator + "test"+ File.separator + "resources"+File.separator + "api";
		System.out.println("ip:" + ip);

	}

	@Test(enabled = true)
	public void testGet() {
		filePathExtractor();
		String path = ip +"\\api.json";
		File file = new File(path);
		
		System.out.println("Path:" + path);
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(path);
		System.out.println(jsonObject);
	}

}
