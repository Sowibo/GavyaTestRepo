package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID17 {
	@Test
	public void verifyTtl() {
		AutomationScript.returnobj().cart();
		AutomationScript.returnobj().verifyTotal();
		
	}

}
