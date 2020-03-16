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
/*------athira*/
	
	public void cookie() {
		WebElement cookie;
		cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		cookie.click();
	}
	public void newUser() {
		WebElement cart,checkout,user;
		cart=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		cart.click();
		checkout.click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		user=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/div/button"));
		user.click();
		String login="https://www.greengavya.com/login/billing";
		String url=driver.getCurrentUrl();
		if(url.equals(login)) {
			System.out.println("TCID30 success");
		}
		else {
			fail("TCID 30 failed: Doesnt redirect to the login page");
			
		}
		}
	
	public void plusFunction() {
		WebElement checkout,plus,quantity;
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();
		
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/button[2]"));
		plus.click();
		quantity=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/span"));
		String value=quantity.getText();
		System.out.println("value="+value);
//		if(value.equals("2")) {
//		System.out.println("TCID33 success");
//		}
//		else {
//			fail("TCID33 fail");
//		}
		
	}
	
	public void minusFunction() {
		WebElement checkout,minus;
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();

		for(int i=0;i<2;i++) {
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			minus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/button[1]"));
			minus.click();
			System.out.println("TCID34 success");
		}
	}
	public void lowerLimit() {
		WebElement lower;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		lower=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/button[1]"));
		lower.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		System.out.println("TCID36 success");
		
	}
	public void upperLimit() {
		WebElement plus;
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/button[2]"));
			plus.click();
		}
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();
			System.out.println("TCID35 success");
			
	}
	public void checkOut() {
		WebElement checkout_btn;
		checkout_btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout_btn.click();
	}
	public void clear() {
		WebElement clear;
		clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[1]/p"));
		clear.click();
		System.out.println("TCID37 success");
		}
	
	
	public void register() {
		WebElement register;
		register=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		register.click();
	}
	public void invalidFname() {
		WebElement fname,submit;
		fname=driver.findElement(By.id("fname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		fname.sendKeys("@#$");
		submit.click();
		String message=fname.getAttribute("validationMessage");
		
		if(message.isEmpty()) {
			fail("TCID52 failed: Didnt show error message with invalid first name");
		}
		else {
			System.out.println("TCID 52 success");
		}
	}
	public void fnameEmpty() {
		WebElement fname, lname,email,phn,password,confirmpass,refferal,submit;
		lname=driver.findElement(By.id("lname"));
		email=driver.findElement(By.id("email"));
		phn=driver.findElement(By.id("phone"));
		password=driver.findElement(By.id("password"));
		confirmpass=driver.findElement(By.id("password2"));
		refferal=driver.findElement(By.id("referral"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		lname.sendKeys("krishna");
		email.sendKeys("athira@sowibo.com");
		phn.sendKeys("8070605020");
		password.sendKeys("athiraathi");
		confirmpass.sendKeys("athiraathi");
		refferal.sendKeys("athi123");
		submit.click();
		fname=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[1]/span"));
		String value = fname.getText();
		
		if(value.equals(" ")) {
			fail("TCID53 failed: Didnt show error message with empty first name");
			
		}
		else {
			System.out.println("TCID53 success");
			
		}
	}
	public void fnamePositiveLength() {
		WebElement fname,submit,message;
		fname=driver.findElement(By.id("fname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		fname.sendKeys("Ath");
		submit.click();
		message=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[1]/span"));
		String value1 = message.getText();
		
		if(value1.equals(" ")) {
			System.out.println("TCID54 Success with positive testcase1");
		}
		else {
			fail("TCID54 failed:Show error message in positive case1");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fname.clear();
		fname.sendKeys("Athi");
		submit.click();
		String value2 = message.getText();

		if(value2.equals(" ")) {
			System.out.println("TCID54 Success with positive testcase2");
		}
		else {
			fail("TCID54 failed:Show error message in positive case2");
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname.clear();
		fname.sendKeys("Athirakrishnan");
		submit.click();
		String value3 = message.getText();

		if(value3.equals(" ")) {
			System.out.println("TCID54 Success with positive testcase3");
		}
		else {
			fail("TCID54 failed:Show error message in positive case3");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname.clear();
		fname.sendKeys("Athirakrishnanm");
		submit.click();	
		String value4 = message.getText();

		if(value4.equals(" ")) {
			System.out.println("TCID54 Success with positive testcase4");
		}
		else {
			fail("TCID54 failed:Show error message in positive case4");
			
		}
	}
	public void fnameNegativeLength() {
		WebElement fname,submit,message;
		fname=driver.findElement(By.id("fname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		fname.sendKeys("At");
		submit.click();
		message=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[1]/span"));
		String value1 = message.getText();		
		if(value1.equals(" ")) {
			fail("TCID55 failed: Didnt show error message with negative test case1");
		}
		else {
			
			System.out.println("TCID55 Success with negative testcase1");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname.clear();
		fname.sendKeys("Athirakrishnanmb");
		submit.click();	
		String value2 = message.getText();		
		if(value2.equals(" ")) {
			fail("TCID55 failed: Didnt show error message with negative test case2");
		}
		else {
			System.out.println("TCID55 sucess test case2");
		}
	}
	public void invalidLname() {
		WebElement lname,submit;
		lname=driver.findElement(By.id("lname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		lname.sendKeys("@#$");
		submit.click();
		String message=lname.getAttribute("validationMessage");
		
		if(message.isEmpty()) {
			fail("TCID56 failed: Didnt show error message with invalid Last name");
		}
		else {
			System.out.println("TCID 56 success");
		}
	}
	public void lnameEmpty() {
		WebElement fname,lname,email,phn,password,confirmpass,refferal,submit;
		fname=driver.findElement(By.id("fname"));
		email=driver.findElement(By.id("email"));
		phn=driver.findElement(By.id("phone"));
		password=driver.findElement(By.id("password"));
		confirmpass=driver.findElement(By.id("password2"));
		refferal=driver.findElement(By.id("referral"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		fname.sendKeys("krishna");
		email.sendKeys("athira@sowibo.com");
		phn.sendKeys("8070605020");
		password.sendKeys("athiraathi");
		confirmpass.sendKeys("athiraathi");
		refferal.sendKeys("athi123");
		submit.click();
		lname=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[2]/span"));
		String value = lname.getText();
		
		if(value.equals(" ")) {
			fail("TCID57 failed: Didnt show error message with empty first name");
			
		}
		else {
			System.out.println("TCID57 success");
			
		}
	}
	public void lnamePositiveLength() {
		WebElement lname,submit,message;
		lname=driver.findElement(By.id("lname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		lname.sendKeys("A");
		submit.click();
		message=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[2]/span"));
		String value1 = message.getText();
		
		if(value1.equals(" ")) {
			System.out.println("TCID58 Success with positive testcase1");
		}
		else {
			fail("TCID58 failed:Show error message in positive case1");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lname.clear();
		lname.sendKeys("MB");
		submit.click();
		String value2 = message.getText();

		if(value2.equals(" ")) {
			System.out.println("TCID58 Success with positive testcase2");
		}
		else {
			fail("TCID58 failed:Show error message in positive case2");
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lname.clear();
		lname.sendKeys("Athirakrishnan");
		submit.click();
		String value3 = message.getText();

		if(value3.equals(" ")) {
			System.out.println("TCID58 Success with positive testcase3");
		}
		else {
			fail("TCID58 failed:Show error message in positive case3");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lname.clear();
		lname.sendKeys("Athirakrishnanm");
		submit.click();	
		String value4 = message.getText();

		if(value4.equals(" ")) {
			System.out.println("TCID58 Success with positive testcase4");
		}
		else {
			fail("TCID58 failed:Show error message in positive case4");
			
		}
	}
	
	
		
}
	
	

	

