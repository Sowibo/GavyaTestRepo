
package automation;

import static org.testng.Assert.fail;

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
	public void checkout()  {
		WebElement checkout;
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();
	}

	public void cart() {
	    WebElement cart;
	    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		cart=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[2]/button"));
		cart.click();
	}
	
	
	public void logout() {
		WebElement logout;
		logout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		logout.click();
	}
	
	public void contactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		System.out.println("alert");
		
		

	}
	public void invalidContactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btn.click();
		
		driver.switchTo().alert().accept();
		
	}
	
	public void invalidFname() {
		WebElement setting,account,fname,lname,phn,btn;
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		fname=driver.findElement(By.id("//*[@id=\"fname\"]"));
		lname=driver.findElement(By.id("//*[@id=\"lname\"]"));
		phn=driver.findElement(By.id("//*[@id=\"phone\"]"));
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		fname.sendKeys("fderw434@##");
		lname.sendKeys("gg");
		phn.sendKeys("7592018435");
		btn.click();
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <108> failed: <no show error message when firat name field with invalid data>");
		}
		else {
			System.out.println("tcid 108 success");
		}
		
		
}

	public void emptyFname() {
		WebElement setting,account,fname,lname,phn,btn;
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		fname=driver.findElement(By.id("fname"));
		lname=driver.findElement(By.id("lname"));
		phn=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		fname.sendKeys("");
		lname.sendKeys("gg");
		phn.sendKeys("7592018435");
		btn.click();
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <109> failed: <no show error message when firat name field is empty>");
		}
		else {
			System.out.println("tcid 109 success");
		}
		
	}
	
	public void invalidLname() {
		WebElement setting,account,fname,lname,phn,btn;
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		lname=driver.findElement(By.id("lname"));
		phn=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		fname.sendKeys("gopika");
		lname.sendKeys("21@@@3E");
		phn.sendKeys("7592018435");
		btn.click();
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <112> failed: <no show error message when last name with invalid data>");
		}
		else {
			System.out.println("tcid 112 success");
		}
		
		
		
	}
	public void emptyLname() {
		WebElement setting,account,fname,lname,phn,btn;
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		lname=driver.findElement(By.id("lname"));
		phn=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		fname.sendKeys("gopika");
		lname.sendKeys("");
		phn.sendKeys("7592018435");
		btn.click();
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <113> failed: <no show error message when empty last name>");
		}
		else {
			System.out.println("tcid 113 success");
		}
	}
		public void invalidPhn() {
			WebElement setting,account,fname,lname,phn,btn;
			setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
			setting.click();
			account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
			account.click();
			fname=driver.findElement(By.id("fname"));
			lname=driver.findElement(By.id("lname"));
			phn=driver.findElement(By.id("phone"));
			btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			fname.sendKeys("gopika");
			lname.sendKeys("gg");
			phn.sendKeys("bdf@@#445");
			btn.click();
			String message=phn.getAttribute("validationMessage");
			if(message.isEmpty()||message.equals(null)) {
				fail("TCID <116> failed: <no show error message when phone number with invalid data>");
			}
			else {
				System.out.println("tcid 116 success");
			}
			
		}
		public void emptyPhn() {
			WebElement setting,account,fname,lname,phn,btn;
			setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
			setting.click();
			account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
			account.click();
			fname=driver.findElement(By.id("fname"));
			lname=driver.findElement(By.id("lname"));
			phn=driver.findElement(By.id("phone"));
			btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			fname.sendKeys("gopika");
			lname.sendKeys("gg");
			phn.sendKeys("");
			btn.click();
			String message=phn.getAttribute("validationMessage");
			if(message.isEmpty()||message.equals(null)) {
				fail("TCID <117> failed: <no show error message when empty phone number>");
			}
			else {
				System.out.println("tcid 117 success");
			}
		}
		
	
	
	
	
	 


	
}
