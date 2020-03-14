package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID108 {
	@Test
	public void startTest() {
		AutomationScript.returnobj().cooki();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().accountSetting();
	}

}
