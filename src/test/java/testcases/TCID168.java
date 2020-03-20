package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID168 {
	@Test
	public  void confirmOrdercase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().confirmOrder();
		
	}
}
