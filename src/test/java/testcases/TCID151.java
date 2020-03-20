package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID151 {
	@Test
	public  void areaEmptycase() {

		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().areaEmpty();
		
	}
}
