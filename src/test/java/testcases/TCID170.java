package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID170 {
	@Test
	public  void ChangeOrderCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().UseAddress();
		AutomationScript.returnobj().ChangeOrder();
		
		
	}
}