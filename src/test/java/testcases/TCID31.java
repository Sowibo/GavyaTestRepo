package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;


public class TCID31 {
	@Test
	public  void checkoutLogged() {
	
		AutomationScript.returnobj().loggedCheckout();
	}
}
