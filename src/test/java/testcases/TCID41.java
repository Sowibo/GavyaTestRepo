package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID41 {
	@Test
	public  void loginInvalid() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().getInvalidLogin();
		
	}
}
