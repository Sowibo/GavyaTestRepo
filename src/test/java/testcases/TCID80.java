package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID80 {
	@Test
	public void clickSuggestion() {
		AutomationScript.returnobj().launchUrl();
		DbConnection.getInstance().clickElement();
			 
		 
	}
}
