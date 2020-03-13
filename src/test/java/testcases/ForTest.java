package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import settings.Settings;

public class ForTest {
	
	WebDriver driver;
	public static void main(String s[]) {
		
		ForTest obj = new ForTest();
		obj.initalization();
		obj.launchUrl();
		obj.testPhoneNumber();
		
	}
	
	
	public void initalization() {
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\sql\\dependens\\geckodriver\\geckodriver.exe");
		  driver=new  FirefoxDriver();
	 }
	
	
	public void launchUrl() {
//		driver.get(Settings.getInstance().getProperty("url"));
		driver.get("http://www.greengavya.com");
	}
	
	public void testPhoneNumber() {
		WebElement settings,accounts,numfield,login,logid,logpass,logbtn;
		
		
		login=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		logid=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		logid.sendKeys("keerthisudev444@gmail.com");
		logpass=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		logpass.sendKeys("keerthisudev");
//		logbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		logbtn=driver.findElement(By.cssSelector("div.row:nth-child(2) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)"));
		logbtn.click();
		
		
//		settings=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
//		settings.click();
//		accounts=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
//		accounts.click();
//		numfield=driver.findElement(By.xpath("//*[@id=\"phone\"]"));
//		numfield.sendKeys("12");
		
	}

}
