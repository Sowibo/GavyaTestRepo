package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID155 {
	@Test
	public  void CityEmptyCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().CityEmpty();
		
	}
}
