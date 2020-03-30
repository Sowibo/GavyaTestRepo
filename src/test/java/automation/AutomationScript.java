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
	
//			FUNCTIONS NEEDED FOR TCID 119 
//			login,settingsPage,accountsSection
	
	public void testPhoneNumberNeg() {
		WebElement numfield,updatebtn,page;		
		numfield=driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		numfield.sendKeys("9999998");	
		updatebtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		numfield.clear();
		numfield.sendKeys("100000000000");
		String mobile = numfield.getText();
		updatebtn.click();
		
		String display_message=numfield.getAttribute("validationMessage");
			if(display_message.isEmpty()||display_message.equals(null)) {
	//			System.out.println("TCID 119 success");
				fail("TCID <119> failed: <the mobile number is invalid >");
			}
//			else {
			
			
			
//				fail("TCID <119> failed: <the mobile number is invalid >");
//			}
	}
	
//			FUNCTIONS NEEDED FOR TCID 120 
	
//			login,settings ,accounts
	
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
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
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
	
//			FUNCTIONS NEEDED FOR TCID 121
	
//	login,settings, acoount,logout
	
	public void checkUpdate() {
		
		WebElement fname,lname,pnum,updatebtn,name;	
		fname = driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("Keerthigs");
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
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
		
//		System.out.println(full_name );
//		String full_name = "keerthi";
			try {
				 Thread.sleep(2000);
			 }
			 catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch(NoAlertPresentException a) {
	//			System.out.println("NO ALERT IS PRESENT"+a);
			}
		
			if(full_name!=(name_check)){
				fail("TCID 121 failed:name not change after login");
			}
	}
	
//	FUNCTIONS NEEDED FOR TCID 122
	
//	login,settings,accounts,chngpass 
	
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


//		FUNCTIONS NEEDED FOR TCID 123
//		login ,settings, changepass

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

//		FUNCTIONS NEEDED FOR TCID 124
	
//	login,settings,accounts,chngpass 
	public void currentPassLenPos() {
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthis");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String currentpass = crntpass.getText();		
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try {
			 Thread.sleep(2000);
		 }
		 catch(InterruptedException e) {
			 e.printStackTrace();
		 }
		
		
		crntpass.clear();
		crntpass.sendKeys("keerthisudev1234");
		save_btn.click();
		try {
			 Thread.sleep(2000);
		 }
		 catch(InterruptedException e) {
			 e.printStackTrace();
		 }
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String display_message=crntpass.getAttribute("Current password is incorrect!!");
		try {
		
		if(display_message.isEmpty()||display_message.equals(null)) {
			System.out.println("TCID 124 success");
		}
		else {
			
			fail("TCID <124> failed: <the mobile number is valid >");
		}
			
			
			
//			if(currentpass.length() >= 8 && currentpass.length() <= 16) {
//				success
//			}
//			else {
//				fail("TCID 125 failed:password length incorrect");
//			}
		}
		catch(NullPointerException n) {
//			System.out.println("nothing to point"	+ n);
			
		}
			
	
	}
	
	
//	125
//	login,settings,accounts,chngpass 	
	public void currentPassLenNeg() {
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		String currentpass = crntpass.getText();
		crntpass.sendKeys("keerthi");		
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		crntpass.clear();
		crntpass.sendKeys("keerthisudev1234");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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
					if(currentpass.length() <= 7 || currentpass.length() >= 17) {
						fail("TCID 125 failed:password length incorrect");
					}
			}
			catch(NoAlertPresentException n) {
				
			}					
	}
	
	
//	126
//	login,settings,accounts,chngpass 	
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
	
//	TCID 127
//	login,settings,accounts,chngpass 
	public void newPasslenPos() {
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthi");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthis");
		String npass = newpass.getText();
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthis");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
		newpass.clear();
		newpass.sendKeys("keerthisudev1234");
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		if(npass.length() >=8 || npass.length() <= 16) {
//			System.out.println("success");
		}
		else {
			fail("test failed");
		}
	}
	
	
//	128
//	login,settings,accounts,chngpass 
	public void newPasslenNeg() {
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthi");
		String npass = newpass.getText();
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		 
		newpass.clear();
		newpass.sendKeys("keerthisudev12345");
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			String url = "https://www.greengavya.com/settings";
			String crnt_url = driver.getCurrentUrl();
				if(npass.length() <=7 || npass.length() >= 17 && url.equals(crnt_url)) {		
					fail("TCID 128 failed:newpassword length invalid");
				}
		}
		catch(NoAlertPresentException n) {
			
		}
	}
	
