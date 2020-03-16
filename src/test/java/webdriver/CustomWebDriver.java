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
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\USER\\Desktop\\selenium\\dependency\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		 driver=new FirefoxDriver();
		
	 }
}
