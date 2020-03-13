
package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	//Gopika
	//Automation
	public void cooki() {
		WebElement cooki;
		cooki=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		cooki.click();
	}
	public void contactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		email=driver.findElement(By.id("email"));
		phnum=driver.findElement(By.id("phone"));
		comment=driver.findElement(By.id("comment"));
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		name.sendKeys("Gopika");
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum.sendKeys("7592018435");
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn.click();
		
	}
	public void invalidContactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		email=driver.findElement(By.id("email"));
		phnum=driver.findElement(By.id("phone"));
		comment=driver.findElement(By.id("comment"));
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		name.sendKeys("g123##$%^");
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum.sendKeys("7592018435");
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn.click();
	}
//	public void button() {
//		
//	}
//	
	public void login() {
		WebElement sendkey,email,password,button;
		sendkey=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		sendkey.click();
		email=driver.findElement(By.id("email"));
		email.sendKeys("gopikagopakumaran1@gmail.com");
		password=driver.findElement(By.id("password"));
		password.sendKeys("gopikagg");
		button=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		button.click();
	}


	
}
