package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID53 {
	@Test
	public  void emptyFname() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().register();
		AutomationScript.returnobj().fnameEmpty();
	}
}
