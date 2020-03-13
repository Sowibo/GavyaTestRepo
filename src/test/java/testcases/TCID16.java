package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID16 {
	@Test
	public  void checkout_emp(){
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().checkout_empty();
	}

}
