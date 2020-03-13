package testcases;

import automation.AutomationScript;

public class TCID18 {
	public void checkout_pro(){
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().cart();
		AutomationScript.returnobj().checkout();
	}
	
}
