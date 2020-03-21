package testcases;

import org.testng.annotations.Test;

import dbcontroller.DbConnection;

public class TCID45 {
	@Test
	public  void forgotInValid() {
		DbConnection.getInstance().getForgotInvalid();
	}
}
