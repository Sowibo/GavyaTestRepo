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
	
	public void cookie() {
		WebElement cookie;
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		cookie.click();
	}
	public void addProduct() {
		WebElement plus,element;
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
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		plus=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[3]/p[3]/span/button[2]"));
		plus.click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
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
	}

	public void cart() {
	    WebElement cart;
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		cart=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
		cart.click();
	}
	public void cartCheckout() {
	    WebElement click;
	    click=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
	    click.click();
	}
	public void sort() {
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
	public void clearcartemp() {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebElement clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[2]/span"));
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
		    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
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
				fail("TCID35 failed: Didnt show alert message while incresing products greater than 10");
			}
			
	}	
	public void clear() {
		WebElement clear;
		clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[1]/div/div[2]/span"));
		clear.click();
	}
	
	
}  

