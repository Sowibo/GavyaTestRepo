package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID137 {
	@Test
	public  void test137() {
		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().validDetails();
	}
}
