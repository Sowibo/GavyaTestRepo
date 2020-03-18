package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID48 {
	@Test
	public  void accountLink() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().createAccount();
	}
}
