package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID15 {
	@Test
	public void verify() {
		AutomationScript.returnobj().verifyProduct();
	}

}
