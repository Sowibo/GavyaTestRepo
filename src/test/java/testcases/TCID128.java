package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID128 {
	@Test
	public  void test128() {

		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().newPasslenNeg();
	
	}
}
