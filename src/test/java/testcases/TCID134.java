package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID134 {
	@Test
	public  void test134() {
		
//		AutomationScript.returnobj().logIn();
		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().newPassEmpty();
	}
}
