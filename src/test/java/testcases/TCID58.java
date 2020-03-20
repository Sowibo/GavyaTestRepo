package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID58 {
	@Test
	public  void lnamePositive() {
		AutomationScript.returnobj().launchUrl();
	
		AutomationScript.returnobj().lnamePositiveLength();
	}
}
