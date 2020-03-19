package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID46 {
	@Test
	public  void emptyPass() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().emptyForgotPassword();
	}
}
