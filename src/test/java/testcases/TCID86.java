package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID86 {
	@Test
	public void clickVegetable() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().categoryVegetable();
			 
		 
	}
}
