package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID161 {
	@Test
	public  void pinInvalidcase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().pinInvalid();
		
	}
}

