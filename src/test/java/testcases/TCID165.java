package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID165 {
	@Test
	public  void landEmptycase() {
	
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().landEmpty();
		
	}
}
