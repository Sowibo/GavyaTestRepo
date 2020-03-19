package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID29 {
	@Test
	public void clearCart() {
		
		AutomationScript.returnobj().cartCheckout();
		AutomationScript.returnobj().clearShop();
		AutomationScript.returnobj().checkout();
	}
}
