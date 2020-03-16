package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID19 {
	@Test
	public void clearEmp() {
		AutomationScript.returnobj().clearEmpty();
	}

}
