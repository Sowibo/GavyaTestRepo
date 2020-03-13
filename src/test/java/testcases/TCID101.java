package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID101 {
	@Test
	public void startTest() {
		AutomationScript.returnobj().cooki();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().invalidContactUs();
	}

}
