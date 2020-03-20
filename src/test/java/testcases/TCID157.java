package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID157 {
	@Test
	public  void cityNegativecase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().cityNegative();
	}
}
