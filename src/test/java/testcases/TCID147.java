package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;



public class TCID147 {
	@Test
	public  void flatNum() {
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().Addcart();
		AutomationScript.returnobj().checkOut();
		AutomationScript.returnobj().proceedCheck();
		AutomationScript.returnobj().pinFiled();
		
	}
		
	
}
