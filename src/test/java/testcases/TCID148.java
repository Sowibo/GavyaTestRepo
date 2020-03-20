package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID148 {
	@Test
	public  void flatPositivecase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().flatPositive();
	}
		
	
}
