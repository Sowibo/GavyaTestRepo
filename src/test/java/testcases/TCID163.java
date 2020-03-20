package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID163 {
	@Test
	public  void pinPositivecase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().pinPositive();
		
	}
}
