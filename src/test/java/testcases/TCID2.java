package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID2 {
	@Test
	public  void addCart() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().cart();
	}
}
