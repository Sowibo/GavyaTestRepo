package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID125 {
	@Test
	public  void test125() {

		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().currentPassLenNeg();
	
	}
}
