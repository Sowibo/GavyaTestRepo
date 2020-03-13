package testcases;

import automation.AutomationScript;

public class TCID20 {
	public void clearPro() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().cart();
		AutomationScript.returnobj().clearEmpty();
	}
}
