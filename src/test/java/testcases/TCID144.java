package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID144 {
	@Test
	public  void test144() {
		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().mobileNumberLenPositive();
	}
}
