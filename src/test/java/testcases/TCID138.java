package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID138 {
	@Test
	public  void test138() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().invalidFullName();
	}
}
