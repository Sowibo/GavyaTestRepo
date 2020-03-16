package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID18 {
	@Test
	public void checkout_pro(){
		AutomationScript.returnobj().checkout();
		AutomationScript.returnobj().cartCheckout();
		
	}
	
}
