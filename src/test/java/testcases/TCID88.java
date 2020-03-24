package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID88 {
	@Test
	public void clickContinueShopping() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().continueShopping();
			 
		 
	}
}
