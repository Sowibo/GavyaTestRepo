package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID14 {
	@Test
	public  void verifypro() {
		AutomationScript.returnobj().verifyProducts();
	}
}
