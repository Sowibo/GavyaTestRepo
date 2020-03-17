package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID12 {
	@Test
	public void ztoa() {
		AutomationScript.returnobj().ztoa();
		AutomationScript.returnobj().launchUrl();
	}

}
