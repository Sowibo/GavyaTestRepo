package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID171 {
	@Test
	public  void standDeliverycase() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().standDelivery();
		
		
		
	}
}