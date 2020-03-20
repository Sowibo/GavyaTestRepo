package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID150 {
	@Test
	public  void areaInvalidcase() {

		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().areaInvalid();
		
	}
}
