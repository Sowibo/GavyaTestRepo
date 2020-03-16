package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID68 {
	@Test
	public void passwordFieldPositive() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().passWordPositive();
	}
}
