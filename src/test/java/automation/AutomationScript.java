
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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
		WebElement login,submit,email,password;
		driver.get(Settings.getInstance().getProperty("url"));
		AutomationScript.returnobj().cooki();
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		email=driver.findElement(By.id("email"));
		email.sendKeys(Settings.getInstance().getProperty("email"));
		password=driver.findElement(By.id("password"));
		password.sendKeys(Settings.getInstance().getProperty("pass"));
		submit=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[2]/button"));
		submit.click();
	}
	public void checkout()  {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement checkout;
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();
	}

	public void cart() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void validContactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert=driver.switchTo().alert();
		alert.accept();
		if(alert.equals(null)) {
			fail("TCID <100> failed: <alert box not present");
			
		}
		else {
			System.out.println("tcid 100 success");
		}
		

	}
	public void invalidNameContactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("dfretr$$#@@@#");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		String message=name.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <101> failed: <no show error message when  name field with invalid data>");	
		}
		else {
			System.out.println("tcid 101 success");
		}
	}
	
	
	
	public void emptyNameContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=name.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <102> failed: <no show error message when empty name field>");	
		}
		else {
			System.out.println("tcid 102 success");
		}
		
	}
	public void invalidEmailContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("sfdeea234432ddd");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=email.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <103> failed: <no show error message when  email field with invalid data>");	
		}
		else {
			System.out.println("tcid 103 success");
		}
		
	
		
	}
	public void emptyEmailContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=email.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <104> failed: <no show error message when empty email field>");	
		}
		else {
			System.out.println("tcid 104 success");
		}
		
	}
	public void invalidPhnContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("tdrd##2e44");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=phnum.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <105> failed: <no show error message when  phone number field with invalid data>");	
		}
		else {
			System.out.println("tcid 105 success");
		}
		
	}
	public void emptyPhnContact() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=phnum.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <106> failed: <no show error message when empty phone number field>");	
		}
		else {
			System.out.println("tcid 106 success");
		}
	}
	public void emptyComment() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=comment.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <107> failed: <no show error message when   empty comment field>");	
		}
		else {
			System.out.println("tcid 107 success");
		}
	}
	
	public void invalidFname() {
		WebElement setting,account,fname,lname,phn,btn;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));	
		fname.clear();
		fname.sendKeys("fderw434@##");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <108> failed: <no show error message when first name field with invalid data>");	
		}
		else {
			System.out.println("tcid 108 success");
		}
		
		
	}

	public void emptyFname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			
			fail("TCID <109> failed: <no show error message when empty first name field>");	
		}
		else {
			
			System.out.println("tcid 109 success");
		}
		
	}
	public void positivFname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("go");
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			System.out.println("tcid 110 first positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  first name field with 2 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname.clear();
		fname.sendKeys("gop");
		String message1=fname.getAttribute("validationMessage");
		if(message1.isEmpty()||message1.equals(null)) {
			System.out.println("tcid 110 second positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  first name field with 3 number data>");	
			
		}
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
	}
	public void negativeFname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("g");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <111> failed: <no show error message when  first name field with  1 number data>");
			
		}
		else {
				
			System.out.println("tcid 111 negative test success");
		}
		
	}
	
	public void invalidLname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("21@@@3E");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			
			fail("TCID <113> failed: <no show error message when empty last name field>");
		}	
		else {
			
			System.out.println("tcid 113 success");
		
		}
		
	}
	public void positiveLname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			System.out.println("tcid 114 first positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  last name field with 2 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lname.clear();
		lname.sendKeys("ggg");
		String message1=lname.getAttribute("validationMessage");
		if(message1.isEmpty()||message1.equals(null)) {
			System.out.println("tcid 114 first positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  last name field with 3 nymber>");	
			
		}
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
	}
	public void nagativeLname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("g");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <115> failed: <no show error message when  first name field with  1 number data>");
			
		}
		else {
				
			System.out.println("tcid 115 negative test success");
		}
		
	}
	public void invalidPhn() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("bdf@@#445");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=phn.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			
			fail("TCID <117> failed: <no show error message when empty phone number field>");
		}	
		else {
			
			System.out.println("tcid 117 success");
		
		}
	}
	public void positivephnum() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("999999");
		String message=phn.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			System.out.println("tcid 118 first positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phn.clear();
		phn.sendKeys("9999997");
		String message1=phn.getAttribute("validationMessage");
		if(message1.isEmpty()||message1.equals(null)) {
			System.out.println("tcid 118 second positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phn.clear();
		phn.sendKeys("9999997896");
		String message2=phn.getAttribute("validationMessage");
		if(message2.isEmpty()||message2.equals(null)) {
			System.out.println("tcid 118 third positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		phn.clear();
		phn.sendKeys("9999992345");
		String message3=phn.getAttribute("validationMessage");
		if(message3.isEmpty()||message3.equals(null)) {
			System.out.println("tcid 118 forth positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
		
	}
	

	
		
			
		
		
	
	
	
	
	 


	
}
