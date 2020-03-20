package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID38 {
	@Test
	public  void emptyLogin() {
		AutomationScript.returnobj().loginEmpty();
	}
}
