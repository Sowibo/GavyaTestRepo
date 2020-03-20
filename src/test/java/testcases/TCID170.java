package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID170 {
	@Test
	public  void changeOrdercase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().changeOrder();
		
		
	}
}