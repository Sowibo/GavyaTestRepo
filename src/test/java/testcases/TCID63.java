package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID63 {
	@Test
	public void phoneNumEmpty() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().phoneNumberEmpty();
	}
}
