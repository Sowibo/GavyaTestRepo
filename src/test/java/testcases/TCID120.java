package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID120 {
	
	@Test
	public  void test120() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().accountsSection();
		AutomationScript.returnobj().clearAccounts();
		AutomationScript.returnobj().testValidData();
		
	}
}
