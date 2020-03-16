package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID148 {
	@Test
	public  void flatPositiveCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().FlatPositive();
	}
		
	
}
