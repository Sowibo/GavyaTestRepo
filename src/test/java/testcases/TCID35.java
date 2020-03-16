package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID35 {
	@Test
	public  void upper() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().upperLimit();
	}
}
