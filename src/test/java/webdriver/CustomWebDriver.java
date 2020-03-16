package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import webdriver.CustomWebDriver;

public class CustomWebDriver {
	public static WebDriver driver;
	public static CustomWebDriver getInstance(){
		return new CustomWebDriver();
		
	}
	
	public void initialize() {
		System.setProperty("webdriver.gecko.driver","C:\\Softwares\\gecko\\geckodriver.exe");
		 driver=new FirefoxDriver();
		
	 }
}
