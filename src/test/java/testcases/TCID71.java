package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID71 {
	@Test
	public void passwordInvalid() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().conformPassDifferent();
	}
}
