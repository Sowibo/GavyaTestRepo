package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID85 {
	@Test
	public void clickFruite() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().categoryFruite();
			 
		 
	}
}
