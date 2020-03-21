package testcases;

import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;

public class TCID44 {
	@Test
	public  void forgotValid() {
		DbConnection.getInstance().getForgotValid();
	}
}
