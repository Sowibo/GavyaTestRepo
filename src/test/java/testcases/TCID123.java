package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID123 {
	@Test
	public  void test123() {
//		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().currentInvalidPass();
	
	}

}
