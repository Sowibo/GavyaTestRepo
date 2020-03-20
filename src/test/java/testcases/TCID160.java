package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID160 {
	@Test
	public  void districtDefaultcase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().districtDefault();
		
	}
}

