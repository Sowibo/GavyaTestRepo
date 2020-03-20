package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID153 {
	@Test
	public  void areaNegativecase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().areaNegative();
	}
}
