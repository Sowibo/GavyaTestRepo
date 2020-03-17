package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID143 {
	@Test
	public  void test143() {
//		AutomationScript.returnobj().logIn();
		BeforeSuites.suit().init();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().emptyMobileNumber();
	}
}
