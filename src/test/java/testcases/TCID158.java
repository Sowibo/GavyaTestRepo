package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID158 {
	@Test
	public  void districtAvalilablecase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().districtAvailable();
		
	}
}
