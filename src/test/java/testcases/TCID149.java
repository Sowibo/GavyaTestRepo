package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID149 {
	@Test
	public  void flatNegativecase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().flatNegative();
		
	}
}
