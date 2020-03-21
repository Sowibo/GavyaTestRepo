package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID40 {
	
	@Test
	public  void loginValid() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().getValidLogin();
		
	}
}
