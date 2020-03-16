package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID152 {
	@Test
	public  void AreaPositiveCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().AreaPositive();
		
	}
}

