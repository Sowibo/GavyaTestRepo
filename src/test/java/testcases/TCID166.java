package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID166 {
	@Test
	public  void primaryAddresscase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().primaryAddress();
		
	}
}