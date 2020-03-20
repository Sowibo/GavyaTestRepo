package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID96 {
	@Test
	public void startTest92() {
		AutomationScript.returnobj().cancel();
		AutomationScript.returnobj().reorder();
		AutomationScript.returnobj().back();
	}

}
