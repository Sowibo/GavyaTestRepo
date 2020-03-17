package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID32 {
	@Test
	public  void verify() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().verifyLabel();
	}
}
