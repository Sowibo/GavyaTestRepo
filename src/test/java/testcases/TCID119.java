package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import automation.AutomationScript;
import dbcontroller.DbConnection;
import settings.Settings;
import webdriver.CustomWebDriver;

public class TCID119 {
	
//	
//	@BeforeSuite
//	public void init() {
//		CustomWebDriver.getInstance().initialize();
//		String url=Settings.getInstance().getProperty("urldb");
//		String usr=Settings.getInstance().getProperty("username");
//		String pass=Settings.getInstance().getProperty("password");
//		DbConnection.getInstance().initialisation(url, usr, pass);
//		
//	 }
	
	
	
	@Test
	public  void test119() {
//		AutomationScript.returnobj().launchUrl();
		
//		BeforeSuites.suit().init();
//		AutomationScript.returnobj().logIn();
		AutomationScript.returnobj().settingsPage();
		AutomationScript.returnobj().accountsSection();
		AutomationScript.returnobj().testPhoneNumber();
		
	}

}
