package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID64 {
	@Test
	public void phoneNumPositive() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().phoneLengthPositive();
	}
}
