package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID3 {
	@Test
	public  void cartPlus(){
		AutomationScript.returnobj().addProduct();
		System.out.println("Added Product");
	}
}
