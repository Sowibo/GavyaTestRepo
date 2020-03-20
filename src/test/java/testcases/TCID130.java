package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID130 {
	@Test
	public  void test130() {
 
		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().changePass();
		AutomationScript.returnobj().conPasslenPos();
	
	}
}
