package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID92 {
	@Test
	public void startTest92() {
	
		AutomationScript.returnobj().checkout();
		AutomationScript.returnobj().useAddress();
		AutomationScript.returnobj().cancel();
		AutomationScript.returnobj().reorder();
	}

}
