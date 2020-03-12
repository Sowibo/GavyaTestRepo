package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	
	//********veena*************************//
	
	public void registerOpen() {
		WebElement regibtn;
		regibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		regibtn.click();
	}
	public void lastNameValidation() {
		WebElement lastname,btn,cookie;
		lastname=driver.findElement(By.id("lname"));

		cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		cookie.click();
		lastname.sendKeys("veenaghyuklavbnl");
		
		btn.click();
		
		
	}
	
	public void invalidEmail() {
		WebElement email,cookie,btn;
		email=driver.findElement(By.id("email"));

		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		

		email.sendKeys("veena2.com");
		btn.click();
	}
	public void emailFieldEmpty() {
		WebElement firstname,lastname,phnum,password,conformpass,refferal,btn;
		firstname=driver.findElement(By.id("fname"));
		lastname=driver.findElement(By.id("lname"));
		phnum=driver.findElement(By.id("phone"));
		password=driver.findElement(By.id("password"));
		conformpass=driver.findElement(By.id("password2"));
		refferal=driver.findElement(By.id("referral"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		firstname.sendKeys("veena");
		lastname.sendKeys("vl");
		phnum.sendKeys("7034994370");
		password.sendKeys("veenavava123");
		conformpass.sendKeys("veenavava123");
		refferal.sendKeys("vgjj123@");
		btn.click();
	}
	public void phoneNumberValid() {
		WebElement phnum,btn;
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		phnum.sendKeys("7034uyh@67");
		btn.click();
	}
	public void phoneNumberEmpty() {
		WebElement firstname,lastname,email,password,conformpass,refferal,btn;
		firstname=driver.findElement(By.id("fname"));
		lastname=driver.findElement(By.id("lname"));
		email=driver.findElement(By.id("email"));
		password=driver.findElement(By.id("password"));
		conformpass=driver.findElement(By.id("password2"));
		refferal=driver.findElement(By.id("referral"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		firstname.sendKeys("veena");
		lastname.sendKeys("vl");
		email.sendKeys("veena@sowibo.com");
		password.sendKeys("veenavava123");
		conformpass.sendKeys("veenavava123");
		refferal.sendKeys("vgjj123@");
		btn.click();
	}
}
