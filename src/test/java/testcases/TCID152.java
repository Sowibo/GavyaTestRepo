package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID152 {
	@Test
	public  void areaPositivecase() {
	
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().areaPositive();
		
	}
}

