package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID149 {
	@Test
	public  void flatNegativeCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().FlatNegative();
		
	}
}
