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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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

		
			if(value.equals(" ")||(value.equals(null))) {
				
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
		

		email.sendKeys("veena");
		btn.click();
		String message=email.getAttribute("validationMessage");
		
		
		if(message.isEmpty()||message.equals(null)) {
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

		if(elementval.equals(" ")||(elementval.equals(null))) {
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

		if(message.isEmpty()||message.equals(null)) {
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
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
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
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
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
		
		if(elementval1.equals(" ")||(elementval.equals(null))) {
			
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
		
		if(elementval2.equals(" ")||(elementval.equals(null))) {
			
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
		
		if(elementval3.equals(" ")||(elementval.equals(null))) {
			
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
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
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
		
		if(elementvalue1.equals(" ")||(elementval.equals(null))) {
			
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
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <66> failed: <no show error message when password field is empty>");
		}
		else {
			System.out.println("tcid66 sucess");
			
		}
	}
	public void conformPasswordEmpty() {
		WebElement firstname,lastname,email,phnum,password,refferal,btn,element;
		firstname=driver.findElement(By.id("fname"));
		lastname=driver.findElement(By.id("lname"));
		email=driver.findElement(By.id("email"));
		phnum=driver.findElement(By.id("phone"));
		password=driver.findElement(By.id("password"));
		refferal=driver.findElement(By.id("referral"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		firstname.sendKeys("veena");
		lastname.sendKeys("vl");
		email.sendKeys("veena@sowibo.com");
		phnum.sendKeys("7034994370");
		password.sendKeys("veenavava123");
		refferal.sendKeys("vgjj123@");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/div/div[2]/div[2]/span[2]"));
		String elementval = element.getText();
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <67> failed: <no show error message when password field is empty>");
		}
		else {
			System.out.println("tcid67 sucess");
			
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

		if(elementval.equals(" ")||(elementval.equals(null))) {
			System.out.println("tcid68 sucess first case");
			
		}
		else {
			
			fail("TCID <68> failed: <show error message when password field positive in first case>");
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

		if(elementval1.equals(" ")||(elementval.equals(null))) {
			System.out.println("tcid68 sucess second case");
			
		}
		else {
			
			fail("TCID <68> failed: <show error message when password field positive in second case>");
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

		if(elementval2.equals(" ")||(elementval.equals(null))) {
			System.out.println("tcid68 sucess third case");
			
		}
		else {
			
			fail("TCID <68> failed: <show error message when password field positive in third case>");
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

		if(elementval3.equals(" ")||(elementval.equals(null))) {
			System.out.println("tcid68 sucess forth case");
			
		}
		else {
			
			fail("TCID <68> failed: <show error message when password field positive in forth case>");
		}
	}
	
	public void passWordNegative() {
		WebElement password,btn,element;
		password=driver.findElement(By.id("password"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		password.sendKeys("veena12");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[2]/div[1]/span"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <69> failed: <no show error message when password field incorrect length in first case>");
			
		}
		else {
			
			System.out.println("tcid69 sucess first case");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password.clear();
		password.sendKeys("veenaveenaveena12");
		btn.click();
		String elementval3 = element.getText();

		if(elementval3.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <69> failed: <no show error message when password field incorrect length in second case>");
		}
		else {
			
			System.out.println("tcid69 sucess second case");
		}
	}
	
	public void passWordInvalidDta() {
		WebElement password,btn,element;
		password=driver.findElement(By.id("password"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		password.sendKeys("vee");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[2]/div[1]/span"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <70> failed: <no show error message when give invalid password >");
			
		}
		else {
			
			System.out.println("tcid70 sucess");
		}
	}
	public void conformPassDifferent() {
		WebElement password,conformpass,btn,element;
		password=driver.findElement(By.id("password"));
		conformpass=driver.findElement(By.id("password2"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		password.sendKeys("veenavava123");
		conformpass.sendKeys("veenavas");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/div/div[2]/div[2]/span[1]"));
		String elementval = element.getText();
		if(elementval.equals(" ")) {
			
			fail("TCID <71> failed: <no show error message when give different passwords >");
			
		}
		else {
			
			System.out.println("tcid71 sucess");
		}
	}
	public void createAccount() {
		WebElement firstname,lastname,email,phnum,password,conformpass,cookie,refferal,btn,element;
		firstname=driver.findElement(By.id("fname"));
		lastname=driver.findElement(By.id("lname"));
		email=driver.findElement(By.id("email"));
		phnum=driver.findElement(By.id("phone"));
		password=driver.findElement(By.id("password"));
		conformpass=driver.findElement(By.id("password2"));
		refferal=driver.findElement(By.id("referral"));
//		cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		firstname.sendKeys("veena");
		lastname.sendKeys("vl");
		email.sendKeys("veena12yu@sowibo.com");
		phnum.sendKeys("7034994370");
		password.sendKeys("veenavava123");
		conformpass.sendKeys("veenavava123");
		refferal.sendKeys("vgjj123@");
//		cookie.click();
		btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Alert alert = driver.switchTo().alert();
		 alert.accept();

			if(alert.equals(null)) {
				fail("TCID <73> failed: <alert box is not present here>");
			}
			else {
				System.out.println("tcid 73 success");
			}   
		

	}
	public void refferalEmpty() {
		WebElement firstname,lastname,email,phnum,password,conformpass,refferal,btn,element;
		firstname=driver.findElement(By.id("fname"));
		lastname=driver.findElement(By.id("lname"));
		email=driver.findElement(By.id("email"));
		phnum=driver.findElement(By.id("phone"));
		password=driver.findElement(By.id("password"));
		conformpass=driver.findElement(By.id("password2"));
		
	    btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		firstname.sendKeys("veena");
		lastname.sendKeys("vl");
		email.sendKeys("veena12yu@sowibo.com");
		phnum.sendKeys("7034994370");
		password.sendKeys("veenavava123");
		conformpass.sendKeys("veenavava123");
		
		btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    Alert alert = driver.switchTo().alert();
	    alert.accept();

		if(alert.equals(null)) {
			fail("TCID <73> failed: <alert box is not present here>");
		}
		else {
			System.out.println("tcid 73 success");
		}
		
	}
	public void backOption() {
		WebElement back;
		back=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/a"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		back.click();
		String str="https://www.greengavya.com/login";
		 String currentURL = driver.getCurrentUrl();
		 System.out.println("uri="+str);
		 System.out.println("current url="+currentURL);
		 if(str.equals(currentURL)) {
			 System.out.println("tcid 74 sucess back option is working");
		 }
		 else {
			 fail("TCID <74> failed: <back option is not working>"); 
		 }
	}
	
	//search valid element using suggestion
	public void testSearch(String str) {
		  WebElement search;
		  String check;
		 		
		  search=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/input"));
		 
		  search.clear();
		  
		  for (int i = 0; i < str.length(); i++) {
		            
		            
				  search.sendKeys(str.charAt(i)+"");
				  try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				}
		  checkElement(str);
		  search.clear();
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void checkElement(String str) {
		String check;
		try {

			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			check = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div[2]/ul/li")).getText();

		     String check1 = check.trim();
		     
			 if(str.equals(check1)) {
				 System.out.println("tcid 77 sucess"+str+"found");
			 }
		}
		
		catch(Exception e) {
			 System.out.println(str+"not found");
			 fail("TCID <77> failed: <products suggestion is not coming for valid products>");
		 }
		
	}
	
	//search invalid element using suggestion
	
	public void invalidElement(String s1) {
		 WebElement search;
		  String check;
		 		
		  search=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/input"));
		 
		  search.clear();
		  
		  for (int i = 0; i < s1.length(); i++) {
		            
		            
				  search.sendKeys(s1.charAt(i)+"");
				  try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				}
		  invalidElementSearch(s1);
		  search.clear();
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void invalidElementSearch(String s1) {
		String check;
		try {

			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			check = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div[2]/ul/li")).getText();

			 if(s1!=check) {
				 System.out.println("tcid 78 sucess"+s1+"not found");
			 }
		}
		catch(Exception e) {
			 System.out.println(s1+"not show error message it not found");
			 fail("TCID <78> failed: <not display element not found message>");
		 }
	}
	
	//search with empty
	
	public void emptySearchBar() {
		 WebElement btn;
		 btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div/button/i"));
		 btn.click();
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Alert alert = driver.switchTo().alert();
		    alert.accept();

			if(alert.equals(null)) {
				fail("TCID <79> failed: <not show error message when search bar is empty>");
			}
			else {
				System.out.println("tcid 79 success");
			}
	}
	
	// search with click suggestion
	
	public void clickOption(String str) {
		  WebElement search,check;
		
		 search=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/input"));
		 
		  search.clear();
		  
		  for (int i = 0; i < str.length(); i++) {
		            
		            
				  search.sendKeys(str.charAt(i)+"");
				  try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				}
		  
		  driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div[2]/ul/li")).click();
		  String currentURL = driver.getCurrentUrl();
	        String expurl="https://www.greengavya.com/?search="+str;
	       
	        if(currentURL.equals(expurl)) {
	        	System.out.println("tcid 80 success"+str+"go to corresponding page");
	        }
	        else {
	        	fail("TCID <80> failed: <it doesn't go corresponding page when a product click in suggestion>");
	        }
		  
   
		  search.clear();
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	 public void mouseClick(String str) {
		 WebElement search,searchbutton;
			
		 search=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/input"));
		 
		  search.clear();
		  
		  for (int i = 0; i < str.length(); i++) {
		            
		            
				  search.sendKeys(str.charAt(i)+"");
				  try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				}
		  searchbutton=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div/button/i"));
		  
		  searchbutton.click();
		  String currentURL = driver.getCurrentUrl();
	        String expurl="https://www.greengavya.com/?search="+str;
	       
	        
	        if(currentURL.equals(expurl)) {
	        	System.out.println("tcid 82 success "+str+" go to corresponding page");
	        }
	        else {
	        	fail("TCID <82> failed: <it doesn't go corresponding page when a product click in search bar>");
	        }
		  search.clear();
		  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	 }
	 //search clear
	 public void clickClearOption(String str) {
		 WebElement search,clearOpt;
			
		 search=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/input"));
		 

		  for (int i = 0; i < str.length(); i++) {
		            
		            
				  search.sendKeys(str.charAt(i)+"");
				  try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				}
		  clearOpt=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/span"));
		  clearOpt.click();
		  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  String content = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/input")).getText();
		  WebElement dr = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/input"));
		 
		  if(content.isEmpty()||content.equals(null)) {
			  System.out.println("tcid 83 is sucess "+str+ "is clear");
		  }
		  else {
			  fail("TCID <83> failed: <Search is not clear when clear option click>");
		  }

	 }
	 public void categoryFruite(){
			WebElement fruite,select,cookie;
			String str="Fruits";
//			cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
//			cookie.click();
			fruite=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[1]/ul/li[2]"));
			
			fruite.click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/h3"));
			String elemrentval = select.getText();
			 System.out.println("element="+elemrentval);
			if(str!=elemrentval) {
				 fail("TCID <85> failed: <when click fruite option in category not see fruites page>");
			}
	 }
			public void categoryVegetable(){
				WebElement vegetable,select,cookie;
				String str="Vegetables";
//				cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
//				cookie.click();
				vegetable=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[1]/ul/li[3]"));
				
				vegetable.click();
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/h3"));
				String elemrentval = select.getText();
				 System.out.println("element="+elemrentval);
				if(str!=elemrentval) {
					 fail("TCID <86> failed: <when click vegetable option in category not see vegetable page>");
				}
			}
			public void categoryOtherGroceries(){
				WebElement groceries,select,cookie;
				String str="Other Groceries";
//				cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
//				cookie.click();
				groceries=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[1]/ul/li[4]"));
				
				groceries.click();
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/h3"));
				String elemrentval = select.getText();
				 System.out.println("element="+elemrentval);
				if(str!=elemrentval) {
					 fail("TCID <87> failed: <when click OtherGroceries option in category not see OtherGroceries page>");
				}
			}
}