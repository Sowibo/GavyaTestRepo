package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID135 {
	@Test
	public  void test135() {
 
		BeforeSuites.suit().init();
		AutomationScript.returnobj().addProduct();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheckOut();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().confirmOrder();
	}

}
