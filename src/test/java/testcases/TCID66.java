package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID66 {
	@Test
	public void passwordFieldEmpty() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().passwordEmpty();
	}
}
