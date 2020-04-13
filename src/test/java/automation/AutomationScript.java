package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
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
	
//		KEERTHI
	
//		LOGIN FUNCTION
	
	public void logIn(){
		WebElement login,logid,logpass = null,logbtn,cookie;
		
		login=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		logid=driver.findElement(By.id("email"));
		String mail = Settings.getInstance().getProperty("email");		
		logid.sendKeys(mail);
		logpass=driver.findElement(By.id("password"));
		String pass = Settings.getInstance().getProperty("pass");
		logpass.sendKeys(pass);	
		logbtn=driver.findElement(By.cssSelector("div.row:nth-child(2) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)"));
		logbtn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
//		cookie

	public void cookie() {
		WebElement cookie;
		cookie=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		cookie.click();
	}
	
//		LOGOUT
	
	public void logOut() {
		WebElement logout;		
		logout = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		logout.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
//		SETTINGS
	
	public void settingsPage() {
		WebElement settings;		
		settings=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		settings.click();
	}
	
//		ACCOUNTS
	
	public void accountsSection() {
		WebElement accounts;		
		accounts=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		accounts.click();
	}
	
	public void clearAccounts() {
		WebElement fname,lname,pnum;		
		fname = driver.findElement(By.id("fname"));
		fname.clear();		
		lname = driver.findElement(By.id("lname"));
		lname.clear();		
		pnum = driver.findElement(By.id("phone"));
		pnum.clear();	
	}
	
//			TCID 119 Test the  phone number  field with input data of varying length-negative

	public void testPhoneNumberNeg() {
		
		WebElement numfield,updatebtn;		
		numfield = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		numfield.clear();
		numfield.sendKeys("999998");		
		updatebtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		updatebtn.click();	
		String phone = numfield.getAttribute("validationMessage");
		
			if(phone.isEmpty() || phone.equals(null)) {
				
			}
			else {
				fail("TCID <119> failed: <the mobile number has invalid length >");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		numfield.clear();
		numfield.sendKeys("100000000000");
		updatebtn.click();	
		String phone1 = numfield.getAttribute("validationMessage");	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			if(phone1.isEmpty() || phone1.equals(null)) {
				
				
			}
			else{
				fail("TCID <119> failed: <the mobile number has invalid length>");
			}
				
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch (NoAlertPresentException e) {
				// TODO: handle exception
			}
	}
	
//		TCID 120	Test first name field,last name field,phone number field as valid

	public void testValidData() {	
		
		WebElement fname,lname,pnum,updatebtn;		
		fname = driver.findElement(By.id("fname"));
		fname.sendKeys("keerthi");		
		lname = driver.findElement(By.id("lname"));
		lname.sendKeys("sudev");		
		pnum = driver.findElement(By.id("phone"));
		pnum.sendKeys("8137006670");		
		updatebtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();	
		
			try {
				 Thread.sleep(2000);
			 }
			 catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				if(alert.equals(null)) {
					fail("TCID 120 failed:you entered invalid data");
				}
			}
			catch(NoAlertPresentException n) {
				
			}
	}
	
//		TCID 121  Check whether name changes after logged in upon updating

	public void checkUpdate() {
		
		WebElement fname,lname,pnum,updatebtn,name;	
		fname = driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("Keerthigs");
		lname = driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("sudev");		
		pnum = driver.findElement(By.id("phone"));
		pnum.clear();
		pnum.sendKeys("8137006670");	
		String full_name = fname.getText();
		System.out.println(full_name);
		updatebtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		logOut();
		logIn();
		name = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/span"));
		String name_check = name.getText();
		
			try {
				 Thread.sleep(2000);
			 }
			 catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();

				if(full_name != (name_check)){
					fail("TCID 121 failed:name not change after login");
				}
			}
			catch(NoAlertPresentException a) {
	//			System.out.println("NO ALERT IS PRESENT"+a);
			}		
	}
	
//	  TCID 122	Test current password field  with valid password,new password,confirm password
 
	public void changePass() {
		
	WebElement chngpass	;
	chngpass = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[1]/div/ul/li[1]/p"));
	chngpass.click();
	}	

	public void currentValidPass() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		String pass = Settings.getInstance().getProperty("pass");
		crntpass.sendKeys(pass);
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		
			try {
				 Thread.sleep(2000);
			 }
			 catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
					if(alert.equals(null)) {
						fail("TCID 122 failed:");
					}
			}
			catch(NoAlertPresentException n) {
				//
			}
	}


