package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID141 {
	@Test
	public  void test141() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().fullNegative();
	}
}
