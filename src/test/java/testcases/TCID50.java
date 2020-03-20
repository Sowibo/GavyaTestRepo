package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID50 {
	@Test
	public  void logOut() {
	
		AutomationScript.returnobj().logout();
	}
}
