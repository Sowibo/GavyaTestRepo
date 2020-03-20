package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID159 {
	@Test
	public  void districtSelectioncase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().DistrictSelection();
		
	}
}
