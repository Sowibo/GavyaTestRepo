package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;

public class TCID95 {
	@Test
	public void startTest95() {

		AutomationScript.returnobj().reorder1();
		AutomationScript.returnobj().confirmReorder();
	}

}
