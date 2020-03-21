package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID27 {
	@Test
	public void verifyttl() {
	AutomationScript.returnobj().cart();
	AutomationScript.returnobj().cartCheckout();
	AutomationScript.returnobj().verifyCheckTotal();
	}
}
