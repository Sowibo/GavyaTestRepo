package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID167 {
	@Test
	public  void DisplayCookiesCase() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().DisplayCookies();
		
	}
}
