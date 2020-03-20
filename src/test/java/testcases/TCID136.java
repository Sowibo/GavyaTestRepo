package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID136 {
	@Test
	public  void test136() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().removeAddress();
	}
}
