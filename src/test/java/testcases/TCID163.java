package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID163 {
	@Test
	public  void PinPositiveCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().PinPositive();
		
	}
}
