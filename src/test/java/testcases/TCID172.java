package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID172 {
	@Test
	public  void fastDeliverycase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().fastDelivery();
		
		
		
	}
}