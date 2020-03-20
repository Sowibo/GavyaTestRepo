package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID57 {
	@Test
	public  void emptyLname() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().lnameEmpty();
	}
}
