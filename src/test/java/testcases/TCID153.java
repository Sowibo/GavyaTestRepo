package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID153 {
	@Test
	public  void AreaNegativeCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().AreaNegative();
		
	}
}
