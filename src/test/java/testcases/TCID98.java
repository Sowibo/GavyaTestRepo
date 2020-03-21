package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID98 {
	@Test
	public void startTest98() {
		AutomationScript.returnobj().invoicePrint();
	}

}
