package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID131 {
	@Test
	public  void test131() {
 
		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().confPassLenNeg();
	
	}
}
