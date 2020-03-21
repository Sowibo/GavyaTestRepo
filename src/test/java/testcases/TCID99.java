package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID99 {
	@Test
	public void startTest99() {
		AutomationScript.returnobj().invoiceDownload();
	}


}
