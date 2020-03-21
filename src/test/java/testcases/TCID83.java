package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID83 {
	@Test
	public void clearOption() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().searchClear();
			 
		 
	}
}
