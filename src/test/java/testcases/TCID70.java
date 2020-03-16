package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID70 {
	@Test
	public void passwordInvalid() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().passWordInvalidDta();;
	}
}
