package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID74 {
	@Test
	public void goToHome() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().backOption();
	}
}
