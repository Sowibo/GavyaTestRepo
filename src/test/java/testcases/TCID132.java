package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID132 {
	
	@Test
	public  void test132() {
//		AutomationScript.returnobj().logIn();
		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().currentPassEmpty();
		
	}
}
