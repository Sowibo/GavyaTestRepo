package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID126 {
	@Test
	public  void test126() {

		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().newPassInvalid();
	
	}
}
