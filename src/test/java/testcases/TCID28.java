package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID28 {
	@Test
	public void continueCart() {
		AutomationScript.returnobj().cart();
		AutomationScript.returnobj().cartCheckout();
		AutomationScript.returnobj().continueCart();
	}
}
