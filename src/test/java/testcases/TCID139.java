package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID139 {
	@Test
	public  void test139() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().emptyFullName();
	}
}
