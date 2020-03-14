package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID136 {
	@Test
	public  void test136() {
		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().removeAddress();
	}
}
