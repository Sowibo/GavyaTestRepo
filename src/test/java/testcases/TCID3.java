package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID3 {
	@Test
	public  void cartPlus(){
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().addProduct();
		
	}
}
