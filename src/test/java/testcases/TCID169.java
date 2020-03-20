package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID169 {
	@Test
	public  void changeAddresscase() {
		
		AutomationScript.returnobj().login();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().changeAddress();
		
		
	}
}
