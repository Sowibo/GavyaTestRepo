package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID42 {
	@Test
	public  void oneValid() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().getValidOne();
		
	}
}
