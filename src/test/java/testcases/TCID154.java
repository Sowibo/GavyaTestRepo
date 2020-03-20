package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID154 {
	@Test
	public  void cityInvalidcase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().cityInvalid();
		
	}
}
