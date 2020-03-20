package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID121 {

	@Test
	public  void test121() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().accountsSection();
		AutomationScript.returnobj().checkUpdate();
//		AutomationScript.returnobj().alertAccept120();
//		AutomationScript.returnobj().logOut();
//		AutomationScript.returnobj().logIn();
	}
}
