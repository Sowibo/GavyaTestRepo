package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID18 {
	@Test
	public void checkout_pro(){
		
		AutomationScript.returnobj().cart();
		AutomationScript.returnobj().cartCheckout();
		AutomationScript.returnobj().continueCart();
		
	}
	
}
