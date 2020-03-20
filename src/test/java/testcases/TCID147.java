package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID147 {
	@Test
	public  void flatEmptycase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().flatEmpty();

	}		
	
}
