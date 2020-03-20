package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID124 {
	@Test
	public  void test124() {

		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().currentPassLenPos();
	
	}
}
