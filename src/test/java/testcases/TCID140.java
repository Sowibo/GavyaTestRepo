package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID140 {
	@Test
	public  void test140() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().fullNamePositive();
	}

}