//	TCID 123	Test current password with invalid password


	public void currentInvalidPass() {
		
		WebElement crntpass,newpass,conpass,save_btn;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("invalidpass");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthikeerthi");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthikeerthi");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
			try {
				 Thread.sleep(2000);
			 }
			 catch(InterruptedException e) {
				 e.printStackTrace();
			 }
		String url = "https://www.greengavya.com/settings";
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			String crnt_url = driver.getCurrentUrl();
				if(url.equals(crnt_url)) {
					fail("TCID 123 failed: current password is invalid");
				}
		}
		catch(NoAlertPresentException n) {
			
		}
}

//	TCID	124	Test the current password field with input data of varying length-positive

	public void currentPassLenPos() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthis");		
		String cpass1 = crntpass.getText();
		String cpass = crntpass.getAttribute("validationMessage");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

		 try {
			 Alert alert = driver.switchTo().alert();
				alert.accept();
				 }
				 catch (Exception e) {
					// TODO: handle exception
				}
		
			if(cpass1.length() >=8 || cpass1.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("test failed1");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		crntpass.clear();
		crntpass.sendKeys("keerthisu");
		String cpass2 = crntpass.getText();
		save_btn.click();
			 try {
				 Alert alert = driver.switchTo().alert();
					alert.accept();
			 }
			 catch (Exception e) {
					// TODO: handle exception
			 }
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
			if(cpass2.length() >=8 || cpass2.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("test failed2");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		crntpass.clear();
		crntpass.sendKeys("keerthisudev123");
		String cpass3 = crntpass.getText();
		save_btn.click();
			 try {
				 Alert alert = driver.switchTo().alert();
					alert.accept();
			 }
			 catch (Exception e) {
						// TODO: handle exception
			 }
			if(cpass3.length() >=8 || cpass3.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("test failed3");
			}
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		crntpass.clear();
		crntpass.sendKeys("keerthisudev1234");
		String cpass4 = crntpass.getText(); 
		save_btn.click();
			 try {
				 Alert alert = driver.switchTo().alert();
					alert.accept();
			 }
			 catch (Exception e) {
						// TODO: handle exception
			 }
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(cpass4.length() >=8 || cpass4.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("test failed");
			}
			
			 try {
				 Alert alert = driver.switchTo().alert();
					alert.accept();
			 }
			catch (Exception e) {
						// TODO: handle exception
			}
				
	}
	
	
//	TCID 125  Test the  current password  field with input data of varying length-negative

 	
	public void currentPassLenNeg() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		String currentpass = crntpass.getText();
		crntpass.sendKeys("keerthi");	
		String cpass = crntpass.getAttribute("validationMessage");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(cpass.isEmpty() || cpass.equals(null)) {
				fail("TCID 125 failed:password length incorrect ");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		crntpass.clear();
		crntpass.sendKeys("keerthisudev1234");
		String cpass1 = crntpass.getAttribute("validationMessage");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(cpass1.isEmpty() || cpass1.equals(null)) {
				fail("TCID 125 failed:password length incorrect ");
			}
		save_btn.click();
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
					
			}
			catch(NoAlertPresentException n) {
				
			}					
	}
	
	
//	TCID 126 Test new password with any invalid data

	
	public void newPassInvalid() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("invalidpass ");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				String url = "https://www.greengavya.com/settings";
				String crnt_url = driver.getCurrentUrl();
					if(url.equals(crnt_url)) {
						fail("TCID 126 failed:invalid new password");
					}
			}
			catch(NoAlertPresentException n) {
				
			}
	}
	
