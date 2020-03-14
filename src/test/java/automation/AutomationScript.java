package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.protobuf.Empty;

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

		
			if(value.equals(" ")) {
				
				fail("TCID <59> failed: <no show error message when give last name length as 16>");
			}
			else {
				
				System.out.println("tcid59 sucess");
			}

		
		
	}
 
	
	public void invalidEmail() {
		WebElement email,cookie,btn;
		email=driver.findElement(By.id("email"));

		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		

		email.sendKeys("veena.com");
		btn.click();
		String message=email.getAttribute("validationMessage");
		
		
		if(message.isEmpty()) {
			fail("TCID <60> failed: <no show error message when email address with invalid data>");
			
		}
		else {
			System.out.println("tcid 60 success");
		}
		

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

		if(elementval.equals(" ")) {
			fail("TCID <61> failed: <no show error message when email field is empty>");
		}
		else {
			
			
			System.out.println("tcid61 success");
		}
	}
	public void phoneNumberValid() {
		WebElement phnum,btn;
		
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		phnum.sendKeys("7034uyh@67");
		btn.click();
		String message=phnum.getAttribute("validationMessage");

		if(message.isEmpty()) {
			fail("TCID <62> failed: <no show error message when phone number with invalid data>");
		}
		else {
			System.out.println("TCID 62 success");
		}
	}
	public void phoneNumberEmpty() {
		WebElement firstname,lastname,email,password,conformpass,refferal,btn,phnumelement;
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
		phnumelement=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/span[2]"));
		String elementval = phnumelement.getText();
		
		if(elementval.equals(" ")) {
			fail("TCID <63> failed: <no show error message when phone number field is empty>");
			
		}
		else {
			System.out.println("tcid63 sucess");
			
		}
	}
	public void phoneLengthPositive() {
		WebElement phnum,btn,cookie,element;
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));

		phnum.sendKeys("703499");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/span[2]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			System.out.println("tcid64 sucess 1 test case");
		}
		else {
			fail("TCID <64> failed: <show error message when phone number with positive case>");
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		phnum.clear();
		phnum.sendKeys("7034994");
		btn.click();
		String elementval1 = element.getText();
		
		if(elementval1.equals(" ")) {
			
			System.out.println("tcid64 sucess 2 test case");
		}
		else {
			fail("TCID <64> failed: <show error message when phone number with positive case>");
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phnum.clear();
		phnum.sendKeys("70349947034994");
		btn.click();
		String elementval2 = element.getText();
		
		if(elementval2.equals(" ")) {
			
			System.out.println("tcid64 sucess 3 test case");
		}
		else {
			fail("TCID <64> failed: <show error message when phone number with positive case>");
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phnum.clear();
		phnum.sendKeys("703499470349941");
		btn.click();
		String elementval3 = element.getText();
		
		if(elementval3.equals(" ")) {
			
			System.out.println("tcid64 sucess 4 test case");
		}
		else {
			fail("TCID <64> failed: <show error message when phone number with positive case>");
			
		}
	}
	public void phoneLengthNegative() {
		WebElement phnum,btn,cookie,element;
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		phnum.sendKeys("70349");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/span[2]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			fail("TCID <65> failed: <no show error message when  phone number length is incorrect >");
		}
		else {
			
			System.out.println("tcid65 sucess test case1");
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
		String elementvalue1 = element.getText();
		
		if(elementvalue1.equals(" ")) {
			
			fail("TCID <65> failed: <no show error message when phone number length is not correct>");
		}
		else {
			
			System.out.println("tcid65 sucess test case2");
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
		
		if(elementval.equals(" ")) {
			
			fail("TCID <66> failed: <no show error message when password field is empty>");
		}
		else {
			System.out.println("tcid66 sucess");
			
		}
	}
	public void passWordPositive() {
		WebElement password,btn,element;
		password=driver.findElement(By.id("password"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		password.sendKeys("veena123");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[2]/div[1]/span"));
		String elementval = element.getText();

		if(elementval.equals(" ")) {
			System.out.println("tcid67 sucess first case");
			
		}
		else {
			
			fail("TCID <67> failed: <show error message when password field positive in first case>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password.clear();
		password.sendKeys("veena1234");
		btn.click();
		String elementval1 = element.getText();

		if(elementval1.equals(" ")) {
			System.out.println("tcid67 sucess second case");
			
		}
		else {
			
			fail("TCID <67> failed: <show error message when password field positive in second case>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password.clear();
		password.sendKeys("veenaveenaveena");
		btn.click();
		String elementval2 = element.getText();

		if(elementval2.equals(" ")) {
			System.out.println("tcid67 sucess third case");
			
		}
		else {
			
			fail("TCID <67> failed: <show error message when password field positive in third case>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password.clear();
		password.sendKeys("veenaveenaveena1");
		btn.click();
		String elementval3 = element.getText();

		if(elementval3.equals(" ")) {
			System.out.println("tcid67 sucess forth case");
			
		}
		else {
			
			fail("TCID <67> failed: <show error message when password field positive in forth case>");
		}
	}
}
