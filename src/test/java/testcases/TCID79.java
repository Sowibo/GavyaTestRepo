package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID79 {
	@Test
	public void emptySearch() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().emptySearchBar();
			 
		 
	}
}
