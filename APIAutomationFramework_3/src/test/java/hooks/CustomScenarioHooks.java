package hooks;

import io.cucumber.java.Before;

import java.io.File;

import io.cucumber.java.After;

public class CustomScenarioHooks {
	

	@Before

	public static void filePathExtractor() {
		
		System.out.println("Inside beforeScenario..");
	}

	@After
	public void afterScenario() {

		System.out.println("Inside afterScenario..");
	}

}
