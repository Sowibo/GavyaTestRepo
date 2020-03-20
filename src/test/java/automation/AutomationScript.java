package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
	
//		KEERTHI
	

	public void logIn(){
		WebElement login,logid,logpass = null,logbtn,cookie;
		
		login=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		
		logid=driver.findElement(By.id("email"));
		String mail = Settings.getInstance().getProperty("email");
//		logid.sendKeys("keerthisudev444@gmail.com");		
		logid.sendKeys(mail);
		logpass=driver.findElement(By.id("password"));
		String pass = Settings.getInstance().getProperty("pass");
		logpass.sendKeys(pass);
//		logpass.sendKeys("keerthisudev");		
		logbtn=driver.findElement(By.cssSelector("div.row:nth-child(2) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)"));
		logbtn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	
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
	
	
	
	
		
	public void testPhoneNumber() {
		WebElement numfield,updatebtn,page;		
		numfield=driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		numfield.sendKeys("9999998");	
		updatebtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		numfield.clear();
		numfield.sendKeys("100000000000");
//		numfield.sendKeys("1234567891");
		updatebtn.click();
		
		String display_message=numfield.getAttribute("validationMessage");
		
		if(display_message.isEmpty()||display_message.equals(null)) {
			fail("TCID <119> failed: <the mobile number is valid >");
		}
		else {
			System.out.println("TCID 119 success");
		}
			
		
	}
	
	
	public void alertTest() {
		String page = driver.getPageSource();
		
	}
	
	
//			FUNCTIONS NEEDED FOR TCID 120 
	
//			login,settings ,accounts
	public void testValidData() {		
		WebElement fname,lname,pnum,updatebtn;		
		fname = driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("keerthi");		
		lname = driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("sudev");		
		pnum = driver.findElement(By.id("phone"));
		pnum.clear();
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
		Alert alert = driver.switchTo().alert();
		alert.accept();
		if(alert.equals(null)) {
			fail("TCID 120 failed:");
		}
		else {
			System.out.println("TCID 120 success");
		}
		
		

	}
	
	
//			FUNCTIONS NEEDED FOR TCID 121
//	login,settings, acoount,logout
	public void checkUpdate() {
		WebElement fname,lname,pnum,updatebtn,name;	
		fname = driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("keerthi");		
		lname = driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("sudev");		
		pnum = driver.findElement(By.id("phone"));
		pnum.clear();
		pnum.sendKeys("8137006670");		
		updatebtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		logOut();
		logIn();
		name = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/span"));
		String name_check = name.getText();
		String full_name = "keerthi";
		try {
			 Thread.sleep(2000);
		 }
		 catch(InterruptedException e) {
			 e.printStackTrace();
		 }
		Alert alert = driver.switchTo().alert();
		alert.accept();
		if(full_name == name_check) {
			System.out.println("TCID 121 success");
		}
		else {
			fail("TCID 121 failed:name not correct");
		}
	}
	public void checkingUpdate() {
		
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
		crntpass.sendKeys("keerthisudev");
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
		Alert alert = driver.switchTo().alert();
		alert.accept();
		if(alert.equals(null)) {
			fail("TCID 122 failed:");
		}
		else {
			System.out.println("TCID 122 success");
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
//	ivide button add cheyyanam
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		
		
		
		try {
			 Thread.sleep(2000);
		 }
		 catch(InterruptedException e) {
			 e.printStackTrace();
		 }
		Alert alert = driver.switchTo().alert();
		String al = alert.getText();
//		System.out.println(al);
		alert.accept();
		
		if(alert.equals(null)) {
			fail("TCID 123 failed:");
		}
		else {
			System.out.println("TCID 123 success");
		}
}

//		FUNCTIONS NEEDED FOR TCID 124
	
//	login,settings,accounts,chngpass 
	public void currentPassLenPos() {
		WebElement save_btn,crntpass,newpass,conpass ;

		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthis");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		crntpass.clear();
		crntpass.sendKeys("keerthisudev1234");
		save_btn.click();
		
	
	}
	
	
//	125
//	login,settings,accounts,chngpass 	
	public void currentPassLenNeg() {
		WebElement save_btn,crntpass,newpass,conpass ;

		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthi");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthisudev");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		crntpass.clear();
		crntpass.sendKeys("keerthisudev12345");
		save_btn.click();
		
	
	}
	
	
//	126
//	login,settings,accounts,chngpass 	
	public void newPassInvalid() {
		WebElement save_btn,crntpass,newpass,conpass ;

		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthi");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("@");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	}
	
//	127
//	login,settings,accounts,chngpass 
	public void newPasslenPos() {
		WebElement save_btn,crntpass,newpass,conpass ;

		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthi");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthis");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthis");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		newpass.clear();
		newpass.sendKeys("keerthisudev1234");
		save_btn.click();
	
	}
	
	
//	128
//	login,settings,accounts,chngpass 
	public void newPasslenNeg() {
		WebElement save_btn,crntpass,newpass,conpass ;

		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthi");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthisudev");
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
		newpass.clear();
		newpass.sendKeys("keerthisudev12345");
		save_btn.click();
	
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
		save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
		save_btn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
		conpass.clear();
		conpass.sendKeys("keerthisudev12345");
		save_btn.click();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//		FUNCTIONS NEEDED FOR TCID 132
//		login,settings,changepass
		public void currentPassEmpty() {			
			WebElement crntpass,newpass,conpass,save_btn,page;		
			newpass = driver.findElement(By.id("password"));
			newpass.sendKeys("keerthikeerthi");			
			conpass = driver.findElement(By.id("confirmpassword"));
			conpass.sendKeys("keerthikeerthi");
			save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			save_btn.click();
			page=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form"));
			String validation = page.getText();
			if(validation.equals(" ")||(validation.equals(null))) {
				fail("TCID  132 failed: saving changes");
				
			}
			else {
				
				System.out.println("TCID 132 success");
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
		
			save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			save_btn.click();	
			
			
			
			page=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form"));
			String validation = page.getText();
			if(validation.equals(" ")||(validation.equals(null))) {
				fail("TCID 133 failed: saving changes");
				
			}
			else {
				
				System.out.println("TCID 133 success");
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
 
			save_btn = driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/button"));
			save_btn.click();	
			
			
			
			page=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form"));
			String validation = page.getText();
			if(validation.equals(" ")||(validation.equals(null))) {
				fail("TCID 134 failed: saving changes");
				
			}
			else {
				
				System.out.println("TCID 134 success");
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

		
		public void removeAddress() {
			WebElement remove;

			remove = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/h5/a"));
			remove.click();	
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
		}
//			FUNCTIONS NEEDED FOR TCID 139

		public void emptyFullName() {			
			WebElement mnum,flatnum,area,city,district,pin,lmark,deliverbtn;		
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
			deliverbtn.click();
			
		}
		
		
		
		
//		141
		public void fullNameNeg() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("ke");			
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
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		FUNCTIONS NEEDED FOR TCID 142		
//		call addProduct,checkout,proceedcheckout
		
		public void invalidMobileNumber() {		
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");			
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("122");			
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
		}
		
		
//		FUNCTIONS NEEDED FOR TCID 143		
//		call addProduct,checkout,proceedcheckout
		
		public void emptyMobileNumber() {
			WebElement fname,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");			
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
			deliverbtn.click();
		}
			
}
	