package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;
import settings.Settings;
import webdriver.CustomWebDriver;

public class TCID119 {
 
	@Test
	public  void test119() {
		BeforeSuites.suit().init();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().accountsSection();
		AutomationScript.returnobj().testPhoneNumber();
		
	}

}
