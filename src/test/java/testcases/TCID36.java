package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID36 {
	
		@Test
		public  void lower() {
			AutomationScript.returnobj().launchUrl();
			AutomationScript.returnobj().checkOut();
			AutomationScript.returnobj().lowerLimit();
		}

}
