package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID60 {
	@Test
	public void invalidEmailValidation() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().invalidEmail();
	}
}
