package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID87 {
	@Test
	public void clickOtherGrocerices() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().categoryOtherGroceries();
			 
		 
	}
}
