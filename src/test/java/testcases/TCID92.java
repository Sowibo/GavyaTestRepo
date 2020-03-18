package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID92 {
	@Test
	public void startTest92() {
	
	AutomationScript.returnobj().cart();
	AutomationScript.returnobj().checkout();
	}

}
