package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID154 {
	@Test
	public  void flatNum() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().CityInvalid();
		
	}
}
