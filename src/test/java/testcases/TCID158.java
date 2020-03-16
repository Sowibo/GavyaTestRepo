package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID158 {
	@Test
	public  void DistrictAvalilableCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().DistrictAvailable();
		
	}
}