//	129
//	login,settings,accounts,chngpass 
	public void confirmDiff() {
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
	
	
	
//	130
//	login,settings,accounts,chngpass 
	public void conPasslenPos() {
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthis");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		 
		conpass.clear();
		conpass.sendKeys("keerthisudev1234");
		save_btn.click();
	
	}
	
	
//	131
//	login,settings,accounts,chngpass 
	public void conPasslenNeg() {
		WebElement save_btn,crntpass,newpass,conpass ;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthi");
		String cpass = conpass.getText();
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		 
		conpass.clear();
		conpass.sendKeys("keerthisudev12345");
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			String url = "https://www.greengavya.com/settings";
			String crnt_url = driver.getCurrentUrl();
				if(cpass.length() <=7 || cpass.length() >= 17 && url.equals(crnt_url)) {
	
					fail("TCID 128 failed:newpassword length invalid");
				}
		}
		catch(NoAlertPresentException n) {
			
		}
	}

//		FUNCTIONS NEEDED FOR TCID 132
//		login,settings,changepass
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
//			page=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form"));
//			page = driver.findElement(By.xpath("//*[@id=\"oldpassword\"]"));	
	

			if(cpass.isEmpty()) {
				fail("TCID 132 failed:current password is empty");
				
				}
		}
			
			

//		FUNCTIONS NEEDED FOR TCID 133
//		SETTINGS,CHANGEPASS	
	
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
			
			
			
//			page=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form"));
//			String validation = page.getText();
//			if(validation.equals(" ")||(validation.equals(null))) {
//				fail("TCID 133 failed: confirm password is empty");
//				
//			}
			
			
			
			if(cpass.isEmpty()) {
				fail("TCID 133 failed:confirm password is empty");
			}
		}

//		FUNCTIONS NEEDED FOR TCID 134
		
		public void newPassEmpty() {
			WebElement crntpass,newpass,conpass,save_btn,page;
//			SETTINGS
//			CHANGEPASS
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

//		FUNCTIONS NEEDED FOR TCID 135
		
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
		
		
		
		
//	tcid 136
//		call addProduct,checkout,proceedcheckout
		public void removeAddress() {
			WebElement remove;

			remove = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/h5/a"));
			remove.click();	
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
		
//		FUNCTIONS NEEDED FOR TCID 137		
//		call addProduct,checkout,proceedcheckout
		
		public void validDetails() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");			
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
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
//		FUNCTIONS NEEDED FOR TCID 138		
//		call addProduct,checkout,proceedcheckout
		
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
//			FUNCTIONS NEEDED FOR TCID 139

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
		
//	140
		public void fullNamePos() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("kee");			
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
			
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			fname.clear();
			fname.sendKeys("keerthichithuchithuchithu");
			String full_name = fname.getText();
			deliverbtn.click();
//			if(full_name.length() >=3 && full_name.length() <= 25) {
//				
//			}
		}
		
		
		
		
//		141
		public void fullNameNeg() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("ke");	
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
			
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			fname.clear();
			fname.sendKeys("keerthichithuchithuchithuk");
			deliverbtn.click();
			
			if(full_name.length() <=2 || full_name.length() >= 26) {
				fail("TCID 141 failed :full name length invalid");
			}
		}
		
	
		
//		FUNCTIONS NEEDED FOR TCID 142		
//		call addProduct,checkout,proceedcheckout
		
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
				fail("TCID failed :invalid mobile number");
			}
		}
		
		
//		FUNCTIONS NEEDED FOR TCID 143		
//		call addProduct,checkout,proceedcheckout
		
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
//		144
		
		public void mobileNumberLenPositive() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("999999");
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
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			mnum.clear();
			mnum.sendKeys("100000000000000");
			deliverbtn.click();
			
		}
		
//		145
		
		public void mobileNumberLenNegative() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("99999");
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
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			mnum.clear();
			mnum.sendKeys("1000000000000000");
			String mobile = mnum.getText();
			deliverbtn.click();
			if(mobile.length() <= 5 || mobile.length() >=16) {
				fail("TCID 145 failed :mobile number length invalid");
			}
			
		}
		
		
		
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
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);				
				deliverbtn.click();
		}
			
}
	