package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID161 {
	@Test
	public  void PinValidCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().PinInvalid();
		
	}
}

