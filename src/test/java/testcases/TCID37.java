package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID37 {
	@Test
	public  void clearClick() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().clear();
	}
}
