package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID34 {
	@Test
	public  void productDecrement() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().minusFunction();
	}
}
