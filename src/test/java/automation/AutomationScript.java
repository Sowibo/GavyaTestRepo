package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.graph.SuccessorsFunction;

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
	
	//manuraj
	public void login() {
		WebElement login,submit,email,password;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Settings.getInstance().getProperty("url"));
		AutomationScript.returnobj().cookie();
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		email=driver.findElement(By.id("email"));
		email.sendKeys(Settings.getInstance().getProperty("email"));
		password=driver.findElement(By.id("password"));
		password.sendKeys(Settings.getInstance().getProperty("pass"));
		submit=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[2]/button"));
		submit.click();
	
	}
	public void cookie() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement cookie;
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		cookie.click();
	}
	public void addProduct() {
		WebElement plus,element;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[2]/p[3]/span/button[2]"));
		plus.click();
		
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[4]/div/div[2]/div[2]/div[2]/p[3]/span/span"));
		String element1=element.getText();

		if(element1.equals("2")) {
			System.out.println("Success");
		}
		else {
			fail("TCID <3> failed: Not increased by one");
		}
	}
	public void minusProduct() {
		WebElement minus,element,plus;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[3]/p[3]/span/button[2]"));
		plus.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[3]/p[3]/span/button[1]"));
		minus.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[3]/p[3]/span/span"));
		String element1=element.getText();
		if(element1.equals("1")) {
			System.out.println("Success");
		}
		else {
			fail("TCID <3> failed: Not decreased by one");
		}
	}
	
	public void checkout_empty() {
		WebElement checkout,clear;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[2]/span"));
		clear.click();
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		checkout.click();
		
		
	}
	public void checkout()  {
		WebElement checkout;
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/p[2]/a"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkout.click();
		String backtohome="https://www.greengavya.com/";
		String url=driver.getCurrentUrl();
		if(url.equals(backtohome)) {
			System.out.println("Success");
		}
		else {
			fail("TCID  failed: Doesnt redirect to the home page");
			
		}
	}

	public void cart() {
	    WebElement cart;
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		cart=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
		cart.click();
	}
	public void cartCheckout() {
	    WebElement click;
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    click=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
	    click.click();
	    
	}
	public void sort() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[4]/div/div[2]/div[1]/span/select"));  
		Select select = new Select(dropdown);  
		List<WebElement> options = select.getOptions();
		for(WebElement we:options)  
		{  
		 System.out.println(we.getText());
		}
	}
	public void relevance() {
		WebElement element;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select")));
		dropdown.selectByIndex(0);
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select/option[1]"));
		String element1=element.getText();
		if(element1.equals("Relevance")) {
			System.out.println("Sorted By Relevance");
		}
		else {
			fail("TCID <8> failed: Relevance Category is not selected");
		}
		
	}
	public void lowtohigh() {
		WebElement element;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select")));
		dropdown.selectByIndex(1);
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select/option[2]"));
		String element1=element.getText();
		if(element1.equals("Price - Low to High")) {
			System.out.println("Sorted By Low to High");
		}
		else {
			fail("TCID <9> failed: Low to High Category is not selected");
		}
		
	}
	public void hightolow() {
		WebElement element;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select")));
		dropdown.selectByIndex(2);
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select/option[3]"));
		String element1=element.getText();
		if(element1.equals("Price - high to Low")) {
			System.out.println("Sorted By High to Low");
		}
		else {
			fail("TCID <10> failed:  High to Low Category is not selected");
		}
		
	}
	public void atoz() {
		WebElement element;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select")));
		dropdown.selectByIndex(3);
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select/option[4]"));
		String element1=element.getText();
		if(element1.equals("Name - A to Z")) {
			System.out.println("Sorted By A to Z");
		}
		else {
			fail("TCID <10> failed:  A to Z Category is not selected");
		}
		
	}
	public void ztoa() {
		WebElement element;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select")));
		dropdown.selectByIndex(4);
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[1]/span/select/option[5]"));
		String element1=element.getText();
		if(element1.equals("Name - Z to A")) {
			System.out.println("Sorted By Z to A");
		}
		else {
			fail("TCID <10> failed:  Z to A Category is not selected");
		}
		
	}
	
	public void pagination() {
		WebElement one,two,three,four,five;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		one=driver.findElement(By.id("1"));
		one.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		two=driver.findElement(By.id("2"));
		two.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		three=driver.findElement(By.id("3"));
		three.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		four=driver.findElement(By.id("4"));
		four.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		five=driver.findElement(By.id("5"));
		five.click();
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		one.click();


	}
	public void clearcartemp() {
		
		WebElement clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[2]/span"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clear.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}
	public void clearcart() {
		
		WebElement clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[2]/span"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clear.click();
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
		lower=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[4]/p[3]/span/button[1]"));
		lower.click();
		
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
			plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[5]/p[3]/span/button[2]"));
			plus.click();
		}
			
	}
	
	public void cartPlus() {
			WebElement cart,plus,element;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cart=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
			cart.click();
			plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/div/button[2]"));
			plus.click();
			element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/div/span"));
			String element1=element.getText();
			if(element1.equals("2")) {
				System.out.println("Success");
			}
			else {
				fail("TCID <21> failed: Not increased by one");
			}
			
	}
	
	public void cartMinus() {
		WebElement minus,element;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		minus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/div/button[1]"));
		minus.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/div/span"));
		String element1=element.getText();
		if(element1.equals("1")){
			System.out.println("Success");
		}
		else{
			fail("TCID <22> failed: Not decreased by one");
		}
	}
	
	public void lowerCart() {
		WebElement lower;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		lower=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/div/button[1]"));
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
			System.out.println("TCID 24 success");
		}
		else {
			fail("TCID36 failed: Didnt show alert message while decresing products less than 1");
		}
		
	}
	public void upperCart() {
		WebElement plus;
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/div/button[2]"));
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
				System.out.println("TCID 23 success");
			}
			else {
				fail("TCID23 failed: Didnt show alert message while incresing products greater than 10");
			}
			
	}	
	public void clear() {
		WebElement clear;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/span"));
		clear.click();
	}
	
	public void continueCart() {
		WebElement continueshop;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueshop=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/button[1]"));
		continueshop.click();
		String backtohome="https://www.greengavya.com/";
		String url=driver.getCurrentUrl();
		if(url.equals(backtohome)) {
			System.out.println("TCID success");
		}
		else {
			fail("TCID  failed: Doesnt redirect to the home page");
			
		}
	}
	public void clearShop() {
		WebElement clearshop;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearshop=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/button[2]"));
		clearshop.click();
		
	}
	 public void verifyProduct() {
		 WebElement	element1,element2;
		 element1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[1]/p[1]"));
		 String value1=element1.getText().substring(0, 11);
		 element2=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/p[1]"));
		 String value2=element2.getText();
		 if(value1.equals(value2)) {
			 System.out.println(value1+"="+value2);
		 }
		 else {
			 fail("TCID <15> failed: Products are not equal");
		 }
	 }
	
}  

