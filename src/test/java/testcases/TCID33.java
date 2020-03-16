package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID33 {
	@Test
	public  void productIncrement() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().plusFunction();
		
	}
}
