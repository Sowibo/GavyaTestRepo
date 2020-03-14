package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID119 {
	@Test
	public  void test119() {
		
		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().accountsSection();
		AutomationScript.returnobj().testPhoneNumber();

	}

}
