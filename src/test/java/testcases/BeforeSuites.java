package testcases;

import org.testng.annotations.BeforeSuite;

import automation.AutomationScript;
import dbcontroller.DbConnection;
import settings.Settings;
import webdriver.CustomWebDriver;

public class BeforeSuites {
	
	public static BeforeSuites suit() {
		return new  BeforeSuites();
	}
	@BeforeSuite
	public void init() {
		CustomWebDriver.getInstance().initialize();
		String url=Settings.getInstance().getProperty("urldb");
		String usr=Settings.getInstance().getProperty("username");
		String pass=Settings.getInstance().getProperty("password");
		DbConnection.getInstance().initialisation(url, usr, pass);
//		njn add cheythath
		
		AutomationScript.returnobj().launchUrl();
		AutomationScript.returnobj().cookie();
		AutomationScript.returnobj().logIn();
	 }
}
