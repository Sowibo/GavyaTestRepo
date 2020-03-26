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
			
	}
 
	
	public void invalidEmail() {
		WebElement email,btn;
		email=driver.findElement(By.id("email"));

		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		

		email.sendKeys("veena");
		btn.click();
		String message=email.getAttribute("validationMessage");
		
		
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <60> failed: <no show error message when email address with invalid data>");
			
			
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
		
	}
	public void phoneLengthPositive() {
		WebElement phnum,btn,cookie,element;
		phnum=driver.findElement(By.id("phone"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		phnum.sendKeys("703499");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/span[2]"));
		String elementval = element.getText();
		
		if(!elementval.equals(" ")) {
			
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
		
		if(!elementval.equals(" ")) {
			
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
		
		if(!elementval.equals(" ")) {
			
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
		
		if(!elementval.equals(" ")) {
			
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
		
	}
	public void passWordPositive() {
		WebElement password,btn,element;
		password=driver.findElement(By.id("password"));
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		password.sendKeys("veena123");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/form/div/div[2]/div[1]/span"));
		String elementval = element.getText();

		if(!elementval.equals(" ")) {
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

		if(!elementval1.equals(" ")) {
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

		if(!elementval2.equals(" ")) {
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

		if(!elementval3.equals(" ")) {
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
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/form/button"));
		firstname.sendKeys("veena");
		lastname.sendKeys("vl");
		email.sendKeys("veena12yu@sowibo.com");
		phnum.sendKeys("7034994370");
		password.sendKeys("veenavava123");
		conformpass.sendKeys("veenavava123");
		refferal.sendKeys("vgjj123@");
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
				fail("TCID <72> failed: <alert box is not present here>");
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
		
		 if(!str.equals(currentURL)) {
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
		     
			
		}
		
		catch(Exception e) {
			 
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

		}
		catch(Exception e) {
			
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
	       
	        if(!currentURL.equals(expurl)) {
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
	       
	        
	        if(!currentURL.equals(expurl)) {
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
		 
		  if(!content.isEmpty()) {
			  fail("TCID <83> failed: <Search is not clear when clear option click>");
		  }
		 

	 }
	 
	 public void findCategory(String s1) {
			String fruite,vegetable,groceries;
			boolean frtflag=false,vegflag=false,groflag=false;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			fruite=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[1]/ul/li[2]")).getText();
			vegetable=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[1]/ul/li[3]")).getText();
			groceries=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[1]/ul/li[4]")).getText();
			
			if(fruite.equals(s1)) {
				frtflag=true;
				
			}
			else if (vegetable.equals(s1)) {
				vegflag=true;
				
			}
			else if (groceries.equals(s1)) {
				groflag=true;
				
			}
			else {
				fail("TCID <84> failed: <All categories are not available>");
			}
		}
	 
	 
	 public void categoryFruite(){
			WebElement fruite,select,cookie;
			String str="Fruits";
//			cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
//			cookie.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			fruite=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[1]/ul/li[2]"));
			
			fruite.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/h3"));
			String elemrentval = select.getText();
			
			if(!str.equals(elemrentval)) {
				 fail("TCID <85> failed: <when click fruite option in category not see fruites page>");
			}
	 }
	 public void categoryVegetable(){
				WebElement vegetable,select,cookie;
				String str="Vegetables";

				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				vegetable=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[1]/ul/li[3]"));
				
				vegetable.click();
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/h3"));
				String elemrentval = select.getText();
				 
				if(!str.equals(elemrentval)) {
					 fail("TCID <86> failed: <when click vegetable option in category not see vegetable page>");
				}
			}
	 public void categoryOtherGroceries(){
				WebElement groceries,select,cookie;
				String str="Other Groceries";

				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
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
				
				if(!str.equals(elemrentval)) {
					 fail("TCID <87> failed: <when click OtherGroceries option in category not see OtherGroceries page>");
				}
	 }
	 
	public void continueShopping() {
		   WebElement cookie,email_field,pass_field,login,loginbtn,myorder,shoppingbtn;
			String email=Settings.getInstance().getProperty("email_id");
			String pass=Settings.getInstance().getProperty("passlogin");
			login=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
			login.click();
			email_field=driver.findElement(By.id("email"));
			pass_field=driver.findElement(By.id("password"));
			email_field.sendKeys(email);
			pass_field.sendKeys(pass);
			loginbtn=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[2]/button"));
			loginbtn.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			myorder=driver.findElement(By.xpath("/html/body/div/div/div/div/nav/div/ul/li[2]/a"));
			String element = myorder.getText();
			
			myorder.click();
			shoppingbtn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/p"));
			String elementl = shoppingbtn.getText();
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			shoppingbtn.click();
			String currenturl=driver.getCurrentUrl();

			String url="https://www.greengavya.com/";

			if(!currenturl.equals(url)) {
				 fail("TCID <88> failed: <Continue shopping is note done when click continue button>");
			}
	}
	
}