package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID133 {
	@Test
	public  void test133() {
 
		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().confirmPassEmpty();
	
	}
}