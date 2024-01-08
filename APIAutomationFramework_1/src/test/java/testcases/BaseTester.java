package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class BaseTester {
	public static String ip;
	
	@BeforeTest

	public static void filePathExtractor() {
		
		ip = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "resources" + File.separator + "api";
		System.out.println("ip:" + ip);

	}
}
