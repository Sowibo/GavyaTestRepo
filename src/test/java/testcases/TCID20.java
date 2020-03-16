package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID20 {
	@Test
	public void clearPro() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().cart();
		AutomationScript.returnobj().clearEmpty();
	}
}
