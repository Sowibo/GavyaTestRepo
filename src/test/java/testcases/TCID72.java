package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID72 {
	@Test
	public void accountCreation() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().createAccount();
}
}