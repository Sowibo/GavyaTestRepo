package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID122 {
	
	@Test
	public  void test122() {

		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().currentValidPass();
	
	}

}
