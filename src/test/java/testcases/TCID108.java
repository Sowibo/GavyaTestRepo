package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID108 {
	@Test
	public void startTest108() {
		AutomationScript.returnobj().cooki();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().invalidFname();
	}

}
