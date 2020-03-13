package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;






public class TCID100 {
	@Test
	public void startTest() {
		AutomationScript.returnobj().cooki();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().contactUs();
		
	}

}
