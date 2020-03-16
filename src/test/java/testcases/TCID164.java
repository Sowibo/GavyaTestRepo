package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID164 {
	@Test
	public  void PinNegativeCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().PinNegative();
		
	}
}
