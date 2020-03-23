package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;

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
//			System.out.println("TCID30 success");
		}
		else {
			fail("TCID30 failed: Doesnt redirect to the login page");
			
		}
		
		}
	
	public void plusFunction() {
		WebElement checkout_btn, plus,quantity;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkout_btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout_btn.click();
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
//		System.out.println("TCID33 success in first click");
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
//		System.out.println("TCID33 success in second click");
		}
		else {
			fail("TCID33 failed: Doesnt increased by 1");
		}
		
	}
	
	public void minusFunction() {
		WebElement minus,quantity;
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
//				System.out.println("TCID34 success in first click");
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
//					System.out.println("TCID34 success in second click");
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
//			System.out.println("TCID36 success");
		}
		else {
			fail("TCID36 failed: Didnt show alert message while decresing products less than 1");
		}
		
	}
	public void upperLimit() {
		WebElement plus;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
//				System.out.println("TCID35 success");
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
		WebElement element,element1,shopping,add,check;
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
//			System.out.println("TCID32 success");
		}
		else {
			fail("TCID32 failed: Quantities are different in numbers");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shopping=driver.findElement(By.xpath("/html/body/div/div/div/div/nav/div/ul/li[1]/a"));
		shopping.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[2]/button"));
		add.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		check=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		check.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/p"));
		String value1=element1.getText();
		String object1="Your cart contain 2 items.";
		if(value1.equals(object1)) {
//			System.out.println("TCID32 success 2");
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
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/p"));
		String value=element.getText();
		 String value1="Your cart contain 1 items.";
		if(value.equals(value1)) {
//			System.out.println("TCID37 success");
		}
		else {
			fail("TCID37 failed: product didnt clear from the cart");

		}
		
	}
	public void testLogin(String s1,String s2) {
		WebElement login,email,password,login_btn,element,logout;
		
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		email=driver.findElement(By.name("email"));
		email.sendKeys(s1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		password=driver.findElement(By.name("password"));
		password.sendKeys(s2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		login_btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		login_btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/span"));
		String name=element.getText();
		
		if(name.equals(" ")) {
			fail("TCID40 failed: Doesnt login with valid email and password");

		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		logout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		logout.click();
		
	}
	
	public void loggedCheckout() {
		WebElement login,email,password,login_btn,checkout,proceed;
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		email=driver.findElement(By.name("email"));
		email.sendKeys(Settings.getInstance().getProperty("email"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		password=driver.findElement(By.name("password"));
		password.sendKeys(Settings.getInstance().getProperty("pass"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		login_btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		login_btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		proceed=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/div/button"));
		proceed.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		String address="https://www.greengavya.com/billing";
		String url=driver.getCurrentUrl();
		if(url.equals(address)) {
//			System.out.println("TCID31 success");
		}
		else {
			fail("TCID31 failed: Doesnt redirect to the address page");
			
		}
	}
	public void logout() {
		WebElement logout;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		logout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		logout.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		String back="https://www.greengavya.com/";
		String url=driver.getCurrentUrl();
		if(url.equals(back)) {
//			System.out.println("TCID50 success");
		}
		else {
			fail("TCID50 failed: Logout failed");
			
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		if(driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
//			System.out.println("TCID38 success");
		}
		else {
			fail("TCID38 failed: Dont show any alert box while login with empty email and password");
		}
	}
	public void loginOneEmpty(String s1,String s2) {
		WebElement login,email,password,login_btn;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		password=driver.findElement(By.name("password"));
		password.sendKeys(s2);
		login_btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		login_btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		if(driver.switchTo().alert() !=null) {
			driver.switchTo().alert().accept();
//			System.out.println("TCID39 success with first case");

		}
		else {
			fail("TCID39 failed: Doesnt show alert box while empty email field");

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		password.clear();
		email=driver.findElement(By.name("email"));
		email.sendKeys(s1);
		login_btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		login_btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		
		if(driver.switchTo().alert() !=null) {
			driver.switchTo().alert().accept();
//			System.out.println("TCID39 success with second case");

		}
		
		else {
			fail("TCID39 failed: Doesnt show alert box while empty password");

		}
	}
	public void invalidLogin(String s1,String s2) {
		
		WebElement login,email,password,login_btn,element;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		email=driver.findElement(By.name("email"));
		email.sendKeys(s1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		password=driver.findElement(By.name("password"));
		password.sendKeys(s2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		login_btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		login_btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[1]/div/p[3]"));
		String name=element.getText();
		
		if(name.equals(" ")) {
			fail("TCID41 failed: Doesnt show error message in invalid email and password");

		}
		
	}
	
	public void validOne(String s1,String s2) {
		
		WebElement login,email,password,login_btn,element;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		email=driver.findElement(By.name("email"));
		email.sendKeys(s1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		password=driver.findElement(By.name("password"));
		password.sendKeys(s2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		login_btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		login_btn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[1]/div/p[3]"));
		String name=element.getText();
		
		if(name.equals(" ")) {
			fail("TCID42 failed: Doesnt show error message  login with invalid email and valid password");

		}
		
	}
	
	
	
	public void forgotPassword() {
		WebElement link;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		link=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[1]/a"));
		link.click();
		String forgotpassword="https://www.greengavya.com/forgotpassword";
		String url=driver.getCurrentUrl();
		if(url.equals(forgotpassword)) {
//			System.out.println("TCID43 success");
		}
		else {
			fail("TCID43 failed: Doesnt redirect to the forgot password page");
			
		}
	}
	public void emptyForgotPassword() {
		WebElement submit;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submit=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button"));
		submit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(driver.switchTo().alert() != null) {
			driver.switchTo().alert().accept();
//			System.out.println("TCID46 success");
		}
		
		else {
			fail("TCID 46 failed: Doesnt show alert message while submit with empty field");
			
		}
	}
	public void forgotValid(String s1) {
		WebElement email,submit;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		email=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys(s1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		submit=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button"));
		submit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		if(driver.switchTo().alert()!=null) {
			driver.switchTo().alert().accept();
//			System.out.println("TCID44 success");
		}
		else {
			fail("TCID44 failed: Doesnt show alert message while link is send to email");
			
		}
		email.clear();
		
	}
	public void forgotInvalid(String s1) {
		WebElement email ,submit;
		email=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		email.sendKeys(s1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		submit=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button"));
		submit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		if(driver.switchTo().alert()!=null) {
			driver.switchTo().alert().accept();
//			System.out.println("TCID45 success");
		}
		else {
			fail("TCID45 failed: Doesnt show alert message while enter invalid email");
			
		}
		
	}
	public void forgotBackLogin() {
		WebElement back;
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		back=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/a"));
		back.click();
		String backurl="https://www.greengavya.com/login";
		String url=driver.getCurrentUrl();
		if(url.equals(backurl)) {
//			System.out.println("TCID47 success");
		}
		else {
			fail("TCID47 failed: Doesnt redirect to the login page");
			
		}
	}
	public void backOption() {
		WebElement back;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		back=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[2]/a"));
		back.click();
		String backtohome="https://www.greengavya.com/";
		String url=driver.getCurrentUrl();
		if(url.equals(backtohome)) {
//			System.out.println("TCID49 success");
		}
		else {
			fail("TCID 49 failed: Doesnt redirect to the home page");
			
		}
		
	}
	public void createAccount() {
		WebElement create,login;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		create=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[1]/div[2]/a/button"));
		create.click();
		String create_account="https://www.greengavya.com/register";
		String url=driver.getCurrentUrl();
		if(url.equals(create_account)) {
//			System.out.println("TCID48 success");
		}
		else {
			fail("TCID 48 failed: Doesnt redirect to the register page");
			
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
		
	}
	public void fnameEmpty() {
		WebElement fname,lname,email,phn,password,confirmpass,refferal,submit,element;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
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
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[1]/span"));
		String value = element.getText();
		
		if(value.equals(" ")) {
			fail("TCID53 failed: Didnt show error message with empty first name");
			
		}
		
	}
	public void fnamePositiveLength() {
		WebElement register,fname,submit,message;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		register.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		fname.sendKeys("Ath");
		submit.click();
		message=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[1]/span"));
		String value1 = message.getText();
		
		if(value1.equals(" ")) {
//			System.out.println("TCID54 Success with positive testcase1");
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
//			System.out.println("TCID54 Success with positive testcase2");
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
//			System.out.println("TCID54 Success with positive testcase3");
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
//			System.out.println("TCID54 Success with positive testcase4");
		}
		else {
			fail("TCID54 failed:Show error message in positive case4");
			
		}
	}
	public void fnameNegativeLength() {
		WebElement register,fname,submit,message;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		register.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		fname.sendKeys("At");
		submit.click();
		message=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[1]/span"));
		String value1 = message.getText();		
		if(value1.equals(" ")) {
			fail("TCID55 failed: Didnt show error message with negative test case1");
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
		
	}
	public void invalidLname() {
		WebElement register,lname,submit;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		register.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lname=driver.findElement(By.id("lname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		lname.sendKeys("@#$");
		submit.click();
		String message=lname.getAttribute("validationMessage");
		
		if(message.isEmpty()) {
			fail("TCID56 failed: Didnt show error message with invalid Last name");
		}
		
	}
	public void lnameEmpty() {
		WebElement register,fname,email,phn,password,confirmpass,refferal,submit,element;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		register.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[2]/span"));
		String value = element.getText();
		
		if(value.equals(" ")) {
			fail("TCID57 failed: Didnt show error message with empty first name");
			
		}
		
	}
	public void lnamePositiveLength() {
		WebElement register,lname,submit,message;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		register.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lname=driver.findElement(By.id("lname"));
		submit=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		lname.sendKeys("A");
		submit.click();
		message=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[1]/div[2]/span"));
		String value1 = message.getText();
		
		if(value1.equals(" ")) {
//			System.out.println("TCID58 Success with positive testcase1");
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
//			System.out.println("TCID58 Success with positive testcase2");
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
//			System.out.println("TCID58 Success with positive testcase3");
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
//			System.out.println("TCID58 Success with positive testcase4");
		}
		else {
			fail("TCID58 failed:Show error message in positive case4");
			
		}
	}
}
	
	

	

