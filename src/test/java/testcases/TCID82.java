package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID82 {
	@Test
	public void clickSearchButton() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().clickSearchBtn();
			 
		 
	}
}