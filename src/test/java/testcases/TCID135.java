package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID135 {
	@Test
	public  void test135() {
		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().useAddress();
	}

}
