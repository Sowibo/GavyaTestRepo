package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID61 {
	@Test
	public void emailValidation() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().emailFieldEmpty();
	}
}
