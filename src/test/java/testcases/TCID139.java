package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID139 {
	@Test
	public  void test139() {
//		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().emptyFullName();
	}
}
