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
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkout.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quantity=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/span"));
		String value=quantity.getText();
		if(value.equals("2")) {
		System.out.println("TCID33 success in first click");
		}
		else {
			fail("TCID33 failed: Doesnt increased by one");
		}
		plus.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quantity=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/span"));
		String value1=quantity.getText();
		if(value1.equals("3")) {
		System.out.println("TCID33 success in second click");
		}
		else {
			fail("TCID33 failed: Doesnt increased by 1");
		}
		
	}
	
	public void minusFunction() {
		WebElement checkout,minus,quantity;
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();
		
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			minus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/button[1]"));
			minus.click();
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			quantity=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/span"));
			String value=quantity.getText();
			if(value.equals("2")) {
				System.out.println("TCID34 success in first click");
				}
				else {
					fail("TCID34 failed: Doesnt decreased by one");
				}
				minus.click();
				try {
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				quantity=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[5]/span/span"));
				String value1=quantity.getText();
				if(value1.equals("1")) {
					System.out.println("TCID34 success in second click");
					}
					else {
						fail("TCID34 failed: Doesnt decreased by one");
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
		if(driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
			System.out.println("TCID 36 success");
		}
		else {
			fail("TCID36 failed: Didnt show alert message while decresing products less than 1");
		}
		
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
			if(driver.switchTo().alert() != null) {
				driver.switchTo().alert().accept();
				System.out.println("TCID 35 success");
			}
			else {
				fail("TCID35 failed: Didnt show alert message while incresing products greater than 10");
			}
			
	}
	public void checkOut() {
		WebElement checkout_btn;
		checkout_btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout_btn.click();
	}
	public void verifyLabel() {
		WebElement element;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/p"));
		String value=element.getText();
		String object="Your cart contain 1 items.";
		if(value.equals(object)) {
			System.out.println("TCID 32 success");
		}
		else {
			fail("TCID32 failed: Quantities are different in numbers");
		}
}
	public void clear() {
		WebElement clear,element;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/table/tbody/tr/td[1]/p"));
		clear.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/p[1]"));
		String value=element.getText();
		 String value1="You have no items in your shopping cart.";
		if(value.equals(value1)) {
			System.out.println("TCID37 success");
		}
		else {
			fail("TCID37 failed: product didnt clear from the cart");

		}
		
	}


	public void loginEmpty() {
		WebElement login,btn;
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[2]/button"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btn.click();
		if(driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
			System.out.println("TCID 38 success");
		}
		else {
			fail("TCID38 failed: Dont show any alert box while login with empty email and password");
		}
	}
	public void createAccount() {
		WebElement login,create;
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		create=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[1]/div[2]/a/button"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		create.click();
		String create_account="https://www.greengavya.com/register";
		String url=driver.getCurrentUrl();
		if(url.equals(create_account)) {
			System.out.println("TCID48 success");
		}
		else {
			fail("TCID 48 failed: Doesnt redirect to the register page");
			
		}
	}
	public void backOption() {
		WebElement login,back;
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		back=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[2]/a"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		back.click();
		String backtohome="https://www.greengavya.com/";
		String url=driver.getCurrentUrl();
		if(url.equals(backtohome)) {
			System.out.println("TCID49 success");
		}
		else {
			fail("TCID 49 failed: Doesnt redirect to the home page");
			
		}
		
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
	
	

	

