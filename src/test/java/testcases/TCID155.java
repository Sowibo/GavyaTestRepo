package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID155 {
	@Test
	public  void cityEmptycase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().cityEmpty();
	}
}
