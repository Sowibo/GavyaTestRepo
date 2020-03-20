package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID156 {
	@Test
	public  void cityPositivecase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().cityPositive();
		
	}
}
