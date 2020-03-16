package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID162 {
	@Test
	public  void PinEmptyCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().PinEmpty();
		
	}
}
