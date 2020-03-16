package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID52 {
	@Test
	public  void invalidFname() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().register();
		AutomationScript.returnobj().invalidFname();
	}
}
