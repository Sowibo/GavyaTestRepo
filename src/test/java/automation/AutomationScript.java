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
	WebElement check;
	public static AutomationScript returnobj() {
		return new AutomationScript();
		
		
	}
	public void launchUrl() {
		driver.get(Settings.getInstance().getProperty("url"));
	}
	
	//neeraja
	
	public void Addcart() {
		WebElement add;
		add=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
		add.click();
		
	}
	public void checkOut() {
		check = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		check.click();
		
	}
	
	public void proceedCheck() {
		WebElement pCheck;
		pCheck=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div/div/button"));
		pCheck.click();
	
	
	}

	public void pinFiled() {
		
		WebElement filed;
		filed=driver.findElement(By.xpath("//*[@id=\"pin\"]"));
		
		
	}
	
	
	
	
	
	
}
