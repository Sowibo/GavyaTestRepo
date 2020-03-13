package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID65 {
	@Test
	public void phoneNumNegative() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().phoneLengthNegative();
	}
}
