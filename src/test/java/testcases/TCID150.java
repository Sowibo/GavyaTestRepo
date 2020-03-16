package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID150 {
	@Test
	public  void AreaInvalidCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().AreaInvalid();
		
	}
}
