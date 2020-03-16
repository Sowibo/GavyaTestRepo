package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID54 {
	@Test
	public  void fnamePositive() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().register();
		AutomationScript.returnobj().fnamePositiveLength();
	}

}
