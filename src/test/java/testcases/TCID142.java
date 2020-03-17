package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID142 {
	@Test
	public  void test142() {
		
//		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().invalidMobileNumber();
	}
}
