package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID151 {
	@Test
	public  void AreaEmptyCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().AreaEmpty();
		
	}
}
