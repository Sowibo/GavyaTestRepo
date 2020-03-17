package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID73 {
	@Test
	public void accountCreation() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().refferalEmpty();
	}
}
