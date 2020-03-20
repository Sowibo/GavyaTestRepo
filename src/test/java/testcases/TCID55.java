package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID55 {
	@Test
	public  void fnameNegative() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().fnameNegativeLength();
	}
}
