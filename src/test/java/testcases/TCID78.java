package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID78 {
	@Test
	public void invalidSearch() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().getElement();
			 
		 
	}
}
