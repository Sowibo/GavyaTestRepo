package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID173 {
	@Test
	public  void totalPrice() {
		
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().showTotal();
		
		
		
	}
}