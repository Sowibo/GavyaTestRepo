package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID39 {
	@Test
	public  void loginEmpty() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().getEmptyLogin();
		
	}
}
