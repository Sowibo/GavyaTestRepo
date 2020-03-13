package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dbcontroller.DbConnection;
import settings.Settings;
import webdriver.CustomWebDriver;

public class AutomationScript extends CustomWebDriver{
	
	public static AutomationScript returnobj() {
		return new AutomationScript();
	}
	public void launchUrl() {
		driver.get(Settings.getInstance().getProperty("url"));
	}
	
	//KEERTHI
	
	
	public void testPhoneNumber() {
		WebElement settings,accounts,numfield,login,logid,logpass;
		try {
		
		login=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		logid=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		logid.sendKeys("keerthisudev444@gmail.com");
		logpass=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		logpass.sendKeys("keerthisudev");
		settings=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		settings.click();
		accounts=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		accounts.click();
		numfield=driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		numfield.sendKeys("12");
		}
		catch(NullPointerException n) {
			System.out.println("i catch an exception");
		}
	}
}
