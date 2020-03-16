package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID165 {
	@Test
	public  void LandEmptyCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().LandEmpty();
		
	}
}
