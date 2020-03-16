package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID30 {
	@Test
	public  void newUserCheckout() {
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().newUser();
	}
}
