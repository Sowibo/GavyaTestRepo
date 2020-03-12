package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID59 {
	@Test
	public void lastNameCheck() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().lastNameValidation();
	}
}
