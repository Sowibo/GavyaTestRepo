package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID25 {
	@Test
	public void clearCart() {
		AutomationScript.returnobj().clear();
	}
}
