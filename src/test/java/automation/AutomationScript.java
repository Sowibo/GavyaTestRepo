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
		
		element=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[2]/p[3]/span/span"));
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
		driver.switchTo().alert().accept();
		
	}
	public void checkout()  {
		WebElement checkout;
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkout.click();
	}

	public void clearEmpty() {
		WebElement clear;
		clear=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[2]/span"));
		clear.click();
	}
	public void cart() {
	    WebElement cart;
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		cart=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
		cart.click();
	}
	public void cartCheckout() {
	    WebElement click;
	    click=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[3]/div/div[2]/div/p[2]/a"));
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
		WebElement relevance = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[4]/div/div[2]/div[1]/span/select/option[1]"));  
		Select dropdown = new Select(relevance);
		dropdown.selectByIndex(0); 
		System.out.println(dropdown);
		
	}
	
}  

