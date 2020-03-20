package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID162 {
	@Test
	public  void pinEmptycase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().pinEmpty();
		
	}
}