//	TCID 127 Test the new password field with input data of varying length-positive

	public void newPasslenPos() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthis");
		String npass1 = newpass.getText();
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		
			 try {
				 Alert alert = driver.switchTo().alert();
				 alert.accept();
			 }
			 catch (Exception e) {
				// TODO: handle exception
			}
			
			if(npass1.length() >=8 || npass1.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 127 failed>:<showing error message with positive length>");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		newpass.clear();
		newpass.sendKeys("keerthisu");
		String npass2 = newpass.getText();
		save_btn.click();
			 try {
				 Alert alert = driver.switchTo().alert();
				 alert.accept();
			 }
			 catch (Exception e) {
				// TODO: handle exception
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
			if(npass2.length() >=8 || npass2.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 127 failed>:<showing error message with positive length>");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		newpass.clear();
		newpass.sendKeys("keerthisudev123");
		String npass3 = newpass.getText();
		save_btn.click();
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			 }
			 catch (Exception e) {
				// TODO: handle exception
			}
			if(npass3.length() >=8 || npass3.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 127 failed>:<showing error message with positive length>");
			}
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		newpass.clear();
		newpass.sendKeys("keerthisudev1234");
		String npass4 = newpass.getText(); 
		save_btn.click();
		 try {
			 Alert alert = driver.switchTo().alert();
			alert.accept();
		 }
		 catch (Exception e) {
				// TODO: handle exception
		 }
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(npass4.length() >=8 || npass4.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 127 failed>:<showing error message with positive length>");
			}
		
		 try {
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
	}
//	TCID 128	Test the  new password  field with input data of varying length-negative

	
	public void newPassLenNeg() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");	
		
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthi");
		String npass1 = newpass.getAttribute("validationMessage");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(npass1.isEmpty() || npass1.equals(null)) {
				fail("<TCID 128 failed>:< new password length incorrect> ");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		newpass.clear();
		newpass.sendKeys("keerthisudev1234");
		String npass2 = newpass.getAttribute("validationMessage");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(npass2.isEmpty() || npass2.equals(null)) {
				fail("<TCID 128 failed>:< new password length incorrect> ");
			}
		save_btn.click();
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
					
			}
			catch(NoAlertPresentException n) {
				
			}					
	}

//	TCID 129	Test confirm password with different password

	public void confirmDiffPass() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisude");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthis");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			try {
				 Thread.sleep(2000);
			 }
			 catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			try {
				Alert alert = driver.switchTo().alert();
				String alert_text = alert.getText();
				alert.accept();
				String text_alert ="Confirm password Incorrect!!";
					if(alert_text.equals(text_alert)) {
						fail("TCID 129 failed:confirm password is different");
					}
			}
			catch(NoAlertPresentException n) {
			
			}
	}

