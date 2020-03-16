package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID56 {
	@Test
	public  void invalidLname() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().register();
		AutomationScript.returnobj().invalidLname();
	}
}
