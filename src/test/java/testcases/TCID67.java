package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID67 {
	@Test
	public void conformFieldEmpty() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().registerOpen();
		AutomationScript.returnobj().conformPasswordEmpty();
	}
}