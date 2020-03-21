package testcases;
import org.testng.annotations.Test;

import automation.AutomationScript;


public class TCID1 {
	
	@Test
	public  void startTest() {
		AutomationScript.returnobj().launchUrl();
		
	}
}
