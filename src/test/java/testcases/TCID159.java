package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID159 {
	@Test
	public  void DistrictSelectionCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().DistrictSelection();
		
	}
}
