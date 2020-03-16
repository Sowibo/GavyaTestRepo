package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID157 {
	@Test
	public  void CityNegativeCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().CityNegative();
		
	}
}
