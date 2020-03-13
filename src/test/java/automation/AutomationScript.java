package automation;

import static org.testng.Assert.fail;

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
			
			
			String value=(driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/div/div[1]/div[2]/span"))).getText();

			System.out.println("message="+value);
			String elementval="Must have atleast 1-15 characters";
			
			if(value.equals(elementval)) {
				System.out.println("tcid59 sucess");
			}
			else {
				
				fail("TCID <59> failed: <no show error message when give last name length as 16>");
			}

		
		
	}
 
	
	public void invalidEmail() {
		WebElement email,cookie,btn;
		email=driver.findElement(By.id("email"));

		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		

		email.sendKeys("veena2.com");
		btn.click();
		

	}
	public void emailFieldEmpty() {
		WebElement firstname,lastname,phnum,password,conformpass,refferal,btn,element;
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
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/div/span[1]"));
		String elementval = element.getText();

		System.out.println("message 61="+elementval);
		String value="Must enter a valid email";
		
		if(elementval.equals(value)) {
			System.out.println("tcid61 sucess");
		}
		else {
			
			fail("TCID <61> failed: <no show error message when email field is empty>");
		}
	}
	public void phoneNumberValid() {
		WebElement phnum,btn;
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		phnum.sendKeys("7034uyh@67");
		btn.click();
	}
	public void phoneNumberEmpty() {
		WebElement firstname,lastname,email,password,conformpass,refferal,btn,element;
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
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/span[2]"));
		String elementval = element.getText();
		String value="Must have atleast 6-15 characters";
		if(elementval.equals(value)) {
			System.out.println("tcid63 sucess");
		}
		else {
			
			fail("TCID <63> failed: <no show error message when phone number field is empty>");
		}
	}
	public void phoneLengthPositive() {
		WebElement phnum,btn,cookie;
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));

		phnum.sendKeys("703499");
		btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		phnum.clear();
		phnum.sendKeys("7034994");
		btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phnum.clear();
		phnum.sendKeys("70349947034994");
		btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phnum.clear();
		phnum.sendKeys("703499470349941");
		btn.click();
	}
	public void phoneLengthNegative() {
		WebElement phnum,btn,cookie,element;
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		phnum.sendKeys("70349");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/span[2]"));
		String elementval = element.getText();
		String value="Must have atleast 6-15 characters";
		if(elementval.equals(value)) {
			System.out.println("tcid65 sucess");
		}
		else {
			
			fail("TCID <65> failed: <no show error message when phone number length is not correct>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phnum.clear();
		phnum.sendKeys("7034994703499412");
		btn.click();
		String elementvalue = element.getText();
		String value1="Must have atleast 6-15 characters";
		if(elementvalue.equals(value1)) {
			System.out.println("tcid65 sucess");
		}
		else {
			
			fail("TCID <65> failed: <no show error message when phone number length is not correct>");
		}
	}
	public void passwordEmpty() {
		WebElement firstname,lastname,email,phnum,conformpass,refferal,btn,element;
		firstname=driver.findElement(By.id("fname"));
		lastname=driver.findElement(By.id("lname"));
		email=driver.findElement(By.id("email"));
		phnum=driver.findElement(By.id("phone"));
		conformpass=driver.findElement(By.id("password2"));
		refferal=driver.findElement(By.id("referral"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		firstname.sendKeys("veena");
		lastname.sendKeys("vl");
		email.sendKeys("veena@sowibo.com");
		phnum.sendKeys("7034994370");
		conformpass.sendKeys("veenavava123");
		refferal.sendKeys("vgjj123@");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[2]/div[1]/span"));
		String elementval = element.getText();
		String value="Your password must be 8-16 characters.";
		if(elementval.equals(value)) {
			System.out.println("tcid66 sucess");
		}
		else {
			
			fail("TCID <66> failed: <no show error message when password field is empty>");
		}
	}
}
