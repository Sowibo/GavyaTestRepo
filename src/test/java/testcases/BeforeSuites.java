package testcases;

import org.testng.annotations.BeforeSuite;

import dbcontroller.DbConnection;
import settings.Settings;
import webdriver.CustomWebDriver;

public class BeforeSuites {
	@BeforeSuite
	public void init() {
		CustomWebDriver.getInstance().initialize();
		String url=Settings.getInstance().getProperty("urldb");
		String usr=Settings.getInstance().getProperty("username");
		String pass=Settings.getInstance().getProperty("password");
		String email=Settings.getInstance().getProperty("email");
		String password=Settings.getInstance().getProperty("pass");
		DbConnection.getInstance().initialisation(url, usr, pass);
	 }
}
