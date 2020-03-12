package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID62 {
	@Test
	public void phoneNumValidation() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().phoneNumberValid();;
	}
}
