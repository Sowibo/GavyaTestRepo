package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID145 {
	@Test
	public  void test145() {
		BeforeSuites.suit().init();
 
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
//		AutomationScript.returnobj().numNegative();
		AutomationScript.returnobj().mobileNumberLenNegative();
	}
}
