package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID84 {
	@Test
	public void dataBaseCategory() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().categoryDb();
		 
		 
	}
}
