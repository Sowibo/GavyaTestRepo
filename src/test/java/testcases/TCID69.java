package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID69 {
	@Test
	public void passwordFieldNegative() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().passWordNegative();
	}
}