//	TCID 130	Test the confirm password field with input data of varying length-positive

	public void confPassLenPos() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthis");		
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		String cpass1 = conpass.getText();
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			 try {
				 Alert alert = driver.switchTo().alert();
				 alert.accept();
			 }
			 catch (Exception e) {
						// TODO: handle exception
			 }
		
			if(cpass1.length() >=8 || cpass1.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 130 failed > : <showing error message with positive length>");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		conpass.clear();
		conpass.sendKeys("keerthisu");
		String cpass2 = conpass.getText();
		save_btn.click();
			 try {
				 Alert alert = driver.switchTo().alert();
				 alert.accept();
			 }
			 catch (Exception e) {
						// TODO: handle exception
			 }
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
			if(cpass2.length() >=8 || cpass2.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 130 failed > : <showing error message with positive length>");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		conpass.clear();
		conpass.sendKeys("keerthisudev123");
		String cpass3 = conpass.getText();
		save_btn.click();
			 try {
				 Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch (Exception e) {
						// TODO: handle exception
			}
			if(cpass3.length() >=8 || cpass3.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 130 failed > : <showing error message with positive length>");
			}
			
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		conpass.clear();
		conpass.sendKeys("keerthisudev1234");
		String cpass4 = conpass.getText(); 
		save_btn.click();
			 try {
				 Alert alert = driver.switchTo().alert();
				 alert.accept();
			 }
			 catch (Exception e) {
						// TODO: handle exception
			 }
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(cpass4.length() >=8 || cpass4.length() <= 16) {
	//			System.out.println("success");
			}
			else {
				fail("<TCID 130 failed > : <showing error message with positive length>");
			}
			
			 try {
				 Alert alert = driver.switchTo().alert();
				 alert.accept();
			 }
			 catch (Exception e) {
						// TODO: handle exception
			 }
	}
		
//	TCID 131 Test the confirm password  field with input data of varying length-negative

	public void confPassLenNeg() {
		
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		String currentpass = crntpass.getText();
		crntpass.sendKeys("keerthisudev");	
		
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthi");
		String cpass1 = conpass.getAttribute("validationMessage");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch (NoAlertPresentException e) {
				// TODO: handle exception
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(cpass1.isEmpty() || cpass1.equals(null)) {
				fail("TCID 131 failed: confirm password length incorrect ");
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		conpass.clear();
		conpass.sendKeys("keerthisudev1234");
		String cpass2 = conpass.getAttribute("validationMessage");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(cpass2.isEmpty() || cpass2.equals(null)) {
				fail("TCID 131 failed:confirm password length incorrect ");
			}
		save_btn.click();
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
					
			}
			catch(NoAlertPresentException n) {
				
			}					
	}
	

//		  TCID 132	Test current password with empty

 
		public void currentPassEmpty() {			
			WebElement crntpass,newpass,conpass,save_btn,page;	
			
			crntpass = driver.findElement(By.id("oldpassword"));
			String cpass = crntpass.getText();
			newpass = driver.findElement(By.id("password"));
			newpass.sendKeys("keerthikeerthi");			
			conpass = driver.findElement(By.id("confirmpassword"));
			conpass.sendKeys("keerthikeerthi");
			save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			save_btn.click();

				if(cpass.isEmpty()) {
					fail("TCID 132 failed:current password is empty");
					
				}
		}
			
			

//		 TCID 133 	Test confirm password with empty

		
		public void confirmPassEmpty() {
			
			WebElement crntpass,newpass,conpass,page,save_btn;

			crntpass = driver.findElement(By.id("oldpassword"));
			crntpass.sendKeys("keerthisudev");
			newpass = driver.findElement(By.id("password"));
			newpass.sendKeys("keerthisudev");			
			
			conpass = driver.findElement(By.id("confirmpassword"));
			String cpass = conpass.getText();
			save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			save_btn.click();				
			
				if(cpass.isEmpty()) {
					fail("TCID 133 failed:confirm password is empty");
				}
		}

//		  TCID 134	Test new password with empty
		
		public void newPassEmpty() {
			
			WebElement crntpass,newpass,conpass,save_btn,page;
			crntpass = driver.findElement(By.id("oldpassword"));
			crntpass.sendKeys("keerthisudev");
			conpass = driver.findElement(By.id("confirmpassword"));
			conpass.sendKeys("keerthikeerthi");
			newpass = driver.findElement(By.id("password"));
			String npass = newpass.getText();
			save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			save_btn.click();	
			page=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form"));
			String validation = page.getText();
			if(npass.isEmpty()) {
				fail("TCID 134 failed: newpassword is empty");
				
			}
		}

//	 TCID 135	Test use address function for saved address

		
		public void addProduct() {
			
			WebElement add;
			add = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
			add.click();
		}
		
		public void checkOut() {
			
			WebElement checkout;
			checkout = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
			checkout.click();
		}

		public void proceedCheckOut() {
			
			WebElement proceed;
			proceed = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div/div/button"));
			proceed.click();
		}
		
		public void useAddress() {
			
			WebElement useadrs,conordr;
			useadrs = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/button"));
			useadrs.click();
			
		}
		
		public void confirmOrder() {
			
			WebElement conordr;
			
			conordr = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[4]/a"));
			conordr.click();
		}
				
		
//	TCID 136	Test remove saved address

		public void removeAddress() {
			
			WebElement remove;

			remove = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/h5/a"));
			remove.click();	
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
		
//	 TCID 137	Test add new address with valid name,mobile number,flatno,street no,city,district,pin,landmark field as valid.
	
		public void validDetails() {
			
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.clear();
			fname.sendKeys("keerthisudev");			
			mnum = driver.findElement(By.id("mobile"));
			mnum.clear();
			mnum.sendKeys("8593026651");			
			flatnum = driver.findElement(By.id("house"));
			flatnum.clear();
			flatnum.sendKeys("myhome123");		
			area = driver.findElement(By.id("area"));
			area.clear();
			area.sendKeys("akg nagar peroorkkada");		
			city =  driver.findElement(By.id("city"));
			city.clear();
			city.sendKeys("Thiruvananthapuram");	
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
//			district.clear();
//			district.sendKeys("Trivandrum");		
			pin = driver.findElement(By.id("pin"));
			pin.clear();
			pin.sendKeys("695020");
			lmark = driver.findElement(By.id("landmark"));
			lmark.clear();
			lmark.sendKeys("near hss school");
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch(NoAlertPresentException n) {
//				
			}
			String url ="https://www.greengavya.com/confirmorder";
			String crnt_url = driver.getCurrentUrl();
				if(url.equals(crnt_url)) {
					fail("TCID 137 failed:showing error message with valid details");
				}
			
		}
		
//		TCID 138		Test full name with invalid name
	public void invalidFullName() {
		
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;		
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("k1234");		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("8593026651");		
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");	
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");	
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");			
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");			
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");			
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
			String url = "https://www.greengavya.com/billing";
			String crnt_url = driver.getCurrentUrl();
				if(url.equals(crnt_url)) {
					fail("TCID 138 failed:  invalid full name");
				}
			
		}
//	  TCID 139	Test full name with empty

	public void emptyFullName() {	
		
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;	
			fname = driver.findElement(By.id("fullname"));
			String full_name = fname.getText();
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("8593026651");		
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");		
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");			
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");			
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");		
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");		
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
			
				if(full_name.isEmpty()) {
					fail("TCID 139 failed:full name field is empty");
				}
		}
		
//		TCID 140	Test the full name field with input data of varying length-positive

	
		public void fullNamePositive() {
			
			WebElement fname,delibtn,message;
			fname=driver.findElement(By.name("fullname"));
			delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			
			fname.sendKeys("kee");
			delibtn.click();
			
			message=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/p[1]"));
			String text = message.getText();
			
				if(text.equals(" ")||(text.equals(null))) {
					
					fail("TCID <140> failed: <show error message when full name with positive length>");
				}
				try {
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			fname .clear();
			fname.sendKeys("chit");
			delibtn.click();
			String text1 = message.getText();
			
				if(text1.equals(" ")||(text1.equals(null))) {
					
					fail("TCID <140> failed: <show error message when full name with positive length>");
					
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			fname.clear();
			fname.sendKeys("keerthichithuchithuchith");
			delibtn.click();
			String text2 = message.getText();
			
				if(text2.equals(" ")||(text2.equals(null))) {
					
					fail("TCID <140> failed: <show error message when full name with positive length>");
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			fname.clear();
			fname.sendKeys("keerthichithuchithuchithu");
			delibtn.click();
			String text3 = message.getText();
			
				if(text3.equals(" ")||(text3.equals(null))) {
					
					fail("TCID <140> failed: <show error message when full name with positive length>");
					
				}
			
		}
	
//		TCID 141	Test the full name field with input data of varying length-negative

//		public void fullNameNeg() {
//			
//			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
//			fname = driver.findElement(By.id("fullname"));
//			fname.sendKeys("ke");	
//			String full_name = fname.getText();
//			mnum = driver.findElement(By.id("mobile"));
//			mnum.sendKeys("8593026651");			
//			flatnum = driver.findElement(By.id("house"));
//			flatnum.sendKeys("myhome123");		
//			area = driver.findElement(By.id("area"));
//			area.sendKeys("akg nagar peroorkkada");		
//			city =  driver.findElement(By.id("city"));
//			city.sendKeys("Thiruvananthapuram");	
//			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
//			district.sendKeys("Trivandrum");		
//			pin = driver.findElement(By.id("pin"));
//			pin.sendKeys("695020");
//			lmark = driver.findElement(By.id("landmark"));
//			lmark.sendKeys("near hss school");
//			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
//			deliverbtn.click();
//				if(full_name.length() <=2 || full_name.length() >= 26) {
//					fail("TCID 141 failed :full name length invalid");
//				}
//			
//			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//			fname.clear();
//			fname.sendKeys("keerthichithuchithuchithuk");
//			String fullname = fname.getText();
//			deliverbtn.click();
//				if(fullname.length() <=2 || fullname.length() >= 26) {
//					fail("TCID 141 failed :full name length invalid");
//				}
//			
//			
//		}
		
		
		public void fullNegative() {
			
			WebElement fname ,deliverbtn,message;
			fname = driver.findElement(By.id("fullname"));
			deliverbtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			
			fname.sendKeys("ke");
			deliverbtn.click();
			
			message=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/p[4]"));
												
			String text = message.getText();
			
				if(text.equals(" ") || (text.equals(null))) {
					
//					
				}
				else {
					fail("TCID <141> failed: < full name  length is incorrect >");
				}
				
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			fname.clear();
			fname.sendKeys("keerthichithuchithuchithuk");
			deliverbtn.click();
			String text1 = message.getText();
			
				if(text1.equals(" ")||(text1.equals(null))) {
					
//					
				}
				else {
					fail("TCID <141> failed: <full name length is not correct>");
				}
		}
	
		
//		  TCID 142		Test mobile number with invalid mobile number
		
		public void invalidMobileNumber() {		
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");			
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("kk");	
			String mob = mnum.getText();
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");			
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");			
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");			
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");			
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");			
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();	
			String character = "a,b,c,d,e,f,g,h,i,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
				if(mob.contains(character) || mob.length() <=5 || mob.length() >= 16) {
					fail("TCID 142 failed :invalid mobile number");
				}
		}
		
		
//		 TCID 143		Test mobile number with empty
		
		public void emptyMobileNumber() {
			
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");	
			mnum = driver.findElement(By.id("mobile"));
			String mobile = mnum.getText();
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");			
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");		
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");		
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");	
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
				if(mobile.isEmpty()) {
					fail("TCID 143 failed:mobile number is empty");
				}
		}
		
//		TCID 144	Test the mobile number  field with input data of varying length-positive
	
		public void mobNumPositive() {
			
			WebElement mnum,delibtn,message;
			mnum = driver.findElement(By.id("mobile"));
			mnum.clear();
			mnum.sendKeys("999999");
			delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			
			  
			delibtn.click();
			
			message=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/p[3]"));
			String text = message.getText();
			
				if(text.equals(" ")||(text.equals(null))) {
					
					fail("TCID <144> failed: <show error message  with positive case>");
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			mnum.clear();
			mnum.sendKeys("9999999");
			delibtn.click();
			String text1 = message.getText();
			
				if(text1.equals(" ")||(text1.equals(null))) {				
					fail("TCID <144> failed: <show error message  with positive case>");				
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			mnum.clear();
			mnum.sendKeys("11111111111111");
			delibtn.click();
			String text2 = message.getText();
			
				if(text2.equals(" ")||(text2.equals(null))) {
					
					fail("TCID <144> failed: <show error message  with positive case>");
				}
				
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			mnum.clear();
			mnum.sendKeys("999999999999999");
			delibtn.click();
			String text3 = message.getText();
			
				if(text3.equals(" ")||(text3.equals(null))) {
					
					fail("TCID <144> failed: <show error message  with positive case>");
					
				}
			
		}
		
//		TCID 145	Test the mobile number field with input data of varying length-negative

		
		
		public void numNegative() {
			
			WebElement mnum,delibtn,message;
			mnum = driver.findElement(By.id("mobile"));
			delibtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			mnum.clear();
			mnum.sendKeys("99999"); 
		    delibtn.click();
		    String number = mnum.getText();
			message = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/p[4]"));
									
			String text = message.getText();
			
//				if(number.length() <= 2|| number.length() >= 17) {
				if(text.isEmpty() || (text.equals(null))) {
//					success
				}
				else {
					fail("TCID <145> failed: mobile number has invalid length");
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			mnum.clear();
			mnum.sendKeys("99999999999999999");
		
			delibtn.click(); 
			String number1 = mnum.getText();
			String text1 = message.getText();
			
//			if(number1.length() <= 2|| number1.length() >= 17) {
				if(text1.isEmpty() || (text1.equals(null))) {
					
					
				}
				else {
					fail("TCID <145> failed: mobile number has invalid length");
				}
			
		}

//		145
		
		public void mobileNumberLenNegative() {
			
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("99999");
			String mobile = mnum.getText();
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");			
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");		
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");		
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");	
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
				if(mobile.length() <= 5 || mobile.length() >=17) {
					fail("TCID 145 failed :mobile number length invalid");
				}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			mnum.clear();
			mnum.sendKeys("1000000000000000");
			String mobile1 = mnum.getText();
			deliverbtn.click();
				if(mobile1.length() <= 5 || mobile1.length() >=17) {
					fail("TCID 145 failed :mobile number length invalid");
				}
				
		}
		
//	TCID	146	Test invalid flat no
 
		
		public void invalidFlatNum() {
			
				WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
				fname = driver.findElement(By.id("fullname"));
				fname.sendKeys("keerthisudev");		
				mnum = driver.findElement(By.id("mobile"));
				mnum.sendKeys("8593026651");
				flatnum = driver.findElement(By.id("house"));
				flatnum.sendKeys("~!@");			
				area = driver.findElement(By.id("area"));
				area.sendKeys("akg nagar peroorkkada");			
				city =  driver.findElement(By.id("city"));
				city.sendKeys("Thiruvananthapuram");
				district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
				district.sendKeys("Trivandrum");		
				pin = driver.findElement(By.id("pin"));
				pin.sendKeys("695020");		
				lmark = driver.findElement(By.id("landmark"));
				lmark.sendKeys("near hss school");	
				deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
				deliverbtn.click();		
				String message=flatnum.getAttribute("validationMessage");
				
				if(message.isEmpty() || message.equals(null)) {
					fail("TCID <146> failed: invalid flat number");
					
				}
		}
		
		
		
		
//		128
//		login,settings,accounts,chngpass 
//		public void newPasslenNeg() {
//			WebElement save_btn,crntpass,newpass,conpass ;
//			crntpass = driver.findElement(By.id("oldpassword"));
//			crntpass.sendKeys("keerthisudev");
//			newpass = driver.findElement(By.id("password"));
//			newpass.sendKeys("keerthi");
//			String npass = newpass.getText();
//			String cpass = crntpass.getAttribute("validationMessage");
//			conpass = driver.findElement(By.id("confirmpassword"));
//			conpass.sendKeys("keerthisudev");
//			save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
//			save_btn.click();
//			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//			if(npass.isEmpty() || npass.equals(null)) {
//				fail("TCID 125 failed:password length incorrect ");
//			}
//			
//			
//			
//			
//			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		 
//			newpass.clear();
//			newpass.sendKeys("keerthisudev12345");
//			String npass1 = crntpass.getAttribute("validationMessage");
////			save_btn.click();
//			
//			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//			
//			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//				if(npass1.isEmpty() || npass1.equals(null)) {
//					fail("TCID 125 failed:password length incorrect2 ");
//				}
//				save_btn.click();
//				try {
//					Alert alert = driver.switchTo().alert();
//					alert.accept();
//						
//				}
//				catch(NoAlertPresentException n) {
//					
//				}		
//		}
			
}
	