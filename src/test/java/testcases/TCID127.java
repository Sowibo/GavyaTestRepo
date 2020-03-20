package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID127 {
	@Test
	public  void test127() {

		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().newPasslenPos();
	
	}
}
