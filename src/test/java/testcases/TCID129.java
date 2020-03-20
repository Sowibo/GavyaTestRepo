package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID129 {
	@Test
	public  void test129() {

		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().confirmDiff();
	
	}
}
