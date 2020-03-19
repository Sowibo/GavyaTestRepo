package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID43 {
	@Test
	public  void forgotPass() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().forgotPassword();
	}
}
